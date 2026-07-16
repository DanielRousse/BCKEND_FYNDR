import { renderBanner } from './banner.js';
import { renderSoporte, initSoporte } from './soporte.js';

export function renderContactoPage() {
    return `
        <div class="contacto-page animate-appear">
            ${renderBanner()}
            ${renderSoporte()}
        </div>
    `;
}

export function initContactoPage() {
    initSoporte();
}
