package org.generation.fyndr.modelos;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Clase que representa a una publicacion en el sistema Fyndr.
 */
@Entity
@Table(name = "publicaciones")
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publicacionId", unique = true, nullable = false)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "fecha_publicacion", nullable = false)
    private LocalDateTime fechaPublicacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario_trabajador", nullable = false)
    private UsuarioTrabajador usuarioTrabajador;


    public Publicacion() {
    } // Publicacion

    public Publicacion(String titulo, String descripcion, Double precio, LocalDateTime fechaPublicacion, UsuarioTrabajador usuarioTrabajador) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaPublicacion = fechaPublicacion;
        this.usuarioTrabajador = usuarioTrabajador;
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

    public UsuarioTrabajador getUsuarioTrabajador() {
        return usuarioTrabajador;
    } //get usuariotrabajadoID

    public void setUsuarioTrabajador(UsuarioTrabajador usuarioTrabajador) {
        this.usuarioTrabajador = usuarioTrabajador;
    }//set usuariotrabajadoID

    @Override
    public String toString() {
        return "Publicacion{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", fechaPublicacion=" + fechaPublicacion +
                ", usuarioTrabajador=" + usuarioTrabajador +
                '}';
    } // toString
} // class Publicacion
