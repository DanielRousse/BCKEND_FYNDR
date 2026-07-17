package org.generation.fyndr.servicios;

import org.generation.fyndr.dto.MensajeDTO;
import org.generation.fyndr.dto.MensajeResponseDTO;
import org.generation.fyndr.modelos.Mensaje;
import org.generation.fyndr.modelos.UsuarioComun;
import org.generation.fyndr.modelos.UsuarioTrabajador;
import org.generation.fyndr.repositorios.MensajeRepository;
import org.generation.fyndr.repositorios.UsuarioComunRepository;
import org.generation.fyndr.repositorios.UsuarioTrabajadorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MensajeService {

    private static final Logger logger = LoggerFactory.getLogger(MensajeService.class);
    private final MensajeRepository mensajeRepository;
    private final UsuarioComunRepository usuarioComunRepository;
    private final UsuarioTrabajadorRepository usuarioTrabajadorRepository;

    @Autowired
    public MensajeService(MensajeRepository mensajeRepository,
                          UsuarioComunRepository usuarioComunRepository,
                          UsuarioTrabajadorRepository usuarioTrabajadorRepository) {
        this.mensajeRepository = mensajeRepository;
        this.usuarioComunRepository = usuarioComunRepository;
        this.usuarioTrabajadorRepository = usuarioTrabajadorRepository;
    }

    public MensajeResponseDTO crearMensaje(MensajeDTO dto) {
        UsuarioComun uc = usuarioComunRepository.findById(dto.getIdUsuarioComun())
                .orElseThrow(() -> new RuntimeException("Usuario común no encontrado"));
        UsuarioTrabajador ut = usuarioTrabajadorRepository.findById(dto.getIdUsuarioTrabajador())
                .orElseThrow(() -> new RuntimeException("Usuario trabajador no encontrado"));

        Mensaje mensaje = new Mensaje(uc, ut, dto.getRemitente(), dto.getContenido(), dto.getFechaEnvio());
        Mensaje saved = mensajeRepository.save(mensaje);
        logger.info("Mensaje creado: id={}, de {} para {}", saved.getId(), uc.getId(), ut.getId());
        return convertToResponseDTO(saved);
    }

    public List<MensajeResponseDTO> todosLosMensajes() {
        return mensajeRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public MensajeResponseDTO mensajesPorId(Long id) {
        Mensaje m = mensajeRepository.findById(id).orElse(null);
        return m != null ? convertToResponseDTO(m) : null;
    }

    public List<MensajeResponseDTO> mensajesPorUsuarioComun(Long idUsuarioComun) {
        return mensajeRepository.findByUsuarioComunId(idUsuarioComun).stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public List<MensajeResponseDTO> mensajesPorUsuarioTrabajador(Long idUsuarioTrabajador) {
        return mensajeRepository.findByUsuarioTrabajadorId(idUsuarioTrabajador).stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public List<MensajeResponseDTO> obtenerConversacion(Long idUsuarioComun, Long idUsuarioTrabajador) {
        return mensajeRepository.findConversation(idUsuarioComun, idUsuarioTrabajador).stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public void eliminarMensaje(Long id) {
        mensajeRepository.deleteById(id);
    }

    public MensajeResponseDTO actualizarMensaje(Long id, MensajeDTO dto) {
        Mensaje mensaje = mensajeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mensaje no encontrado con id: " + id));

        if (dto.getIdUsuarioComun() != null) {
            UsuarioComun uc = usuarioComunRepository.findById(dto.getIdUsuarioComun())
                    .orElseThrow(() -> new RuntimeException("Usuario común no encontrado"));
            mensaje.setUsuarioComun(uc);
        }
        if (dto.getIdUsuarioTrabajador() != null) {
            UsuarioTrabajador ut = usuarioTrabajadorRepository.findById(dto.getIdUsuarioTrabajador())
                    .orElseThrow(() -> new RuntimeException("Usuario trabajador no encontrado"));
            mensaje.setUsuarioTrabajador(ut);
        }
        if (dto.getRemitente() != null) mensaje.setRemitente(dto.getRemitente());
        if (dto.getContenido() != null) mensaje.setContenido(dto.getContenido());
        if (dto.getFechaEnvio() != null) mensaje.setFechaEnvio(dto.getFechaEnvio());

        Mensaje updated = mensajeRepository.save(mensaje);
        return convertToResponseDTO(updated);
    }

    private MensajeResponseDTO convertToResponseDTO(Mensaje m) {
        return new MensajeResponseDTO(
                m.getId(),
                m.getUsuarioComun().getId(),
                m.getUsuarioComun().getNombre(),
                m.getUsuarioTrabajador().getId(),
                m.getUsuarioTrabajador().getNombre(),
                m.getRemitente(),
                m.getContenido(),
                m.getFechaEnvio()
        );
    }
}