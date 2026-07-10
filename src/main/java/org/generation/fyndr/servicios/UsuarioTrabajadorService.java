package org.generation.fyndr.servicios;

import org.generation.fyndr.modelos.UsuarioTrabajador;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Servicio para gestionar las operaciones de los usuarios trabajadores en memoria local.
 */
@Service
public class UsuarioTrabajadorService {

    private final ArrayList<UsuarioTrabajador> lista = new ArrayList<>();

    public UsuarioTrabajadorService() {
        lista.add(new UsuarioTrabajador("Carlos Gomez", "carlos@example.com", "5559876543", "WorkPass789!", LocalDate.of(1990, 5, 10), "ine_carlos.pdf", "GOMC900510HDFRNS01", "carlos.jpg", "comprobante_carlos.pdf", "antecedentes_carlos.pdf", 5, "Plomero experto con 5 anos de experiencia.", "Plomeria, Fugas, Gas", "cert_plomero.pdf", "portafolio_carlos.pdf", "GOXC9005101A1", "constancia_carlos.pdf", "012180012345678901", "Banco de la Union", 250.0, 4.8, LocalDateTime.now()));
        lista.add(new UsuarioTrabajador("Ana Ruiz", "ana@example.com", "5553456789", "RuizPass321!", LocalDate.of(1995, 8, 15), "ine_ana.pdf", "RUIA950815MDFRNS02", "ana.jpg", "comprobante_ana.pdf", "antecedentes_ana.pdf", 3, "Electricista certificada.", "Electricidad, Cableado", "cert_elect.pdf", "portafolio_ana.pdf", "RUIA9508152B2", "constancia_ana.pdf", "012180098765432102", "Banco del Futuro", 300.0, 4.9, LocalDateTime.now()));
    } // UsuarioTrabajadorService

    public ArrayList<UsuarioTrabajador> getEntidades() {
        return lista;
    } // getEntidades

    public UsuarioTrabajador getEntidad(Long id) {
        for (int i = 0; i < lista.size(); i++) {
            UsuarioTrabajador t = lista.get(i);
            if (t.getId().equals(id)) {
                return t;
            } // if
        } // for
        return null;
    } // getEntidad

    public UsuarioTrabajador crearEntidad(UsuarioTrabajador obj) {
        UsuarioTrabajador nuevo = new UsuarioTrabajador(obj.getNombre(), obj.getEmail(), obj.getTelefono(), obj.getContrasena(), obj.getFechaNacimiento(), obj.getInePath(), obj.getCurp(), obj.getFotografiaPath(), obj.getComprobantePath(), obj.getAntecedentesPath(), obj.getExperienciaAnos(), obj.getDescripcion(), obj.getSubespecialidades(), obj.getCertificacionesPath(), obj.getPortafolioPath(), obj.getRfc(), obj.getConstanciaFiscalPath(), obj.getClabe(), obj.getBanco(), obj.getTarifaHora(), obj.getCalificacionPromedio(), LocalDateTime.now());
        lista.add(nuevo);
        return nuevo;
    } // crearEntidad

    public UsuarioTrabajador deleteEntidad(Long id) {
        for (int i = 0; i < lista.size(); i++) {
            UsuarioTrabajador t = lista.get(i);
            if (t.getId().equals(id)) {
                UsuarioTrabajador ref = t;
                lista.remove(i);
                return ref;
            } // if
        } // for
        return null;
    } // deleteEntidad

    public UsuarioTrabajador actualizarEntidad(Long id, String nombre, String email, String telefono, String contrasena, LocalDate fechaNacimiento, String inePath, String curp, String fotografiaPath, String comprobantePath, String antecedentesPath, Integer experienciaAnos, String descripcion, String subespecialidades, String certificacionesPath, String portafolioPath, String rfc, String constanciaFiscalPath, String clabe, String banco, Double tarifaHora, Double calificacionPromedio) {
        for (int i = 0; i < lista.size(); i++) {
            UsuarioTrabajador t = lista.get(i);
            if (t.getId().equals(id)) {
                if (nombre != null) {
                    t.setNombre(nombre);
                } // if
                if (email != null) {
                    t.setEmail(email);
                } // if
                if (telefono != null) {
                    t.setTelefono(telefono);
                } // if
                if (contrasena != null) {
                    t.setContrasena(contrasena);
                } // if
                if (fechaNacimiento != null) {
                    t.setFechaNacimiento(fechaNacimiento);
                } // if
                if (inePath != null) {
                    t.setInePath(inePath);
                } // if
                if (curp != null) {
                    t.setCurp(curp);
                } // if
                if (fotografiaPath != null) {
                    t.setFotografiaPath(fotografiaPath);
                } // if
                if (comprobantePath != null) {
                    t.setComprobantePath(comprobantePath);
                } // if
                if (antecedentesPath != null) {
                    t.setAntecedentesPath(antecedentesPath);
                } // if
                if (experienciaAnos != null) {
                    t.setExperienciaAnos(experienciaAnos);
                } // if
                if (descripcion != null) {
                    t.setDescripcion(descripcion);
                } // if
                if (subespecialidades != null) {
                    t.setSubespecialidades(subespecialidades);
                } // if
                if (certificacionesPath != null) {
                    t.setCertificacionesPath(certificacionesPath);
                } // if
                if (portafolioPath != null) {
                    t.setPortafolioPath(portafolioPath);
                } // if
                if (rfc != null) {
                    t.setRfc(rfc);
                } // if
                if (constanciaFiscalPath != null) {
                    t.setConstanciaFiscalPath(constanciaFiscalPath);
                } // if
                if (clabe != null) {
                    t.setClabe(clabe);
                } // if
                if (banco != null) {
                    t.setBanco(banco);
                } // if
                if (tarifaHora != null) {
                    t.setTarifaHora(tarifaHora);
                } // if
                if (calificacionPromedio != null) {
                    t.setCalificacionPromedio(calificacionPromedio);
                } // if
                return t;
            } // if
        } // for
        return null;
    } // actualizarEntidad
} // class UsuarioTrabajadorService
