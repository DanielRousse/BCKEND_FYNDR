package org.generation.fyndr.controller;

import org.generation.fyndr.model.Profesion;
import org.generation.fyndr.service.ProfesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesiones")
@CrossOrigin(origins = "*")
public class ProfesionController {

    private final ProfesionService service;

    @Autowired
    public ProfesionController(ProfesionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Profesion>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profesion> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Profesion> create(@RequestBody Profesion profesion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(profesion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profesion> update(@PathVariable Integer id, @RequestBody Profesion profesion) {
        return service.update(id, profesion)
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
