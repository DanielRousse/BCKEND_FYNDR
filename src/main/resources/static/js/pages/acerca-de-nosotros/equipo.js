export function renderEquipo() {
    return `
        <!-- SECCIÓN EQUIPO -->
        <section class="equipo">
            <h2>Nuestro Equipo</h2>
            <p>Somos un equipo de personas apasionadas por la tecnología y por simplificar tu día a día.</p>

            <div class="contenedor-equipo" id="contenedor-equipo"></div>

            <div id="modal" class="modal">
                <div class="modal-contenido">
                    <span id="cerrar">&times;</span>
                    <img id="modal-foto" src="" alt="">
                    <h3 id="modal-nombre"></h3>
                    <h3 id="modal-puesto"></h3>
                    <p id="modal-descripcion"></p>
                </div>
            </div>
        </section>
    `;
}

const miembros = [
    {
        nombre: "Elisa Méndez Gómez",
        puesto: "Scrum Master & Lead Developer",
        foto: "assets/persona1.jpg",
        descripcion: "Desarrolladora Java Full Stack Jr., con conocimientos en desarrollo web, programación orientada a objetos con Java, bases de datos y desarrollo de aplicaciones utilizando Spring Boot. Experiencia en creación de soluciones web con JavaScript y fundamentos de desarrollo full stack. Con formación en negocios internacionales, análisis, comunicación y trabajo multidisciplinario. Capacidad para trabajar en equipo, aprender rápidamente y adaptarse a entornos tecnológicos dinámicos."
    },
    {
        nombre: "Jonathan Daniel Reyes Gordillo",
        puesto: "Product Owner & Backend Developer",
        foto: "assets/persona2.jpg",
        descripcion: "Ayudo a empresas y equipos tecnológicos a optimizar sus procesos y conectar sistemas complejos con entornos digitales mediante el desarrollo de software seguro y eficiente. Lo que más disfruto de mi trabajo es diseñar la arquitectura detrás de aplicaciones web, resolver problemas lógicos complejos y crear soluciones que funcionen a la perfección. Mi experiencia clave incluye la creación de sistemas de seguridad biométrica, gestión de datos especializados y modelado digital. Lo que realmente me apasiona es ver cómo el código cobra vida de manera inteligente para solucionar necesidades del mundo real."
    },
    {
        nombre: "Erick Alan González Mora",
        puesto: "Backend Developer",
        foto: "assets/persona3.jpg",
        descripcion: "Egresado de la licenciatura en Matemáticas por la UNAM, orienté mi carrera hacia el desarrollo y análisis computacional, participando en proyectos de automatización, bases de datos y desarrollo de software en instituciones como la UNAM, TCS, IDS e IMSS la mayoría de las experiencias son en el ámbito bancario. He trabajado con tecnologías como Java, Python, SQL, Oracle, HTML, CSS y JavaScript, destacando por la optimización de procesos y el trabajo colaborativo. Hobbies: Correr, natación ciclismo, música y la tecnología."
    },
    {
        nombre: "Alan Hernández Casimo",
        puesto: "Frontend Developer",
        foto: "assets/persona4.jpg",
        descripcion: "Ingeniero en Sistemas Computacionales enfocado en desarrollo Full Stack con experiencia en aplicaciones web y móviles utilizando tecnologías como React, Angular, Node.js y TypeScript. He participado en proyectos empresariales y hackathones desarrollando soluciones relacionadas con inteligencia artificial, automatización y gestión de información. Me caracterizo por el trabajo en equipo, aprendizaje constante y desarrollo de soluciones tecnológicas orientadas a resultados."
    },
    {
        nombre: "Xally Romina Ibañez Miranda",
        puesto: "Frontend Developer",
        foto: "assets/persona5.jpg",
        descripcion: "Desarrollador enfocado en el crecimiento profesional continuo y en la creación de aplicaciones eficientes. Cuento con experiencia práctica en el desarrollo de software, destacándome en tareas esenciales para el ciclo de vida del código como la limpieza, optimización y revisión meticulosa de textos y documentación técnica. Gracias a mi experiencia en operaciones y atención al cliente, poseo una gran capacidad para gestionar flujos de trabajo estructurados, resolver problemas con metodología y colaborar eficazmente en equipos multidisciplinarios orientados al sector IT."
    },
    {
        nombre: "Rodrigo Flores Novia",
        puesto: "Backend Developer",
        foto: "assets/persona6.jpg",
        descripcion: "Ingeniero Titulado en la Universidad Nacional Autónoma de México con enfoque en programación Full Stack utilizando Java, JavaScript y HTML. Cuento con conocimientos en desarrollo de software, SQL Server, Excel avanzado, macros y GitHub. He desarrollado proyectos aplicando programación orientada a objetos y automatización de procesos. Destaco por mi capacidad de aprendizaje, resolución de problemas y trabajo en equipo. Busco aportar soluciones tecnológicas eficientes y contribuir al crecimiento de la empresa mediante la mejora continua."
    }
];

export function initEquipo() {
    const contenedor = document.getElementById('contenedor-equipo');
    const modal = document.getElementById('modal');
    const cerrar = document.getElementById('cerrar');
    const modalFoto = document.getElementById('modal-foto');
    const modalNombre = document.getElementById('modal-nombre');
    const modalPuesto = document.getElementById('modal-puesto');
    const modalDescripcion = document.getElementById('modal-descripcion');

    if (!contenedor) return;

    // Limpiar para evitar duplicados en renderizaciones sucesivas
    contenedor.innerHTML = '';

    miembros.forEach(m => {
        const tarjeta = document.createElement('div');
        tarjeta.classList.add('miembro');
        tarjeta.innerHTML = `
            <img src="${m.foto}" alt="${m.nombre}">
            <h3>${m.nombre}</h3>
            <p>${m.puesto}</p>
            <button class="btn-ver-mas">Ver más</button>
        `;
        tarjeta.addEventListener('click', () => {
            modalFoto.src = m.foto;
            modalNombre.textContent = m.nombre;
            modalPuesto.textContent = m.puesto;
            modalDescripcion.textContent = m.descripcion;
            modal.style.display = 'flex';
        });
        contenedor.appendChild(tarjeta);
    });

    if (cerrar) {
        cerrar.addEventListener('click', () => {
            modal.style.display = 'none';
        });
    }

    if (modal) {
        modal.addEventListener('click', (e) => {
            if (e.target === modal) modal.style.display = 'none';
        });
    }
}