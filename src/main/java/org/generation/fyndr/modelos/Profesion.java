package org.generation.fyndr.modelos;

/**
 * Clase que representa a una profesion en el sistema Fyndr.
 */
public class Profesion {

    private Long id;
    private String nombreProfesion;

    private static Long total = 0L;

    public Profesion() {
    } // Profesion

    public Profesion(String nombreProfesion) {
        total++;
        this.id = total;
        this.nombreProfesion = nombreProfesion;
    } // Profesion

    public Long getId() {
        return id;
    } // getId

    public String getNombreProfesion() {
        return nombreProfesion;
    } // getNombreProfesion

    public void setNombreProfesion(String nombreProfesion) {
        this.nombreProfesion = nombreProfesion;
    } // setNombreProfesion

    @Override
    public String toString() {
        return "Profesion{" +
                "id=" + id +
                ", nombreProfesion='" + nombreProfesion + '\'' +
                '}';
    } // toString
} // class Profesion
