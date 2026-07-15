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

import java.util.Optional;

/**
 * Controlador REST para manejar solicitudes de inicio de sesión y autenticación de usuarios.
 */
@RestController
@RequestMapping(path="/api/login")
@CrossOrigin(origins = "*")
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
    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDto) {
        // 1. Buscar en repositorio de UsuarioComun
        Optional<UsuarioComun> usuarioComunOpt = usuarioComunRepository.findByEmail(loginDto.getEmail());
        if (usuarioComunOpt.isPresent()) {
            UsuarioComun usuarioComun = usuarioComunOpt.get();
            if (passwordEncoder.matches(loginDto.getContrasena(), usuarioComun.getContrasena())) {
                String token = jwtUtil.generateToken(usuarioComun.getEmail());
                return ResponseEntity.ok(new TokenDTO(token));
            } // if matches
        } // if usuarioComun

        // 2. Buscar en repositorio de UsuarioTrabajador
        Optional<UsuarioTrabajador> usuarioTrabajadorOpt = usuarioTrabajadorRepository.findByEmail(loginDto.getEmail());
        if (usuarioTrabajadorOpt.isPresent()) {
            UsuarioTrabajador usuarioTrabajador = usuarioTrabajadorOpt.get();
            if (passwordEncoder.matches(loginDto.getContrasena(), usuarioTrabajador.getContrasena())) {
                String token = jwtUtil.generateToken(usuarioTrabajador.getEmail());
                return ResponseEntity.ok(new TokenDTO(token));
            } // if matches
        } // if usuarioTrabajador

        // 3. Error de credenciales
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .header("Content-Type", "application/json")
                .body("{\"error\": \"Correo o contraseña incorrectos\"}");
    } // login
} // class AuthController
