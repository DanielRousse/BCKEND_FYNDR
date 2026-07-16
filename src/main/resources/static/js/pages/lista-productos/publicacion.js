export function renderPublicacion() {
    return `
        <section class="call-to-action pt-5 pb-0 px-3">
            <div class="container-fluid">
                <div class="row align-items-center text-center text-md-start">
                    <div class="col-12 col-md-3 d-flex justify-content-center align-self-end">
                        <img src="assets/phone_FYNDR.svg" alt="Mockup Celular Fyndr" class="img-fluid phone">
                    </div>

                    <div class="col-12 col-md-6 text-center mb-3 mb-md-0">
                        <h2 class="fw-bold h4 mb-2">¿No encuentras lo que buscas?</h2>
                        <p class="mb-0 text-muted small-text">
                            Únete a miles de personas que ya confían en <strong>FYNDR</strong> para hacer su vida más fácil.
                        </p>
                    </div>

                    <div class="col-12 col-md-3">
                        <div class="d-grid gap-2 col-10 col-md-12 mx-auto pb-4">
                            <button type="button" id="btnPublicar"
                                class="btn btn-outline-primary custom-btn d-flex align-items-center justify-content-center gap-2">
                                <i class="bi bi-briefcase"></i> Publicar trabajo
                            </button>
                        </div>
                    </div>

                </div>
            </div>
        </section>
    `;
}
