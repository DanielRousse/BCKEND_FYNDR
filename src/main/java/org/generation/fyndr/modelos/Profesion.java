package org.generation.fyndr.modelos;

import jakarta.persistence.*;

/**
 * Clase que representa una profesión en el sistema Fyndr.
 */
@Entity
@Table(name = "profesiones")
public class Profesion {

    // Llave primaria de la tabla.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesion")
    private Long id;

    // Nombre de la profesión.
    @Column(name = "nombre_profesion", nullable = false, unique = true)
    private String nombreProfesion;

    // Constructor vacío requerido por JPA.
    public Profesion() {
    }

    // Constructor con parámetros.
    public Profesion(String nombreProfesion) {
        this.nombreProfesion = nombreProfesion;
    }

    public Long getId() {
        return id;
    }

    public String getNombreProfesion() {
        return nombreProfesion;
    }

    public void setNombreProfesion(String nombreProfesion) {
        this.nombreProfesion = nombreProfesion;
    }

    @Override
    public String toString() {
        return "Profesion{" +
                "id=" + id +
                ", nombreProfesion='" + nombreProfesion + '\'' +
                '}';
    }
}