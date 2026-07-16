package org.generation.fyndr.repositorios;

import org.generation.fyndr.modelos.Contratacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratacionRepository extends JpaRepository<Contratacion, Long> {

}
