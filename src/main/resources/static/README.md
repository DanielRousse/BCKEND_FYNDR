# FYNDR - Expertos para cada necesidad del hogar

Bienvenidos a **FYNDR**, la plataforma digital que hemos diseñado para transformar la manera en que conectamos a las personas con profesionales de confianza para el cuidado y mantenimiento del hogar. Nuestro propósito final es brindar seguridad, accesibilidad y eficiencia tanto a clientes como a proveedores de servicios técnicos en una única y fluida experiencia web.

---

## 🌟 ¿Qué es FYNDR?

**FYNDR** es una aplicación web interactiva (Single Page Application - SPA) que actúa como un puente directo entre dos tipos de usuarios:
1. **Clientes (Usuarios Comunes):** Personas que buscan solucionar necesidades específicas del hogar (plomería, electricidad, limpieza, jardinería, etc.) a través de profesionales de confianza.
2. **Profesionales (Trabajadores):** Especialistas capacitados que ofrecen sus servicios, administran sus tarifas, publican anuncios y construyen su reputación de forma autónoma.

---

## ⚙️ Características Clave del Producto

### 1. Registro Seguro y Verificación de Profesionales
Para garantizar la máxima seguridad en los hogares de nuestros clientes, implementamos un proceso de onboarding de 4 pasos para los profesionales, que requiere:
*   **Identificación Oficial:** Carga de INE y CURP.
*   **Seguridad:** Verificación de antecedentes no penales.
*   **Perfil de Especialidad:** Carga de certificaciones, experiencia en años y portafolio de trabajos previos.
*   **Datos de Facturación y Pago:** RFC, constancia fiscal, Clave Interbancaria (CLABE) y banco receptor.

### 2. Búsqueda Inteligente de Servicios
Nuestros clientes pueden explorar un completo catálogo de servicios clasificados por categorías esenciales del hogar:
*   🔧 Plomería
*   🏗️ Albañilería
*   ⚡ Electricidad
*   🪚 Carpintería
*   🧹 Limpieza
*   🎨 Pintura
*   🌱 Jardinería

### 3. Sistema de Publicaciones Dinámicas
Los profesionales pueden crear, editar y gestionar sus propios anuncios de servicios, especificando descripciones detalladas, subespecialidades y tarifas personalizadas por hora.

### 4. Gestión de Contrataciones e Historial
Nuestra plataforma permite agendar, rechazar o confirmar contrataciones de manera transparente, manteniendo un control del estado del servicio (*Pendiente, En Proceso, Completado, Cancelado*).

### 5. Reseñas y Calificaciones Reales
Los clientes pueden calificar y dejar comentarios escritos sobre el desempeño de los profesionales, construyendo un sistema de reputación confiable basado en estrellas.

### 6. Mensajería Directa
Integramos un chat seguro para la negociación de tarifas, aclaración de dudas y seguimiento del servicio contratado.

### 7. Formulario de Soporte y Contacto
Mediante la integración directa con **EmailJS**, facilitamos a los usuarios enviar correos electrónicos al equipo de soporte directamente desde la aplicación sin necesidad de intermediarios.

---

## 🛠️ Stack Tecnológico

Hemos construido **FYNDR** utilizando tecnologías modernas y ligeras para asegurar una carga ultrarrápida y una experiencia de usuario responsiva (adaptada a móviles y computadoras):

*   **Estructura:** HTML5 Semántico.
*   **Diseño y Estilos:** CSS3 personalizado y **Bootstrap 5** (v5.3.3) para un diseño responsivo y moderno.
*   **Interactividad:** Javascript Vanilla de última generación (módulos ES6) y **SweetAlert2** para alertas interactivas.
*   **Base de Datos Relacional:** **MySQL** para almacenar la información de manera estructurada y segura.
*   **Enrutador Virtual:** Un Router en Javascript para gestionar el cambio de páginas de forma asíncrona mediante URLs con hashes (`#inicio`, `#buscar`, etc.).

---

## 🗄️ Estructura y Scripts de la Base de Datos (`BD_Fyndr`)

En la carpeta [BD_Fyndr](./BD_Fyndr) se encuentran los scripts SQL listos para levantar nuestro entorno de datos relacional:

1.  **[crear_tablas.sql](./BD_Fyndr/crear_tablas.sql):** Contiene la arquitectura lógica del sistema, incluyendo las siguientes tablas principales:
    *   `usuario_comun`: Datos de los clientes.
    *   `usuario_trabajador`: Información detallada, documentos de verificación y datos bancarios del profesional.
    *   `profesiones`: Catálogo oficial de oficios.
    *   `publicaciones`: Anuncios y servicios ofrecidos.
    *   `contrataciones`: Vínculos contractuales y estados del trabajo.
    *   `resenas`: Puntuación de calidad.
    *   `mensajes`: Mensajería interna del chat.
    *   `favoritos`: Lista de profesionales destacados por cliente.
2.  **[insertar_datos.sql](./BD_Fyndr/insertar_datos.sql):** Inserta datos iniciales de prueba y semillas (seeders) para visualizar el funcionamiento de la plataforma de inmediato.
3.  **[seguridad_dcl.sql](./BD_Fyndr/seguridad_dcl.sql):** Define y gestiona los privilegios de los usuarios administradores y de aplicación de base de datos para asegurar el principio de menor privilegio en producción.

---

## 👥 Nuestros Valores y Filosofía

En **FYNDR** nos regimos bajo cuatro pilares indispensables:
*   **Confianza:** Validamos detalladamente la información laboral y penal de cada trabajador antes de permitirle registrarse.
*   **Compromiso:** Diseñamos una experiencia agradable para clientes y un canal rentable para trabajadores.
*   **Transparencia:** Sin cargos ocultos, tarifas claras e información directa en cada interacción.
*   **Respeto:** Protegemos la privacidad de tu información y valoramos el tiempo dedicado a cada servicio de hogar.

---

*Desarrollado con pasión para brindar soluciones seguras al hogar.* 🏠✨

