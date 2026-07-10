package org.generation.fyndr.servicios;

import org.generation.fyndr.modelos.UsuarioComun;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Servicio para gestionar las operaciones de los usuarios comunes en memoria local.
 */
@Service
public class UsuarioComunService {

    private final ArrayList<UsuarioComun> lista = new ArrayList<>();

    public UsuarioComunService() {
        lista.add(new UsuarioComun("Juan Perez", "juan@example.com", "5551234567", "Password123!", LocalDateTime.now()));
        lista.add(new UsuarioComun("Maria Lopez", "maria@example.com", "5557654321", "SecurePass456!", LocalDateTime.now()));
    } // UsuarioComunService

    public ArrayList<UsuarioComun> getEntidades() {
        return lista;
    } // getEntidades

    public UsuarioComun getEntidad(Long id) {
        for (int i = 0; i < lista.size(); i++) {
            UsuarioComun u = lista.get(i);
            if (u.getId().equals(id)) {
                return u;
            } // if
        } // for
        return null;
    } // getEntidad

    public UsuarioComun crearEntidad(UsuarioComun obj) {
        UsuarioComun nuevo = new UsuarioComun(obj.getNombre(), obj.getEmail(), obj.getTelefono(), obj.getContrasena(), LocalDateTime.now());
        lista.add(nuevo);
        return nuevo;
    } // crearEntidad

    public UsuarioComun deleteEntidad(Long id) {
        for (int i = 0; i < lista.size(); i++) {
            UsuarioComun u = lista.get(i);
            if (u.getId().equals(id)) {
                UsuarioComun ref = u;
                lista.remove(i);
                return ref;
            } // if
        } // for
        return null;
    } // deleteEntidad

    public UsuarioComun actualizarEntidad(Long id, String nombre, String email, String telefono, String contrasena) {
        for (int i = 0; i < lista.size(); i++) {
            UsuarioComun u = lista.get(i);
            if (u.getId().equals(id)) {
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
                    u.setContrasena(contrasena);
                } // if
                return u;
            } // if
        } // for
        return null;
    } // actualizarEntidad
} // class UsuarioComunService
