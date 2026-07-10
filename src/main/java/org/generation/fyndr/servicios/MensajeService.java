package org.generation.fyndr.servicios;

import org.generation.fyndr.modelos.Mensaje;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Servicio para gestionar las operaciones de los mensajes en memoria local.
 */
@Service
public class MensajeService {

    private final ArrayList<Mensaje> lista = new ArrayList<>();

    public MensajeService() {
        lista.add(new Mensaje(1L, 1L, "Comun", "Hola, me interesa tu servicio de plomeria.", LocalDateTime.now()));
        lista.add(new Mensaje(1L, 1L, "Trabajador", "Hola, claro, cuando te gustaria programar la cita?", LocalDateTime.now()));
    } // MensajeService

    public ArrayList<Mensaje> getEntidades() {
        return lista;
    } // getEntidades

    public Mensaje getEntidad(Long id) {
        for (int i = 0; i < lista.size(); i++) {
            Mensaje m = lista.get(i);
            if (m.getId().equals(id)) {
                return m;
            } // if
        } // for
        return null;
    } // getEntidad

    public Mensaje crearEntidad(Mensaje obj) {
        Mensaje nuevo = new Mensaje(obj.getIdUsuarioComun(), obj.getIdUsuarioTrabajador(), obj.getRemitente(), obj.getContenido(), LocalDateTime.now());
        lista.add(nuevo);
        return nuevo;
    } // crearEntidad

    public Mensaje deleteEntidad(Long id) {
        for (int i = 0; i < lista.size(); i++) {
            Mensaje m = lista.get(i);
            if (m.getId().equals(id)) {
                Mensaje ref = m;
                lista.remove(i);
                return ref;
            } // if
        } // for
        return null;
    } // deleteEntidad

    public Mensaje actualizarEntidad(Long id, Long idUsuarioComun, Long idUsuarioTrabajador, String remitente, String contenido) {
        for (int i = 0; i < lista.size(); i++) {
            Mensaje m = lista.get(i);
            if (m.getId().equals(id)) {
                if (idUsuarioComun != null) {
                    m.setIdUsuarioComun(idUsuarioComun);
                } // if
                if (idUsuarioTrabajador != null) {
                    m.setIdUsuarioTrabajador(idUsuarioTrabajador);
                } // if
                if (remitente != null) {
                    m.setRemitente(remitente);
                } // if
                if (contenido != null) {
                    m.setContenido(contenido);
                } // if
                return m;
            } // if
        } // for
        return null;
    } // actualizarEntidad
} // class MensajeService
