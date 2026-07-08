package org.generation.fyndr.model;

import java.time.LocalDateTime;

public class Mensaje {

    private Integer idMensaje;
    private Integer idUsuarioComun;
    private Integer idUsuarioTrabajador;
    private String remitente;
    private String contenido;
    private LocalDateTime fechaEnvio;

    public Mensaje() {
    }

    public Mensaje(Integer idMensaje, Integer idUsuarioComun, Integer idUsuarioTrabajador, String remitente, String contenido, LocalDateTime fechaEnvio) {
        this.idMensaje = idMensaje;
        this.idUsuarioComun = idUsuarioComun;
        this.idUsuarioTrabajador = idUsuarioTrabajador;
        this.remitente = remitente;
        this.contenido = contenido;
        this.fechaEnvio = fechaEnvio;
    }

    public Integer getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
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

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
}
