package org.generation.fyndr.repositorios;

import org.generation.fyndr.modelos.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz de repositorio para la entidad Publicacion.
 */
@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
} // interface PublicacionRepository
