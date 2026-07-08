package org.generation.fyndr.service;

import org.generation.fyndr.model.Publicacion;
import org.generation.fyndr.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacionService {

    private final PublicacionRepository repository;

    @Autowired
    public PublicacionService(PublicacionRepository repository) {
        this.repository = repository;
    }

    public List<Publicacion> getAll() {
        return repository.findAll();
    }

    public Optional<Publicacion> getById(Integer id) {
        return repository.findById(id);
    }

    public Publicacion create(Publicacion publicacion) {
        return repository.save(publicacion);
    }

    public Optional<Publicacion> update(Integer id, Publicacion nueva) {
        return repository.findById(id).map(existente -> {
            existente.setTitulo(nueva.getTitulo());
            existente.setDescripcion(nueva.getDescripcion());
            existente.setPrecio(nueva.getPrecio());
            existente.setIdUsuarioTrabajador(nueva.getIdUsuarioTrabajador());
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
