package org.generation.fyndr.dto;

/**
 * DTO para transferir datos de actualizacion de un usuario comun.
 */
public class UsuarioComunDTO {

    private String nombre;
    private String email;
    private String telefono;
    private String contrasena;

    public UsuarioComunDTO() {
    } // UsuarioComunDTO

    public UsuarioComunDTO(String nombre, String email, String telefono, String contrasena) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.contrasena = contrasena;
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

    @Override
    public String toString() {
        return "UsuarioComunDTO{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", contrasena='***'" +
                '}';
    } // toString
} // class UsuarioComunDTO
