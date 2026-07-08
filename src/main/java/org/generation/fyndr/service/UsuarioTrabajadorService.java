package org.generation.fyndr.service;

import org.generation.fyndr.model.UsuarioTrabajador;
import org.generation.fyndr.repository.UsuarioTrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioTrabajadorService {

    private final UsuarioTrabajadorRepository repository;

    @Autowired
    public UsuarioTrabajadorService(UsuarioTrabajadorRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioTrabajador> getAll() {
        return repository.findAll();
    }

    public Optional<UsuarioTrabajador> getById(Integer id) {
        return repository.findById(id);
    }

    public UsuarioTrabajador create(UsuarioTrabajador trabajador) {
        return repository.save(trabajador);
    }

    public Optional<UsuarioTrabajador> update(Integer id, UsuarioTrabajador nuevo) {
        return repository.findById(id).map(existente -> {
            existente.setNombre(nuevo.getNombre());
            existente.setEmail(nuevo.getEmail());
            existente.setTelefono(nuevo.getTelefono());
            existente.setContrasena(nuevo.getContrasena());
            existente.setFechaNacimiento(nuevo.getFechaNacimiento());
            existente.setInePath(nuevo.getInePath());
            existente.setCurp(nuevo.getCurp());
            existente.setFotografiaPath(nuevo.getFotografiaPath());
            existente.setComprobantePath(nuevo.getComprobantePath());
            existente.setAntecedentesPath(nuevo.getAntecedentesPath());
            existente.setExperienciaAnos(nuevo.getExperienciaAnos());
            existente.setDescripcion(nuevo.getDescripcion());
            existente.setSubespecialidades(nuevo.getSubespecialidades());
            existente.setCertificacionesPath(nuevo.getCertificacionesPath());
            existente.setPortafolioPath(nuevo.getPortafolioPath());
            existente.setRfc(nuevo.getRfc());
            existente.setConstanciaFiscalPath(nuevo.getConstanciaFiscalPath());
            existente.setClabe(nuevo.getClabe());
            existente.setBanco(nuevo.getBanco());
            existente.setTarifaHora(nuevo.getTarifaHora());
            existente.setCalificacionPromedio(nuevo.getCalificacionPromedio());
            return repository.save(existente);
        });
    }

    public boolean delete(Integer id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
