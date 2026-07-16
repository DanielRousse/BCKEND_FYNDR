package org.generation.fyndr.repositorios;

import org.generation.fyndr.modelos.UsuarioComun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interfaz de repositorio para la entidad UsuarioComun con soporte de Spring Data JPA.
 */
@Repository
public interface UsuarioComunRepository extends JpaRepository<UsuarioComun, Long> {
    Optional<UsuarioComun> findByEmail(String email);
} // interface UsuarioComunRepository
