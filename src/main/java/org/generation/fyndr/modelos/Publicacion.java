package org.generation.fyndr.modelos;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Clase que representa a una publicacion en el sistema Fyndr.
 */
@Entity
@Table(name = "publicaciones")
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descripcion", nullable = false, length = 1000)
    private String descripcion;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "fecha_publicacion", nullable = false)
    private LocalDateTime fechaPublicacion;

    @Column(name = "id_usuario_trabajador", nullable = false)
    private Long idUsuarioTrabajador;

    public Publicacion() {
    } // Publicacion

    public Publicacion(String titulo, String descripcion, Double precio, LocalDateTime fechaPublicacion, Long idUsuarioTrabajador) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaPublicacion = fechaPublicacion;
        this.idUsuarioTrabajador = idUsuarioTrabajador;
    } // Publicacion

    public Long getId() {
        return id;
    } // getId

    public void setId(Long id) {
        this.id = id;
    } // setId

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
