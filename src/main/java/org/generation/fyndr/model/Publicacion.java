package org.generation.fyndr.model;

import java.time.LocalDateTime;

public class Publicacion {

    private Integer idPublicacion;
    private String titulo;
    private String descripcion;
    private Double precio;
    private LocalDateTime fechaPublicacion;
    private Integer idUsuarioTrabajador;

    public Publicacion() {
    }

    public Publicacion(Integer idPublicacion, String titulo, String descripcion, Double precio, LocalDateTime fechaPublicacion, Integer idUsuarioTrabajador) {
        this.idPublicacion = idPublicacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaPublicacion = fechaPublicacion;
        this.idUsuarioTrabajador = idUsuarioTrabajador;
    }

    public Integer getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(Integer idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Integer getIdUsuarioTrabajador() {
        return idUsuarioTrabajador;
    }

    public void setIdUsuarioTrabajador(Integer idUsuarioTrabajador) {
        this.idUsuarioTrabajador = idUsuarioTrabajador;
    }
}
