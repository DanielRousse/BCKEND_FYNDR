package org.generation.fyndr.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

public class MensajeDTO {

    @NotNull(message = "El ID de usuario común es obligatorio")
    private Long idUsuarioComun;

    @NotNull(message = "El ID de usuario trabajador es obligatorio")
    private Long idUsuarioTrabajador;

    @NotBlank(message = "El remitente es obligatorio")
    private String remitente;

    @NotBlank(message = "El contenido no puede estar vacío")
    @Size(max = 500, message = "El contenido no puede superar los 500 caracteres")
    private String contenido;

    private LocalDateTime fechaEnvio;

    public MensajeDTO() {}

    public MensajeDTO(Long idUsuarioComun, Long idUsuarioTrabajador, String remitente, String contenido, LocalDateTime fechaEnvio) {
        this.idUsuarioComun = idUsuarioComun;
        this.idUsuarioTrabajador = idUsuarioTrabajador;
        this.remitente = remitente;
        this.contenido = contenido;
        this.fechaEnvio = fechaEnvio;
    }

    public Long getIdUsuarioComun() { return idUsuarioComun; }
    public void setIdUsuarioComun(Long idUsuarioComun) { this.idUsuarioComun = idUsuarioComun; }

    public Long getIdUsuarioTrabajador() { return idUsuarioTrabajador; }
    public void setIdUsuarioTrabajador(Long idUsuarioTrabajador) { this.idUsuarioTrabajador = idUsuarioTrabajador; }

    public String getRemitente() { return remitente; }
    public void setRemitente(String remitente) { this.remitente = remitente; }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }

    public LocalDateTime getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(LocalDateTime fechaEnvio) { this.fechaEnvio = fechaEnvio; }
}
