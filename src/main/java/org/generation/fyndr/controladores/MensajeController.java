package org.generation.fyndr.controladores;

import org.generation.fyndr.modelos.Mensaje;
import org.generation.fyndr.servicios.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/mensajes/")
public class MensajeController {

    private final MensajeService service;

    @Autowired
    public MensajeController(MensajeService service) {
        this.service = service;
    }

    // get http://localhost:8080/api/mensajes/
    @GetMapping
    public List<Mensaje> getMensajes() {
        return service.todosLosMensajes();
    }

    // get http://localhost:8080/api/mensajes/1
    @GetMapping(path="/{entidadId}")
    public ResponseEntity<Mensaje> getMensaje(@PathVariable("entidadId") Long id) {
        return service.mensajesPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //  post http://localhost:8080/api/mensajes/
    @PostMapping
    public Mensaje crearMensaje(@RequestBody Mensaje mensaje) {
        return service.crearMensaje(mensaje);
    }

    //  put http://localhost:8080/api/mensajes/1
    @PutMapping(path="/{entidadId}")
    public ResponseEntity<Mensaje> actualizarMensaje(
            @PathVariable("entidadId") Long id,
            @RequestBody Mensaje datosActualizados) {
        try {
            return ResponseEntity.ok(service.actualizarMensaje(id, datosActualizados));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // delete http://localhost:8080/api/mensajes/1
    @DeleteMapping(path="/{entidadId}")
    public ResponseEntity<Void> eliminarMensaje(@PathVariable("entidadId") Long id) {
        try {
            service.eliminarMensaje(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}