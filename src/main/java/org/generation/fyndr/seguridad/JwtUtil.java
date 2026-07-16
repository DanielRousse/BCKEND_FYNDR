package org.generation.fyndr.seguridad;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Clase de utilidad para la generación, parsing y validación de tokens JWT.
 */
@Component
public class JwtUtil {

    // Clave secreta para firmar los tokens (mínimo 32 caracteres / 256 bits para HS256)
    private static final String SECRET_KEY_STR = "EstaEsUnaClaveSecretaMuyLargaYSeguraParaMapearLosTokensDeJWTFyndr123!";
    private static final Key KEY = Keys.hmacShaKeyFor(SECRET_KEY_STR.getBytes());

    // Tiempo de expiración del token (10 horas)
    private static final long EXPIRATION_TIME = 1000L * 60 * 60 * 10;

    /**
     * Genera un token JWT para el email proporcionado.
     */
    public String generateToken(String email) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, email);
    } // generateToken

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(KEY, SignatureAlgorithm.HS256)
                .compact();
    } // createToken

    /**
     * Valida si el token es correcto y corresponde al email del usuario.
     */
    public Boolean validateToken(String token, String email) {
        final String extractedEmail = extractEmail(token);
        return (extractedEmail.equals(email) && !isTokenExpired(token));
    } // validateToken

    /**
     * Valida si el token es válido y no ha expirado (sin importar el email).
     */
    public Boolean validateTokenWithoutEmail(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(KEY).build().parseClaimsJws(token);
            return !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    } // validateTokenWithoutEmail

    /**
     * Extrae el email (subject) del token.
     */
    public String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    } // extractEmail

    /**
     * Extrae la fecha de expiración del token.
     */
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    } // extractExpiration

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    } // extractClaim

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    } // extractAllClaims

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    } // isTokenExpired
} // class JwtUtil
