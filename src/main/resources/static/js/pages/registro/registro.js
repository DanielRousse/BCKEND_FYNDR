export function renderRegistroPage() {
    return `
        <section class="registro-choice-section animate-appear">
            <div class="split-pane left-pane">
                <div class="pane-overlay"></div>
                <div class="pane-content">
                    <h2 class="pane-title">¿Buscas un servicio?</h2>
                    <p class="pane-text">Encuentra profesionales calificados y verificados para tu hogar en minutos.</p>
                    <a href="#registro-usuario" class="btn-choice">Registrarse como Cliente</a>
                </div>
            </div>
            <div class="split-pane right-pane">
                <div class="pane-overlay"></div>
                <div class="pane-content">
                    <h2 class="pane-title">¿Ofreces un servicio?</h2>
                    <p class="pane-text">Únete a nuestra red de expertos y encuentra nuevos clientes hoy mismo.</p>
                    <a href="#registro-profesional" class="btn-choice">Registrarse como Profesional</a>
                </div>
            </div>
        </section>
    `;
}

export function initRegistroPage() {
}
