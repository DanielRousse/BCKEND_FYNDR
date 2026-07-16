export function renderValores() {
    return `
        <section class="valores-section py-5">
            <div class="container">
                <h2 class="text-center fw-bold mb-4" style="color: var(--azul-rey-profundo);">
                    Nuestros valores
                </h2>

                <div class="row g-4 justify-content-center">
                    <!-- Valor 1 -->
                    <div class="col-12 col-md-6 col-lg-3">
                        <div class="valor-card text-center p-4 h-100">
                            <div class="icon-container">
                                <img src="assets/Confianza.svg" alt="Confianza" width="64" height="64">
                            </div>
                            <h4 class="fw-bold mt-3">Confianza</h4>
                            <p class="mb-0 fw-bold">
                                Verificamos a cada profesional para garantizar seguridad y tranquilidad.
                            </p>
                        </div>
                    </div>

                    <!-- Valor 2 -->
                    <div class="col-12 col-md-6 col-lg-3">
                        <div class="valor-card text-center p-4 h-100">
                            <div class="icon-container">
                                <img src="assets/Compromiso.svg" alt="Compromiso" width="64" height="64">
                            </div>
                            <h4 class="fw-bold mt-3">Compromiso</h4>
                            <p class="mb-0 fw-bold">
                                Nos comprometemos a ofrecer la mejor experiencia a nuestros usuarios y profesionales.
                            </p>
                        </div>
                    </div>

                    <!-- Valor 3 -->
                    <div class="col-12 col-md-6 col-lg-3">
                        <div class="valor-card text-center p-4 h-100">
                            <div class="icon-container">
                                <img src="assets/transparenia.svg" alt="Transparencia" width="64" height="64">
                            </div>
                            <h4 class="fw-bold mt-3">Transparencia</h4>
                            <p class="mb-0 fw-bold">
                                Información clara, precios justos y comunicación abierta en cada servicio.
                            </p>
                        </div>
                    </div>

                    <!-- Valor 4 -->
                    <div class="col-12 col-md-6 col-lg-3">
                        <div class="valor-card text-center p-4 h-100">
                            <div class="icon-container">
                                <img src="assets/respeto.svg" width="64" height="64" alt="Respeto">
                            </div>
                            <h4 class="fw-bold mt-3">Respeto</h4>
                            <p class="mb-0 fw-bold">
                                Valoramos tu tiempo, tu hogar y el trabajo de nuestros profesionales.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    `;
}
