import { renderBanner } from './banner.js';
import { renderValores } from './valores.js';
import { renderMision } from './mision.js';
import { renderEquipo, initEquipo } from './equipo.js';
import { renderCallToAction } from './calltoaction.js';

export function renderAcercaPage() {
    return `
        <div class="acerca-page animate-appear">
            ${renderBanner()}
            ${renderValores()}
            ${renderMision()}
            ${renderEquipo()}
            ${renderCallToAction()}
        </div>
    `;
}

export function initAcercaPage() {
    initEquipo();

    const btnBuscar = document.getElementById('btnBuscar');
    if (btnBuscar) {
        btnBuscar.addEventListener('click', (e) => {
            e.preventDefault();
            window.location.hash = '#buscar';
        });
    }

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
                        window.location.hash = '#crear-publicacion';
                    } else {
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

