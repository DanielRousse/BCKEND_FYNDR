package org.generation.fyndr.repository;

import org.generation.fyndr.model.Resena;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ResenaRepository {

    private final Map<Integer, Resena> database = new ConcurrentHashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public List<Resena> findAll() {
        return new ArrayList<>(database.values());
    }

    public Optional<Resena> findById(Integer id) {
        return Optional.ofNullable(database.get(id));
    }

    public Resena save(Resena resena) {
        if (resena.getIdResena() == null) {
            resena.setIdResena(idCounter.getAndIncrement());
        }
        if (resena.getFechaResena() == null) {
            resena.setFechaResena(LocalDateTime.now());
        }
        database.put(resena.getIdResena(), resena);
        return resena;
    }

    public void deleteById(Integer id) {
        database.remove(id);
    }
}
