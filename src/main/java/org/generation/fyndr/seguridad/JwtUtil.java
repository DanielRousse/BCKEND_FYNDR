package org.generation.fyndr.seguridad;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
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

    @Value("${jwt.secret-key}")
    private String secretKeyStr;

    @Value("${jwt.expiration-ms}")
    private long expirationMs;

    private Key key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(secretKeyStr.getBytes());
    }

    /**
     * Genera un token JWT para el email proporcionado con claims de rol e ID.
     */
    public String generateToken(String email, String role, Long id) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        claims.put("id", id);
        return createToken(claims, email);
    } // generateToken

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    } // createToken

    /**
     * Valida si el token es válido y no ha expirado.
     */
    public Boolean validateTokenWithoutEmail(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
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
     * Extrae el rol del token.
     */
    public String extractRole(String token) {
        return extractClaim(token, claims -> claims.get("role", String.class));
    } // extractRole

    /**
     * Extrae el ID del token.
     */
    public Long extractId(String token) {
        return extractClaim(token, claims -> claims.get("id", Long.class));
    } // extractId

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
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    } // extractAllClaims

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    } // isTokenExpired
} // class JwtUtil
