package org.generation.fyndr.servicios;

import org.generation.fyndr.modelos.Contratacion;
import org.generation.fyndr.repositorios.ContratacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratacionService {

    private final ContratacionRepository contratacionRepository;

    @Autowired
    public ContratacionService(ContratacionRepository contratacionRepository) {
        this.contratacionRepository = contratacionRepository;
    }

    //getEntidades pide las contrataciones de la base de datos
    public List<Contratacion> getEntidades() {
        return contratacionRepository.findAll();
    }

    //getEntidad para buscar una contratacion por su id
    public Contratacion getEntidad(Long id) {
        return contratacionRepository.findById(id).orElse(null);
    }

    //crearEntidad para guardar una contratacion
    public Contratacion crearEntidad(Contratacion obj) {
        return contratacionRepository.save(obj);
    }

    //deleteEntidad para eliminar por medio del id
    public Contratacion deleteEntidad(Long id) {
        Contratacion c = getEntidad(id);
        if (c != null) {
            contratacionRepository.deleteById(id);
        }
        return c; // Retorna el objeto eliminado tal como lo hacía Jonathan
    }

    //actualizarEntidad para modificar los datos de una contratacion
    public Contratacion actualizarEntidad(Long id, Long idUsuarioComun, Long idUsuarioTrabajador, String estado) {
        Contratacion c = getEntidad(id);
        if (c != null) {
            if (idUsuarioComun != null) c.setIdUsuarioComun(idUsuarioComun);
            if (idUsuarioTrabajador != null) c.setIdUsuarioTrabajador(idUsuarioTrabajador);
            if (estado != null) c.setEstado(estado);
            return contratacionRepository.save(c);
        }
        return null;
    }
}
