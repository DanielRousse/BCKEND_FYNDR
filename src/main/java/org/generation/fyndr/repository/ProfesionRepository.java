package org.generation.fyndr.repository;

import org.generation.fyndr.model.Profesion;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ProfesionRepository {

    private final Map<Integer, Profesion> database = new ConcurrentHashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public List<Profesion> findAll() {
        return new ArrayList<>(database.values());
    }

    public Optional<Profesion> findById(Integer id) {
        return Optional.ofNullable(database.get(id));
    }

    public Profesion save(Profesion profesion) {
        if (profesion.getIdProfesion() == null) {
            profesion.setIdProfesion(idCounter.getAndIncrement());
        }
        database.put(profesion.getIdProfesion(), profesion);
        return profesion;
    }

    public void deleteById(Integer id) {
        database.remove(id);
    }
}
