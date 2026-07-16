package org.generation.fyndr.dto;

import java.time.LocalDateTime;

public class PublicacionResponseDTO {

    private Long id;
    private String titulo;
    private String descripcion;
    private Double precio;
    private LocalDateTime fechaPublicacion;
    private Long idUsuarioTrabajador;
    private String nombreUsuarioTrabajador;

    public PublicacionResponseDTO() {}

    public PublicacionResponseDTO(Long id, String titulo, String descripcion, Double precio, LocalDateTime fechaPublicacion, Long idUsuarioTrabajador, String nombreUsuarioTrabajador) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaPublicacion = fechaPublicacion;
        this.idUsuarioTrabajador = idUsuarioTrabajador;
        this.nombreUsuarioTrabajador = nombreUsuarioTrabajador;
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

    public Long getIdUsuarioTrabajador() { return idUsuarioTrabajador; }
    public void setIdUsuarioTrabajador(Long idUsuarioTrabajador) { this.idUsuarioTrabajador = idUsuarioTrabajador; }

    public String getNombreUsuarioTrabajador() { return nombreUsuarioTrabajador; }
    public void setNombreUsuarioTrabajador(String nombreUsuarioTrabajador) { this.nombreUsuarioTrabajador = nombreUsuarioTrabajador; }
}
