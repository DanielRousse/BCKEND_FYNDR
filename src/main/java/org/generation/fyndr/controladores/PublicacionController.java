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
@CrossOrigin(origins = "*")
public class PublicacionController {

    private final PublicacionService service;

    @Autowired
    public PublicacionController(PublicacionService service) {
        this.service = service;
    } // PublicacionController

    @GetMapping
    public List<Publicacion> getPublicaciones() {
        // GET http://localhost:8080/api/publicaciones/
        return service.getPublicaciones();
    } // getPublicaciones

    @GetMapping(path="{publicacionId}")
    public Publicacion getPublicacion(@PathVariable("publicacionId") Long id) {
        // GET http://localhost:8080/api/publicaciones/1
        return service.getPublicacion(id);
    } // getPublicacion

    @PostMapping
    public Publicacion crearPublicacion(@RequestBody Publicacion publicacion) {
        // POST http://localhost:8080/api/publicaciones/
        return service.crearPublicacion(publicacion);
    } // crearPublicacion

    @PutMapping(path="{publicacionId}")
    public Publicacion actualizarPublicacion(
            @PathVariable("publicacionId") Long id,
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String descripcion,
            @RequestParam(required = false) Double precio,
            @RequestParam(required = false) Long idUsuarioTrabajador
    ) {
        // PUT http://localhost:8080/api/publicaciones/1
        return service.actualizarPublicacion(id, titulo, descripcion, precio, idUsuarioTrabajador);
    } // actualizarPublicacion

    @DeleteMapping(path="{publicacionId}")
    public Publicacion eliminarPublicacion(@PathVariable("publicacionId") Long id) {
        // DELETE http://localhost:8080/api/publicaciones/1
        return service.deletePublicacion(id);
    } // eliminarPublicacion
} // class PublicacionController
