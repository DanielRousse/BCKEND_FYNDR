package org.generation.fyndr.servicios;

import org.generation.fyndr.modelos.Publicacion;
import org.generation.fyndr.repositorios.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Servicio para gestionar las operaciones de las publicaciones en base de datos.
 */
@Service
public class PublicacionService {

    private final PublicacionRepository publicacionRepository;

    @Autowired
    public PublicacionService(PublicacionRepository publicacionRepository) {
        this.publicacionRepository = publicacionRepository;
    } // PublicacionService

    public List<Publicacion> getEntidades() {
        return publicacionRepository.findAll();
    } // getEntidades

    public Publicacion getEntidad(Long id) {
        return publicacionRepository.findById(id).orElse(null);
    } // getEntidad

    public Publicacion crearEntidad(Publicacion obj) {
        if (obj.getFechaPublicacion() == null) {
            obj.setFechaPublicacion(LocalDateTime.now());
        }
        return publicacionRepository.save(obj);
    } // crearEntidad

    public Publicacion deleteEntidad(Long id) {
        Publicacion p = getEntidad(id);
        if (p != null) {
            publicacionRepository.deleteById(id);
        }
        return p;
    } // deleteEntidad

    public Publicacion actualizarEntidad(Long id, String titulo, String descripcion, Double precio, Long idUsuarioTrabajador) {
        Publicacion p = getEntidad(id);
        if (p != null) {
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
            return publicacionRepository.save(p);
        } // if
        return null;
    } // actualizarEntidad
} // class PublicacionService
