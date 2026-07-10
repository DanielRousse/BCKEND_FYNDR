package org.generation.fyndr.modelos;

import java.time.LocalDateTime;

/**
 * Clase que representa una contratacion en el sistema Fyndr.
 */
public class Contratacion {

    private Long id;
    private Long idUsuarioComun;
    private Long idUsuarioTrabajador;
    private LocalDateTime fechaContratacion;
    private String estado;

    private static Long total = 0L;

    public Contratacion() {
    } // Contratacion

    public Contratacion(Long idUsuarioComun, Long idUsuarioTrabajador, LocalDateTime fechaContratacion, String estado) {
        total++;
        this.id = total;
        this.idUsuarioComun = idUsuarioComun;
        this.idUsuarioTrabajador = idUsuarioTrabajador;
        this.fechaContratacion = fechaContratacion;
        this.estado = estado;
    } // Contratacion

    public Long getId() {
        return id;
    } // getId

    public Long getIdUsuarioComun() {
        return idUsuarioComun;
    } // getIdUsuarioComun

    public void setIdUsuarioComun(Long idUsuarioComun) {
        this.idUsuarioComun = idUsuarioComun;
    } // setIdUsuarioComun

    public Long getIdUsuarioTrabajador() {
        return idUsuarioTrabajador;
    } // getIdUsuarioTrabajador

    public void setIdUsuarioTrabajador(Long idUsuarioTrabajador) {
        this.idUsuarioTrabajador = idUsuarioTrabajador;
    } // setIdUsuarioTrabajador

    public LocalDateTime getFechaContratacion() {
        return fechaContratacion;
    } // getFechaContratacion

    public void setFechaContratacion(LocalDateTime fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    } // setFechaContratacion

    public String getEstado() {
        return estado;
    } // getEstado

    public void setEstado(String estado) {
        this.estado = estado;
    } // setEstado

    @Override
    public String toString() {
        return "Contratacion{" +
                "id=" + id +
                ", idUsuarioComun=" + idUsuarioComun +
                ", idUsuarioTrabajador=" + idUsuarioTrabajador +
                ", fechaContratacion=" + fechaContratacion +
                ", estado='" + estado + '\'' +
                '}';
    } // toString
} // class Contratacion
