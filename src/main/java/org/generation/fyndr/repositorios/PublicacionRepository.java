package org.generation.fyndr.repositorios;

import org.generation.fyndr.modelos.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
    List<Publicacion> findByUsuarioTrabajadorId(Long id);
}
