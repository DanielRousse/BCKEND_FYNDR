import { renderBanner } from './banner.js';
import { renderCategorias } from './categorias.js';
import { renderProfesionales } from './profesionales.js';
import { renderPublicacion } from './publicacion.js';
import { renderBeneficios } from './beneficios.js';

export function renderListaProductosPage() {
    return `
        <div class="lista-productos-page animate-appear">
            ${renderBanner()}
            ${renderCategorias()}
            ${renderProfesionales()}
            ${renderPublicacion()}
            ${renderBeneficios()}
        </div>
    `;
}

export function initListaProductosPage() {
    const btnPublicar = document.getElementById('btnPublicar');
    if (btnPublicar) {
        btnPublicar.addEventListener('click', async (e) => {
            e.preventDefault();
            const currentUser = JSON.parse(localStorage.getItem('currentUser') || 'null');
            
            // Si no detecta una cuenta en uso, redirigir a iniciar sesión (#login)
            if (!currentUser || !currentUser.email) {
                window.location.hash = '#login';
                return;
            }

            // Si detecta cuenta, verificar qué tipo de cuenta es (comun o profesional)
            try {
                const response = await fetch('/api/usuarios-trabajadores/');
                if (response.ok) {
                    const trabajadores = await response.json();
                    const esTrabajador = trabajadores.some(t => t.email === currentUser.email);
                    
                    if (esTrabajador) {
                        // Si eres profesional, te manda a la página de crear publicación (#crear-publicacion)
                        window.location.hash = '#crear-publicacion';
                    } else {
                        // Si eres común, te manda a registrarte como profesional (#registro-profesional)
                        window.location.hash = '#registro-profesional';
                    }
                } else {
                    window.location.hash = '#registro-profesional';
                }
            } catch (error) {
                console.error("Error al verificar tipo de cuenta:", error);
                window.location.hash = '#registro-profesional';
            }
        });
    }
}
