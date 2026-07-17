package org.generation.fyndr.modelos;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Clase que representa a un usuario comun en el sistema Fyndr y mapea a la base de datos.
 */
@Entity
@Table(name = "usuario_comun")
public class UsuarioComun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_comun")
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El formato del email es inválido")
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "El teléfono debe contener entre 10 y 15 dígitos numéricos")
    @Column(nullable = false, length = 15)
    private String telefono;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false, length = 255)
    private String contrasena;

    @Column(name = "fecha_registro", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaRegistro;

    @Column(name = "fotografia_path", columnDefinition = "LONGTEXT")
    private String fotografiaPath;

    @Column(name = "direcciones_json", columnDefinition = "LONGTEXT")
    private String direccionesJson;

    @Column(name = "tarjetas_json", columnDefinition = "LONGTEXT")
    private String tarjetasJson;

    @OneToMany(mappedBy = "usuarioComun", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "usuarioComun-resena")
    private List<Resena> resenas;

    @OneToMany(mappedBy = "usuarioComun", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Contratacion> contrataciones;

    @OneToMany(mappedBy = "usuarioComun", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Mensaje> mensajes;

    @ManyToMany
    @JoinTable(
        name = "favoritos",
        joinColumns = @JoinColumn(name = "id_usuario_comun"),
        inverseJoinColumns = @JoinColumn(name = "id_usuario_trabajador")
    )
    @JsonIgnore
    private List<UsuarioTrabajador> favoritos;

    public UsuarioComun() {
    } // UsuarioComun

    public UsuarioComun(String nombre, String email, String telefono, String contrasena, LocalDateTime fechaRegistro) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.fechaRegistro = fechaRegistro;
    } // UsuarioComun

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

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    } // getFechaRegistro

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    } // setFechaRegistro

    public List<Resena> getResenas() {
        return resenas;
    } // getResenas

    public void setResenas(List<Resena> resenas) {
        this.resenas = resenas;
    } // setResenas

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

    public List<UsuarioTrabajador> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(List<UsuarioTrabajador> favoritos) {
        this.favoritos = favoritos;
    }

    public String getFotografiaPath() {
        return fotografiaPath;
    }

    public void setFotografiaPath(String fotografiaPath) {
        this.fotografiaPath = fotografiaPath;
    }

    public String getDireccionesJson() {
        return direccionesJson;
    }

    public void setDireccionesJson(String direccionesJson) {
        this.direccionesJson = direccionesJson;
    }

    public String getTarjetasJson() {
        return tarjetasJson;
    }

    public void setTarjetasJson(String tarjetasJson) {
        this.tarjetasJson = tarjetasJson;
    }

    @Override
    public String toString() {
        return "UsuarioComun{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    } // toString
} // class UsuarioComun
