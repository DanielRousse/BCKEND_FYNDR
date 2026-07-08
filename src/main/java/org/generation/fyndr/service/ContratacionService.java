package org.generation.fyndr.service;

import org.generation.fyndr.model.Contratacion;
import org.generation.fyndr.repository.ContratacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratacionService {

    private final ContratacionRepository repository;

    @Autowired
    public ContratacionService(ContratacionRepository repository) {
        this.repository = repository;
    }

    public List<Contratacion> getAll() {
        return repository.findAll();
    }

    public Optional<Contratacion> getById(Integer id) {
        return repository.findById(id);
    }

    public Contratacion create(Contratacion contratacion) {
        return repository.save(contratacion);
    }

    public Optional<Contratacion> update(Integer id, Contratacion nueva) {
        return repository.findById(id).map(existente -> {
            existente.setIdUsuarioComun(nueva.getIdUsuarioComun());
            existente.setIdUsuarioTrabajador(nueva.getIdUsuarioTrabajador());
            existente.setEstado(nueva.getEstado());
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
