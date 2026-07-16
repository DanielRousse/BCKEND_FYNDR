package org.generation.fyndr.modelos;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contrataciones")
public class Contratacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_usuario_comun", nullable = false)
    private Long idUsuarioComun;

    @Column(name = "id_usuario_trabajador", nullable = false)
    private Long idUsuarioTrabajador;

    @Column(name = "fecha_contratacion", nullable = false)
    private LocalDateTime fechaContratacion;

    @Column(name = "estado", nullable = false)
    private String estado;

    // Constructor vacío
    public Contratacion() {}

    // Constructor completo adaptado (sin el contador manual obsoleto)
    public Contratacion(Long idUsuarioComun, Long idUsuarioTrabajador, LocalDateTime fechaContratacion, String estado) {
        this.idUsuarioComun = idUsuarioComun;
        this.idUsuarioTrabajador = idUsuarioTrabajador;
        this.fechaContratacion = fechaContratacion;
        this.estado = estado;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdUsuarioComun() { return idUsuarioComun; }
    public void setIdUsuarioComun(Long idUsuarioComun) { this.idUsuarioComun = idUsuarioComun; }

    public Long getIdUsuarioTrabajador() { return idUsuarioTrabajador; }
    public void setIdUsuarioTrabajador(Long idUsuarioTrabajador) { this.idUsuarioTrabajador = idUsuarioTrabajador; }

    public LocalDateTime getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(LocalDateTime fechaContratacion) { this.fechaContratacion = fechaContratacion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Contratacion{" +
                "id=" + id +
                ", idUsuarioComun=" + idUsuarioComun +
                ", idUsuarioTrabajador=" + idUsuarioTrabajador +
                ", fechaContratacion=" + fechaContratacion +
                ", estado='" + estado + '\'' +
                '}';
    }
}