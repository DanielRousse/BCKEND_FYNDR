package org.generation.fyndr.servicios;

import org.generation.fyndr.dto.TrabajadorDTO;
import org.generation.fyndr.modelos.UsuarioTrabajador;
import org.generation.fyndr.repositorios.UsuarioTrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar las operaciones de los usuarios trabajadores en memoria local.
 */
@Service
public class UsuarioTrabajadorService {

    private final UsuarioTrabajadorRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioTrabajadorService(UsuarioTrabajadorRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioTrabajador> getEntidades() {
        return repository.findAll();
    } // getEntidades

    public UsuarioTrabajador getEntidad(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("El usuario-trabajador con el id [" + id + "] no existe"));
    } // getEntidad

    public UsuarioTrabajador crearEntidad(UsuarioTrabajador obj) {
        Optional<UsuarioTrabajador> usr = repository.findByEmail(obj.getEmail());

        if(usr.isEmpty()){
            obj.setContrasena(passwordEncoder.encode(obj.getContrasena()));
            repository.save(obj);
        }else{
            obj=null;
        }
        return obj;
    } // crearEntidad

    public UsuarioTrabajador deleteEntidad(Long id) {
        UsuarioTrabajador usr = null;
        if(repository.existsById(id)){
            usr = repository.findById(id).get();
            repository.deleteById(id);
        }
        return usr;
    } // deleteEntidad

    public UsuarioTrabajador actualizarEntidad(Long id, TrabajadorDTO dto) {

            UsuarioTrabajador trabajador = null;
            if (repository.existsById(id)) {
                UsuarioTrabajador t = repository.findById(id).get();
                if (dto.getNombre() != null) {
                    t.setNombre(dto.getNombre());
                } // if
                if (dto.getEmail() != null) {
                    t.setEmail(dto.getEmail());
                } // if
                if (dto.getTelefono() != null) {
                    t.setTelefono(dto.getTelefono());
                } // if
                if (dto.getContrasena() != null) {
                    t.setContrasena(passwordEncoder.encode((dto.getContrasena())));
                } // if
                if (dto.getFechaNacimiento() != null) {
                    t.setFechaNacimiento(dto.getFechaNacimiento());
                } // if
                if (dto.getInePath() != null) {
                    t.setInePath(dto.getInePath());
                } // if
                if (dto.getCurp() != null) {
                    t.setCurp(dto.getCurp());
                } // if
                if (dto.getFotografiaPath() != null) {
                    t.setFotografiaPath(dto.getFotografiaPath());
                } // if
                if (dto.getComprobantePath() != null) {
                    t.setComprobantePath(dto.getComprobantePath());
                } // if
                if (dto.getAntecedentesPath() != null) {
                    t.setAntecedentesPath(dto.getAntecedentesPath());
                } // if
                if (dto.getExperienciaAnos() != null) {
                    t.setExperienciaAnos(dto.getExperienciaAnos());
                } // if
                if (dto.getDescripcion() != null) {
                    t.setDescripcion(dto.getDescripcion());
                } // if
                if (dto.getSubspecialidades() != null) {
                    t.setSubespecialidades(dto.getSubspecialidades());
                } // if
                if (dto.getCertificacionesPath() != null) {
                    t.setCertificacionesPath(dto.getCertificacionesPath());
                } // if
                if (dto.getPortafolioPath() != null) {
                    t.setPortafolioPath(dto.getPortafolioPath());
                } // if
                if (dto.getRfc() != null) {
                    t.setRfc(dto.getRfc());
                } // if
                if (dto.getConstanciaFiscalPath() != null) {
                    t.setConstanciaFiscalPath(dto.getConstanciaFiscalPath());
                } // if
                if (dto.getClabe() != null) {
                    t.setClabe(dto.getClabe());
                } // if
                if (dto.getBanco() != null) {
                    t.setBanco(dto.getBanco());
                } // if
                if (dto.getTarifaHora() != null) {
                    t.setTarifaHora(dto.getTarifaHora());
                } // if
                if (dto.getCalificacionPromedio() != null) {
                    t.setCalificacionPromedio(dto.getCalificacionPromedio());
                } // if

                trabajador = repository.save(t);


            } // if

        return trabajador;
    } // actualizarEntidad
} // class UsuarioTrabajadorService
