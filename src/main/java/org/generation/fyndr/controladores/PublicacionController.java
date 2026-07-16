package org.generation.fyndr.controladores;

import org.generation.fyndr.dto.PublicacionDTO;
import org.generation.fyndr.dto.PublicacionResponseDTO;
import org.generation.fyndr.servicios.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/publicaciones")
public class PublicacionController {

    private final PublicacionService service;

    @Autowired
    public PublicacionController(PublicacionService service) {
        this.service = service;
    } // PublicacionController

    @GetMapping
    public ResponseEntity<List<PublicacionResponseDTO>> getPublicaciones(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {
        if (page != null && size != null) {
            return ResponseEntity.ok(service.getEntidadesPaginadas(page, size).getContent());
        }
        return ResponseEntity.ok(service.getEntidades());
    }

    @GetMapping("/{entidadId}")
    public ResponseEntity<PublicacionResponseDTO> getPublicacion(@PathVariable("entidadId") Long id) {
        PublicacionResponseDTO dto = service.getEntidad(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PublicacionResponseDTO> crearPublicacion(@Valid @RequestBody PublicacionDTO dto) {
        PublicacionResponseDTO created = service.crearEntidad(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{entidadId}")
    public ResponseEntity<PublicacionResponseDTO> actualizarPublicacion(
            @PathVariable("entidadId") Long id,
            @Valid @RequestBody PublicacionDTO dto) {
        PublicacionResponseDTO updated = service.actualizarEntidad(id, dto);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{entidadId}")
    public ResponseEntity<PublicacionResponseDTO> eliminarPublicacion(@PathVariable("entidadId") Long id) {
        PublicacionResponseDTO deleted = service.deleteEntidad(id);
        if (deleted != null) {
            return ResponseEntity.ok(deleted);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/trabajador/{trabajadorId}")
    public ResponseEntity<List<PublicacionResponseDTO>> getPublicacionesPorTrabajador(@PathVariable("trabajadorId") Long id) {
        return ResponseEntity.ok(service.getPublicacionesPorTrabajador(id));
    }
}
