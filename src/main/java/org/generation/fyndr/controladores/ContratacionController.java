package org.generation.fyndr.controladores;

import org.generation.fyndr.modelos.Contratacion;
import org.generation.fyndr.servicios.ContratacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar peticiones relacionadas con contrataciones.
 */
@RestController
@RequestMapping(path="/api/contrataciones/")
@CrossOrigin(origins = "*")
public class ContratacionController {

    private final ContratacionService service;

    @Autowired
    public ContratacionController(ContratacionService service) {
        this.service = service;
    } // ContratacionController

    @GetMapping
    public List<Contratacion> getContrataciones() {
        // GET http://localhost:8080/api/contrataciones/
        return service.getEntidades();
    } // getContrataciones

    @GetMapping(path="{entidadId}")
    public Contratacion getContratacion(@PathVariable("entidadId") Long id) {
        // GET http://localhost:8080/api/contrataciones/1
        return service.getEntidad(id);
    } // getContratacion

    @PostMapping
    public Contratacion crearContratacion(@RequestBody Contratacion contratacion) {
        // POST http://localhost:8080/api/contrataciones/
        return service.crearEntidad(contratacion);
    } // crearContratacion

    @PutMapping(path="{entidadId}")
    public Contratacion actualizarContratacion(
            @PathVariable("entidadId") Long id,
            @RequestParam(required = false) Long idUsuarioComun,
            @RequestParam(required = false) Long idUsuarioTrabajador,
            @RequestParam(required = false) String estado
    ) {
        // PUT http://localhost:8080/api/contrataciones/1
        return service.actualizarEntidad(id, idUsuarioComun, idUsuarioTrabajador, estado);
    } // actualizarContratacion

    @DeleteMapping(path="{entidadId}")
    public Contratacion eliminarContratacion(@PathVariable("entidadId") Long id) {
        // DELETE http://localhost:8080/api/contrataciones/1
        return service.deleteEntidad(id);
    } // eliminarContratacion
} // class ContratacionController
