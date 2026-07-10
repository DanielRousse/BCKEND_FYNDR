package org.generation.fyndr.modelos;

import java.time.LocalDateTime;

/**
 * Clase que representa a una publicacion en el sistema Fyndr.
 */
public class Publicacion {

    private Long id;
    private String titulo;
    private String descripcion;
    private Double precio;
    private LocalDateTime fechaPublicacion;
    private Long idUsuarioTrabajador;

    private static Long total = 0L;

    public Publicacion() {
    } // Publicacion

    public Publicacion(String titulo, String descripcion, Double precio, LocalDateTime fechaPublicacion, Long idUsuarioTrabajador) {
        total++;
        this.id = total;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaPublicacion = fechaPublicacion;
        this.idUsuarioTrabajador = idUsuarioTrabajador;
    } // Publicacion

    public Long getId() {
        return id;
    } // getId

    public String getTitulo() {
        return titulo;
    } // getTitulo

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    } // setTitulo

    public String getDescripcion() {
        return descripcion;
    } // getDescripcion

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    } // setDescripcion

    public Double getPrecio() {
        return precio;
    } // getPrecio

    public void setPrecio(Double precio) {
        this.precio = precio;
    } // setPrecio

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    } // getFechaPublicacion

    public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    } // setFechaPublicacion

    public Long getIdUsuarioTrabajador() {
        return idUsuarioTrabajador;
    } // getIdUsuarioTrabajador

    public void setIdUsuarioTrabajador(Long idUsuarioTrabajador) {
        this.idUsuarioTrabajador = idUsuarioTrabajador;
    } // setIdUsuarioTrabajador

    @Override
    public String toString() {
        return "Publicacion{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", fechaPublicacion=" + fechaPublicacion +
                ", idUsuarioTrabajador=" + idUsuarioTrabajador +
                '}';
    } // toString
} // class Publicacion
