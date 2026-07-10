package org.generation.fyndr.servicios;

import org.generation.fyndr.modelos.Contratacion;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Servicio para gestionar las operaciones de las contrataciones en memoria local.
 */
@Service
public class ContratacionService {

    private final ArrayList<Contratacion> lista = new ArrayList<>();

    public ContratacionService() {
        lista.add(new Contratacion(1L, 1L, LocalDateTime.now(), "Pendiente"));
        lista.add(new Contratacion(2L, 2L, LocalDateTime.now(), "Aceptado"));
    } // ContratacionService

    public ArrayList<Contratacion> getEntidades() {
        return lista;
    } // getEntidades

    public Contratacion getEntidad(Long id) {
        for (int i = 0; i < lista.size(); i++) {
            Contratacion c = lista.get(i);
            if (c.getId().equals(id)) {
                return c;
            } // if
        } // for
        return null;
    } // getEntidad

    public Contratacion crearEntidad(Contratacion obj) {
        Contratacion nuevo = new Contratacion(obj.getIdUsuarioComun(), obj.getIdUsuarioTrabajador(), LocalDateTime.now(), "Pendiente");
        lista.add(nuevo);
        return nuevo;
    } // crearEntidad

    public Contratacion deleteEntidad(Long id) {
        for (int i = 0; i < lista.size(); i++) {
            Contratacion c = lista.get(i);
            if (c.getId().equals(id)) {
                Contratacion ref = c;
                lista.remove(i);
                return ref;
            } // if
        } // for
        return null;
    } // deleteEntidad

    public Contratacion actualizarEntidad(Long id, Long idUsuarioComun, Long idUsuarioTrabajador, String estado) {
        for (int i = 0; i < lista.size(); i++) {
            Contratacion c = lista.get(i);
            if (c.getId().equals(id)) {
                if (idUsuarioComun != null) {
                    c.setIdUsuarioComun(idUsuarioComun);
                } // if
                if (idUsuarioTrabajador != null) {
                    c.setIdUsuarioTrabajador(idUsuarioTrabajador);
                } // if
                if (estado != null) {
                    c.setEstado(estado);
                } // if
                return c;
            } // if
        } // for
        return null;
    } // actualizarEntidad
} // class ContratacionService
