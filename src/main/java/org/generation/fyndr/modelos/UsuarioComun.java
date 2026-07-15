package org.generation.fyndr.modelos;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Clase que representa a un usuario comun en el sistema Fyndr y mapea a la base de datos.
 */
@Entity
@Table(name = "usuario_comun")
public class UsuarioComun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_comun")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 15)
    private String telefono;

    @Column(nullable = false, length = 255)
    private String contrasena;

    @Column(name = "fecha_registro", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaRegistro;

    @OneToMany(mappedBy = "usuarioComun", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Resena> resenas;

    public UsuarioComun() {
    } // UsuarioComun

    public UsuarioComun(String nombre, String email, String telefono, String contrasena, LocalDateTime fechaRegistro) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.fechaRegistro = fechaRegistro;
    } // UsuarioComun

    public Integer getId() {
        return id;
    } // getId

    public String getNombre() {
        return nombre;
    } // getNombre

    public void setNombre(String nombre) {
        this.nombre = nombre;
    } // setNombre

    public String getEmail() {
        return email;
    } // getEmail

    public void setEmail(String email) {
        this.email = email;
    } // setEmail

    public String getTelefono() {
        return telefono;
    } // getTelefono

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    } // setTelefono

    public String getContrasena() {
        return contrasena;
    } // getContrasena

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    } // setContrasena

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    } // getFechaRegistro

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    } // setFechaRegistro

    public List<Resena> getResenas() {
        return resenas;
    } // getResenas

    public void setResenas(List<Resena> resenas) {
        this.resenas = resenas;
    } // setResenas

    @Override
    public String toString() {
        return "UsuarioComun{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    } // toString
} // class UsuarioComun
