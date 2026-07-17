package org.generation.fyndr.controladores;

import org.generation.fyndr.dto.TrabajadorDTO;
import org.generation.fyndr.modelos.UsuarioTrabajador;
import org.generation.fyndr.servicios.UsuarioTrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar peticiones relacionadas con usuarios trabajadores.
 */
@RestController
@RequestMapping(path="/api/usuarios-trabajadores/")
public class UsuarioTrabajadorController {

    private final UsuarioTrabajadorService service;

    @Autowired
    public UsuarioTrabajadorController(UsuarioTrabajadorService service) {
        this.service = service;
    } // UsuarioTrabajadorController

    @GetMapping
    public List<UsuarioTrabajador> getTrabajadores(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {
        // GET http://localhost:8080/api/usuarios-trabajadores/
        if (page != null && size != null) {
            return service.getEntidadesPaginadas(page, size).getContent();
        }
        return service.getEntidades();
    } // getTrabajadores

    @GetMapping(path="{entidadId}")
    public UsuarioTrabajador getTrabajador(@PathVariable("entidadId") Long id) {
        // GET http://localhost:8080/api/usuarios-trabajadores/1
        return service.getEntidad(id);
    } // getTrabajador

    @PostMapping
    public UsuarioTrabajador crearTrabajador(@Valid @RequestBody UsuarioTrabajador trabajador) {
        // POST http://localhost:8080/api/usuarios-trabajadores/
        return service.crearEntidad(trabajador);
    } // crearTrabajador

    @PutMapping(path="{entidadId}")
    public UsuarioTrabajador actualizarTrabajador(@PathVariable("entidadId") Long id, @Valid @RequestBody TrabajadorDTO dto) {
        // PUT http://localhost:8080/api/usuarios-trabajadores/1
        return service.actualizarEntidad(id, dto);
    } // actualizarTrabajador

    @DeleteMapping(path="{entidadId}")
    public UsuarioTrabajador eliminarTrabajador(@PathVariable("entidadId") Long id) {
        // DELETE http://localhost:8080/api/usuarios-trabajadores/1
        return service.deleteEntidad(id);
    } // eliminarTrabajador

    /**
     * Buscar trabajadores por profesión.
     */
    @GetMapping("profesion/{profesionId}")
    public ResponseEntity<List<UsuarioTrabajador>> buscarPorProfesion(@PathVariable("profesionId") Long profesionId) {
        return ResponseEntity.ok(service.buscarPorProfesion(profesionId));
    }

    /**
     * Asignar una profesión a un trabajador.
     */
    @PostMapping("{trabajadorId}/profesiones/{profesionId}")
    public ResponseEntity<UsuarioTrabajador> asignarProfesion(
            @PathVariable("trabajadorId") Long trabajadorId,
            @PathVariable("profesionId") Long profesionId) {
        return ResponseEntity.ok(service.asignarProfesion(trabajadorId, profesionId));
    }

    /**
     * Desasignar una profesión de un trabajador.
     */
    @DeleteMapping("{trabajadorId}/profesiones/{profesionId}")
    public ResponseEntity<UsuarioTrabajador> desasignarProfesion(
            @PathVariable("trabajadorId") Long trabajadorId,
            @PathVariable("profesionId") Long profesionId) {
        return ResponseEntity.ok(service.desasignarProfesion(trabajadorId, profesionId));
    }
} // class UsuarioTrabajadorController
