package org.generation.fyndr.controller;

import org.generation.fyndr.model.UsuarioTrabajador;
import org.generation.fyndr.service.UsuarioTrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios-trabajadores")
@CrossOrigin(origins = "*")
public class UsuarioTrabajadorController {

    private final UsuarioTrabajadorService service;

    @Autowired
    public UsuarioTrabajadorController(UsuarioTrabajadorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioTrabajador>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioTrabajador> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioTrabajador> create(@RequestBody UsuarioTrabajador trabajador) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(trabajador));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioTrabajador> update(@PathVariable Integer id, @RequestBody UsuarioTrabajador trabajador) {
        return service.update(id, trabajador)
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
