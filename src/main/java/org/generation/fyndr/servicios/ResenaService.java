package org.generation.fyndr.servicios;

import org.generation.fyndr.modelos.Resena;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Servicio para gestionar las operaciones de las resenas en memoria local.
 */
@Service
public class ResenaService {

    private final ArrayList<Resena> lista = new ArrayList<>();

    public ResenaService() {
        lista.add(new Resena(1L, 1L, 5, "Excelente plomero, muy rapido y limpio.", LocalDateTime.now()));
        lista.add(new Resena(2L, 2L, 4, "Buen trabajo electrico, muy puntual.", LocalDateTime.now()));
    } // ResenaService

    public ArrayList<Resena> getEntidades() {
        return lista;
    } // getEntidades

    public Resena getEntidad(Long id) {
        for (int i = 0; i < lista.size(); i++) {
            Resena r = lista.get(i);
            if (r.getId().equals(id)) {
                return r;
            } // if
        } // for
        return null;
    } // getEntidad

    public Resena crearEntidad(Resena obj) {
        Resena nuevo = new Resena(obj.getIdUsuarioComun(), obj.getIdUsuarioTrabajador(), obj.getCalificacion(), obj.getComentario(), LocalDateTime.now());
        lista.add(nuevo);
        return nuevo;
    } // crearEntidad

    public Resena deleteEntidad(Long id) {
        for (int i = 0; i < lista.size(); i++) {
            Resena r = lista.get(i);
            if (r.getId().equals(id)) {
                Resena ref = r;
                lista.remove(i);
                return ref;
            } // if
        } // for
        return null;
    } // deleteEntidad

    public Resena actualizarEntidad(Long id, Long idUsuarioComun, Long idUsuarioTrabajador, Integer calificacion, String comentario) {
        for (int i = 0; i < lista.size(); i++) {
            Resena r = lista.get(i);
            if (r.getId().equals(id)) {
                if (idUsuarioComun != null) {
                    r.setIdUsuarioComun(idUsuarioComun);
                } // if
                if (idUsuarioTrabajador != null) {
                    r.setIdUsuarioTrabajador(idUsuarioTrabajador);
                } // if
                if (calificacion != null) {
                    r.setCalificacion(calificacion);
                } // if
                if (comentario != null) {
                    r.setComentario(comentario);
                } // if
                return r;
            } // if
        } // for
        return null;
    } // actualizarEntidad
} // class ResenaService
