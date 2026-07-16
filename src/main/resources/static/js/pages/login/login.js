import { renderFormulario, initLogin} from './formulario.js';

export function renderLoginPage() {
    return `
        <div class="login-page animate-appear">
            ${renderFormulario()}
        </div>
    `;
}

export function initLoginPage(){
    initLogin();
}
