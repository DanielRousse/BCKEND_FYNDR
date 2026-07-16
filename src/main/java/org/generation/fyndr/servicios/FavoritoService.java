package org.generation.fyndr.servicios;

import org.generation.fyndr.modelos.UsuarioComun;
import org.generation.fyndr.modelos.UsuarioTrabajador;
import org.generation.fyndr.repositorios.UsuarioComunRepository;
import org.generation.fyndr.repositorios.UsuarioTrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritoService {

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
        }
    }
}
