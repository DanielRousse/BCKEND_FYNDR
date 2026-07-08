package org.generation.fyndr.controller;

import org.generation.fyndr.model.Resena;
import org.generation.fyndr.service.ResenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resenas")
@CrossOrigin(origins = "*")
public class ResenaController {

    private final ResenaService service;

    @Autowired
    public ResenaController(ResenaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Resena>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resena> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Resena> create(@RequestBody Resena resena) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(resena));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resena> update(@PathVariable Integer id, @RequestBody Resena resena) {
        return service.update(id, resena)
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
