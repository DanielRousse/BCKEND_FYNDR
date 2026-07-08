package org.generation.fyndr.service;

import org.generation.fyndr.model.Mensaje;
import org.generation.fyndr.repository.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensajeService {

    private final MensajeRepository repository;

    @Autowired
    public MensajeService(MensajeRepository repository) {
        this.repository = repository;
    }

    public List<Mensaje> getAll() {
        return repository.findAll();
    }

    public Optional<Mensaje> getById(Integer id) {
        return repository.findById(id);
    }

    public Mensaje create(Mensaje mensaje) {
        return repository.save(mensaje);
    }

    public Optional<Mensaje> update(Integer id, Mensaje nuevo) {
        return repository.findById(id).map(existente -> {
            existente.setIdUsuarioComun(nuevo.getIdUsuarioComun());
            existente.setIdUsuarioTrabajador(nuevo.getIdUsuarioTrabajador());
            existente.setRemitente(nuevo.getRemitente());
            existente.setContenido(nuevo.getContenido());
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
