package org.generation.fyndr.servicios;

import org.generation.fyndr.modelos.UsuarioComun;
import org.generation.fyndr.modelos.UsuarioTrabajador;
import org.generation.fyndr.repositorios.UsuarioComunRepository;
import org.generation.fyndr.repositorios.UsuarioTrabajadorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritoService {

    private static final Logger logger = LoggerFactory.getLogger(FavoritoService.class);
    private final UsuarioComunRepository usuarioComunRepository;
    private final UsuarioTrabajadorRepository usuarioTrabajadorRepository;

    @Autowired
    public FavoritoService(UsuarioComunRepository usuarioComunRepository,
                           UsuarioTrabajadorRepository usuarioTrabajadorRepository) {
        this.usuarioComunRepository = usuarioComunRepository;
        this.usuarioTrabajadorRepository = usuarioTrabajadorRepository;
    }

    public List<UsuarioTrabajador> obtenerFavoritos(Long idUsuarioComun) {
        UsuarioComun uc = usuarioComunRepository.findById(idUsuarioComun)
                .orElseThrow(() -> new RuntimeException("Usuario común no encontrado"));
        return uc.getFavoritos();
    }

    public void agregarFavorito(Long idUsuarioComun, Long idUsuarioTrabajador) {
        UsuarioComun uc = usuarioComunRepository.findById(idUsuarioComun)
                .orElseThrow(() -> new RuntimeException("Usuario común no encontrado"));
        UsuarioTrabajador ut = usuarioTrabajadorRepository.findById(idUsuarioTrabajador)
                .orElseThrow(() -> new RuntimeException("Usuario trabajador no encontrado"));

        if (!uc.getFavoritos().contains(ut)) {
            uc.getFavoritos().add(ut);
            usuarioComunRepository.save(uc);
            logger.info("Trabajador id={} agregado a favoritos de usuario común id={}", idUsuarioTrabajador, idUsuarioComun);
        }
    }

    public void eliminarFavorito(Long idUsuarioComun, Long idUsuarioTrabajador) {
        UsuarioComun uc = usuarioComunRepository.findById(idUsuarioComun)
                .orElseThrow(() -> new RuntimeException("Usuario común no encontrado"));
        UsuarioTrabajador ut = usuarioTrabajadorRepository.findById(idUsuarioTrabajador)
                .orElseThrow(() -> new RuntimeException("Usuario trabajador no encontrado"));

        if (uc.getFavoritos().contains(ut)) {
            uc.getFavoritos().remove(ut);
            usuarioComunRepository.save(uc);
            logger.info("Trabajador id={} eliminado de favoritos de usuario común id={}", idUsuarioTrabajador, idUsuarioComun);
        }
    }
}
