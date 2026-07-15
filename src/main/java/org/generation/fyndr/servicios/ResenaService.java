package org.generation.fyndr.servicios;

import org.generation.fyndr.modelos.Resena;
import org.generation.fyndr.modelos.UsuarioComun;
import org.generation.fyndr.repositorios.ResenaRepository;
import org.generation.fyndr.repositorios.UsuarioComunRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Servicio para gestionar las operaciones de las resenas en memoria local.
 */
@Service
public class ResenaService {

    private static final Logger logger =  LoggerFactory.getLogger(ResenaService.class);

    private final ResenaRepository resenaRepository;
    private final UsuarioComunRepository usuarioComunRepository;

    public ResenaService(ResenaRepository resenaRepository, UsuarioComunRepository usuarioComunRepository) {
        this.resenaRepository = resenaRepository;
        this.usuarioComunRepository = usuarioComunRepository;
    }

    public Resena crearResena(Resena resena) {
        UsuarioComun usuarioComun = this.usuarioComunRepository.findById(resena.getUsuarioComun().getId()).orElseThrow(() -> {
            ResenaService.logger.error("Usuario común no encontrado: {}", resena.getUsuarioComun());
            return new RuntimeException("Usuario común no encontrado " +  resena.getUsuarioComun());
        });

        ResenaService.logger.info("Usuario Común encontrado: {}", usuarioComun);
        resena.setUsuarioComun(usuarioComun);
        resena.setFechaResena(LocalDateTime.now());

        ResenaService.logger.info("Creando reseña: {}", resena);
        return this.resenaRepository.save(resena);
    }

    public Resena obtenerResena(Integer id) {
        return this.resenaRepository.findById(id).orElseThrow(() -> {
            ResenaService.logger.error("Reseña no encontrada, ID {}", id);
            return new RuntimeException("Reseña no encontrada, ID " + id);
        });
    }

    public List<Resena> obtenerResenas() {
        var resenas = this.resenaRepository.findAll();
        ResenaService.logger.info("Lista obtenida de reseñas, cantidad de reseñas: {}", resenas.size());
        return resenas;
    }

    public void borrarResena(Integer id) {
        this.resenaRepository.findById(id).ifPresent(resena -> {
            ResenaService.logger.info("Reseña eliminada, ID {}", id);
            this.resenaRepository.delete(resena);
        });
    }

    public Resena actualizarResena(Integer id, Resena resena) {
        Resena resenaBD = this.resenaRepository.findById(id).orElseThrow(() -> {
            ResenaService.logger.error("No se encontro reseña con ID: {}", id);
            return new RuntimeException("No se encontro reseña con ID: " + id);
        });

        ResenaService.logger.info("Actualizando reseña con ID {}", resena.getId());
        Resena resenaUpdate = new Resena();
        resenaUpdate.setId(resenaBD.getId());
        resenaUpdate.setUsuarioComun(Objects.isNull(resena.getUsuarioComun()) ? resenaBD.getUsuarioComun() : resena.getUsuarioComun());
        resenaUpdate.setCalificacion(Objects.isNull(resena.getCalificacion()) ? resenaBD.getCalificacion() : resena.getCalificacion());
        resenaUpdate.setComentario(Objects.isNull(resena.getComentario()) ? resenaBD.getComentario() : resena.getComentario());
        resenaUpdate.setFechaResena(LocalDateTime.now());
        resenaUpdate.setTotal(Objects.isNull(resena.getTotal()) ? resenaBD.getTotal() : resena.getTotal());

        return this.resenaRepository.save(resenaUpdate);
    }

} // class ResenaService
