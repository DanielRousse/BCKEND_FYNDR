package org.generation.fyndr.repositorios;

import org.generation.fyndr.modelos.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

    List<Mensaje> findByUsuarioComunId(Long id);
    List<Mensaje> findByUsuarioTrabajadorId(Long id);

    @Query("SELECT m FROM Mensaje m WHERE m.usuarioComun.id = :comunId AND m.usuarioTrabajador.id = :trabajadorId ORDER BY m.fechaEnvio ASC")
    List<Mensaje> findConversation(@Param("comunId") Long comunId, @Param("trabajadorId") Long trabajadorId);
}
