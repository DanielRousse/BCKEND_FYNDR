package org.generation.fyndr.repository;

import org.generation.fyndr.model.Contratacion;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ContratacionRepository {

    private final Map<Integer, Contratacion> database = new ConcurrentHashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public List<Contratacion> findAll() {
        return new ArrayList<>(database.values());
    }

    public Optional<Contratacion> findById(Integer id) {
        return Optional.ofNullable(database.get(id));
    }

    public Contratacion save(Contratacion contratacion) {
        if (contratacion.getIdContratacion() == null) {
            contratacion.setIdContratacion(idCounter.getAndIncrement());
        }
        if (contratacion.getFechaContratacion() == null) {
            contratacion.setFechaContratacion(LocalDateTime.now());
        }
        if (contratacion.getEstado() == null) {
            contratacion.setEstado("Pendiente");
        }
        database.put(contratacion.getIdContratacion(), contratacion);
        return contratacion;
    }

    public void deleteById(Integer id) {
        database.remove(id);
    }
}
