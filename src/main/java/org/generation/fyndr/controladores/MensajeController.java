package org.generation.fyndr.controladores;

import org.generation.fyndr.modelos.Mensaje;
import org.generation.fyndr.servicios.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar peticiones relacionadas con mensajes.
 */
@RestController
@RequestMapping(path="/api/mensajes/")
@CrossOrigin(origins = "*")
public class MensajeController {

    private final MensajeService service;

    @Autowired
    public MensajeController(MensajeService service) {
        this.service = service;
    } // MensajeController

    @GetMapping
    public List<Mensaje> getMensajes() {
        // GET http://localhost:8080/api/mensajes/
        return service.getEntidades();
    } // getMensajes

    @GetMapping(path="{entidadId}")
    public Mensaje getMensaje(@PathVariable("entidadId") Long id) {
        // GET http://localhost:8080/api/mensajes/1
        return service.getEntidad(id);
    } // getMensaje

    @PostMapping
    public Mensaje crearMensaje(@RequestBody Mensaje mensaje) {
        // POST http://localhost:8080/api/mensajes/
        return service.crearEntidad(mensaje);
    } // crearMensaje

    @PutMapping(path="{entidadId}")
    public Mensaje actualizarMensaje(
            @PathVariable("entidadId") Long id,
            @RequestParam(required = false) Long idUsuarioComun,
            @RequestParam(required = false) Long idUsuarioTrabajador,
            @RequestParam(required = false) String remitente,
            @RequestParam(required = false) String contenido
    ) {
        // PUT http://localhost:8080/api/mensajes/1
        return service.actualizarEntidad(id, idUsuarioComun, idUsuarioTrabajador, remitente, contenido);
    } // actualizarMensaje

    @DeleteMapping(path="{entidadId}")
    public Mensaje eliminarMensaje(@PathVariable("entidadId") Long id) {
        // DELETE http://localhost:8080/api/mensajes/1
        return service.deleteEntidad(id);
    } // eliminarMensaje
} // class MensajeController
