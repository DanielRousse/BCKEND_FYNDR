package org.generation.fyndr.dto;

import jakarta.validation.constraints.*;

/**
 * DTO para transferir datos de actualización de un usuario común.
 */
public class UsuarioComunDTO {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El formato del email es inválido")
    private String email;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "El teléfono debe contener entre 10 y 15 dígitos numéricos")
    private String telefono;

    private String contrasena;
    private String fotografiaPath;

    public UsuarioComunDTO() {
    } // UsuarioComunDTO

    public UsuarioComunDTO(String nombre, String email, String telefono, String contrasena, String fotografiaPath) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.fotografiaPath = fotografiaPath;
    } // UsuarioComunDTO

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

    public String getFotografiaPath() {
        return fotografiaPath;
    } // getFotografiaPath

    public void setFotografiaPath(String fotografiaPath) {
        this.fotografiaPath = fotografiaPath;
    } // setFotografiaPath

    @Override
    public String toString() {
        return "UsuarioComunDTO{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", contrasena='***'" +
                ", fotografiaPath='" + (fotografiaPath != null ? "present" : "null") + '\'' +
                '}';
    } // toString
} // class UsuarioComunDTO
