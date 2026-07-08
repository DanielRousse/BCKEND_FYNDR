package org.generation.fyndr.service;

import org.generation.fyndr.model.Profesion;
import org.generation.fyndr.repository.ProfesionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesionService {

    private final ProfesionRepository repository;

    @Autowired
    public ProfesionService(ProfesionRepository repository) {
        this.repository = repository;
    }

    public List<Profesion> getAll() {
        return repository.findAll();
    }

    public Optional<Profesion> getById(Integer id) {
        return repository.findById(id);
    }

    public Profesion create(Profesion profesion) {
        return repository.save(profesion);
    }

    public Optional<Profesion> update(Integer id, Profesion nueva) {
        return repository.findById(id).map(existente -> {
            existente.setNombreProfesion(nueva.getNombreProfesion());
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
