package org.generation.fyndr.controladores;

import org.generation.fyndr.modelos.Resena;
import org.generation.fyndr.servicios.ResenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar peticiones relacionadas con resenas.
 */
@RestController
@RequestMapping(path="/api/resenas/")
@CrossOrigin(origins = "*")
public class ResenaController {

    private final ResenaService service;

    @Autowired
    public ResenaController(ResenaService service) {
        this.service = service;
    } // ResenaController

    @GetMapping
    public List<Resena> getResenas() {
        // GET http://localhost:8080/api/resenas/
        return service.getEntidades();
    } // getResenas

    @GetMapping(path="{entidadId}")
    public Resena getResena(@PathVariable("entidadId") Long id) {
        // GET http://localhost:8080/api/resenas/1
        return service.getEntidad(id);
    } // getResena

    @PostMapping
    public Resena crearResena(@RequestBody Resena resena) {
        // POST http://localhost:8080/api/resenas/
        return service.crearEntidad(resena);
    } // crearResena

    @PutMapping(path="{entidadId}")
    public Resena actualizarResena(
            @PathVariable("entidadId") Long id,
            @RequestParam(required = false) Long idUsuarioComun,
            @RequestParam(required = false) Long idUsuarioTrabajador,
            @RequestParam(required = false) Integer calificacion,
            @RequestParam(required = false) String comentario
    ) {
        // PUT http://localhost:8080/api/resenas/1
        return service.actualizarEntidad(id, idUsuarioComun, idUsuarioTrabajador, calificacion, comentario);
    } // actualizarResena

    @DeleteMapping(path="{entidadId}")
    public Resena eliminarResena(@PathVariable("entidadId") Long id) {
        // DELETE http://localhost:8080/api/resenas/1
        return service.deleteEntidad(id);
    } // eliminarResena
} // class ResenaController
