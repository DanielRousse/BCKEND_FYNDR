export function renderCategorias() {
    return `
        <section class="container my-5 py-4 text-center">
            <h2 class="subtitulo" style="font-size: 2.2rem; font-weight: 800; color: var(--azul-rey-profundo); margin-bottom: 0.5rem;">
                Explora nuestras categorías populares
            </h2>
            <p class="texto-regular text-muted mb-5">Encuentra expertos calificados en los oficios más solicitados del hogar.</p>
            
            <div class="inicio-categorias-grid">
                <a href="#buscar" class="inicio-categoria-card">
                    <i class="bi bi-droplet-fill"></i>
                    <span>Plomería</span>
                </a>
                <a href="#buscar" class="inicio-categoria-card">
                    <i class="bi bi-lightning-charge-fill"></i>
                    <span>Electricidad</span>
                </a>
                <a href="#buscar" class="inicio-categoria-card">
                    <i class="bi bi-hammer"></i>
                    <span>Carpintería</span>
                </a>
                <a href="#buscar" class="inicio-categoria-card">
                    <i class="bi bi-stars"></i>
                    <span>Limpieza</span>
                </a>
                <a href="#buscar" class="inicio-categoria-card">
                    <i class="bi bi-brush-fill"></i>
                    <span>Pintura</span>
                </a>
                <a href="#buscar" class="inicio-categoria-card">
                    <i class="bi bi-flower1"></i>
                    <span>Jardinería</span>
                </a>
            </div>
        </section>
    `;
}
