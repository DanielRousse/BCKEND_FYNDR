package org.generation.fyndr.dto;

/**
 * DTO para transferir credenciales de inicio de sesion.
 */
public class LoginDTO {

    private String email;
    private String contrasena;

    public LoginDTO() {
    } // LoginDTO

    public LoginDTO(String email, String contrasena) {
        this.email = email;
        this.contrasena = contrasena;
    } // LoginDTO

    public String getEmail() {
        return email;
    } // getEmail

    public void setEmail(String email) {
        this.email = email;
    } // setEmail

    public String getContrasena() {
        return contrasena;
    } // getContrasena

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    } // setContrasena

    @Override
    public String toString() {
        return "LoginDTO{" +
                "email='" + email + '\'' +
                ", contrasena='***'" +
                '}';
    } // toString
} // class LoginDTO
