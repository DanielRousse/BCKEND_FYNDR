package org.generation.fyndr.controladores;

import org.generation.fyndr.modelos.Resena;
import org.generation.fyndr.servicios.ResenaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar peticiones relacionadas con resenas.
 */
@RestController
@RequestMapping(path="/api/resenas/")
public class ResenaController {


    private static final Logger logger = LoggerFactory.getLogger(ResenaController.class);

    private final ResenaService resenaService;

    public ResenaController(ResenaService service) {
        this.resenaService = service;
    }

    @GetMapping
    public ResponseEntity<List<Resena>> getResenas() {
        ResenaController.logger.info("Iniciando la consulta de reseñas");
        List<Resena> resenas = resenaService.obtenerResenas();
        if (resenas.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(resenas);
    }

    @GetMapping("/{entidadId}")
    public ResponseEntity<Resena> getResena(@PathVariable Long entidadId) {
        ResenaController.logger.info("Buscando la reseña con id: {}", entidadId);
        Resena resena = resenaService.obtenerResena(entidadId);
        ResenaController.logger.info("Reseña encontrada: {}", resena);
        return ResponseEntity.ok(resena);
    }

    @PostMapping
    public ResponseEntity<Resena> crearResena(@RequestBody Resena resena) {
        ResenaController.logger.info("Creando reseña: {}", resena);
        Resena resenaCreated = resenaService.crearResena(resena);
        ResenaController.logger.info("Reseña creada: {}", resenaCreated);
        return ResponseEntity.status(HttpStatus.CREATED).body(resenaCreated);
    }

    @PutMapping("/{entidadId}")
    public ResponseEntity<Resena> actualizarResena(@PathVariable Long entidadId, @RequestBody Resena resena) {
        ResenaController.logger.info("Actualizado reseña con id: {}", entidadId);
        Resena resenaBD = this.resenaService.actualizarResena(entidadId, resena);
        ResenaController.logger.info("Reseña actualizada: {}", resenaBD);
        return ResponseEntity.ok(resenaBD);
    }

    @DeleteMapping("/{entidadId}")
    public ResponseEntity<Void> eliminarResena(@PathVariable Long entidadId) {
        ResenaController.logger.info("Eliminando reseña con id: {}", entidadId);
        this.resenaService.borrarResena(entidadId);
        return ResponseEntity.noContent().build();
    }

}
