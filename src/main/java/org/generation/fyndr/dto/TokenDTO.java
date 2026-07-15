package org.generation.fyndr.dto;

/**
 * DTO para devolver el token JWT generado tras un login exitoso.
 */
public class TokenDTO {

    private String accessToken;

    public TokenDTO() {
    } // TokenDTO

    public TokenDTO(String accessToken) {
        this.accessToken = accessToken;
    } // TokenDTO

    public String getAccessToken() {
        return accessToken;
    } // getAccessToken

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    } // setAccessToken
} // class TokenDTO
