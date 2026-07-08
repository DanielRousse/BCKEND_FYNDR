package org.generation.fyndr.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UsuarioTrabajador {

    private Integer idUsuarioTrabajador;
    private String nombre;
    private String email;
    private String telefono;
    private String contrasena;
    private LocalDate fechaNacimiento;
    private String inePath;
    private String curp;
    private String fotografiaPath;
    private String comprobantePath;
    private String antecedentesPath;
    private Integer experienciaAnos;
    private String descripcion;
    private String subespecialidades;
    private String certificacionesPath;
    private String portafolioPath;
    private String rfc;
    private String constanciaFiscalPath;
    private String clabe;
    private String banco;
    private Double tarifaHora;
    private Double calificacionPromedio;
    private LocalDateTime fechaRegistro;

    public UsuarioTrabajador() {
    }

    public UsuarioTrabajador(Integer idUsuarioTrabajador, String nombre, String email, String telefono, String contrasena, LocalDate fechaNacimiento, String inePath, String curp, String fotografiaPath, String comprobantePath, String antecedentesPath, Integer experienciaAnos, String descripcion, String subespecialidades, String certificacionesPath, String portafolioPath, String rfc, String constanciaFiscalPath, String clabe, String banco, Double tarifaHora, Double calificacionPromedio, LocalDateTime fechaRegistro) {
        this.idUsuarioTrabajador = idUsuarioTrabajador;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.fechaNacimiento = fechaNacimiento;
        this.inePath = inePath;
        this.curp = curp;
        this.fotografiaPath = fotografiaPath;
        this.comprobantePath = comprobantePath;
        this.antecedentesPath = antecedentesPath;
        this.experienciaAnos = experienciaAnos;
        this.descripcion = descripcion;
        this.subespecialidades = subespecialidades;
        this.certificacionesPath = certificacionesPath;
        this.portafolioPath = portafolioPath;
        this.rfc = rfc;
        this.constanciaFiscalPath = constanciaFiscalPath;
        this.clabe = clabe;
        this.banco = banco;
        this.tarifaHora = tarifaHora;
        this.calificacionPromedio = calificacionPromedio;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdUsuarioTrabajador() {
        return idUsuarioTrabajador;
    }

    public void setIdUsuarioTrabajador(Integer idUsuarioTrabajador) {
        this.idUsuarioTrabajador = idUsuarioTrabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getInePath() {
        return inePath;
    }

    public void setInePath(String inePath) {
        this.inePath = inePath;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getFotografiaPath() {
        return fotografiaPath;
    }

    public void setFotografiaPath(String fotografiaPath) {
        this.fotografiaPath = fotografiaPath;
    }

    public String getComprobantePath() {
        return comprobantePath;
    }

    public void setComprobantePath(String comprobantePath) {
        this.comprobantePath = comprobantePath;
    }

    public String getAntecedentesPath() {
        return antecedentesPath;
    }

    public void setAntecedentesPath(String antecedentesPath) {
        this.antecedentesPath = antecedentesPath;
    }

    public Integer getExperienciaAnos() {
        return experienciaAnos;
    }

    public void setExperienciaAnos(Integer experienciaAnos) {
        this.experienciaAnos = experienciaAnos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSubespecialidades() {
        return subespecialidades;
    }

    public void setSubespecialidades(String subespecialidades) {
        this.subespecialidades = subespecialidades;
    }

    public String getCertificacionesPath() {
        return certificacionesPath;
    }

    public void setCertificacionesPath(String certificacionesPath) {
        this.certificacionesPath = certificacionesPath;
    }

    public String getPortafolioPath() {
        return portafolioPath;
    }

    public void setPortafolioPath(String portafolioPath) {
        this.portafolioPath = portafolioPath;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getConstanciaFiscalPath() {
        return constanciaFiscalPath;
    }

    public void setConstanciaFiscalPath(String constanciaFiscalPath) {
        this.constanciaFiscalPath = constanciaFiscalPath;
    }

    public String getClabe() {
        return clabe;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public Double getTarifaHora() {
        return tarifaHora;
    }

    public void setTarifaHora(Double tarifaHora) {
        this.tarifaHora = tarifaHora;
    }

    public Double getCalificacionPromedio() {
        return calificacionPromedio;
    }

    public void setCalificacionPromedio(Double calificacionPromedio) {
        this.calificacionPromedio = calificacionPromedio;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
