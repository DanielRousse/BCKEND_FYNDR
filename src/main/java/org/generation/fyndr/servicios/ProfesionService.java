package org.generation.fyndr.servicios;

import org.generation.fyndr.modelos.Profesion;
import org.generation.fyndr.repositorios.ProfesionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar las operaciones CRUD de las profesiones.
 */
@Service
public class ProfesionService {

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
        return profesionRepository.save(profesion);
    }

    // Eliminar una profesión.
    public Profesion deleteEntidad(Long id) {
        Optional<Profesion> profesion = profesionRepository.findById(id);

        if (profesion.isPresent()) {
            profesionRepository.deleteById(id);
            return profesion.get();
        }

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

            return profesionRepository.save(p);
        }

        return null;
    }
}