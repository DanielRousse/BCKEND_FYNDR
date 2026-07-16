package org.generation.fyndr.modelos;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.time.LocalDateTime;

/**
 * Clase que representa a una resena en el sistema Fyndr.
 */
@Entity
@Table(name = "resenas")
public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resena")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_comun")
    @JsonBackReference(value = "usuarioComun-resena")
    private UsuarioComun usuarioComun;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_trabajador")
    @JsonBackReference(value = "usuarioTrabajador-resena")
    private UsuarioTrabajador usuarioTrabajador;
    private Integer calificacion;
    private String comentario;
    @Column(name = "fecha_resena")
    private LocalDateTime fechaResena;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioComun getUsuarioComun() {
        return usuarioComun;
    }

    public void setUsuarioComun(UsuarioComun usuarioComun) {
        this.usuarioComun = usuarioComun;
    }

    public UsuarioTrabajador getUsuarioTrabajador() {
        return usuarioTrabajador;
    }

    public void setUsuarioTrabajador(UsuarioTrabajador usuarioTrabajador) {
        this.usuarioTrabajador = usuarioTrabajador;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getFechaResena() {
        return fechaResena;
    }

    public void setFechaResena(LocalDateTime fechaResena) {
        this.fechaResena = fechaResena;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Resena{");
        sb.append("id=").append(id);
        sb.append(", usuarioComun=").append(usuarioComun);
        sb.append(", calificacion=").append(calificacion);
        sb.append(", comentario='").append(comentario).append('\'');
        sb.append(", fechaResena=").append(fechaResena);
        sb.append('}');
        return sb.toString();
    }
}
