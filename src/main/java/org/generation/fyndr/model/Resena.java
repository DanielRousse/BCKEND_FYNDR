package org.generation.fyndr.model;

import java.time.LocalDateTime;

public class Resena {

    private Integer idResena;
    private Integer idUsuarioComun;
    private Integer idUsuarioTrabajador;
    private Integer calificacion;
    private String comentario;
    private LocalDateTime fechaResena;

    public Resena() {
    }

    public Resena(Integer idResena, Integer idUsuarioComun, Integer idUsuarioTrabajador, Integer calificacion, String comentario, LocalDateTime fechaResena) {
        this.idResena = idResena;
        this.idUsuarioComun = idUsuarioComun;
        this.idUsuarioTrabajador = idUsuarioTrabajador;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fechaResena = fechaResena;
    }

    public Integer getIdResena() {
        return idResena;
    }

    public void setIdResena(Integer idResena) {
        this.idResena = idResena;
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

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getFechaResena() {
        return fechaResena;
    }

    public void setFechaResena(LocalDateTime fechaResena) {
        this.fechaResena = fechaResena;
    }
}
