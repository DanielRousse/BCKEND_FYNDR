package org.generation.fyndr.repositorios;

import org.generation.fyndr.modelos.Resena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Interfaz de repositorio para la entidad Resena.
 */
public interface ResenaRepository extends JpaRepository<Resena, Long> {

    @Query("SELECT AVG(r.calificacion) FROM Resena r WHERE r.usuarioTrabajador.id = :id")
    Double calcularPromedioByTrabajador(@Param("id") Long id);
} // interface ResenaRepository
