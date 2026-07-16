export function renderCategorias() {
    return `
        <section class="container my-5 py-4 border-bottom">

            <div id="categories-container" class="d-flex flex-wrap justify-content-center gap-4">

                <div class="categoria-card btn-categoria-top" data-categoria="Todos" id="cat-todos" style="cursor: pointer;">
                    <i class="bi bi-grid-fill"></i>
                    <span>Todos</span>
                </div>

                <div class="categoria-card btn-categoria-top cat-service" data-categoria="Plomería" style="cursor: pointer;">
                    <i class="bi bi-droplet-fill"></i>
                    <span>Plomería</span>
                </div>

                <div class="categoria-card btn-categoria-top cat-service" data-categoria="Electricidad" style="cursor: pointer;">
                    <i class="bi bi-lightning-charge-fill"></i>
                    <span>Electricidad</span>
                </div>

                <div class="categoria-card btn-categoria-top cat-service" data-categoria="Carpintería" style="cursor: pointer;">
                    <i class="bi bi-hammer"></i>
                    <span>Carpintería</span>
                </div>

                <div class="categoria-card btn-categoria-top cat-service d-none" data-categoria="Limpieza" style="cursor: pointer;">
                    <i class="bi bi-stars"></i>
                    <span>Limpieza</span>
                </div>

                <div class="categoria-card btn-categoria-top cat-service d-none" data-categoria="Pintura" style="cursor: pointer;">
                    <i class="bi bi-brush-fill"></i>
                    <span>Pintura</span>
                </div>

                <div class="categoria-card btn-categoria-top cat-service d-none" data-categoria="Jardinería" style="cursor: pointer;">
                    <i class="bi bi-flower1"></i>
                    <span>Jardinería</span>
                </div>

                <div class="categoria-card" id="cat-mas" style="cursor: pointer;">
                    <i class="bi bi-three-dots"></i>
                    <span>Más</span>
                </div>

            </div>

            <div class="d-flex justify-content-center mt-4">
                <button class="btn-categorias" id="btn-relevantes-top">
                    Más relevantes
                    <i class="bi bi-chevron-down"></i>
                </button>
            </div>

        </section>
    `;
}