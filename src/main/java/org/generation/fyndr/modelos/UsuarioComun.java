package org.generation.fyndr.modelos;

import java.time.LocalDateTime;

/**
 * Clase que representa a un usuario comun en el sistema Fyndr.
 */
public class UsuarioComun {

    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String contrasena;
    private LocalDateTime fechaRegistro;

    private static Long total = 0L;

    public UsuarioComun() {
    } // UsuarioComun

    public UsuarioComun(String nombre, String email, String telefono, String contrasena, LocalDateTime fechaRegistro) {
        total++;
        this.id = total;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.fechaRegistro = fechaRegistro;
    } // UsuarioComun

    public Long getId() {
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
