package org.generation.fyndr.controladores;

import org.generation.fyndr.dto.LoginDTO;
import org.generation.fyndr.dto.TokenDTO;
import org.generation.fyndr.modelos.UsuarioComun;
import org.generation.fyndr.modelos.UsuarioTrabajador;
import org.generation.fyndr.repositorios.UsuarioComunRepository;
import org.generation.fyndr.repositorios.UsuarioTrabajadorRepository;
import org.generation.fyndr.seguridad.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Controlador REST para manejar solicitudes de inicio de sesión y autenticación de usuarios.
 */
@RestController
public class AuthController {

    private final UsuarioComunRepository usuarioComunRepository;
    private final UsuarioTrabajadorRepository usuarioTrabajadorRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthController(UsuarioComunRepository usuarioComunRepository,
                          UsuarioTrabajadorRepository usuarioTrabajadorRepository,
                          PasswordEncoder passwordEncoder,
                          JwtUtil jwtUtil) {
        this.usuarioComunRepository = usuarioComunRepository;
        this.usuarioTrabajadorRepository = usuarioTrabajadorRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    } // AuthController

    /**
     * Endpoint para autenticar tanto a UsuarioComun como a UsuarioTrabajador y retornar un JWT.
     */
    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDto) {
        // 1. Buscar en repositorio de UsuarioComun
        Optional<UsuarioComun> usuarioComunOpt = usuarioComunRepository.findByEmail(loginDto.getEmail());
        if (usuarioComunOpt.isPresent()) {
            UsuarioComun usuarioComun = usuarioComunOpt.get();
            if (passwordEncoder.matches(loginDto.getContrasena(), usuarioComun.getContrasena())) {
                String token = jwtUtil.generateToken(usuarioComun.getEmail(), "comun", usuarioComun.getId());
                return ResponseEntity.ok(new TokenDTO(token, usuarioComun.getNombre(), usuarioComun.getEmail(), "comun", usuarioComun.getId()));
            } // if matches
        } // if usuarioComun

        // 2. Buscar en repositorio de UsuarioTrabajador
        Optional<UsuarioTrabajador> usuarioTrabajadorOpt = usuarioTrabajadorRepository.findByEmail(loginDto.getEmail());
        if (usuarioTrabajadorOpt.isPresent()) {
            UsuarioTrabajador usuarioTrabajador = usuarioTrabajadorOpt.get();
            if (passwordEncoder.matches(loginDto.getContrasena(), usuarioTrabajador.getContrasena())) {
                String token = jwtUtil.generateToken(usuarioTrabajador.getEmail(), "trabajador", usuarioTrabajador.getId());
                return ResponseEntity.ok(new TokenDTO(token, usuarioTrabajador.getNombre(), usuarioTrabajador.getEmail(), "trabajador", usuarioTrabajador.getId()));
            } // if matches
        } // if usuarioTrabajador

        // 3. Error de credenciales
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .header("Content-Type", "application/json")
                .body("{\"error\": \"Correo o contraseña incorrectos\"}");
    } // login

    /**
     * Endpoint para obtener la información del usuario autenticado actual.
     */
    @GetMapping("/api/auth/me")
    public ResponseEntity<?> getMe(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("{\"error\": \"Acceso no autorizado: Token faltante\"}");
        }

        String token = authHeader.substring(7);
        try {
            if (!jwtUtil.validateTokenWithoutEmail(token)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("{\"error\": \"Acceso no autorizado: Token inválido o expirado\"}");
            }

            String email = jwtUtil.extractEmail(token);
            String role = jwtUtil.extractRole(token);
            Long id = jwtUtil.extractId(token);

            Map<String, Object> meData = new HashMap<>();
            meData.put("id", id);
            meData.put("email", email);
            meData.put("role", role);

            if ("comun".equals(role)) {
                Optional<UsuarioComun> uc = usuarioComunRepository.findById(id);
                if (uc.isPresent()) {
                    meData.put("nombre", uc.get().getNombre());
                    meData.put("telefono", uc.get().getTelefono());
                    return ResponseEntity.ok(meData);
                }
            } else if ("trabajador".equals(role)) {
                Optional<UsuarioTrabajador> ut = usuarioTrabajadorRepository.findById(id);
                if (ut.isPresent()) {
                    meData.put("nombre", ut.get().getNombre());
                    meData.put("telefono", ut.get().getTelefono());
                    meData.put("direccion", ut.get().getDireccion());
                    return ResponseEntity.ok(meData);
                }
            }

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("{\"error\": \"Usuario no encontrado\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("{\"error\": \"Error al procesar el token\"}");
        }
    }
} // class AuthController
