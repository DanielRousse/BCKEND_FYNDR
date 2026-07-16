const profesionalesData = [
    { id: 1, nombre: "Juan Perez", servicio: "Plomería", calificacion: 4.9, resenas: 124, precio: 350, img: "./assets/juan.svg" },
    { id: 2, nombre: "Carlos Ramirez", servicio: "Electricidad", calificacion: 4.8, resenas: 98, precio: 400, img: "./assets/carlos.svg" },
    { id: 3, nombre: "Miguelina Torres", servicio: "Carpintería", calificacion: 4.9, resenas: 156, precio: 500, img: "./assets/miguelina.svg" },
    { id: 4, nombre: "Maria Lopez", servicio: "Limpieza", calificacion: 4.7, resenas: 86, precio: 300, img: "./assets/maria.svg" },
    { id: 5, nombre: "Luis Hernandez", servicio: "Pintura", calificacion: 4.8, resenas: 112, precio: 450, img: "./assets/luis.svg" },
    { id: 6, nombre: "Fernando Garcia", servicio: "Jardinería", calificacion: 4.6, resenas: 75, precio: 350, img: "./assets/fernando.svg" },
    { id: 7, nombre: "Roberto Gómez", servicio: "Plomería", calificacion: 4.5, resenas: 42, precio: 320, img: "./assets/roberto.svg" },
    { id: 8, nombre: "Alicia Díaz", servicio: "Electricidad", calificacion: 4.9, resenas: 110, precio: 420, img: "./assets/alicia.svg" },
    { id: 9, nombre: "Sonia Martínez", servicio: "Limpieza", calificacion: 4.8, resenas: 65, precio: 280, img: "./assets/sonia.svg" },
    { id: 10, nombre: "Pedro Infante", servicio: "Carpintería", calificacion: 4.4, resenas: 38, precio: 480, img: "./assets/pedro.svg" },
    { id: 11, nombre: "Ricardo Silva", servicio: "Pintura", calificacion: 4.7, resenas: 54, precio: 390, img: "./assets/ricardo.svg" },
    { id: 12, nombre: "Elena Rostova", servicio: "Jardinería", calificacion: 4.9, resenas: 93, precio: 370, img: "./assets/elena.svg" },
    { id: 13, nombre: "Hugo Sánchez", servicio: "Plomería", calificacion: 4.6, resenas: 29, precio: 360, img: "./assets/hugo.svg" },
    { id: 14, nombre: "Manuel Belgrano", servicio: "Electricidad", calificacion: 4.3, resenas: 19, precio: 310, img: "./assets/manuel.svg" },
    { id: 15, nombre: "Gabriela Mistral", servicio: "Limpieza", calificacion: 4.8, resenas: 74, precio: 330, img: "./assets/gabriela.svg" },
    { id: 16, nombre: "Jorge Luis", servicio: "Carpintería", calificacion: 4.7, resenas: 88, precio: 520, img: "./assets/jorge.svg" },
    { id: 17, nombre: "Andrés Calamaro", servicio: "Pintura", calificacion: 4.5, resenas: 31, precio: 410, img: "./assets/andres.svg" },
    { id: 18, nombre: "Beatriz Pinzón", servicio: "Jardinería", calificacion: 4.8, resenas: 47, precio: 340, img: "./assets/beatriz.svg" },
    { id: 19, nombre: "Tomás Alva", servicio: "Electricidad", calificacion: 4.9, resenas: 150, precio: 460, img: "./assets/tomas.svg" },
    { id: 20, nombre: "Clara Luna", servicio: "Limpieza", calificacion: 4.6, resenas: 52, precio: 290, img: "./assets/clara.svg" }
];


let profesionalesVisibles = 6;
let listaFiltradaActual = [...profesionalesData];


