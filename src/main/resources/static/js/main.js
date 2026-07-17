import './navBar.js';
import { renderInicioPage, initInicioPage } from './pages/inicio/inicio.js';
import { renderListaProductosPage, initListaProductosPage } from './pages/lista-productos/listaProductos.js';
import { renderAcercaPage, initAcercaPage } from './pages/acerca-de-nosotros/acerca.js';
import { renderContactoPage, initContactoPage } from './pages/contacto/contacto.js';
import { renderLoginPage, initLoginPage } from './pages/login/login.js';
import { renderRegistroPage, initRegistroPage } from './pages/registro/registro.js';
import { renderRegistroUsuarioPage, initRegistroUsuarioPage } from './pages/registro/registroUsuario.js';
import { renderRegistroProfesionalPage, initRegistroProfesionalPage } from './pages/registro-profesionales/registroProfesional.js';
import { renderCrearPublicacionPage, initCrearPublicacionPage } from './pages/crear-publicacion/crearPublicacion.js';
import { renderPerfilProfesionalPage, initPerfilProfesionalPage } from './pages/perfil-profesional/perfilProfesional.js';
import { renderHacerPedidoPage, initHacerPedidoPage } from './pages/hacer-pedido/hacerPedido.js';
import { renderChatPage, initChatPage } from './pages/chat/chat.js';
import { renderPerfilUsuarioPage, initPerfilUsuarioPage } from './pages/mi-perfil/miPerfil.js';
import { renderPdfPage, initPdfPage } from './pages/ver-pdf/verPdf.js';
import { renderFaqPage, initFaqPage } from './pages/faq/preguntasFrecuentes.js';

const mainContent = document.getElementById('main-content');

// Mapeo de rutas (hashes) a sus funciones coordinadoras de renderizado
const routes = {
    '#inicio': { render: renderInicioPage, init: initInicioPage },
    '#buscar': { render: renderListaProductosPage, init: initListaProductosPage },
    '#acerca': { render: renderAcercaPage, init: initAcercaPage },
    '#contacto': { render: renderContactoPage, init: initContactoPage },
    '#login': {render: renderLoginPage, init: initLoginPage },
    '#registro': { render: renderRegistroPage, init: initRegistroPage },
    '#registro-usuario': { render: renderRegistroUsuarioPage, init: initRegistroUsuarioPage },
    '#registro-profesional': { render: renderRegistroProfesionalPage, init: initRegistroProfesionalPage },
    '#crear-publicacion': { render: renderCrearPublicacionPage, init: initCrearPublicacionPage },
    '#perfil-profesional': { render: renderPerfilProfesionalPage, init: initPerfilProfesionalPage },
    '#hacer-pedido': { render: renderHacerPedidoPage, init: initHacerPedidoPage },
    '#chat': { render: renderChatPage, init: initChatPage },
    '#mi-perfil': { render: renderPerfilUsuarioPage, init: initPerfilUsuarioPage },
    '#ver-pdf': { render: renderPdfPage, init: initPdfPage },
    '#faq': { render: renderFaqPage, init: initFaqPage }
};

function updateAuthUI() {
    const authButtonsContainer = document.querySelector('.navbar-custom .d-flex.justify-content-end');
    if (!authButtonsContainer) return;

    const currentUser = JSON.parse(localStorage.getItem('currentUser') || 'null');
    if (currentUser && currentUser.nombre) {
        authButtonsContainer.innerHTML = `
            <a href="#mi-perfil" class="text-white me-3 fw-bold" style="text-decoration: underline;"><i class="bi bi-person-circle me-1"></i>${currentUser.nombre}</a>
            <button id="btn-logout" class="btn-custom btn-custom-outline" style="border: 1px solid white; color: white;">Cerrar Sesión</button>
        `;
        const logoutBtn = document.getElementById('btn-logout');
        if (logoutBtn) {
            logoutBtn.addEventListener('click', (e) => {
                e.preventDefault();
                localStorage.removeItem('currentUser');
                localStorage.removeItem('token');
                window.location.reload();
            });
        }
    } else {
        authButtonsContainer.innerHTML = `
            <a href="#registro" class="btn-custom btn-custom-outline">Registro</a>
            <a href="#login" class="btn-custom btn-custom-primary">Iniciar Sesión</a>
        `;
    }
}

function router() {
    const hash = window.location.hash || '#inicio';
    const parts = hash.split('/');
    const basePath = parts[0];
    const param = parts[1]; // optional parameter (like ID)
    
    const route = routes[basePath];
    if (route) {
        if (typeof route === 'function') {
            mainContent.innerHTML = route(param);
        } else {
            mainContent.innerHTML = route.render(param);
            if (route.init) {
                route.init(param);
            }
        }
    } else {
        window.location.hash = '#inicio';
        return;
    }

    updateActiveNavLink(basePath);
    updateAuthUI();
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

