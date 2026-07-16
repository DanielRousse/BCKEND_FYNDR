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
}

