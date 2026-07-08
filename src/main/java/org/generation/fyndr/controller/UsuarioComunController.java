package org.generation.fyndr.controller;

import org.generation.fyndr.model.UsuarioComun;
import org.generation.fyndr.service.UsuarioComunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios-comunes")
@CrossOrigin(origins = "*")
public class UsuarioComunController {

    private final UsuarioComunService service;

    @Autowired
    public UsuarioComunController(UsuarioComunService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioComun>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioComun> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioComun> create(@RequestBody UsuarioComun usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioComun> update(@PathVariable Integer id, @RequestBody UsuarioComun usuario) {
        return service.update(id, usuario)
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
