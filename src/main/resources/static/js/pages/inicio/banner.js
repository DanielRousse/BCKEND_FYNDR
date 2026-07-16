export function renderBanner() {
    return `
        <section class="container hero-section">
            <div class="hero-content">
                <h1 class="hero-title">
                    Encuentra al profesional ideal para tu hogar <span>en segundos</span>
                </h1>
                <p class="hero-subtitle">
                    Conectamos de forma rápida y segura a personas que buscan ayuda con profesionales de confianza para plomería, electricidad, carpintería y más.
                </p>
                <div class="hero-buttons">
                    <a href="#buscar" class="hero-btn-primary">Buscar servicios</a>
                    <a href="#registro" class="hero-btn-secondary">Ofrecer servicios</a>
                </div>
            </div>
            <div class="hero-video-container">
                <video id="hero-banner-video" src="./assets/Fyndr_Video.mp4" autoplay muted loop playsinline class="hero-video"></video>
            </div>
        </section>
    `;
}
