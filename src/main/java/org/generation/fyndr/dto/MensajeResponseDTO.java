package org.generation.fyndr.dto;

import java.time.LocalDateTime;

public class MensajeResponseDTO {

    private Long id;
    private Long idUsuarioComun;
    private String nombreUsuarioComun;
    private Long idUsuarioTrabajador;
    private String nombreUsuarioTrabajador;
    private String remitente;
    private String contenido;
    private LocalDateTime fechaEnvio;

    public MensajeResponseDTO() {}

    public MensajeResponseDTO(Long id, Long idUsuarioComun, String nombreUsuarioComun, Long idUsuarioTrabajador, String nombreUsuarioTrabajador, String remitente, String contenido, LocalDateTime fechaEnvio) {
        this.id = id;
        this.idUsuarioComun = idUsuarioComun;
        this.nombreUsuarioComun = nombreUsuarioComun;
        this.idUsuarioTrabajador = idUsuarioTrabajador;
        this.nombreUsuarioTrabajador = nombreUsuarioTrabajador;
        this.remitente = remitente;
        this.contenido = contenido;
        this.fechaEnvio = fechaEnvio;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdUsuarioComun() { return idUsuarioComun; }
    public void setIdUsuarioComun(Long idUsuarioComun) { this.idUsuarioComun = idUsuarioComun; }

    public String getNombreUsuarioComun() { return nombreUsuarioComun; }
    public void setNombreUsuarioComun(String nombreUsuarioComun) { this.nombreUsuarioComun = nombreUsuarioComun; }

    public Long getIdUsuarioTrabajador() { return idUsuarioTrabajador; }
    public void setIdUsuarioTrabajador(Long idUsuarioTrabajador) { this.idUsuarioTrabajador = idUsuarioTrabajador; }

    public String getNombreUsuarioTrabajador() { return nombreUsuarioTrabajador; }
    public void setNombreUsuarioTrabajador(String nombreUsuarioTrabajador) { this.nombreUsuarioTrabajador = nombreUsuarioTrabajador; }

    public String getRemitente() { return remitente; }
    public void setRemitente(String remitente) { this.remitente = remitente; }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }

    public LocalDateTime getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(LocalDateTime fechaEnvio) { this.fechaEnvio = fechaEnvio; }
}
