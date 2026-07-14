package org.generation.fyndr.repositorios;

import org.generation.fyndr.modelos.UsuarioTrabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interfaz de repositorio para la entidad UsuarioTrabajador.
 */
@Repository
public interface UsuarioTrabajadorRepository  extends JpaRepository<UsuarioTrabajador,Long> {
    Optional<UsuarioTrabajador> findByEmail(String email);
} // interface UsuarioTrabajadorRepository
