package org.generation.fyndr.servicios;

import org.generation.fyndr.modelos.Publicacion;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Servicio para gestionar las operaciones de las publicaciones en memoria local.
 */
@Service
public class PublicacionService {

    private final ArrayList<Publicacion> lista = new ArrayList<>();

    public PublicacionService() {
        lista.add(new Publicacion("Instalacion de lavabo completo", "Incluye conexion de mangueras y mezcladora nueva.", 450.0, LocalDateTime.now(), 1L));
        lista.add(new Publicacion("Cableado electrico residencial", "Cableado completo de habitacion con materiales premium.", 1500.0, LocalDateTime.now(), 2L));
    } // PublicacionService

    public ArrayList<Publicacion> getEntidades() {
        return lista;
    } // getEntidades

    public Publicacion getEntidad(Long id) {
        for (int i = 0; i < lista.size(); i++) {
            Publicacion p = lista.get(i);
            if (p.getId().equals(id)) {
                return p;
            } // if
        } // for
        return null;
    } // getEntidad

    public Publicacion crearEntidad(Publicacion obj) {
        Publicacion nuevo = new Publicacion(obj.getTitulo(), obj.getDescripcion(), obj.getPrecio(), LocalDateTime.now(), obj.getIdUsuarioTrabajador());
        lista.add(nuevo);
        return nuevo;
    } // crearEntidad

    public Publicacion deleteEntidad(Long id) {
        for (int i = 0; i < lista.size(); i++) {
            Publicacion p = lista.get(i);
            if (p.getId().equals(id)) {
                Publicacion ref = p;
                lista.remove(i);
                return ref;
            } // if
        } // for
        return null;
    } // deleteEntidad

    public Publicacion actualizarEntidad(Long id, String titulo, String descripcion, Double precio, Long idUsuarioTrabajador) {
        for (int i = 0; i < lista.size(); i++) {
            Publicacion p = lista.get(i);
            if (p.getId().equals(id)) {
                if (titulo != null) {
                    p.setTitulo(titulo);
                } // if
                if (descripcion != null) {
                    p.setDescripcion(descripcion);
                } // if
                if (precio != null) {
                    p.setPrecio(precio);
                } // if
                if (idUsuarioTrabajador != null) {
                    p.setIdUsuarioTrabajador(idUsuarioTrabajador);
                } // if
                return p;
            } // if
        } // for
        return null;
    } // actualizarEntidad
} // class PublicacionService
