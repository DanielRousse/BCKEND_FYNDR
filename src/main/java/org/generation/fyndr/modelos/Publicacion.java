package org.generation.fyndr.modelos;

import jakarta.persistence.*;
import java.time.LocalDateTime;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_trabajador", nullable = false)
    private UsuarioTrabajador usuarioTrabajador;

    @Column(name = "imagen_path", columnDefinition = "LONGTEXT")
    private String imagenPath;

    public Publicacion() {}

    public Publicacion(String titulo, String descripcion, Double precio, LocalDateTime fechaPublicacion, UsuarioTrabajador usuarioTrabajador) {
        this(titulo, descripcion, precio, fechaPublicacion, usuarioTrabajador, "");
    }

    public Publicacion(String titulo, String descripcion, Double precio, LocalDateTime fechaPublicacion, UsuarioTrabajador usuarioTrabajador, String imagenPath) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaPublicacion = fechaPublicacion;
        this.usuarioTrabajador = usuarioTrabajador;
        this.imagenPath = imagenPath;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public LocalDateTime getFechaPublicacion() { return fechaPublicacion; }
    public void setFechaPublicacion(LocalDateTime fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }

    public UsuarioTrabajador getUsuarioTrabajador() { return usuarioTrabajador; }
    public void setUsuarioTrabajador(UsuarioTrabajador usuarioTrabajador) { this.usuarioTrabajador = usuarioTrabajador; }

    public String getImagenPath() { return imagenPath; }
    public void setImagenPath(String imagenPath) { this.imagenPath = imagenPath; }

    @Override
    public String toString() {
        return "Publicacion{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", fechaPublicacion=" + fechaPublicacion +
                ", usuarioTrabajador=" + (usuarioTrabajador != null ? usuarioTrabajador.getId() : null) +
                '}';
    }
}
