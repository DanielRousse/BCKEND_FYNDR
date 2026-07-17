package org.generation.fyndr.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TrabajadorDTO {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El formato del email es inválido")
    private String email;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "El teléfono debe contener entre 10 y 15 dígitos numéricos")
    private String telefono;

    private String contrasena;
    private LocalDate fechaNacimiento;
    private String inePath;
    private String curp;
    private String fotografiaPath;
    private String comprobantePath;
    private String antecedentesPath;

    @Min(value = 0, message = "Los años de experiencia no pueden ser negativos")
    private Integer experienciaAnos;

    private String descripcion;
    private String subspecialidades;
    private String direccion;
    private String certificacionesPath;
    private String portafolioPath;
    private String rfc;
    private String constanciaFiscalPath;
    private String clabe;
    private String banco;
    private BigDecimal tarifaHora;
    private BigDecimal calificacionPromedio;
    private Double latitud;
    private Double longitud;

    public TrabajadorDTO(String nombre, String email, String telefono, String contrasena, LocalDate fechaNacimiento, String inePath, String curp, String fotografiaPath, String comprobantePath, String antecedentesPath, Integer experienciaAnos, String descripcion, String subspecialidades, String certificacionesPath, String portafolioPath, String rfc, String constanciaFiscalPath, String clabe, String banco, BigDecimal tarifaHora, BigDecimal calificacionPromedio) {
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
        this.subspecialidades = subspecialidades;
        this.certificacionesPath = certificacionesPath;
        this.portafolioPath = portafolioPath;
        this.rfc = rfc;
        this.constanciaFiscalPath = constanciaFiscalPath;
        this.clabe = clabe;
        this.banco = banco;
        this.tarifaHora = tarifaHora;
        this.calificacionPromedio = calificacionPromedio;
    }

    public TrabajadorDTO() {
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

    public String getSubspecialidades() {
        return subspecialidades;
    }

    public void setSubspecialidades(String subspecialidades) {
        this.subspecialidades = subspecialidades;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public BigDecimal getTarifaHora() {
        return tarifaHora;
    }

    public void setTarifaHora(BigDecimal tarifaHora) {
        this.tarifaHora = tarifaHora;
    }

    public BigDecimal getCalificacionPromedio() {
        return calificacionPromedio;
    }

    public void setCalificacionPromedio(BigDecimal calificacionPromedio) {
        this.calificacionPromedio = calificacionPromedio;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "TrabajadorDTO{" +
                "nombre='" + nombre + '\'' +
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
                ", subspecialidades='" + subspecialidades + '\'' +
                ", certificacionesPath='" + certificacionesPath + '\'' +
                ", portafolioPath='" + portafolioPath + '\'' +
                ", rfc='" + rfc + '\'' +
                ", constanciaFiscalPath='" + constanciaFiscalPath + '\'' +
                ", clabe='" + clabe + '\'' +
                ", banco='" + banco + '\'' +
                ", tarifaHora=" + tarifaHora +
                ", calificacionPromedio=" + calificacionPromedio +
                '}';
    }
}
