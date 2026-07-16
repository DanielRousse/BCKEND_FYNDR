package org.generation.fyndr.servicios;

import org.generation.fyndr.modelos.Mensaje;
import org.generation.fyndr.repositorios.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;

    // se crear  un mensaje en la base de datos
    public Mensaje crearMensaje(Mensaje mensaje) {
        return mensajeRepository.save(mensaje);
    }

    // obtenemos todos los mensajes reales de sql
    public List<Mensaje> todosLosMensajes() {
        return mensajeRepository.findAll();
    }

    // buscamos  un mensaje específico por su el id
    public Optional<Mensaje> mensajesPorId(Long id) {
        return mensajeRepository.findById(id);
    }

    // filtramos mensajes de un usuario comun
    public List<Mensaje> mensajesPorUsuarioComun(Long idUsuarioComun) {
        return mensajeRepository.findAll().stream()
                .filter(m -> m.getIdUsuarioComun().equals(idUsuarioComun))
                .collect(Collectors.toList());
    }

    // filtramos para Usuario Trabajador
    public List<Mensaje> mensajesPorUsuarioTrabajador(Long idUsuarioTrabajador) {
        return mensajeRepository.findAll().stream()
                .filter(m -> m.getIdUsuarioTrabajador().equals(idUsuarioTrabajador))
                .collect(Collectors.toList());
    }

    // elimina mensaje
    public void eliminarMensaje(Long id) {
        mensajeRepository.deleteById(id);
    }

    // actualiza mensaje
    public Mensaje actualizarMensaje(Long id, Mensaje datosActualizados) {
        return mensajeRepository.findById(id).map(mensaje -> {
            mensaje.setIdUsuarioComun(datosActualizados.getIdUsuarioComun());
            mensaje.setIdUsuarioTrabajador(datosActualizados.getIdUsuarioTrabajador());
            mensaje.setRemitente(datosActualizados.getRemitente());
            mensaje.setContenido(datosActualizados.getContenido());
            mensaje.setFechaEnvio(datosActualizados.getFechaEnvio());
            return mensajeRepository.save(mensaje);
        }).orElseThrow(() -> new RuntimeException("Mensaje no encontrado con id: " + id));
    }
}