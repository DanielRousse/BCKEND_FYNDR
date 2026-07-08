package org.generation.fyndr.model;

public class Profesion {

    private Integer idProfesion;
    private String nombreProfesion;

    public Profesion() {
    }

    public Profesion(Integer idProfesion, String nombreProfesion) {
        this.idProfesion = idProfesion;
        this.nombreProfesion = nombreProfesion;
    }

    public Integer getIdProfesion() {
        return idProfesion;
    }

    public void setIdProfesion(Integer idProfesion) {
        this.idProfesion = idProfesion;
    }

    public String getNombreProfesion() {
        return nombreProfesion;
    }

    public void setNombreProfesion(String nombreProfesion) {
        this.nombreProfesion = nombreProfesion;
    }
}
