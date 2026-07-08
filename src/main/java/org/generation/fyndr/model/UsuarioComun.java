package org.generation.fyndr.model;

import java.time.LocalDateTime;

public class UsuarioComun {

    private Integer idUsuarioComun;
    private String nombre;
    private String email;
    private String telefono;
    private String contrasena;
    private LocalDateTime fechaRegistro;

    public UsuarioComun() {
    }

    public UsuarioComun(Integer idUsuarioComun, String nombre, String email, String telefono, String contrasena, LocalDateTime fechaRegistro) {
        this.idUsuarioComun = idUsuarioComun;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdUsuarioComun() {
        return idUsuarioComun;
    }

    public void setIdUsuarioComun(Integer idUsuarioComun) {
        this.idUsuarioComun = idUsuarioComun;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
