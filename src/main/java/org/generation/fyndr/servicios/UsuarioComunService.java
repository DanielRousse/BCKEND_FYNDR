package org.generation.fyndr.servicios;

import org.generation.fyndr.modelos.UsuarioComun;
import org.generation.fyndr.repositorios.UsuarioComunRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Servicio para gestionar las operaciones de los usuarios comunes conectandose a JPA.
 */
@Service
public class UsuarioComunService {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioComunService.class);
    private final UsuarioComunRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioComunService(UsuarioComunRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    } // UsuarioComunService

    public ArrayList<UsuarioComun> getEntidades() {
        return new ArrayList<>(repository.findAll());
    } // getEntidades

    public UsuarioComun getEntidad(Long id) {
        return repository.findById(id).orElse(null);
    } // getEntidad

    public UsuarioComun crearEntidad(UsuarioComun obj) {
        obj.setContrasena(passwordEncoder.encode(obj.getContrasena()));
        UsuarioComun saved = repository.save(obj);
        logger.info("Usuario común creado: id={}, email='{}'", saved.getId(), saved.getEmail());
        return saved;
    } // crearEntidad

    public UsuarioComun deleteEntidad(Long id) {
        UsuarioComun ref = getEntidad(id);
        if (ref != null) {
            repository.delete(ref);
            logger.info("Usuario común eliminado: id={}", id);
            return ref;
        } // if
        logger.warn("Intento de eliminar usuario común inexistente: id={}", id);
        return null;
    } // deleteEntidad

    public UsuarioComun actualizarEntidad(Long id, String nombre, String email, String telefono, String contrasena, String fotografiaPath, String direccionesJson, String tarjetasJson) {
        UsuarioComun u = getEntidad(id);
        if (u != null) {
            if (nombre != null) {
                u.setNombre(nombre);
            } // if
            if (email != null) {
                u.setEmail(email);
            } // if
            if (telefono != null) {
                u.setTelefono(telefono);
            } // if
            if (contrasena != null) {
                u.setContrasena(passwordEncoder.encode(contrasena));
            } // if
            if (fotografiaPath != null) {
                u.setFotografiaPath(fotografiaPath);
            } // if
            if (direccionesJson != null) {
                u.setDireccionesJson(direccionesJson);
            } // if
            if (tarjetasJson != null) {
                u.setTarjetasJson(tarjetasJson);
            } // if
            UsuarioComun updated = repository.save(u);
            logger.info("Usuario común actualizado: id={}", updated.getId());
            return updated;
        } // if
        logger.warn("Intento de actualizar usuario común inexistente: id={}", id);
        return null;
    } // actualizarEntidad
} // class UsuarioComunService
