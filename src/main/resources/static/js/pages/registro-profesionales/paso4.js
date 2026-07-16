export function renderPaso4() {
    return `
        <div class="paso-formulario">

            <h1 class="paso-numero">Paso 4</h1>
            <h5 class="paso-subtitulo text-center">
                Información fiscal y bancaria
            </h5>

            <!-- RFC -->
            <div class="mb-3">
                <label class="form-label">RFC</label>

                <input
                    type="text"
                    class="form-control"
                    id="rfc"
                    maxlength="13"
                    placeholder="Ingresa tu RFC">
            </div>

            <!-- CONSTANCIA -->
            <div class="mb-3">
                <label class="form-label">
                    Constancia de situación fiscal
                </label>

                <input
                    type="file"
                    class="form-control"
                    id="constanciaFiscal"
                    accept=".pdf">
            </div>

            <!-- CLABE -->
            <div class="mb-3">
                <label class="form-label">CLABE interbancaria</label>

                <input
                    type="text"
                    class="form-control"
                    id="clabe"
                    maxlength="18"
                    placeholder="18 dígitos">
            </div>

            <!-- BANCO -->
            <div class="mb-4">
                <label class="form-label">Banco emisor</label>

                <select class="form-select" id="banco">
                    <option value="">Selecciona un banco</option>
                    <option>BBVA</option>
                    <option>Banamex</option>
                    <option>Santander</option>
                    <option>Banorte</option>
                    <option>HSBC</option>
                    <option>Scotiabank</option>
                    <option>Inbursa</option>
                    <option>Banco Azteca</option>
                    <option>BanCoppel</option>
                </select>
            </div>

            <!-- BOTONES -->
            <div class="d-flex justify-content-between mt-4">

                <button
                    type="button"
                    class="btn btn-outline-primary"
                    id="btn-anterior">
                    Anterior
                </button>

                <button
                    type="button"
                    class="btn btn-success"
                    id="btn-siguiente">
                    Finalizar registro
                </button>

            </div>

        </div>
    `;
}