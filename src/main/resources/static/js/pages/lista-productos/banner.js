export function renderBanner() {
    return `
        <section class="banner-productos">

           <div class="contenido-banner">
                <div class="texto-banner">
                    <h1>Nuestros servicios</h1>

                    <p>
                        Encuentra profesionales verificados y
                        <br>
                        calificados para cualquier trabajo en tu hogar
                    </p>
                </div>
            </div>

            <div class="buscador">
                <div class="input-box">

                    <i class="fa-solid fa-magnifying-glass"></i>

                    <input 
                    type="text" 
                    id="servicio"
                    placeholder="¿Qué servicio necesitas?">

                </div>

                <div class="input-box">

                    <i class="fa-solid fa-location-dot"></i>

                    <input 
                    type="text"
                    id="ubicacion"
                    placeholder="Tu ubicación">

                </div>

                <button id="btnBuscar">

                    <i class="fa-solid fa-magnifying-glass"></i>
                    Buscar

                </button>
            </div>

        </section>

    `;
}
