package org.generation.fyndr.servicios;

import org.generation.fyndr.modelos.Publicacion;
import org.generation.fyndr.modelos.UsuarioTrabajador;
import org.generation.fyndr.repositorios.PublicacionRepository;
import org.generation.fyndr.repositorios.UsuarioTrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Servicio para gestionar las publicaciones usando persistencia JPA.
 */
@Service
public class PublicacionService {

    private final PublicacionRepository repository;
    private final UsuarioTrabajadorRepository usuarioTrabajadorRepository;

    @Autowired
    public PublicacionService(PublicacionRepository repository, UsuarioTrabajadorRepository usuarioTrabajadorRepository) {
        this.repository = repository;
        this.usuarioTrabajadorRepository = usuarioTrabajadorRepository;
    } // PublicacionService

    public List<Publicacion> getPublicaciones() {
        return repository.findAll();
    } // getPublicaciones

    public Publicacion getPublicacion(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Publicacion no encontrada"));
    } // getPublicacion

    public Publicacion crearPublicacion(Publicacion obj) {
        if (obj.getFechaPublicacion() == null) {
            obj.setFechaPublicacion(LocalDateTime.now());
        } // if

        UsuarioTrabajador usuarioTrabajador = obj.getUsuarioTrabajador();
        if (usuarioTrabajador == null || usuarioTrabajador.getId() == null) {
            throw new IllegalArgumentException("Debe incluirse el id del usuario trabajador");
        } // if

        UsuarioTrabajador usuarioGuardado = usuarioTrabajadorRepository.findById(usuarioTrabajador.getId())
                .orElseThrow(() -> new IllegalArgumentException("El usuario trabajador no existe"));
        obj.setUsuarioTrabajador(usuarioGuardado);

        return repository.save(obj);
    } // crearEntidad

    public Publicacion deletePublicacion(Long id) {
        Publicacion ref = getPublicacion(id);
        repository.delete(ref);
        return ref;
    } // deletePublicacion

    public Publicacion actualizarPublicacion(Long id, String titulo, String descripcion, Double precio, Long idUsuarioTrabajador) {
        Publicacion p = getPublicacion(id);
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
            UsuarioTrabajador usuarioGuardado = usuarioTrabajadorRepository.findById(idUsuarioTrabajador)
                    .orElseThrow(() -> new IllegalArgumentException("El usuario trabajador no existe"));
            p.setUsuarioTrabajador(usuarioGuardado);
        } // if
        return repository.save(p);
    } // actualizarPublicacion
} // class PublicacionService
