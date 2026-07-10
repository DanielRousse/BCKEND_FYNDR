package org.generation.fyndr.servicios;

import org.generation.fyndr.modelos.Profesion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Servicio para gestionar las operaciones de las profesiones en memoria local.
 */
@Service
public class ProfesionService {

    private final ArrayList<Profesion> lista = new ArrayList<>();

    public ProfesionService() {
        lista.add(new Profesion("Plomeria"));
        lista.add(new Profesion("Electricidad"));
        lista.add(new Profesion("Carpinteria"));
    } // ProfesionService

    public ArrayList<Profesion> getEntidades() {
        return lista;
    } // getEntidades

    public Profesion getEntidad(Long id) {
        for (int i = 0; i < lista.size(); i++) {
            Profesion p = lista.get(i);
            if (p.getId().equals(id)) {
                return p;
            } // if
        } // for
        return null;
    } // getEntidad

    public Profesion crearEntidad(Profesion obj) {
        Profesion nuevo = new Profesion(obj.getNombreProfesion());
        lista.add(nuevo);
        return nuevo;
    } // crearEntidad

    public Profesion deleteEntidad(Long id) {
        for (int i = 0; i < lista.size(); i++) {
            Profesion p = lista.get(i);
            if (p.getId().equals(id)) {
                Profesion ref = p;
                lista.remove(i);
                return ref;
            } // if
        } // for
        return null;
    } // deleteEntidad

    public Profesion actualizarEntidad(Long id, String nombreProfesion) {
        for (int i = 0; i < lista.size(); i++) {
            Profesion p = lista.get(i);
            if (p.getId().equals(id)) {
                if (nombreProfesion != null) {
                    p.setNombreProfesion(nombreProfesion);
                } // if
                return p;
            } // if
        } // for
        return null;
    } // actualizarEntidad
} // class ProfesionService
