package org.generation.fyndr.controller;

import org.generation.fyndr.model.Mensaje;
import org.generation.fyndr.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mensajes")
@CrossOrigin(origins = "*")
public class MensajeController {

    private final MensajeService service;

    @Autowired
    public MensajeController(MensajeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Mensaje>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mensaje> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mensaje> create(@RequestBody Mensaje mensaje) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(mensaje));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mensaje> update(@PathVariable Integer id, @RequestBody Mensaje mensaje) {
        return service.update(id, mensaje)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (service.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
