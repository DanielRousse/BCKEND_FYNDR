package org.generation.fyndr.repositorios;

import org.generation.fyndr.modelos.Contratacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratacionRepository extends JpaRepository<Contratacion, Long> {
    List<Contratacion> findByUsuarioComunId(Long id);
    List<Contratacion> findByUsuarioTrabajadorId(Long id);
}
