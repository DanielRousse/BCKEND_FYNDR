export function renderPaso2() {
    return `
        <div class="paso-formulario">

            <h1 class="paso-numero">Paso 2</h1>
            <h5 class="paso-subtitulo">
                Datos de identidad y verificación
            </h5>

            <!-- INE -->
            <div class="mb-3">
                <label class="form-label">
                    Identificación oficial (INE / Pasaporte)
                </label>

                <input
                    type="file"
                    class="form-control"
                    id="ine"
                    accept=".jpg,.jpeg,.png"
                    onchange="validarImagen(this)">
            </div>

            <!-- CURP -->
            <div class="mb-3">
                <label class="form-label">CURP</label>

                <input
                    type="text"
                    class="form-control"
                    id="curp"
                    maxlength="18"
                    placeholder="AAAA000000HDFXXX00"
                    onchange="validarCURP(this)">
            </div>

            <!-- FOTO -->
            <div class="mb-3">
                <label class="form-label">Fotografía</label>

                <input
    type="file"
    class="form-control"
    id="fotografia"
    accept=".jpg,.jpeg,.png"
    onchange="validarImagen(this)">
            </div>

            <!-- COMPROBANTE -->
            <div class="mb-3">
                <label class="form-label">
                    Comprobante de domicilio
                </label>

                <input
                    type="file"
                    class="form-control"
                    id="comprobante"
                    accept=".jpg,.jpeg,.png,.pdf"
                    onchange="validarImagenOPdf(this)">
            </div>

            <!-- ANTECEDENTES -->
            <div class="mb-3">
                <label class="form-label">
                    Carta de antecedentes no penales
                </label>

                <input
                    type="file"
                    class="form-control"
                    id="antecedentes"
                    accept=".pdf"
                    onchange="validarPDF(this)">
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
                    class="btn btn-primary"
                    id="btn-siguiente">
                    Siguiente
                </button>

            </div>

        </div>
    `;
}