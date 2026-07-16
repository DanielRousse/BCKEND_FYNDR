export function renderTutorial() {
    return `
        <section class="container my-5 py-4">
            <div class="text-center mb-5">
                <h2 class="subtitulo" style="font-size: 2.2rem; font-weight: 800; color: var(--azul-rey-profundo); margin-bottom: 0.5rem;">
                    ¿Cómo funciona FYNDR?
                </h2>
                <p class="texto-regular text-muted">Contratar ayuda confiable para tu hogar nunca había sido tan sencillo.</p>
            </div>
            
            <div class="tutorial-video-container mb-5">
                <video src="./assets/Tutorial_Fyndr.mp4" autoplay muted loop playsinline class="tutorial-video"></video>
            </div>
            
            <div class="tutorial-step-container mb-5">
                <div class="tutorial-step">
                    <div class="tutorial-step-icon">1</div>
                    <h4>Busca</h4>
                    <p>Elige el servicio que necesitas e introduce tu ubicación para filtrar los profesionales más cercanos a tu hogar.</p>
                </div>
                <div class="tutorial-step">
                    <div class="tutorial-step-icon">2</div>
                    <h4>Compara</h4>
                    <p>Revisa perfiles reales con portafolios, calificaciones detalladas de otros clientes y tarifas por hora o trabajo.</p>
                </div>
                <div class="tutorial-step">
                    <div class="tutorial-step-icon">3</div>
                    <h4>Contrata</h4>
                    <p>Contacta directamente al experto de tu preferencia de forma segura para agendar y llevar a cabo el servicio.</p>
                </div>
            </div>

            <div class="cta-profesional">
                <h3>¿Eres un profesional de los servicios?</h3>
                <p>
                    Únete a la red de FYNDR para ofrecer tus habilidades de plomería, pintura, limpieza y más. Consigue nuevos clientes y haz crecer tus ingresos hoy mismo.
                </p>
                <a href="#registro" class="cta-btn-white">Regístrate como Profesional</a>
            </div>
        </section>
    `;
}
