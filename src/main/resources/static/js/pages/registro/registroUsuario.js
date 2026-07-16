import { renderFormulario, initFormulario } from './formulario.js';

export function renderRegistroUsuarioPage() {
    return `
        <div class="registro-usuario-page animate-appear">
            ${renderFormulario()}
        </div>
    `;
}

export function initRegistroUsuarioPage() {
    initFormulario();
}
