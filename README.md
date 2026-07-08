# Fyndr Backend

Este repositorio contiene la estructura inicial del backend para el proyecto **Fyndr**, desarrollado en Java con Spring Boot y Gradle.

## Tecnologías Utilizadas

- **Java 21**
- **Spring Boot 4.1.0** (Web, JPA)
- **MySQL Connector** (para base de datos)
- **Gradle** (gestor de dependencias y construcción)

## Requisitos Previos

Asegúrate de tener instalado:
- **Java Development Kit (JDK) 21** o superior.

## Cómo Ejecutar el Proyecto

Para compilar y ejecutar el proyecto localmente, utiliza el Gradle Wrapper provisto.

### En Linux / macOS:
```bash
./gradlew bootRun
```

### En Windows:
```cmd
gradlew.bat bootRun
```

El servidor iniciará por defecto en el puerto `8080` (http://localhost:8080).

## Estructura del Proyecto

El proyecto está estructurado de la siguiente forma:
- `src/main/java/org/generation/fyndr`: Contiene el código fuente principal de la aplicación.
  - `FyndrApplication.java`: Clase principal y punto de entrada de Spring Boot.
- `src/main/resources`: Configuración del proyecto.
  - `application.properties`: Propiedades de configuración (base de datos, puertos, etc.).
- `src/test`: Pruebas unitarias e integración.