export function renderProfesionales() {
    
    setTimeout(() => {
        inicializarLogicaProfesionales();
    }, 0);

    return `
        <section class="container my-5 py-4 border-bottom">
            <div class="row">
                
                <div class="col-lg-9 col-md-8">
                    <div id="grid-profesionales" class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
                        </div>
                    
                    <div class="text-center mt-5">
                        <button class="btn btn-outline-dark px-4 py-2" id="btnCargarMas">
                            Cargar más profesionales
                        </button>
                    </div>
                </div>

                <div class="col-lg-3 col-md-4">
                    <div class="card p-3 shadow-sm" style="background-color: #e3f2fd; border: none; border-radius: 12px;">
                        <h4 class="fw-bold mb-3" style="font-size: 1.1rem; color: #333;">Filtros</h4>
                        
                        <div class="mb-3">
                            <label class="form-label fw-semibold small mb-1">Ubicación</label>
                            <div class="input-group input-group-sm">
                                <span class="input-group-text bg-white border-end-0"><i class="bi bi-geo-alt"></i></span>
                                <input type="text" id="filtro-ubicacion" class="form-control border-start-0" placeholder="Tu ubicación">
                            </div>
                        </div>

                        <div class="mb-3">
                            <div class="input-group input-group-sm">
                                <input type="text" id="filtro-distancia" class="form-control border-end-0" placeholder="10 km">
                                <span class="input-group-text bg-white border-start-0"><i class="bi bi-envelope"></i></span>
                            </div>
                        </div>

                        <div class="mb-3">
                            <label class="form-label fw-semibold small mb-1">Tipo de servicio</label>
                            <div id="filtros-servicios-checkboxes" class="small">
                                ${["Plomería", "Electricidad", "Carpintería", "Limpieza", "Pintura", "Jardinería"].map(serv => `
                                    <div class="form-check d-flex justify-content-between align-items-center mb-1">
                                        <label class="form-check-label" for="chk-${serv}">${serv}</label>
                                        <input class="form-check-input chk-servicio" type="checkbox" value="${serv}" id="chk-${serv}">
                                    </div>
                                `).join('')}
                            </div>
                        </div>

                        <div class="mb-3">
                            <label class="form-label fw-semibold small mb-1">Precio</label>
                            <div class="d-flex gap-2">
                                <input type="number" id="precio-min" class="form-control form-control-sm" placeholder="Mínimo">
                                <input type="number" id="precio-max" class="form-control form-control-sm" placeholder="Máximo">
                            </div>
                        </div>

                        <div class="mb-4">
                            <label class="form-label fw-semibold small mb-1">Calificación mínima</label>
                            <select id="select-calificacion" class="form-select form-select-sm">
                                <option value="0">Todas</option>
                                <option value="4.5">4.5+ ★★★★★</option>
                                <option value="4.7">4.7+ ★★★★★</option>
                                <option value="4.8">4.8+ ★★★★★</option>
                                <option value="4.9">4.9+ ★★★★★</option>
                            </select>
                        </div>

                        <button class="btn btn-primary btn-sm w-100 mb-2 fw-bold" id="btn-aplicar-filtros" style="background-color: #0d6efd;">
                            Aplicar filtros
                        </button>
                        <button class="btn btn-outline-secondary btn-sm w-100 fw-bold bg-white" id="btn-limpiar-filtros">
                            Limpiar filtros
                        </button>
                    </div>
                </div>

            </div>
        </section>
    `;
}

function inicializarLogicaProfesionales() {
    listaFiltradaActual = [...profesionalesData];
    profesionalesVisibles = 6;

    renderizarSegmento();

    const catMas = document.getElementById("cat-mas");
    const catServices = document.querySelectorAll(".cat-service");

    if (catMas) {
        catMas.addEventListener("click", () => {
            catServices.forEach(cat => cat.classList.remove("d-none"));
            catMas.classList.add("d-none");
        });
    }

    const btnsCategoriasTop = document.querySelectorAll(".btn-categoria-top");
    btnsCategoriasTop.forEach(btn => {
        btn.addEventListener("click", () => {
            const categoria = btn.getAttribute("data-categoria");

            const checkboxes = document.querySelectorAll(".chk-servicio");
            checkboxes.forEach(chk => {
                if (categoria === "Todos") {
                    chk.checked = false;
                } else {
                    chk.checked = (chk.value === categoria);
                }
            });

            ejecutarFlujoFiltrado();
        });
    });

    
    const btnRelevantesTop = document.getElementById("btn-relevantes-top");
    if (btnRelevantesTop) {
        btnRelevantesTop.addEventListener("click", () => {
            listaFiltradaActual.sort((a, b) => b.calificacion - a.calificacion);
            renderizarSegmento();
        });
    }

    const btnCargarMas = document.getElementById("btnCargarMas");
    if (btnCargarMas) {
        btnCargarMas.addEventListener("click", () => {
            profesionalesVisibles += 6;
            renderizarSegmento();
        });
    }

    const btnAplicar = document.getElementById("btn-aplicar-filtros");
    if (btnAplicar) {
        btnAplicar.addEventListener("click", ejecutarFlujoFiltrado);
    }

    const btnLimpiar = document.getElementById("btn-limpiar-filtros");
    if (btnLimpiar) {
        btnLimpiar.addEventListener("click", () => {
            document.getElementById("precio-min").value = "";
            document.getElementById("precio-max").value = "";
            document.getElementById("select-calificacion").value = "0";
            document.querySelectorAll(".chk-servicio").forEach(cb => cb.checked = false);

            listaFiltradaActual = [...profesionalesData];
            profesionalesVisibles = 6;
            renderizarSegmento();
        });
    }
}

