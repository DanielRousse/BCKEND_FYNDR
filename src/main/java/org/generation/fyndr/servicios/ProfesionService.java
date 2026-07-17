package org.generation.fyndr.servicios;

import org.generation.fyndr.modelos.Profesion;
import org.generation.fyndr.repositorios.ProfesionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar las operaciones CRUD de las profesiones.
 */
@Service
public class ProfesionService {

    private static final Logger logger = LoggerFactory.getLogger(ProfesionService.class);
    private final ProfesionRepository profesionRepository;

    // Inyección del repositorio mediante el constructor.
    public ProfesionService(ProfesionRepository profesionRepository) {
        this.profesionRepository = profesionRepository;
    }

    // Obtener todas las profesiones.
    public List<Profesion> getEntidades() {
        return profesionRepository.findAll();
    }

    // Obtener una profesión por su id.
    public Profesion getEntidad(Long id) {
        Optional<Profesion> profesion = profesionRepository.findById(id);
        return profesion.orElse(null);
    }

    // Crear una nueva profesión.
    public Profesion crearEntidad(Profesion profesion) {
        Profesion saved = profesionRepository.save(profesion);
        logger.info("Profesión creada: id={}, nombre='{}'", saved.getId(), saved.getNombreProfesion());
        return saved;
    }

    // Eliminar una profesión.
    public Profesion deleteEntidad(Long id) {
        Optional<Profesion> profesion = profesionRepository.findById(id);

        if (profesion.isPresent()) {
            profesionRepository.deleteById(id);
            logger.info("Profesión eliminada: id={}", id);
            return profesion.get();
        }
        logger.warn("Intento de eliminar profesión inexistente: id={}", id);
        return null;
    }

    // Actualizar una profesión.
    public Profesion actualizarEntidad(Long id, String nombreProfesion) {
        Optional<Profesion> profesion = profesionRepository.findById(id);

        if (profesion.isPresent()) {
            Profesion p = profesion.get();

            if (nombreProfesion != null) {
                p.setNombreProfesion(nombreProfesion);
            }

            Profesion updated = profesionRepository.save(p);
            logger.info("Profesión actualizada: id={}", updated.getId());
            return updated;
        }
        logger.warn("Intento de actualizar profesión inexistente: id={}", id);
        return null;
    }
}