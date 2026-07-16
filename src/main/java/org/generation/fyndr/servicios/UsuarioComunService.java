package org.generation.fyndr.servicios;

import org.generation.fyndr.modelos.UsuarioComun;
import org.generation.fyndr.repositorios.UsuarioComunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Servicio para gestionar las operaciones de los usuarios comunes conectandose a JPA.
 */
@Service
public class UsuarioComunService {

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
        return repository.save(obj);
    } // crearEntidad

    public UsuarioComun deleteEntidad(Long id) {
        UsuarioComun ref = getEntidad(id);
        if (ref != null) {
            repository.delete(ref);
            return ref;
        } // if
        return null;
    } // deleteEntidad

    public UsuarioComun actualizarEntidad(Long id, String nombre, String email, String telefono, String contrasena, String fotografiaPath) {
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
            return repository.save(u);
        } // if
        return null;
    } // actualizarEntidad
} // class UsuarioComunService
