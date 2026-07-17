export function renderFaqPage() {
    return `
        <div class="container py-5 animate-appear" style="min-height: 80vh; max-width: 800px;">
            <div class="text-center mb-5">
                <h2 class="fw-bold mb-2" style="color: var(--azul-rey-profundo);">Preguntas Frecuentes</h2>
                <p class="text-muted">Encuentra respuestas rápidas a las dudas más comunes sobre Fyndr.</p>
            </div>
            
            <div class="accordion" id="faqAccordion">
                
                <!-- FAQ 1 -->
                <div class="accordion-item border shadow-sm mb-3" style="border-radius: 8px; overflow: hidden;">
                    <h2 class="accordion-header" id="headingOne">
                        <button class="accordion-button fw-bold text-dark bg-white" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                            ¿Qué es Fyndr?
                        </button>
                    </h2>
                    <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#faqAccordion">
                        <div class="accordion-body text-secondary" style="line-height: 1.6;">
                            Fyndr es una plataforma digital que conecta a usuarios con profesionales de servicios para el hogar y comercio (plomeros, electricistas, carpinteros, etc.), permitiéndote contratarlos de forma directa, chatear con ellos y evaluar su desempeño.
                        </div>
                    </div>
                </div>

                <!-- FAQ 2 -->
                <div class="accordion-item border shadow-sm mb-3" style="border-radius: 8px; overflow: hidden;">
                    <h2 class="accordion-header" id="headingTwo">
                        <button class="accordion-button collapsed fw-bold text-dark bg-white" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                            ¿Cómo contrato a un profesional?
                        </button>
                    </h2>
                    <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#faqAccordion">
                        <div class="accordion-body text-secondary" style="line-height: 1.6;">
                            Es muy fácil: ingresa a la sección de "Buscar servicios", selecciona la categoría o busca por nombre de servicio, revisa el perfil del profesional y haz clic en el botón "Contratar Servicio" para realizar una solicitud de pedido.
                        </div>
                    </div>
                </div>

                <!-- FAQ 3 -->
                <div class="accordion-item border shadow-sm mb-3" style="border-radius: 8px; overflow: hidden;">
                    <h2 class="accordion-header" id="headingThree">
                        <button class="accordion-button collapsed fw-bold text-dark bg-white" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                            ¿Cómo me registro como profesional?
                        </button>
                    </h2>
                    <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#faqAccordion">
                        <div class="accordion-body text-secondary" style="line-height: 1.6;">
                            Inicia sesión con tu cuenta común, haz clic en el botón de publicar servicio del menú de navegación, y el sistema te llevará de forma automática al formulario de registro profesional. Deberás completar tus datos de contacto, tarifas, especialidades y documentos correspondientes.
                        </div>
                    </div>
                </div>

                <!-- FAQ 4 -->
                <div class="accordion-item border shadow-sm mb-3" style="border-radius: 8px; overflow: hidden;">
                    <h2 class="accordion-header" id="headingFour">
                        <button class="accordion-button collapsed fw-bold text-dark bg-white" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                            ¿Los pagos son seguros en Fyndr?
                        </button>
                    </h2>
                    <div id="collapseFour" class="accordion-collapse collapse" aria-labelledby="headingFour" data-bs-parent="#faqAccordion">
                        <div class="accordion-body text-secondary" style="line-height: 1.6;">
                            Sí, contamos con un sistema de verificación y métodos de pago guardados de forma segura con cifrado estándar de la industria, asegurando que tus transacciones y datos bancarios estén protegidos en todo momento.
                        </div>
                    </div>
                </div>

                <!-- FAQ 5 -->
                <div class="accordion-item border shadow-sm mb-3" style="border-radius: 8px; overflow: hidden;">
                    <h2 class="accordion-header" id="headingFive">
                        <button class="accordion-button collapsed fw-bold text-dark bg-white" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
                            ¿Tiene algún costo usar la plataforma?
                        </button>
                    </h2>
                    <div id="collapseFive" class="accordion-collapse collapse" aria-labelledby="headingFive" data-bs-parent="#faqAccordion">
                        <div class="accordion-body text-secondary" style="line-height: 1.6;">
                            El registro y la búsqueda de servicios son completamente gratuitos. Los pagos realizados corresponden únicamente a la cotización acordada con el profesional contratado.
                        </div>
                    </div>
                </div>

            </div>
            
            <div class="text-center mt-5">
                <p class="text-muted mb-3">¿Aún tienes dudas?</p>
                <a href="#contacto" class="btn btn-outline-dark px-4 py-2" style="border-radius: 8px; font-weight: 600;">Contáctanos directamente</a>
            </div>
        </div>
    `;
}

export function initFaqPage() {
    // Bootstrap accordion requires no manual JS to trigger
}
