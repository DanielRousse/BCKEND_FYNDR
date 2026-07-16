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
