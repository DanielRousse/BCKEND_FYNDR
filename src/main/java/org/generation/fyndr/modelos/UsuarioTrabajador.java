package org.generation.fyndr.modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Clase que representa a un usuario trabajador en el sistema Fyndr.
 */
public class UsuarioTrabajador {

    private Long id;
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

    private static Long total = 0L;

    public UsuarioTrabajador() {
    } // UsuarioTrabajador

    public UsuarioTrabajador(String nombre, String email, String telefono, String contrasena, LocalDate fechaNacimiento, String inePath, String curp, String fotografiaPath, String comprobantePath, String antecedentesPath, Integer experienciaAnos, String descripcion, String subespecialidades, String certificacionesPath, String portafolioPath, String rfc, String constanciaFiscalPath, String clabe, String banco, Double tarifaHora, Double calificacionPromedio, LocalDateTime fechaRegistro) {
        total++;
        this.id = total;
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
    } // UsuarioTrabajador

    public Long getId() {
        return id;
    } // getId

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

    public String getTelefono() {
        return telefono;
    } // getTelefono

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    } // setTelefono

    public String getContrasena() {
        return contrasena;
    } // getContrasena

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    } // setContrasena

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    } // getFechaNacimiento

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    } // setFechaNacimiento

    public String getInePath() {
        return inePath;
    } // getInePath

    public void setInePath(String inePath) {
        this.inePath = inePath;
    } // setInePath

    public String getCurp() {
        return curp;
    } // getCurp

    public void setCurp(String curp) {
        this.curp = curp;
    } // setCurp

    public String getFotografiaPath() {
        return fotografiaPath;
    } // getFotografiaPath

    public void setFotografiaPath(String fotografiaPath) {
        this.fotografiaPath = fotografiaPath;
    } // setFotografiaPath

    public String getComprobantePath() {
        return comprobantePath;
    } // getComprobantePath

    public void setComprobantePath(String comprobantePath) {
        this.comprobantePath = comprobantePath;
    } // setComprobantePath

    public String getAntecedentesPath() {
        return antecedentesPath;
    } // getAntecedentesPath

    public void setAntecedentesPath(String antecedentesPath) {
        this.antecedentesPath = antecedentesPath;
    } // setAntecedentesPath

    public Integer getExperienciaAnos() {
        return experienciaAnos;
    } // getExperienciaAnos

    public void setExperienciaAnos(Integer experienciaAnos) {
        this.experienciaAnos = experienciaAnos;
    } // setExperienciaAnos

    public String getDescripcion() {
        return descripcion;
    } // getDescripcion

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    } // setDescripcion

    public String getSubespecialidades() {
        return subespecialidades;
    } // getSubespecialidades

    public void setSubespecialidades(String subespecialidades) {
        this.subespecialidades = subespecialidades;
    } // setSubespecialidades

    public String getCertificacionesPath() {
        return certificacionesPath;
    } // getCertificacionesPath

    public void setCertificacionesPath(String certificacionesPath) {
        this.certificacionesPath = certificacionesPath;
    } // setCertificacionesPath

    public String getPortafolioPath() {
        return portafolioPath;
    } // getPortafolioPath

    public void setPortafolioPath(String portafolioPath) {
        this.portafolioPath = portafolioPath;
    } // setPortafolioPath

    public String getRfc() {
        return rfc;
    } // getRfc

    public void setRfc(String rfc) {
        this.rfc = rfc;
    } // setRfc

    public String getConstanciaFiscalPath() {
        return constanciaFiscalPath;
    } // getConstanciaFiscalPath

    public void setConstanciaFiscalPath(String constanciaFiscalPath) {
        this.constanciaFiscalPath = constanciaFiscalPath;
    } // setConstanciaFiscalPath

    public String getClabe() {
        return clabe;
    } // getClabe

    public void setClabe(String clabe) {
        this.clabe = clabe;
    } // setClabe

    public String getBanco() {
        return banco;
    } // getBanco

    public void setBanco(String banco) {
        this.banco = banco;
    } // setBanco

    public Double getTarifaHora() {
        return tarifaHora;
    } // getTarifaHora

    public void setTarifaHora(Double tarifaHora) {
        this.tarifaHora = tarifaHora;
    } // setTarifaHora

    public Double getCalificacionPromedio() {
        return calificacionPromedio;
    } // getCalificacionPromedio

    public void setCalificacionPromedio(Double calificacionPromedio) {
        this.calificacionPromedio = calificacionPromedio;
    } // setCalificacionPromedio

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    } // getFechaRegistro

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    } // setFechaRegistro

    @Override
    public String toString() {
        return "UsuarioTrabajador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", inePath='" + inePath + '\'' +
                ", curp='" + curp + '\'' +
                ", fotografiaPath='" + fotografiaPath + '\'' +
                ", comprobantePath='" + comprobantePath + '\'' +
                ", antecedentesPath='" + antecedentesPath + '\'' +
                ", experienciaAnos=" + experienciaAnos +
                ", descripcion='" + descripcion + '\'' +
                ", subespecialidades='" + subespecialidades + '\'' +
                ", certificacionesPath='" + certificacionesPath + '\'' +
                ", portafolioPath='" + portafolioPath + '\'' +
                ", rfc='" + rfc + '\'' +
                ", constanciaFiscalPath='" + constanciaFiscalPath + '\'' +
                ", clabe='" + clabe + '\'' +
                ", banco='" + banco + '\'' +
                ", tarifaHora=" + tarifaHora +
                ", calificacionPromedio=" + calificacionPromedio +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    } // toString
} // class UsuarioTrabajador
