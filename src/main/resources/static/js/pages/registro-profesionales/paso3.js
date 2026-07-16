export function renderPaso3() {
    return `
        <div class="paso-formulario">

            <h1 class="paso-numero">Paso 3</h1>
            <h5 class="paso-subtitulo">
                Perfil profesional
            </h5>

            <!-- OFICIO -->
            <div class="mb-3">
                <label class="form-label">Oficio / Especialidad principal</label>

                <select class="form-select" id="especialidad">
                    <option selected disabled>Selecciona una opción</option>
                    <option>Electricista</option>
                    <option>Plomero</option>
                    <option>Albañil</option>
                    <option>Pintor</option>
                    <option>Carpintero</option>
                    <option>Herrero</option>
                    <option>Técnico en refrigeración</option>
                </select>
            </div>

            <!-- SUBESPECIALIDADES -->
            <div class="mb-3">
                <label class="form-label">Subespecialidades</label>

                <select class="form-select" id="subespecialidades" multiple>
                    <option>Instalaciones</option>
                    <option>Mantenimiento</option>
                    <option>Reparaciones</option>
                    <option>Emergencias</option>
                </select>
            </div>

            <div class="row">

                <!-- EXPERIENCIA -->
                <div class="col-md-4 mb-3">
                    <label class="form-label">Años de experiencia</label>

                    <input
                        type="number"
                        class="form-control"
                        id="experiencia"
                        min="0"
                        placeholder="0">
                </div>

                <!-- PORTAFOLIO -->
                <div class="col-md-8 mb-3">
                    <label class="form-label">Descripción / Experiencia</label>

                    <textarea
                        class="form-control"
                        id="descripcion"
                        rows="4"
                        placeholder="Describe tu experiencia profesional"></textarea>
                </div>
            </div>

            <!-- CERTIFICACIONES -->
            <div class="mb-3">
                <label class="form-label">Certificaciones / Títulos</label>

                <input
                    type="file"
                    class="form-control"
                    id="certificaciones"
                    accept=".pdf,image/png,image/jpeg">
            </div>

            <!-- PORTAFOLIO -->
            <div class="mb-4">
                <label class="form-label">Galería de trabajos</label>

                <input
                    type="file"
                    class="form-control"
                    id="portafolio"
                    accept=".pdf,image/png,image/jpeg">
            </div>

            <!-- BOTONES -->
            <div class="d-flex justify-content-between">

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