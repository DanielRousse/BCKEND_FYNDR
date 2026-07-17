package org.generation.fyndr.servicios;

import org.generation.fyndr.dto.TrabajadorDTO;
import org.generation.fyndr.modelos.Profesion;
import org.generation.fyndr.modelos.UsuarioTrabajador;
import org.generation.fyndr.repositorios.ProfesionRepository;
import org.generation.fyndr.repositorios.UsuarioTrabajadorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar las operaciones de los usuarios trabajadores.
 */
@Service
public class UsuarioTrabajadorService {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioTrabajadorService.class);

    private final UsuarioTrabajadorRepository repository;
    private final ProfesionRepository profesionRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioTrabajadorService(UsuarioTrabajadorRepository repository, ProfesionRepository profesionRepository) {
        this.repository = repository;
        this.profesionRepository = profesionRepository;
    }

    public List<UsuarioTrabajador> getEntidades() {
        logger.info("Obteniendo todos los usuarios trabajadores");
        return repository.findAll();
    } // getEntidades

    public org.springframework.data.domain.Page<UsuarioTrabajador> getEntidadesPaginadas(int page, int size) {
        logger.info("Obteniendo trabajadores paginados: page={}, size={}", page, size);
        return repository.findAll(org.springframework.data.domain.PageRequest.of(page, size));
    } // getEntidadesPaginadas

    public UsuarioTrabajador getEntidad(Long id) {
        logger.info("Buscando usuario trabajador con id: {}", id);
        return repository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("El usuario-trabajador con el id [" + id + "] no existe"));
    } // getEntidad

    public UsuarioTrabajador crearEntidad(UsuarioTrabajador obj) {
        Optional<UsuarioTrabajador> usr = repository.findByEmail(obj.getEmail());

        if(usr.isEmpty()){
            obj.setContrasena(passwordEncoder.encode(obj.getContrasena()));
            repository.save(obj);
            logger.info("Usuario trabajador creado: {}", obj.getEmail());
        }else{
            logger.warn("Intento de crear usuario trabajador con email duplicado: {}", obj.getEmail());
            obj=null;
        }
        return obj;
    } // crearEntidad

    public UsuarioTrabajador deleteEntidad(Long id) {
        UsuarioTrabajador usr = null;
        if(repository.existsById(id)){
            usr = repository.findById(id).get();
            repository.deleteById(id);
            logger.info("Usuario trabajador eliminado: id={}", id);
        } else {
            logger.warn("Intento de eliminar usuario trabajador inexistente: id={}", id);
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
                if (dto.getDireccion() != null) {
                    t.setDireccion(dto.getDireccion());
                } // if
                if (dto.getLatitud() != null) {
                    t.setLatitud(dto.getLatitud());
                } // if
                if (dto.getLongitud() != null) {
                    t.setLongitud(dto.getLongitud());
                } // if

                trabajador = repository.save(t);
                logger.info("Usuario trabajador actualizado: id={}", id);

            } else {
                logger.warn("Intento de actualizar usuario trabajador inexistente: id={}", id);
            } // if

        return trabajador;
    } // actualizarEntidad

    /**
     * Busca trabajadores por profesión.
     */
    public List<UsuarioTrabajador> buscarPorProfesion(Long profesionId) {
        logger.info("Buscando trabajadores por profesión id={}", profesionId);
        return repository.findByProfesiones_Id(profesionId);
    }

    /**
     * Asigna una profesión a un trabajador.
     */
    public UsuarioTrabajador asignarProfesion(Long trabajadorId, Long profesionId) {
        UsuarioTrabajador trabajador = repository.findById(trabajadorId)
                .orElseThrow(() -> new RuntimeException("Usuario trabajador no encontrado con id: " + trabajadorId));
        Profesion profesion = profesionRepository.findById(profesionId)
                .orElseThrow(() -> new RuntimeException("Profesión no encontrada con id: " + profesionId));

        if (!trabajador.getProfesiones().contains(profesion)) {
            trabajador.getProfesiones().add(profesion);
            repository.save(trabajador);
            logger.info("Profesión id={} asignada a trabajador id={}", profesionId, trabajadorId);
        } else {
            logger.info("Profesión id={} ya estaba asignada a trabajador id={}", profesionId, trabajadorId);
        }
        return trabajador;
    }

    /**
     * Desasigna una profesión de un trabajador.
     */
    public UsuarioTrabajador desasignarProfesion(Long trabajadorId, Long profesionId) {
        UsuarioTrabajador trabajador = repository.findById(trabajadorId)
                .orElseThrow(() -> new RuntimeException("Usuario trabajador no encontrado con id: " + trabajadorId));
        Profesion profesion = profesionRepository.findById(profesionId)
                .orElseThrow(() -> new RuntimeException("Profesión no encontrada con id: " + profesionId));

        if (trabajador.getProfesiones().remove(profesion)) {
            repository.save(trabajador);
            logger.info("Profesión id={} desasignada de trabajador id={}", profesionId, trabajadorId);
        } else {
            logger.warn("Profesión id={} no estaba asignada a trabajador id={}", profesionId, trabajadorId);
        }
        return trabajador;
    }
} // class UsuarioTrabajadorService
