CREATE DATABASE fyndr_db;
USE fyndr_db;

CREATE TABLE usuario_comun (
    id_usuario_comun INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefono VARCHAR(15) NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE usuario_trabajador (
    id_usuario_trabajador INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefono VARCHAR(15) NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    fecha_nacimiento DATE,
    ine_path VARCHAR(255),
    curp VARCHAR(18) UNIQUE,
    fotografia_path VARCHAR(255),
    comprobante_path VARCHAR(255),
    antecedentes_path VARCHAR(255),
    experiencia_anos INT DEFAULT 0,
    descripcion TEXT,
    subespecialidades VARCHAR(255),
    certificaciones_path VARCHAR(255),
    portafolio_path VARCHAR(255),
    rfc VARCHAR(13) UNIQUE,
    constancia_fiscal_path VARCHAR(255),
    clabe VARCHAR(18),
    banco VARCHAR(50),
    tarifa_hora DECIMAL(10, 2),
    calificacion_promedio DECIMAL(3, 2) DEFAULT 5.00,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE profesiones (
    id_profesion INT AUTO_INCREMENT PRIMARY KEY,
    nombre_profesion VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE publicaciones (
    id_publicacion INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    descripcion TEXT NOT NULL,
    precio DECIMAL(10, 2),
    fecha_publicacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    id_usuario_trabajador INT NOT NULL,
    FOREIGN KEY (id_usuario_trabajador) REFERENCES usuario_trabajador(id_usuario_trabajador) ON DELETE CASCADE
);

CREATE TABLE contrataciones (
    id_contratacion INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario_comun INT NOT NULL,
    id_usuario_trabajador INT NOT NULL,
    fecha_contratacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(20) DEFAULT 'Pendiente',
    FOREIGN KEY (id_usuario_comun) REFERENCES usuario_comun(id_usuario_comun) ON DELETE CASCADE,
    FOREIGN KEY (id_usuario_trabajador) REFERENCES usuario_trabajador(id_usuario_trabajador) ON DELETE CASCADE
);

CREATE TABLE trabajador_profesion (
    id_usuario_trabajador INT NOT NULL,
    id_profesion INT NOT NULL,
    PRIMARY KEY (id_usuario_trabajador, id_profesion),
    FOREIGN KEY (id_usuario_trabajador) REFERENCES usuario_trabajador(id_usuario_trabajador) ON DELETE CASCADE,
    FOREIGN KEY (id_profesion) REFERENCES profesiones(id_profesion) ON DELETE CASCADE
);

CREATE TABLE resenas (
    id_resena INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario_comun INT NOT NULL,
    id_usuario_trabajador INT NOT NULL,
    calificacion INT,
    comentario TEXT,
    fecha_resena TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_usuario_comun) REFERENCES usuario_comun(id_usuario_comun) ON DELETE CASCADE,
    FOREIGN KEY (id_usuario_trabajador) REFERENCES usuario_trabajador(id_usuario_trabajador) ON DELETE CASCADE
);

CREATE TABLE mensajes (
    id_mensaje INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario_comun INT NOT NULL,
    id_usuario_trabajador INT NOT NULL,
    remitente VARCHAR(20),
    contenido TEXT NOT NULL,
    fecha_envio TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_usuario_comun) REFERENCES usuario_comun(id_usuario_comun) ON DELETE CASCADE,
    FOREIGN KEY (id_usuario_trabajador) REFERENCES usuario_trabajador(id_usuario_trabajador) ON DELETE CASCADE
);

CREATE TABLE favoritos (
    id_usuario_comun INT NOT NULL,
    id_usuario_trabajador INT NOT NULL,
    PRIMARY KEY (id_usuario_comun, id_usuario_trabajador),
    FOREIGN KEY (id_usuario_comun) REFERENCES usuario_comun(id_usuario_comun) ON DELETE CASCADE,
    FOREIGN KEY (id_usuario_trabajador) REFERENCES usuario_trabajador(id_usuario_trabajador) ON DELETE CASCADE
);
