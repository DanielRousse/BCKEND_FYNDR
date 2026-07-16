package org.generation.fyndr.controladores;

import org.generation.fyndr.dto.MensajeDTO;
import org.generation.fyndr.dto.MensajeResponseDTO;
import org.generation.fyndr.servicios.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/mensajes")
public class MensajeController {

    private final MensajeService service;

    @Autowired
    public MensajeController(MensajeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MensajeResponseDTO>> getMensajes() {
        return ResponseEntity.ok(service.todosLosMensajes());
    }

    @GetMapping("/{entidadId}")
    public ResponseEntity<MensajeResponseDTO> getMensaje(@PathVariable("entidadId") Long id) {
        MensajeResponseDTO dto = service.mensajesPorId(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<MensajeResponseDTO> crearMensaje(@RequestBody MensajeDTO dto) {
        MensajeResponseDTO created = service.crearMensaje(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{entidadId}")
    public ResponseEntity<MensajeResponseDTO> actualizarMensaje(
            @PathVariable("entidadId") Long id,
            @RequestBody MensajeDTO dto) {
        try {
            return ResponseEntity.ok(service.actualizarMensaje(id, dto));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{entidadId}")
    public ResponseEntity<Void> eliminarMensaje(@PathVariable("entidadId") Long id) {
        try {
            service.eliminarMensaje(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/conversacion")
    public ResponseEntity<List<MensajeResponseDTO>> getConversacion(
            @RequestParam("idUsuarioComun") Long idUsuarioComun,
            @RequestParam("idUsuarioTrabajador") Long idUsuarioTrabajador) {
        return ResponseEntity.ok(service.obtenerConversacion(idUsuarioComun, idUsuarioTrabajador));
    }
}