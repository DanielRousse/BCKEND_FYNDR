import './navBar.js';
import { renderInicioPage, initInicioPage } from './pages/inicio/inicio.js';
import { renderListaProductosPage } from './pages/lista-productos/listaProductos.js';
import { renderAcercaPage, initAcercaPage } from './pages/acerca-de-nosotros/acerca.js';
import { renderContactoPage, initContactoPage } from './pages/contacto/contacto.js';
import { renderLoginPage, initLoginPage } from './pages/login/login.js';
import { renderRegistroPage, initRegistroPage } from './pages/registro/registro.js';
import { renderRegistroUsuarioPage, initRegistroUsuarioPage } from './pages/registro/registroUsuario.js';
import { renderRegistroProfesionalPage } from './pages/registro-profesionales/registroProfesional.js';
import { renderCrearPublicacionPage, initCrearPublicacionPage } from './pages/crear-publicacion/crearPublicacion.js';

const mainContent = document.getElementById('main-content');

// Mapeo de rutas (hashes) a sus funciones coordinadoras de renderizado
const routes = {
    '#inicio': { render: renderInicioPage, init: initInicioPage },
    '#buscar': renderListaProductosPage,
    '#acerca': { render: renderAcercaPage, init: initAcercaPage },
    '#contacto': { render: renderContactoPage, init: initContactoPage },
    '#login': {render: renderLoginPage, init: initLoginPage },
    '#registro': { render: renderRegistroPage, init: initRegistroPage },
    '#registro-usuario': { render: renderRegistroUsuarioPage, init: initRegistroUsuarioPage },
    '#registro-profesional': renderRegistroProfesionalPage,
    '#crear-publicacion': { render: renderCrearPublicacionPage, init: initCrearPublicacionPage }
};

function router() {
    const hash = window.location.hash || '#inicio';
    
    
    const route = routes[hash];
    if (route) {
        if (typeof route === 'function') {
            mainContent.innerHTML = route();
        } else {
            mainContent.innerHTML = route.render();
            if (route.init) {
                route.init();
            }
        }
    } else {
        
        window.location.hash = '#inicio';
        return;
    }

    
    updateActiveNavLink(hash);

    
    closeNavbarOnMobile();
}

function updateActiveNavLink(currentHash) {
    const navLinks = document.querySelectorAll('.nav-link-custom, .btn-custom');
    navLinks.forEach(link => {
        const href = link.getAttribute('href');
        if (href === currentHash) {
            link.classList.add('active-nav-item');
        } else {
            link.classList.remove('active-nav-item');
        }
    });
}

function closeNavbarOnMobile() {
    const navbarCollapse = document.getElementById('navbarContent');
    if (navbarCollapse && navbarCollapse.classList.contains('show')) {
        
        if (window.bootstrap && window.bootstrap.Collapse) {
            const bsCollapse = window.bootstrap.Collapse.getInstance(navbarCollapse) || new window.bootstrap.Collapse(navbarCollapse);
            bsCollapse.hide();
        }
    }
}

// Escuchar cambios de ruta y carga inicial de la página
window.addEventListener('hashchange', router);
window.addEventListener('load', router);

