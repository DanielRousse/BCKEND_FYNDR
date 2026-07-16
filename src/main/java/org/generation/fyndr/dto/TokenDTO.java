package org.generation.fyndr.dto;

/**
 * DTO para devolver el token JWT generado tras un login exitoso.
 */
public class TokenDTO {

    private String accessToken;
    private String nombre;
    private String email;

    public TokenDTO() {
    } // TokenDTO

    public TokenDTO(String accessToken, String nombre, String email) {
        this.accessToken = accessToken;
        this.nombre = nombre;
        this.email = email;
    } // TokenDTO

    public String getAccessToken() {
        return accessToken;
    } // getAccessToken

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    } // setAccessToken

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
} // class TokenDTO
