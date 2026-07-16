package org.generation.fyndr.controladores;

import org.generation.fyndr.modelos.Contratacion;
import org.generation.fyndr.servicios.ContratacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/contrataciones/")
public class ContratacionController {

    private final ContratacionService service;

    @Autowired
    public ContratacionController(ContratacionService service) {
        this.service = service;
    }

    //get http://localhost:8080/api/contrataciones/
    @GetMapping
    public List<Contratacion> getContrataciones() {
        return service.getEntidades();
    }

    //get http://localhost:8080/api/contrataciones/1
    @GetMapping(path="/{entidadId}")
    public Contratacion getContratacion(@PathVariable("entidadId") Long id) {
        return service.getEntidad(id);
    }

    //post http://localhost:8080/api/contrataciones/
    @PostMapping
    public Contratacion crearContratacion(@RequestBody Contratacion contratacion) {
        return service.crearEntidad(contratacion);
    }

    //put http://localhost:8080/api/contrataciones/1
    @PutMapping(path="/{entidadId}")
    public Contratacion actualizarContratacion(
            @PathVariable("entidadId") Long id,
            @RequestParam(required = false) Long idUsuarioComun,
            @RequestParam(required = false) Long idUsuarioTrabajador,
            @RequestParam(required = false) String estado) {
        return service.actualizarEntidad(id, idUsuarioComun, idUsuarioTrabajador, estado);
    }

    //delete http://localhost:8080/api/contrataciones/1
    @DeleteMapping(path="/{entidadId}")
    public Contratacion eliminarContratacion(@PathVariable("entidadId") Long id) {
        return service.deleteEntidad(id);
    }
}
