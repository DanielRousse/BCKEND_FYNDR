package org.generation.fyndr.modelos;

import java.time.LocalDateTime;

/**
 * Clase que representa a una resena en el sistema Fyndr.
 */
public class Resena {

    private Long id;
    private Long idUsuarioComun;
    private Long idUsuarioTrabajador;
    private Integer calificacion;
    private String comentario;
    private LocalDateTime fechaResena;

    private static Long total = 0L;

    public Resena() {
    } // Resena

    public Resena(Long idUsuarioComun, Long idUsuarioTrabajador, Integer calificacion, String comentario, LocalDateTime fechaResena) {
        total++;
        this.id = total;
        this.idUsuarioComun = idUsuarioComun;
        this.idUsuarioTrabajador = idUsuarioTrabajador;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fechaResena = fechaResena;
    } // Resena

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

    public Integer getCalificacion() {
        return calificacion;
    } // getCalificacion

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    } // setCalificacion

    public String getComentario() {
        return comentario;
    } // getComentario

    public void setComentario(String comentario) {
        this.comentario = comentario;
    } // setComentario

    public LocalDateTime getFechaResena() {
        return fechaResena;
    } // getFechaResena

    public void setFechaResena(LocalDateTime fechaResena) {
        this.fechaResena = fechaResena;
    } // setFechaResena

    @Override
    public String toString() {
        return "Resena{" +
                "id=" + id +
                ", idUsuarioComun=" + idUsuarioComun +
                ", idUsuarioTrabajador=" + idUsuarioTrabajador +
                ", calificacion=" + calificacion +
                ", comentario='" + comentario + '\'' +
                ", fechaResena=" + fechaResena +
                '}';
    } // toString
} // class Resena
