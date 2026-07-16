package org.generation.fyndr.dto;

/**
 * DTO para devolver el token JWT generado tras un login exitoso, incluyendo rol e id del usuario.
 */
public class TokenDTO {

    private String accessToken;
    private String nombre;
    private String email;
    private String role;
    private Long id;

    public TokenDTO() {
    } // TokenDTO

    public TokenDTO(String accessToken, String nombre, String email, String role, Long id) {
        this.accessToken = accessToken;
        this.nombre = nombre;
        this.email = email;
        this.role = role;
        this.id = id;
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

    public String getRole() {
        return role;
    } // getRole

    public void setRole(String role) {
        this.role = role;
    } // setRole

    public Long getId() {
        return id;
    } // getId

    public void setId(Long id) {
        this.id = id;
    } // setId
} // class TokenDTO
