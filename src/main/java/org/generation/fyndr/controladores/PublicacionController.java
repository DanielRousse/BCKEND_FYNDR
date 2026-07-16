package org.generation.fyndr.controladores;

import org.generation.fyndr.modelos.Publicacion;
import org.generation.fyndr.servicios.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar peticiones relacionadas con publicaciones.
 */
@RestController
@RequestMapping(path="/api/publicaciones/")
public class PublicacionController {

    private final PublicacionService service;

    @Autowired
    public PublicacionController(PublicacionService service) {
        this.service = service;
    } // PublicacionController

    @GetMapping
    public List<Publicacion> getPublicaciones() {
        // GET http://localhost:8080/api/publicaciones/
        return service.getEntidades();
    } // getPublicaciones

    @GetMapping(path="{entidadId}")
    public Publicacion getPublicacion(@PathVariable("entidadId") Long id) {
        // GET http://localhost:8080/api/publicaciones/1
        return service.getEntidad(id);
    } // getPublicacion

    @PostMapping
    public Publicacion crearPublicacion(@RequestBody Publicacion publicacion) {
        // POST http://localhost:8080/api/publicaciones/
        return service.crearEntidad(publicacion);
    } // crearPublicacion

    @PutMapping(path="{entidadId}")
    public Publicacion actualizarPublicacion(
            @PathVariable("entidadId") Long id,
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String descripcion,
            @RequestParam(required = false) Double precio,
            @RequestParam(required = false) Long idUsuarioTrabajador
    ) {
        // PUT http://localhost:8080/api/publicaciones/1
        return service.actualizarEntidad(id, titulo, descripcion, precio, idUsuarioTrabajador);
    } // actualizarPublicacion

    @DeleteMapping(path="{entidadId}")
    public Publicacion eliminarPublicacion(@PathVariable("entidadId") Long id) {
        // DELETE http://localhost:8080/api/publicaciones/1
        return service.deleteEntidad(id);
    } // eliminarPublicacion
} // class PublicacionController
