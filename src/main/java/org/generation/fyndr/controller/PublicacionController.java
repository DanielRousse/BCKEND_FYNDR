package org.generation.fyndr.controller;

import org.generation.fyndr.model.Publicacion;
import org.generation.fyndr.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publicaciones")
@CrossOrigin(origins = "*")
public class PublicacionController {

    private final PublicacionService service;

    @Autowired
    public PublicacionController(PublicacionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Publicacion>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Publicacion> create(@RequestBody Publicacion publicacion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(publicacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publicacion> update(@PathVariable Integer id, @RequestBody Publicacion publicacion) {
        return service.update(id, publicacion)
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
