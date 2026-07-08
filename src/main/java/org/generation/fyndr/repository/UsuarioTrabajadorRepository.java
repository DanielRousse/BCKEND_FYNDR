package org.generation.fyndr.repository;

import org.generation.fyndr.model.UsuarioTrabajador;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UsuarioTrabajadorRepository {

    private final Map<Integer, UsuarioTrabajador> database = new ConcurrentHashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public List<UsuarioTrabajador> findAll() {
        return new ArrayList<>(database.values());
    }

    public Optional<UsuarioTrabajador> findById(Integer id) {
        return Optional.ofNullable(database.get(id));
    }

    public UsuarioTrabajador save(UsuarioTrabajador trabajador) {
        if (trabajador.getIdUsuarioTrabajador() == null) {
            trabajador.setIdUsuarioTrabajador(idCounter.getAndIncrement());
        }
        if (trabajador.getFechaRegistro() == null) {
            trabajador.setFechaRegistro(LocalDateTime.now());
        }
        database.put(trabajador.getIdUsuarioTrabajador(), trabajador);
        return trabajador;
    }

    public void deleteById(Integer id) {
        database.remove(id);
    }
}
