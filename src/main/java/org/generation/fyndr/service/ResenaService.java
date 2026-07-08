package org.generation.fyndr.service;

import org.generation.fyndr.model.Resena;
import org.generation.fyndr.repository.ResenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResenaService {

    private final ResenaRepository repository;

    @Autowired
    public ResenaService(ResenaRepository repository) {
        this.repository = repository;
    }

    public List<Resena> getAll() {
        return repository.findAll();
    }

    public Optional<Resena> getById(Integer id) {
        return repository.findById(id);
    }

    public Resena create(Resena resena) {
        return repository.save(resena);
    }

    public Optional<Resena> update(Integer id, Resena nueva) {
        return repository.findById(id).map(existente -> {
            existente.setIdUsuarioComun(nueva.getIdUsuarioComun());
            existente.setIdUsuarioTrabajador(nueva.getIdUsuarioTrabajador());
            existente.setCalificacion(nueva.getCalificacion());
            existente.setComentario(nueva.getComentario());
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
