package org.generation.fyndr.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

public class ContratacionDTO {

    @NotNull(message = "El ID de usuario común es obligatorio")
    private Long idUsuarioComun;

    @NotNull(message = "El ID de usuario trabajador es obligatorio")
    private Long idUsuarioTrabajador;

    private LocalDateTime fechaContratacion;

    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    public ContratacionDTO() {}

    public ContratacionDTO(Long idUsuarioComun, Long idUsuarioTrabajador, LocalDateTime fechaContratacion, String estado) {
        this.idUsuarioComun = idUsuarioComun;
        this.idUsuarioTrabajador = idUsuarioTrabajador;
        this.fechaContratacion = fechaContratacion;
        this.estado = estado;
    }

    public Long getIdUsuarioComun() { return idUsuarioComun; }
    public void setIdUsuarioComun(Long idUsuarioComun) { this.idUsuarioComun = idUsuarioComun; }

    public Long getIdUsuarioTrabajador() { return idUsuarioTrabajador; }
    public void setIdUsuarioTrabajador(Long idUsuarioTrabajador) { this.idUsuarioTrabajador = idUsuarioTrabajador; }

    public LocalDateTime getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(LocalDateTime fechaContratacion) { this.fechaContratacion = fechaContratacion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
