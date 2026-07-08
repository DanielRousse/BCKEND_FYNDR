package org.generation.fyndr.repository;

import org.generation.fyndr.model.UsuarioComun;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UsuarioComunRepository {

    private final Map<Integer, UsuarioComun> database = new ConcurrentHashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public List<UsuarioComun> findAll() {
        return new ArrayList<>(database.values());
    }

    public Optional<UsuarioComun> findById(Integer id) {
        return Optional.ofNullable(database.get(id));
    }

    public UsuarioComun save(UsuarioComun usuario) {
        if (usuario.getIdUsuarioComun() == null) {
            usuario.setIdUsuarioComun(idCounter.getAndIncrement());
        }
        if (usuario.getFechaRegistro() == null) {
            usuario.setFechaRegistro(LocalDateTime.now());
        }
        database.put(usuario.getIdUsuarioComun(), usuario);
        return usuario;
    }

    public void deleteById(Integer id) {
        database.remove(id);
    }
}
