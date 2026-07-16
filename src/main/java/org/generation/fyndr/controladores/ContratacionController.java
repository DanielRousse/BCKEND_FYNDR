package org.generation.fyndr.controladores;

import org.generation.fyndr.dto.ContratacionDTO;
import org.generation.fyndr.dto.ContratacionResponseDTO;
import org.generation.fyndr.servicios.ContratacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/contrataciones")
public class ContratacionController {

    private final ContratacionService service;

    @Autowired
    public ContratacionController(ContratacionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ContratacionResponseDTO>> getContrataciones() {
        return ResponseEntity.ok(service.getEntidades());
    }

    @GetMapping("/{entidadId}")
    public ResponseEntity<ContratacionResponseDTO> getContratacion(@PathVariable("entidadId") Long id) {
        ContratacionResponseDTO dto = service.getEntidad(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ContratacionResponseDTO> crearContratacion(@RequestBody ContratacionDTO dto) {
        ContratacionResponseDTO created = service.crearEntidad(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{entidadId}")
    public ResponseEntity<ContratacionResponseDTO> actualizarContratacion(
            @PathVariable("entidadId") Long id,
            @RequestBody ContratacionDTO dto) {
        ContratacionResponseDTO updated = service.actualizarEntidad(id, dto);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{entidadId}")
    public ResponseEntity<ContratacionResponseDTO> eliminarContratacion(@PathVariable("entidadId") Long id) {
        ContratacionResponseDTO deleted = service.deleteEntidad(id);
        if (deleted != null) {
            return ResponseEntity.ok(deleted);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<ContratacionResponseDTO>> getContratacionesPorUsuario(@PathVariable("usuarioId") Long id) {
        return ResponseEntity.ok(service.getContratacionesPorUsuario(id));
    }

    @GetMapping("/trabajador/{trabajadorId}")
    public ResponseEntity<List<ContratacionResponseDTO>> getContratacionesPorTrabajador(@PathVariable("trabajadorId") Long id) {
        return ResponseEntity.ok(service.getContratacionesPorTrabajador(id));
    }
}
