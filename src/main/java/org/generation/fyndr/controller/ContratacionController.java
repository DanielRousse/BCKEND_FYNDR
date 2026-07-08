package org.generation.fyndr.controller;

import org.generation.fyndr.model.Contratacion;
import org.generation.fyndr.service.ContratacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contrataciones")
@CrossOrigin(origins = "*")
public class ContratacionController {

    private final ContratacionService service;

    @Autowired
    public ContratacionController(ContratacionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Contratacion>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contratacion> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Contratacion> create(@RequestBody Contratacion contratacion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(contratacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contratacion> update(@PathVariable Integer id, @RequestBody Contratacion contratacion) {
        return service.update(id, contratacion)
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
