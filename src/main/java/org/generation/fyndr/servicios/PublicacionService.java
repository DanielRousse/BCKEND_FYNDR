package org.generation.fyndr.servicios;

import org.generation.fyndr.dto.PublicacionDTO;
import org.generation.fyndr.dto.PublicacionResponseDTO;
import org.generation.fyndr.modelos.Publicacion;
import org.generation.fyndr.modelos.UsuarioTrabajador;
import org.generation.fyndr.repositorios.PublicacionRepository;
import org.generation.fyndr.repositorios.UsuarioTrabajadorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicacionService {

    private static final Logger logger = LoggerFactory.getLogger(PublicacionService.class);
    private final PublicacionRepository publicacionRepository;
    private final UsuarioTrabajadorRepository usuarioTrabajadorRepository;

    @Autowired
    public PublicacionService(PublicacionRepository publicacionRepository,
                              UsuarioTrabajadorRepository usuarioTrabajadorRepository) {
        this.publicacionRepository = publicacionRepository;
        this.usuarioTrabajadorRepository = usuarioTrabajadorRepository;
    } // PublicacionService

    public List<PublicacionResponseDTO> getEntidades() {
        return publicacionRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    } // getEntidades

    public org.springframework.data.domain.Page<PublicacionResponseDTO> getEntidadesPaginadas(int page, int size) {
        return publicacionRepository.findAll(org.springframework.data.domain.PageRequest.of(page, size))
                .map(this::convertToResponseDTO);
    } // getEntidadesPaginadas

    public PublicacionResponseDTO getEntidad(Long id) {
        Publicacion p = publicacionRepository.findById(id).orElse(null);
        return p != null ? convertToResponseDTO(p) : null;
    } // getEntidad

    public PublicacionResponseDTO crearEntidad(PublicacionDTO dto) {
        UsuarioTrabajador ut = usuarioTrabajadorRepository.findById(dto.getIdUsuarioTrabajador())
                .orElseThrow(() -> new RuntimeException("Usuario trabajador no encontrado"));

        Publicacion p = new Publicacion();
        p.setTitulo(dto.getTitulo());
        p.setDescripcion(dto.getDescripcion());
        p.setPrecio(dto.getPrecio());
        p.setFechaPublicacion(dto.getFechaPublicacion() != null ? dto.getFechaPublicacion() : LocalDateTime.now());
        p.setUsuarioTrabajador(ut);
        p.setImagenPath(dto.getImagenPath());

        Publicacion saved = publicacionRepository.save(p);
        logger.info("Publicación creada: id={}, título='{}', trabajadorId={}", saved.getId(), saved.getTitulo(), ut.getId());
        return convertToResponseDTO(saved);
    } // crearEntidad

    public PublicacionResponseDTO deleteEntidad(Long id) {
        Publicacion p = publicacionRepository.findById(id).orElse(null);
        if (p != null) {
            publicacionRepository.deleteById(id);
            logger.info("Publicación eliminada: id={}", id);
            return convertToResponseDTO(p);
        }
        logger.warn("Intento de eliminar publicación inexistente: id={}", id);
        return null;
    } // deleteEntidad

    public PublicacionResponseDTO actualizarEntidad(Long id, PublicacionDTO dto) {
        Publicacion p = publicacionRepository.findById(id).orElse(null);
        if (p != null) {
            if (dto.getTitulo() != null) p.setTitulo(dto.getTitulo());
            if (dto.getDescripcion() != null) p.setDescripcion(dto.getDescripcion());
            if (dto.getPrecio() != null) p.setPrecio(dto.getPrecio());
            if (dto.getIdUsuarioTrabajador() != null) {
                UsuarioTrabajador ut = usuarioTrabajadorRepository.findById(dto.getIdUsuarioTrabajador())
                        .orElseThrow(() -> new RuntimeException("Usuario trabajador no encontrado"));
                p.setUsuarioTrabajador(ut);
            }
            if (dto.getFechaPublicacion() != null) p.setFechaPublicacion(dto.getFechaPublicacion());
            if (dto.getImagenPath() != null) p.setImagenPath(dto.getImagenPath());
            
            Publicacion updated = publicacionRepository.save(p);
            return convertToResponseDTO(updated);
        } // if
        return null;
    } // actualizarEntidad

    public List<PublicacionResponseDTO> getPublicacionesPorTrabajador(Long idUsuarioTrabajador) {
        return publicacionRepository.findByUsuarioTrabajadorId(idUsuarioTrabajador).stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    private PublicacionResponseDTO convertToResponseDTO(Publicacion p) {
        return new PublicacionResponseDTO(
                p.getId(),
                p.getTitulo(),
                p.getDescripcion(),
                p.getPrecio(),
                p.getFechaPublicacion(),
                p.getUsuarioTrabajador().getId(),
                p.getUsuarioTrabajador().getNombre(),
                p.getImagenPath()
        );
    }
}
