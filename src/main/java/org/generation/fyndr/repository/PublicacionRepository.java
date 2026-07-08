package org.generation.fyndr.repository;

import org.generation.fyndr.model.Publicacion;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PublicacionRepository {

    private final Map<Integer, Publicacion> database = new ConcurrentHashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public List<Publicacion> findAll() {
        return new ArrayList<>(database.values());
    }

    public Optional<Publicacion> findById(Integer id) {
        return Optional.ofNullable(database.get(id));
    }

    public Publicacion save(Publicacion publicacion) {
        if (publicacion.getIdPublicacion() == null) {
            publicacion.setIdPublicacion(idCounter.getAndIncrement());
        }
        if (publicacion.getFechaPublicacion() == null) {
            publicacion.setFechaPublicacion(LocalDateTime.now());
        }
        database.put(publicacion.getIdPublicacion(), publicacion);
        return publicacion;
    }

    public void deleteById(Integer id) {
        database.remove(id);
    }
}
