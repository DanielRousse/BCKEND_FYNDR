package org.generation.fyndr.controladores;

import org.generation.fyndr.dto.UsuarioComunDTO;
import org.generation.fyndr.modelos.UsuarioComun;
import org.generation.fyndr.servicios.UsuarioComunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar peticiones relacionadas con usuarios comunes.
 */
@RestController
@RequestMapping(path="/api/usuarios-comunes/")
@CrossOrigin(origins = "*")
public class UsuarioComunController {

    private final UsuarioComunService service;

    @Autowired
    public UsuarioComunController(UsuarioComunService service) {
        this.service = service;
    } // UsuarioComunController

    @GetMapping
    public List<UsuarioComun> getUsuarios() {
        // GET http://localhost:8080/api/usuarios-comunes/
        return service.getEntidades();
    } // getUsuarios

    @GetMapping(path="{entidadId}")
    public UsuarioComun getUsuario(@PathVariable("entidadId") Integer id) {
        // GET http://localhost:8080/api/usuarios-comunes/1
        return service.getEntidad(id);
    } // getUsuario

    @PostMapping
    public UsuarioComun crearUsuario(@RequestBody UsuarioComun usuario) {
        // POST http://localhost:8080/api/usuarios-comunes/
        return service.crearEntidad(usuario);
    } // crearUsuario

    @PutMapping(path="{entidadId}")
    public UsuarioComun actualizarUsuario(@PathVariable("entidadId") Integer id, @RequestBody UsuarioComunDTO dto) {
        // PUT http://localhost:8080/api/usuarios-comunes/1
        return service.actualizarEntidad(id, dto.getNombre(), dto.getEmail(), dto.getTelefono(), dto.getContrasena());
    } // actualizarUsuario

    @DeleteMapping(path="{entidadId}")
    public UsuarioComun eliminarUsuario(@PathVariable("entidadId") Integer id) {
        // DELETE http://localhost:8080/api/usuarios-comunes/1
        return service.deleteEntidad(id);
    } // eliminarUsuario
} // class UsuarioComunController
