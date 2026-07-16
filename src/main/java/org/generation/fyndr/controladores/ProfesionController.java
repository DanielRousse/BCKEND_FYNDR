package org.generation.fyndr.controladores;

import org.generation.fyndr.modelos.Profesion;
import org.generation.fyndr.servicios.ProfesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar peticiones relacionadas con profesiones.
 */
@RestController
@RequestMapping(path="/api/profesiones/")
public class ProfesionController {

    private final ProfesionService service;

    @Autowired
    public ProfesionController(ProfesionService service) {
        this.service = service;
    } // ProfesionController

    @GetMapping
    public List<Profesion> getProfesiones() {
        // GET http://localhost:8080/api/profesiones/
        return service.getEntidades();
    } // getProfesiones

    @GetMapping(path="{entidadId}")
    public Profesion getProfesion(@PathVariable("entidadId") Long id) {
        // GET http://localhost:8080/api/profesiones/1
        return service.getEntidad(id);
    } // getProfesion

    @PostMapping
    public Profesion crearProfesion(@RequestBody Profesion profesion) {
        // POST http://localhost:8080/api/profesiones/
        return service.crearEntidad(profesion);
    } // crearProfesion

    @PutMapping(path="{entidadId}")
    public Profesion actualizarProfesion(
            @PathVariable("entidadId") Long id,
            @RequestParam(required = false) String nombreProfesion
    ) {
        // PUT http://localhost:8080/api/profesiones/1
        return service.actualizarEntidad(id, nombreProfesion);
    } // actualizarProfesion

    @DeleteMapping(path="{entidadId}")
    public Profesion eliminarProfesion(@PathVariable("entidadId") Long id) {
        // DELETE http://localhost:8080/api/profesiones/1
        return service.deleteEntidad(id);
    } // eliminarProfesion
} // class ProfesionController
