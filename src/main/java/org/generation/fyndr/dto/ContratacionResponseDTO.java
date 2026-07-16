package org.generation.fyndr.dto;

import java.time.LocalDateTime;

public class ContratacionResponseDTO {

    private Long id;
    private Long idUsuarioComun;
    private String nombreUsuarioComun;
    private Long idUsuarioTrabajador;
    private String nombreUsuarioTrabajador;
    private LocalDateTime fechaContratacion;
    private String estado;

    public ContratacionResponseDTO() {}

    public ContratacionResponseDTO(Long id, Long idUsuarioComun, String nombreUsuarioComun, Long idUsuarioTrabajador, String nombreUsuarioTrabajador, LocalDateTime fechaContratacion, String estado) {
        this.id = id;
        this.idUsuarioComun = idUsuarioComun;
        this.nombreUsuarioComun = nombreUsuarioComun;
        this.idUsuarioTrabajador = idUsuarioTrabajador;
        this.nombreUsuarioTrabajador = nombreUsuarioTrabajador;
        this.fechaContratacion = fechaContratacion;
        this.estado = estado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdUsuarioComun() { return idUsuarioComun; }
    public void setIdUsuarioComun(Long idUsuarioComun) { this.idUsuarioComun = idUsuarioComun; }

    public String getNombreUsuarioComun() { return nombreUsuarioComun; }
    public void setNombreUsuarioComun(String nombreUsuarioComun) { this.nombreUsuarioComun = nombreUsuarioComun; }

    public Long getIdUsuarioTrabajador() { return idUsuarioTrabajador; }
    public void setIdUsuarioTrabajador(Long idUsuarioTrabajador) { this.idUsuarioTrabajador = idUsuarioTrabajador; }

    public String getNombreUsuarioTrabajador() { return nombreUsuarioTrabajador; }
    public void setNombreUsuarioTrabajador(String nombreUsuarioTrabajador) { this.nombreUsuarioTrabajador = nombreUsuarioTrabajador; }

    public LocalDateTime getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(LocalDateTime fechaContratacion) { this.fechaContratacion = fechaContratacion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
