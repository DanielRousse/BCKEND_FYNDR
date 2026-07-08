package org.generation.fyndr.service;

import org.generation.fyndr.model.UsuarioComun;
import org.generation.fyndr.repository.UsuarioComunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioComunService {

    private final UsuarioComunRepository repository;

    @Autowired
    public UsuarioComunService(UsuarioComunRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioComun> getAll() {
        return repository.findAll();
    }

    public Optional<UsuarioComun> getById(Integer id) {
        return repository.findById(id);
    }

    public UsuarioComun create(UsuarioComun usuario) {
        return repository.save(usuario);
    }

    public Optional<UsuarioComun> update(Integer id, UsuarioComun nuevoUsuario) {
        return repository.findById(id).map(existente -> {
            existente.setNombre(nuevoUsuario.getNombre());
            existente.setEmail(nuevoUsuario.getEmail());
            existente.setTelefono(nuevoUsuario.getTelefono());
            existente.setContrasena(nuevoUsuario.getContrasena());
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
