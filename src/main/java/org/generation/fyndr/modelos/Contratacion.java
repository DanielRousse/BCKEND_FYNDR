package org.generation.fyndr.modelos;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contrataciones")
public class Contratacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_comun", nullable = false)
    private UsuarioComun usuarioComun;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_trabajador", nullable = false)
    private UsuarioTrabajador usuarioTrabajador;

    @Column(name = "fecha_contratacion", nullable = false)
    private LocalDateTime fechaContratacion;

    @Column(name = "estado", nullable = false)
    private String estado;

    // Constructor vacío
    public Contratacion() {}

    // Constructor completo
    public Contratacion(UsuarioComun usuarioComun, UsuarioTrabajador usuarioTrabajador, LocalDateTime fechaContratacion, String estado) {
        this.usuarioComun = usuarioComun;
        this.usuarioTrabajador = usuarioTrabajador;
        this.fechaContratacion = fechaContratacion;
        this.estado = estado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public UsuarioComun getUsuarioComun() { return usuarioComun; }
    public void setUsuarioComun(UsuarioComun usuarioComun) { this.usuarioComun = usuarioComun; }

    public UsuarioTrabajador getUsuarioTrabajador() { return usuarioTrabajador; }
    public void setUsuarioTrabajador(UsuarioTrabajador usuarioTrabajador) { this.usuarioTrabajador = usuarioTrabajador; }

    public LocalDateTime getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(LocalDateTime fechaContratacion) { this.fechaContratacion = fechaContratacion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Contratacion{" +
                "id=" + id +
                ", usuarioComun=" + (usuarioComun != null ? usuarioComun.getId() : null) +
                ", usuarioTrabajador=" + (usuarioTrabajador != null ? usuarioTrabajador.getId() : null) +
                ", fechaContratacion=" + fechaContratacion +
                ", estado='" + estado + '\'' +
                '}';
    }
}