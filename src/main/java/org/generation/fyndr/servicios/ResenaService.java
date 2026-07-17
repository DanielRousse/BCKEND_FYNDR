package org.generation.fyndr.servicios;

import org.generation.fyndr.modelos.Resena;
import org.generation.fyndr.modelos.UsuarioComun;
import org.generation.fyndr.modelos.UsuarioTrabajador;
import org.generation.fyndr.repositorios.ResenaRepository;
import org.generation.fyndr.repositorios.UsuarioComunRepository;
import org.generation.fyndr.repositorios.UsuarioTrabajadorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Servicio para gestionar las operaciones de las reseñas conectándose a JPA.
 */
@Service
public class ResenaService {

    private static final Logger logger = LoggerFactory.getLogger(ResenaService.class);

    private final ResenaRepository resenaRepository;
    private final UsuarioComunRepository usuarioComunRepository;
    private final UsuarioTrabajadorRepository usuarioTrabajadorRepository;

    public ResenaService(ResenaRepository resenaRepository, 
                         UsuarioComunRepository usuarioComunRepository,
                         UsuarioTrabajadorRepository usuarioTrabajadorRepository) {
        this.resenaRepository = resenaRepository;
        this.usuarioComunRepository = usuarioComunRepository;
        this.usuarioTrabajadorRepository = usuarioTrabajadorRepository;
    }

    public Resena crearResena(Resena resena) {
        UsuarioComun usuarioComun = this.usuarioComunRepository.findById(resena.getUsuarioComun().getId()).orElseThrow(() -> {
            ResenaService.logger.error("Usuario común no encontrado: {}", resena.getUsuarioComun());
            return new RuntimeException("Usuario común no encontrado " + resena.getUsuarioComun());
        });

        UsuarioTrabajador trabajador = this.usuarioTrabajadorRepository.findById(resena.getUsuarioTrabajador().getId()).orElseThrow(() -> {
            ResenaService.logger.error("Usuario trabajador no encontrado: {}", resena.getUsuarioTrabajador());
            return new RuntimeException("Usuario trabajador no encontrado " + resena.getUsuarioTrabajador());
        });

        resena.setUsuarioComun(usuarioComun);
        resena.setUsuarioTrabajador(trabajador);
        resena.setFechaResena(LocalDateTime.now());

        Resena resenaCreated = this.resenaRepository.save(resena);
        recalcularCalificacionTrabajador(trabajador);
        return resenaCreated;
    }

    public Resena obtenerResena(Long id) {
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

    public void borrarResena(Long id) {
        this.resenaRepository.findById(id).ifPresent(resena -> {
            UsuarioTrabajador trabajador = resena.getUsuarioTrabajador();
            this.resenaRepository.delete(resena);
            if (trabajador != null) {
                recalcularCalificacionTrabajador(trabajador);
            }
            ResenaService.logger.info("Reseña eliminada, ID {}", id);
        });
    }

    public Resena actualizarResena(Long id, Resena resena) {
        Resena resenaBD = this.resenaRepository.findById(id).orElseThrow(() -> {
            ResenaService.logger.error("No se encontro reseña con ID: {}", id);
            return new RuntimeException("No se encontro reseña con ID: " + id);
        });

        Resena resenaUpdate = new Resena();
        resenaUpdate.setId(resenaBD.getId());
        resenaUpdate.setUsuarioComun(Objects.isNull(resena.getUsuarioComun()) ? resenaBD.getUsuarioComun() : resena.getUsuarioComun());
        resenaUpdate.setUsuarioTrabajador(Objects.isNull(resena.getUsuarioTrabajador()) ? resenaBD.getUsuarioTrabajador() : resena.getUsuarioTrabajador());
        resenaUpdate.setCalificacion(Objects.isNull(resena.getCalificacion()) ? resenaBD.getCalificacion() : resena.getCalificacion());
        resenaUpdate.setComentario(Objects.isNull(resena.getComentario()) ? resenaBD.getComentario() : resena.getComentario());
        resenaUpdate.setFechaResena(LocalDateTime.now());

        Resena updated = this.resenaRepository.save(resenaUpdate);
        if (updated.getUsuarioTrabajador() != null) {
            recalcularCalificacionTrabajador(updated.getUsuarioTrabajador());
        }
        return updated;
    }

    private void recalcularCalificacionTrabajador(UsuarioTrabajador trabajador) {
        if (trabajador == null) return;
        Double avg = resenaRepository.calcularPromedioByTrabajador(trabajador.getId());
        if (avg != null) {
            trabajador.setCalificacionPromedio(java.math.BigDecimal.valueOf(avg));
        } else {
            trabajador.setCalificacionPromedio(java.math.BigDecimal.valueOf(5.0));
        }
        usuarioTrabajadorRepository.save(trabajador);
        logger.info("Calificación promedio recalculada para trabajador id={}: {}", trabajador.getId(), trabajador.getCalificacionPromedio());
    }
}
