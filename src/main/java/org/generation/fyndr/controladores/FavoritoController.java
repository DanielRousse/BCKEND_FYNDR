package org.generation.fyndr.controladores;

import org.generation.fyndr.modelos.UsuarioTrabajador;
import org.generation.fyndr.servicios.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/favoritos")
public class FavoritoController {

    private final FavoritoService service;

    @Autowired
    public FavoritoController(FavoritoService service) {
        this.service = service;
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<UsuarioTrabajador>> getFavoritos(@PathVariable("usuarioId") Long id) {
        return ResponseEntity.ok(service.obtenerFavoritos(id));
    }

    @PostMapping("/usuario/{usuarioId}/trabajador/{trabajadorId}")
    public ResponseEntity<Void> agregarFavorito(
            @PathVariable("usuarioId") Long idUsuarioComun,
            @PathVariable("trabajadorId") Long idUsuarioTrabajador) {
        service.agregarFavorito(idUsuarioComun, idUsuarioTrabajador);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/usuario/{usuarioId}/trabajador/{trabajadorId}")
    public ResponseEntity<Void> eliminarFavorito(
            @PathVariable("usuarioId") Long idUsuarioComun,
            @PathVariable("trabajadorId") Long idUsuarioTrabajador) {
        service.eliminarFavorito(idUsuarioComun, idUsuarioTrabajador);
        return ResponseEntity.ok().build();
    }
}
