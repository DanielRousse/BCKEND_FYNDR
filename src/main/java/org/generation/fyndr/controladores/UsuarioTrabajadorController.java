package org.generation.fyndr.controladores;

import org.generation.fyndr.dto.TrabajadorDTO;
import org.generation.fyndr.modelos.UsuarioTrabajador;
import org.generation.fyndr.servicios.UsuarioTrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar peticiones relacionadas con usuarios trabajadores.
 */
@RestController
@RequestMapping(path="/api/usuarios-trabajadores/")
@CrossOrigin(origins = "*")
public class UsuarioTrabajadorController {

    private final UsuarioTrabajadorService service;

    @Autowired
    public UsuarioTrabajadorController(UsuarioTrabajadorService service) {
        this.service = service;
    } // UsuarioTrabajadorController

    @GetMapping
    public List<UsuarioTrabajador> getTrabajadores() {
        // GET http://localhost:8080/api/usuarios-trabajadores/
        return service.getEntidades();
    } // getTrabajadores

    @GetMapping(path="{entidadId}")
    public UsuarioTrabajador getTrabajador(@PathVariable("entidadId") Long id) {
        // GET http://localhost:8080/api/usuarios-trabajadores/1
        return service.getEntidad(id);
    } // getTrabajador

    @PostMapping
    public UsuarioTrabajador crearTrabajador(@RequestBody UsuarioTrabajador trabajador) {
        // POST http://localhost:8080/api/usuarios-trabajadores/
        return service.crearEntidad(trabajador);
    } // crearTrabajador

    @PutMapping(path="{entidadId}")
    public UsuarioTrabajador actualizarTrabajador(@PathVariable("entidadId") Long id, @RequestBody TrabajadorDTO dto) {
        // PUT http://localhost:8080/api/usuarios-trabajadores/1
        return service.actualizarEntidad(id, dto);
    } // actualizarTrabajador

    @DeleteMapping(path="{entidadId}")
    public UsuarioTrabajador eliminarTrabajador(@PathVariable("entidadId") Long id) {
        // DELETE http://localhost:8080/api/usuarios-trabajadores/1
        return service.deleteEntidad(id);
    } // eliminarTrabajador
} // class UsuarioTrabajadorController
