package org.generation.fyndr.modelos;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mensajes")
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_comun", nullable = false)
    private UsuarioComun usuarioComun;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_trabajador", nullable = false)
    private UsuarioTrabajador usuarioTrabajador;

    @Column(name = "remitente", nullable = false)
    private String remitente;

    @Column(name = "contenido", nullable = false, length = 500)
    private String contenido;

    @Column(name = "fecha_envio", nullable = false)
    private LocalDateTime fechaEnvio;

    // Constructor vacío obligatorio
    public Mensaje() {}

    // Constructor completo
    public Mensaje(UsuarioComun usuarioComun, UsuarioTrabajador usuarioTrabajador, String remitente, String contenido, LocalDateTime fechaEnvio) {
        this.usuarioComun = usuarioComun;
        this.usuarioTrabajador = usuarioTrabajador;
        this.remitente = remitente;
        this.contenido = contenido;
        this.fechaEnvio = fechaEnvio;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public UsuarioComun getUsuarioComun() { return usuarioComun; }
    public void setUsuarioComun(UsuarioComun usuarioComun) { this.usuarioComun = usuarioComun; }

    public UsuarioTrabajador getUsuarioTrabajador() { return usuarioTrabajador; }
    public void setUsuarioTrabajador(UsuarioTrabajador usuarioTrabajador) { this.usuarioTrabajador = usuarioTrabajador; }

    public String getRemitente() { return remitente; }
    public void setRemitente(String remitente) { this.remitente = remitente; }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }

    public LocalDateTime getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(LocalDateTime fechaEnvio) { this.fechaEnvio = fechaEnvio; }

    @Override
    public String toString() {
        return "Mensaje{" +
                "id=" + id +
                ", usuarioComun=" + (usuarioComun != null ? usuarioComun.getId() : null) +
                ", usuarioTrabajador=" + (usuarioTrabajador != null ? usuarioTrabajador.getId() : null) +
                ", remitente='" + remitente + '\'' +
                ", contenido='" + contenido + '\'' +
                ", fechaEnvio=" + fechaEnvio +
                '}';
    }
}