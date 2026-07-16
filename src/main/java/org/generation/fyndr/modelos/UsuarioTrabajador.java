package org.generation.fyndr.modelos;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Clase que representa a un usuario trabajador en el sistema Fyndr.
 */

@Entity
@Table(name = "usuario_trabajador")
public class UsuarioTrabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_trabajador", unique=true, nullable = false)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El formato del email es inválido")
    @Column(name = "email" , nullable = false, unique = true)
    private String email;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "El teléfono debe contener entre 10 y 15 dígitos numéricos")
    @Column(name = "telefono", nullable = false)
    private String telefono;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "ine_path", columnDefinition = "LONGTEXT")
    private String inePath;

    @Column(name = "curp" , unique = true)
    private String curp;

    @Column(name = "fotografia_path", columnDefinition = "LONGTEXT")
    private String fotografiaPath;

    @Column(name = "comprobante_path", columnDefinition = "LONGTEXT")
    private String comprobantePath;

    @Column(name = "antecedentes_path", columnDefinition = "LONGTEXT")
    private String antecedentesPath;

    @Min(value = 0, message = "Los años de experiencia no pueden ser negativos")
    @ColumnDefault("0")
    @Column(name = "experiencia_anos")
    private Integer experienciaAnos;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "subespecialidades")
    private String subespecialidades;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "certificaciones_path", columnDefinition = "LONGTEXT")
    private String certificacionesPath;

    @Column(name = "portafolio_path", columnDefinition = "LONGTEXT")
    private String portafolioPath;

    @Column(name = "rfc", unique = true)
    private String rfc;

    @Column(name = "constancia_fiscal_path")
    private String constanciaFiscalPath;

    @Column(name = "clabe")
    private String clabe;

    @Column(name = "banco")
    private String banco;

    @Column(name = "tarifa_hora", precision = 10, scale = 2)
    private BigDecimal tarifaHora;

    @Column(name = "calificacion_promedio", precision = 3 , scale = 2)
    private BigDecimal calificacionPromedio;

    @Column(name = "fecha_registro", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaRegistro;

    @OneToMany(mappedBy = "usuarioTrabajador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "usuarioTrabajador-resena")
    private List<Resena> resenas;

    @ManyToMany
    @JoinTable(
        name = "trabajador_profesion",
        joinColumns = @JoinColumn(name = "id_usuario_trabajador"),
        inverseJoinColumns = @JoinColumn(name = "id_profesion")
    )
    private List<Profesion> profesiones;

    @OneToMany(mappedBy = "usuarioTrabajador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Publicacion> publicaciones;

    @OneToMany(mappedBy = "usuarioTrabajador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Contratacion> contrataciones;

    @OneToMany(mappedBy = "usuarioTrabajador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Mensaje> mensajes;

    public UsuarioTrabajador() {
    } // UsuarioTrabajador

    public UsuarioTrabajador(String nombre, String email, String telefono, String contrasena, LocalDate fechaNacimiento, String inePath, String curp, String fotografiaPath, String comprobantePath, String antecedentesPath, Integer experienciaAnos, String descripcion, String subespecialidades, String certificacionesPath, String portafolioPath, String rfc, String constanciaFiscalPath, String clabe, String banco, BigDecimal tarifaHora, BigDecimal calificacionPromedio, LocalDateTime fechaRegistro) {
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

    public Long getId() {
        return id;
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

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<Resena> getResenas() {
        return resenas;
    }

    public void setResenas(List<Resena> resenas) {
        this.resenas = resenas;
    }

    public List<Profesion> getProfesiones() {
        return profesiones;
    }

    public void setProfesiones(List<Profesion> profesiones) {
        this.profesiones = profesiones;
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(List<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }

    public List<Contratacion> getContrataciones() {
        return contrataciones;
    }

    public void setContrataciones(List<Contratacion> contrataciones) {
        this.contrataciones = contrataciones;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    @Override
    public String toString() {
        return "UsuarioTrabajador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", experienciaAnos=" + experienciaAnos +
                ", subespecialidades='" + subespecialidades + '\'' +
                ", tarifaHora=" + tarifaHora +
                ", calificacionPromedio=" + calificacionPromedio +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    } // toString
} // class UsuarioTrabajador
