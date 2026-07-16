export function renderPaso1() {

    const datos = window.registroProfesionalState?.datos || {};

    return `
        <div class="paso-formulario">

            <h1 class="paso-numero">Paso 1</h1>
            <h5 class="paso-subtitulo">Datos personales</h5>

            <!-- NOMBRE -->
            <div class="mb-3">
                <label class="form-label">Nombre completo</label>
                <input
                    type="text"
                    class="form-control"
                    id="nombre"
                    placeholder="Nombre completo"
                    value="${datos.nombre}">
                <small id="error-nombre" class="text-danger"></small>
            </div>

            <!-- CORREO -->
            <div class="mb-3">
                <label class="form-label">Correo electrónico</label>
                <input
                    type="email"
                    class="form-control"
                    id="correo"
                    placeholder="correo@ejemplo.com"
                    value="${datos.correo}">
                <small id="error-correo" class="text-danger"></small>
            </div>

            <!-- PASSWORD -->
            <div class="mb-3">
                <label class="form-label">Contraseña</label>
                <input
                    type="password"
                    class="form-control"
                    id="password"
                    value="${datos.password}">
                <small id="error-password" class="text-danger"></small>
            </div>

            <!-- CONFIRMAR PASSWORD -->
            <div class="mb-3">
                <label class="form-label">Confirmar contraseña</label>
                <input
                    type="password"
                    class="form-control"
                    id="confirmarPassword"
                    value="${datos.password}">
                <small id="error-confirmar" class="text-danger"></small>
            </div>

            <!-- TELÉFONO -->
            <div class="mb-3">
                <label class="form-label">Teléfono</label>
                <input
                      type="tel"
                      class="form-control"
                      id="telefono"
                      placeholder="5512345678"
                      maxlength="10"
                      value="${datos.telefono}">
                <small id="error-telefono" class="text-danger"></small>
            </div>

            <!-- FECHA -->
            <div class="mb-3">
                <label class="form-label">Fecha de nacimiento</label>
                <input
                    type="date"
                    class="form-control"
                    id="fechaNacimiento"
                    value="${datos.fechaNacimiento}">
                <small id="error-fecha" class="text-danger"></small>
            </div>

            <!-- BOTÓN -->
            <div class="d-flex justify-content-end mt-4">
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