package org.generation.fyndr.modelos;

import java.time.LocalDateTime;

/**
 * Clase que representa un mensaje en el sistema Fyndr.
 */
public class Mensaje {

    private Long id;
    private Long idUsuarioComun;
    private Long idUsuarioTrabajador;
    private String remitente;
    private String contenido;
    private LocalDateTime fechaEnvio;

    private static Long total = 0L;

    public Mensaje() {
    } // Mensaje

    public Mensaje(Long idUsuarioComun, Long idUsuarioTrabajador, String remitente, String contenido, LocalDateTime fechaEnvio) {
        total++;
        this.id = total;
        this.idUsuarioComun = idUsuarioComun;
        this.idUsuarioTrabajador = idUsuarioTrabajador;
        this.remitente = remitente;
        this.contenido = contenido;
        this.fechaEnvio = fechaEnvio;
    } // Mensaje

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

    public String getRemitente() {
        return remitente;
    } // getRemitente

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    } // setRemitente

    public String getContenido() {
        return contenido;
    } // getContenido

    public void setContenido(String contenido) {
        this.contenido = contenido;
    } // setContenido

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    } // getFechaEnvio

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    } // setFechaEnvio

    @Override
    public String toString() {
        return "Mensaje{" +
                "id=" + id +
                ", idUsuarioComun=" + idUsuarioComun +
                ", idUsuarioTrabajador=" + idUsuarioTrabajador +
                ", remitente='" + remitente + '\'' +
                ", contenido='" + contenido + '\'' +
                ", fechaEnvio=" + fechaEnvio +
                '}';
    } // toString
} // class Mensaje
