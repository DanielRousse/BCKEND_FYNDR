package org.generation.fyndr.model;

import java.time.LocalDateTime;

public class Contratacion {

    private Integer idContratacion;
    private Integer idUsuarioComun;
    private Integer idUsuarioTrabajador;
    private LocalDateTime fechaContratacion;
    private String estado;

    public Contratacion() {
    }

    public Contratacion(Integer idContratacion, Integer idUsuarioComun, Integer idUsuarioTrabajador, LocalDateTime fechaContratacion, String estado) {
        this.idContratacion = idContratacion;
        this.idUsuarioComun = idUsuarioComun;
        this.idUsuarioTrabajador = idUsuarioTrabajador;
        this.fechaContratacion = fechaContratacion;
        this.estado = estado;
    }

    public Integer getIdContratacion() {
        return idContratacion;
    }

    public void setIdContratacion(Integer idContratacion) {
        this.idContratacion = idContratacion;
    }

    public Integer getIdUsuarioComun() {
        return idUsuarioComun;
    }

    public void setIdUsuarioComun(Integer idUsuarioComun) {
        this.idUsuarioComun = idUsuarioComun;
    }

    public Integer getIdUsuarioTrabajador() {
        return idUsuarioTrabajador;
    }

    public void setIdUsuarioTrabajador(Integer idUsuarioTrabajador) {
        this.idUsuarioTrabajador = idUsuarioTrabajador;
    }

    public LocalDateTime getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDateTime fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
