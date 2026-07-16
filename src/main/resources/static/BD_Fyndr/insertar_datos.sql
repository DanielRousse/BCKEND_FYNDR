USE fyndr_db;

INSERT INTO usuario_comun (nombre, email, telefono, contrasena) VALUES
('Juan Pérez', 'juan.perez@example.com', '5512345678', 'perez123'),
('María López', 'maria.lopez@example.com', '5523456789', 'lopez456'),
('Carlos Gómez', 'carlos.gomez@example.com', '5534567890', 'gomez789'),
('Ana Martínez', 'ana.martinez@example.com', '5545678901', 'martinez123'),
('Luis Rodríguez', 'luis.rodriguez@example.com', '5556789012', 'rodriguez456');

INSERT INTO usuario_trabajador (nombre, email, telefono, contrasena, fecha_nacimiento, ine_path, curp, fotografia_path, comprobante_path, antecedentes_path, experiencia_anos, descripcion, subespecialidades, certificaciones_path, portafolio_path, rfc, constancia_fiscal_path, clabe, banco, tarifa_hora, calificacion_promedio) VALUES
('José Hernández', 'jose.hernandez@example.com', '5567890123', 'jose123', '1985-04-12', 'uploads/ine_jose.png', 'HERJ850412HDFXXS01', 'uploads/foto_jose.png', 'uploads/comp_jose.png', 'uploads/ant_jose.pdf', 8, 'Plomero certificado experto en fugas y griferías residenciales.', 'Reparaciones, Instalaciones', 'uploads/cert_jose.pdf', 'uploads/port_jose.pdf', 'HERJ850412XX1', 'uploads/const_jose.pdf', '012180012345678901', 'BBVA', 150.00, 4.80),
('Lucía Díaz', 'lucia.diaz@example.com', '5578901234', 'lucia456', '1990-09-22', 'uploads/ine_lucia.png', 'DIAL900922MDFXXS02', 'uploads/foto_lucia.png', 'uploads/comp_lucia.png', 'uploads/ant_lucia.pdf', 5, 'Electricista certificada con amplia experiencia en mantenimiento industrial y residencial.', 'Mantenimiento, Instalaciones', 'uploads/cert_lucia.pdf', 'uploads/port_lucia.pdf', 'DIAL900922XX2', 'uploads/const_lucia.pdf', '012180012345678902', 'Banamex', 180.00, 4.90),
('Miguel Torres', 'miguel.torres@example.com', '5589012345', 'miguel789', '1978-12-05', 'uploads/ine_miguel.png', 'TOOM781205HDFXXS03', 'uploads/foto_miguel.png', 'uploads/comp_miguel.png', 'uploads/ant_miguel.pdf', 15, 'Carpintero ebanista. Diseño e instalación de cocinas integrales y clósets a medida.', 'Instalaciones, Reparaciones', 'uploads/cert_miguel.pdf', 'uploads/port_miguel.pdf', 'TOOM781205XX3', 'uploads/const_miguel.pdf', '012180012345678903', 'Santander', 200.00, 4.70),
('Elena Ruiz', 'elena.ruiz@example.com', '5590123456', 'elena123', '1993-02-18', 'uploads/ine_elena.png', 'RUIE930218MDFXXS04', 'uploads/foto_elena.png', 'uploads/comp_elena.png', 'uploads/ant_elena.pdf', 3, 'Servicios profesionales de limpieza profunda y sanitización residencial.', 'Mantenimiento, Emergencias', 'uploads/cert_elena.pdf', 'uploads/port_elena.pdf', 'RUIE930218XX4', 'uploads/const_elena.pdf', '012180012345678904', 'Banorte', 120.00, 4.50),
('Pedro Sánchez', 'pedro.sanchez@example.com', '5501234567', 'pedro456', '1988-07-30', 'uploads/ine_pedro.png', 'SACP880730HDFXXS05', 'uploads/foto_pedro.png', 'uploads/comp_pedro.png', 'uploads/ant_pedro.pdf', 10, 'Pintor profesional de fachadas, interiores y trabajos en alturas. Impermeabilización.', 'Reparaciones, Mantenimiento', 'uploads/cert_pedro.pdf', 'uploads/port_pedro.pdf', 'SACP880730XX5', 'uploads/const_pedro.pdf', '012180012345678905', 'HSBC', 160.00, 4.60);

INSERT INTO profesiones (nombre_profesion) VALUES
('Plomeria'),
('Albañileria'),
('Electricista'),
('Carpinteria'),
('Limpieza'),
('Pintura'),
('Jardineria');

INSERT INTO publicaciones (titulo, descripcion, precio, id_usuario_trabajador) VALUES
('Servicios de Plomería Profesional', 'Reparación de fugas, tuberías y sanitarios en general.', 350.00, 1),
('Instalaciones Eléctricas Residenciales', 'Cableado completo, tableros y mantenimiento correctivo.', 500.00, 2),
('Fabricación de Muebles de Madera', 'Carpintería fina y reparación de mobiliario a medida.', 1200.00, 3),
('Limpieza Profunda de Casas y Oficinas', 'Servicio integral con productos biodegradables.', 250.00, 4),
('Pintura de Fachadas e Interiores', 'Acabados profesionales y aplicación de impermeabilizantes.', 800.00, 5);

INSERT INTO contrataciones (id_usuario_comun, id_usuario_trabajador, estado) VALUES
(1, 1, 'Completada'),
(2, 2, 'En Proceso'),
(3, 3, 'Pendiente'),
(4, 4, 'Completada'),
(5, 5, 'Cancelada');

INSERT INTO trabajador_profesion (id_usuario_trabajador, id_profesion) VALUES
(1, 1),
(2, 3),
(3, 4),
(4, 5),
(5, 6);

INSERT INTO resenas (id_usuario_comun, id_usuario_trabajador, calificacion, comentario) VALUES
(1, 1, 5, 'Excelente trabajo de plomería, rápido y muy educado.'),
(2, 2, 5, 'Instalación impecable y segura. Muy recomendada.'),
(3, 3, 4, 'El clóset quedó muy bien armado, solo tardó un día más.'),
(4, 4, 4, 'Limpieza profunda de buena calidad, muy puntual.'),
(5, 5, 5, 'Pintó toda la sala rápido y no dejó manchas.');

INSERT INTO mensajes (id_usuario_comun, id_usuario_trabajador, remitente, contenido) VALUES
(1, 1, 'comun', 'Hola, buenas tardes. ¿Tiene disponibilidad para mañana?'),
(1, 1, 'trabajador', 'Hola, sí, tengo libre a partir de las 2:00 pm.'),
(2, 2, 'comun', '¿Cuál es el costo por instalar un interruptor doble?'),
(3, 3, 'comun', 'Hola, ¿podría cotizarme un mueble para televisión?'),
(4, 4, 'trabajador', 'Ya terminé el servicio de limpieza, espero su confirmación.');

INSERT INTO favoritos (id_usuario_comun, id_usuario_trabajador) VALUES
(1, 1),
(1, 2),
(2, 2),
(3, 3),
(4, 4);
