package org.generation.fyndr.config;

import org.generation.fyndr.modelos.Profesion;
import org.generation.fyndr.modelos.UsuarioComun;
import org.generation.fyndr.modelos.UsuarioTrabajador;
import org.generation.fyndr.modelos.Publicacion;
import org.generation.fyndr.repositorios.ProfesionRepository;
import org.generation.fyndr.repositorios.UsuarioComunRepository;
import org.generation.fyndr.repositorios.UsuarioTrabajadorRepository;
import org.generation.fyndr.repositorios.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UsuarioComunRepository usuarioComunRepository;
    private final UsuarioTrabajadorRepository usuarioTrabajadorRepository;
    private final ProfesionRepository profesionRepository;
    private final PublicacionRepository publicacionRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DataInitializer(UsuarioComunRepository usuarioComunRepository,
                           UsuarioTrabajadorRepository usuarioTrabajadorRepository,
                           ProfesionRepository profesionRepository,
                           PublicacionRepository publicacionRepository,
                           PasswordEncoder passwordEncoder) {
        this.usuarioComunRepository = usuarioComunRepository;
        this.usuarioTrabajadorRepository = usuarioTrabajadorRepository;
        this.profesionRepository = profesionRepository;
        this.publicacionRepository = publicacionRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // Seeding Profesiones
        if (profesionRepository.count() == 0) {
            profesionRepository.save(new Profesion("Plomería"));
            profesionRepository.save(new Profesion("Electricidad"));
            profesionRepository.save(new Profesion("Carpintería"));
            profesionRepository.save(new Profesion("Limpieza"));
            profesionRepository.save(new Profesion("Pintura"));
            profesionRepository.save(new Profesion("Jardinería"));
        }

        // Seeding UsuarioComun (Clients)
        if (usuarioComunRepository.count() == 0) {
            UsuarioComun client1 = new UsuarioComun();
            client1.setNombre("Daniel Rousse");
            client1.setEmail("daniel@fyndr.com");
            client1.setTelefono("5512345678");
            client1.setContrasena(passwordEncoder.encode("Password123!"));
            client1.setFechaRegistro(LocalDateTime.now());
            usuarioComunRepository.save(client1);

            UsuarioComun client2 = new UsuarioComun();
            client2.setNombre("Jonathan Reyes");
            client2.setEmail("jonathan@fyndr.com");
            client2.setTelefono("5587654321");
            client2.setContrasena(passwordEncoder.encode("Password123!"));
            client2.setFechaRegistro(LocalDateTime.now());
            usuarioComunRepository.save(client2);
        }

        // Seeding UsuarioTrabajador (Professionals)
        if (usuarioTrabajadorRepository.count() == 0) {
            UsuarioTrabajador worker1 = new UsuarioTrabajador();
            worker1.setNombre("Juan Pérez");
            worker1.setEmail("juan.plomero@fyndr.com");
            worker1.setTelefono("5522334455");
            worker1.setContrasena(passwordEncoder.encode("Password123!"));
            worker1.setFechaNacimiento(LocalDate.of(1985, 5, 10));
            worker1.setExperienciaAnos(10);
            worker1.setDescripcion("Plomero verificado con más de 10 años de experiencia en reparación de fugas, boilers y tuberías.");
            worker1.setSubespecialidades("Plomería");
            worker1.setTarifaHora(BigDecimal.valueOf(250.0));
            worker1.setCalificacionPromedio(BigDecimal.valueOf(4.8));
            worker1.setDireccion("Centro, CDMX");
            UsuarioTrabajador savedWorker1 = usuarioTrabajadorRepository.save(worker1);

            UsuarioTrabajador worker2 = new UsuarioTrabajador();
            worker2.setNombre("Carlos Gómez");
            worker2.setEmail("carlos.electrico@fyndr.com");
            worker2.setTelefono("5566778899");
            worker2.setContrasena(passwordEncoder.encode("Password123!"));
            worker2.setFechaNacimiento(LocalDate.of(1990, 8, 15));
            worker2.setExperienciaAnos(7);
            worker2.setDescripcion("Electricista profesional con experiencia en instalaciones residenciales y comerciales.");
            worker2.setSubespecialidades("Electricidad");
            worker2.setTarifaHora(BigDecimal.valueOf(300.0));
            worker2.setCalificacionPromedio(BigDecimal.valueOf(4.9));
            worker2.setDireccion("Reforma, CDMX");
            UsuarioTrabajador savedWorker2 = usuarioTrabajadorRepository.save(worker2);

            // Seed some Publications
            if (publicacionRepository.count() == 0) {
                publicacionRepository.save(new Publicacion(
                        "Instalación de Calentadores",
                        "Ofrezco servicios profesionales de instalación y mantenimiento de boilers de gas y eléctricos.",
                        450.0,
                        LocalDateTime.now(),
                        savedWorker1
                ));

                publicacionRepository.save(new Publicacion(
                        "Reparación de Cortocircuitos",
                        "Diagnóstico rápido y reparación de fallas eléctricas, cortocircuitos y cambio de fusibles.",
                        500.0,
                        LocalDateTime.now(),
                        savedWorker2
                ));
            }
        }
    }
}