function ejecutarFlujoFiltrado() {
    const checkboxes = document.querySelectorAll(".chk-servicio:checked");
    const serviciosSeleccionados = Array.from(checkboxes).map(cb => cb.value);

    const precioMin = parseFloat(document.getElementById("precio-min").value) || 0;
    const precioMax = parseFloat(document.getElementById("precio-max").value) || Infinity;
    const calificacionMin = parseFloat(document.getElementById("select-calificacion").value) || 0;

    listaFiltradaActual = profesionalesData.filter(pro => {
        const cumpleServicio = serviciosSeleccionados.length === 0 || serviciosSeleccionados.includes(pro.servicio);
        const cumplePrecio = pro.precio >= precioMin && pro.precio <= precioMax;
        const cumpleStars = pro.calificacion >= calificacionMin;
        return cumpleServicio && cumplePrecio && cumpleStars;
    });

    profesionalesVisibles = 6;
    renderizarSegmento();
}

function renderizarSegmento() {
    const grid = document.getElementById("grid-profesionales");
    const btnCargarMas = document.getElementById("btnCargarMas");
    if (!grid) return;

    const segmentoAMostrar = listaFiltradaActual.slice(0, profesionalesVisibles);

    grid.innerHTML = "";

    if (segmentoAMostrar.length === 0) {
        grid.innerHTML = `<div class="col-12 text-center py-4 text-muted"><p>No se encontraron profesionales que coincidan.</p></div>`;
        if (btnCargarMas) btnCargarMas.style.display = "none";
        return;
    }

    segmentoAMostrar.forEach(pro => {
        const col = document.createElement("div");
        col.className = "col";
        col.innerHTML = `
            <div class="card h-100 border text-start shadow-sm" style="border-radius: 8px; overflow: hidden;">
                <div style="height: 180px; background-color: #eaeaea;" class="d-flex align-items-center justify-content-center">
                    <img class="w-100 h-100" style="object-fit: cover; object-position: center;" src="${pro.img}" alt="foto_perfil">
                </div>
                <div class="card-body d-flex flex-column justify-content-between">
                    <div>
                        <h5 class="card-title fw-bold mb-0" style="font-size: 1.1rem;">${pro.nombre}</h5>
                        <p class="text-muted small mb-2">${pro.servicio}</p>
                        
                        <div class="d-flex align-items-center gap-1 mb-3 small">
                            <span class="fw-bold text-dark">${pro.calificacion}</span>
                            <span class="text-warning">★★★★★</span>
                            <span class="text-muted">(${pro.resenas})</span>
                        </div>
                    </div>
                    
                    <div class="d-flex justify-content-between align-items-center mt-2">
                        <div class="fw-bold text-dark" style="font-size: 1rem;">
                            <span class="text-muted fw-normal small">Desde</span> $${pro.precio}
                        </div>
                        <button class="btn btn-sm btn-outline-secondary px-3" style="border-radius: 4px;">
                            Ver perfil
                        </button>
                    </div>
                </div>
            </div>
        `;
        grid.appendChild(col);
    });

    if (btnCargarMas) {
        if (profesionalesVisibles >= listaFiltradaActual.length) {
            btnCargarMas.style.display = "none";
        } else {
            btnCargarMas.style.display = "inline-block";
        }
    }
}