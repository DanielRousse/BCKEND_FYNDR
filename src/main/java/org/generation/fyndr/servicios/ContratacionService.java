package org.generation.fyndr.servicios;

import org.generation.fyndr.dto.ContratacionDTO;
import org.generation.fyndr.dto.ContratacionResponseDTO;
import org.generation.fyndr.modelos.Contratacion;
import org.generation.fyndr.modelos.UsuarioComun;
import org.generation.fyndr.modelos.UsuarioTrabajador;
import org.generation.fyndr.repositorios.ContratacionRepository;
import org.generation.fyndr.repositorios.UsuarioComunRepository;
import org.generation.fyndr.repositorios.UsuarioTrabajadorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContratacionService {

    private static final Logger logger = LoggerFactory.getLogger(ContratacionService.class);
    private final ContratacionRepository contratacionRepository;
    private final UsuarioComunRepository usuarioComunRepository;
    private final UsuarioTrabajadorRepository usuarioTrabajadorRepository;

    @Autowired
    public ContratacionService(ContratacionRepository contratacionRepository,
                               UsuarioComunRepository usuarioComunRepository,
                               UsuarioTrabajadorRepository usuarioTrabajadorRepository) {
        this.contratacionRepository = contratacionRepository;
        this.usuarioComunRepository = usuarioComunRepository;
        this.usuarioTrabajadorRepository = usuarioTrabajadorRepository;
    }

    public List<ContratacionResponseDTO> getEntidades() {
        return contratacionRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public ContratacionResponseDTO getEntidad(Long id) {
        Contratacion c = contratacionRepository.findById(id).orElse(null);
        return c != null ? convertToResponseDTO(c) : null;
    }

    public ContratacionResponseDTO crearEntidad(ContratacionDTO dto) {
        UsuarioComun uc = usuarioComunRepository.findById(dto.getIdUsuarioComun())
                .orElseThrow(() -> new RuntimeException("Usuario común no encontrado"));
        UsuarioTrabajador ut = usuarioTrabajadorRepository.findById(dto.getIdUsuarioTrabajador())
                .orElseThrow(() -> new RuntimeException("Usuario trabajador no encontrado"));

        Contratacion c = new Contratacion(uc, ut, dto.getFechaContratacion(), dto.getEstado());
        Contratacion saved = contratacionRepository.save(c);
        logger.info("Contratación creada: id={}, usuario={}, trabajador={}", saved.getId(), uc.getId(), ut.getId());
        return convertToResponseDTO(saved);
    }

    public ContratacionResponseDTO deleteEntidad(Long id) {
        Contratacion c = contratacionRepository.findById(id).orElse(null);
        if (c != null) {
            contratacionRepository.deleteById(id);
            return convertToResponseDTO(c);
        }
        return null;
    }

    public ContratacionResponseDTO actualizarEntidad(Long id, ContratacionDTO dto) {
        Contratacion c = contratacionRepository.findById(id).orElse(null);
        if (c != null) {
            if (dto.getIdUsuarioComun() != null) {
                UsuarioComun uc = usuarioComunRepository.findById(dto.getIdUsuarioComun())
                        .orElseThrow(() -> new RuntimeException("Usuario común no encontrado"));
                c.setUsuarioComun(uc);
            }
            if (dto.getIdUsuarioTrabajador() != null) {
                UsuarioTrabajador ut = usuarioTrabajadorRepository.findById(dto.getIdUsuarioTrabajador())
                        .orElseThrow(() -> new RuntimeException("Usuario trabajador no encontrado"));
                c.setUsuarioTrabajador(ut);
            }
            if (dto.getEstado() != null) c.setEstado(dto.getEstado());
            if (dto.getFechaContratacion() != null) c.setFechaContratacion(dto.getFechaContratacion());
            
            Contratacion updated = contratacionRepository.save(c);
            return convertToResponseDTO(updated);
        }
        return null;
    }

    public List<ContratacionResponseDTO> getContratacionesPorUsuario(Long idUsuarioComun) {
        return contratacionRepository.findByUsuarioComunId(idUsuarioComun).stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public List<ContratacionResponseDTO> getContratacionesPorTrabajador(Long idUsuarioTrabajador) {
        return contratacionRepository.findByUsuarioTrabajadorId(idUsuarioTrabajador).stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    private ContratacionResponseDTO convertToResponseDTO(Contratacion c) {
        return new ContratacionResponseDTO(
                c.getId(),
                c.getUsuarioComun().getId(),
                c.getUsuarioComun().getNombre(),
                c.getUsuarioTrabajador().getId(),
                c.getUsuarioTrabajador().getNombre(),
                c.getFechaContratacion(),
                c.getEstado()
        );
    }
}
