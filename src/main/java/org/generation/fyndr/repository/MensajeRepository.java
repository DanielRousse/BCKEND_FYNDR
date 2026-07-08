package org.generation.fyndr.repository;

import org.generation.fyndr.model.Mensaje;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MensajeRepository {

    private final Map<Integer, Mensaje> database = new ConcurrentHashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public List<Mensaje> findAll() {
        return new ArrayList<>(database.values());
    }

    public Optional<Mensaje> findById(Integer id) {
        return Optional.ofNullable(database.get(id));
    }

    public Mensaje save(Mensaje mensaje) {
        if (mensaje.getIdMensaje() == null) {
            mensaje.setIdMensaje(idCounter.getAndIncrement());
        }
        if (mensaje.getFechaEnvio() == null) {
            mensaje.setFechaEnvio(LocalDateTime.now());
        }
        database.put(mensaje.getIdMensaje(), mensaje);
        return mensaje;
    }

    public void deleteById(Integer id) {
        database.remove(id);
    }
}
