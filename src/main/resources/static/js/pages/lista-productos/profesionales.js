import { geocodeAddress, calcularDistanciaKm } from '../../geocoding.js';

let profesionalesData = [];
let profesionalesVisibles = 6;
let listaFiltradaActual = [];

let listMap = null;
let listMarkersGroup = null;
let clientCoordinates = null;
let geocodeTimeout = null;


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
                    
                    <!-- Mapa de Profesionales -->
                    <div class="card p-2 shadow-sm mt-3" style="border-radius: 12px; height: 260px;" id="mapa-profesionales-container">
                        <div id="mapa-profesionales" style="height: 100%; border-radius: 8px; z-index: 1;"></div>
                    </div>
                </div>

            </div>
        </section>
    `;
}

function cargarProfesionalesDesdeBD() {
    fetch('/api/usuarios-trabajadores/')
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al cargar profesionales');
            }
            return response.json();
        })
        .then(data => {
            if (data && data.length > 0) {
                profesionalesData = data.map(trabajador => {
                    const calif = trabajador.calificacionPromedio !== null && trabajador.calificacionPromedio !== undefined
                        ? parseFloat(trabajador.calificacionPromedio)
                        : 4.5;

                    const numResenas = Array.isArray(trabajador.resenas) ? trabajador.resenas.length : Math.floor(Math.random() * 50) + 5;
                    const tarifa = trabajador.tarifaHora !== null && trabajador.tarifaHora !== undefined
                        ? parseFloat(trabajador.tarifaHora)
                        : 350.0;

                    let imgPath = trabajador.fotografiaPath || "";
                    if (!imgPath) {
                        const nameKey = (trabajador.nombre || "").split(' ')[0].toLowerCase();
                        const knownAvatars = ["juan", "carlos", "maria", "luis", "fernando", "beatriz", "alicia", "andres", "clara", "elena", "gabriela", "hugo", "jorge", "manuel", "miguelina", "pedro", "ricardo", "roberto", "sonia", "tomas"];
                        if (knownAvatars.includes(nameKey)) {
                            imgPath = `./assets/${nameKey}.svg`;
                        } else {
                            imgPath = `./assets/juan.svg`;
                        }
                    } else if (!imgPath.startsWith('.') && !imgPath.startsWith('http') && !imgPath.startsWith('assets')) {
                        imgPath = `./assets/${imgPath}`;
                    }

                    const servicioStr = trabajador.subespecialidades || "Servicios Generales";
                    const direccionStr = trabajador.direccion || "CDMX";

                    return {
                        id: trabajador.id,
                        nombre: trabajador.nombre,
                        servicio: servicioStr,
                        calificacion: calif,
                        resenas: numResenas,
                        precio: tarifa,
                        img: imgPath,
                        direccion: direccionStr,
                        latitud: trabajador.latitud,
                        longitud: trabajador.longitud
                    };
                });
                listaFiltradaActual = [...profesionalesData];
            }
            renderizarSegmento();
        })
        .catch(error => {
            console.error('Error al obtener profesionales de la BD, usando fallback local:', error);
            renderizarSegmento();
        });
}

function inicializarLogicaProfesionales() {
    profesionalesVisibles = 6;
    cargarProfesionalesDesdeBD();

    if (window.L) {
        inicializarMapa();
    }

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

    // Buscar con el botón de la barra superior (banner)
    const btnBuscarTop = document.querySelector(".banner-productos #btnBuscar");
    if (btnBuscarTop) {
        btnBuscarTop.addEventListener("click", (e) => {
            e.preventDefault();
            ejecutarFlujoFiltrado();
        });
    }

    // Permitir presionar "Enter" en los buscadores de la barra superior
    const inputServicio = document.getElementById("servicio");
    if (inputServicio) {
        inputServicio.addEventListener("keypress", (e) => {
            if (e.key === "Enter") ejecutarFlujoFiltrado();
        });
    }
    // Sincronizar y escuchar cambios en inputs de ubicación
    const inputUbicacion = document.getElementById("ubicacion");
    const inputFiltroUbicacion = document.getElementById("filtro-ubicacion");

    if (inputUbicacion && inputFiltroUbicacion) {
        inputUbicacion.addEventListener("input", (e) => {
            inputFiltroUbicacion.value = e.target.value;
            actualizarCoordenadasYFiltrar(e.target.value);
        });
        inputFiltroUbicacion.addEventListener("input", (e) => {
            inputUbicacion.value = e.target.value;
            actualizarCoordenadasYFiltrar(e.target.value);
        });
    } else {
        if (inputUbicacion) {
            inputUbicacion.addEventListener("input", (e) => actualizarCoordenadasYFiltrar(e.target.value));
        }
        if (inputFiltroUbicacion) {
            inputFiltroUbicacion.addEventListener("input", (e) => actualizarCoordenadasYFiltrar(e.target.value));
        }
    }

    // Escuchar cambios en el input de distancia lateral
    const inputFiltroDistancia = document.getElementById("filtro-distancia");
    if (inputFiltroDistancia) {
        inputFiltroDistancia.addEventListener("input", ejecutarFlujoFiltrado);
    }

    const btnLimpiar = document.getElementById("btn-limpiar-filtros");
    if (btnLimpiar) {
        btnLimpiar.addEventListener("click", () => {
            document.getElementById("precio-min").value = "";
            document.getElementById("precio-max").value = "";
            document.getElementById("select-calificacion").value = "0";
            
            const fUbi = document.getElementById("filtro-ubicacion");
            if (fUbi) fUbi.value = "";
            const fDist = document.getElementById("filtro-distancia");
            if (fDist) fDist.value = "";
            const bUbi = document.getElementById("ubicacion");
            if (bUbi) bUbi.value = "";
            const bServ = document.getElementById("servicio");
            if (bServ) bServ.value = "";
            document.querySelectorAll(".chk-servicio").forEach(cb => cb.checked = false);

            clientCoordinates = null;
            listaFiltradaActual = [...profesionalesData];
            profesionalesVisibles = 6;
            renderizarSegmento();
        });
    }
}

function obtenerCoordenadasSync(direccion) {
    const dir = (direccion || "").toLowerCase();
    const COORD_MAP = {
        "cdmx": { lat: 19.4326, lon: -99.1332 },
        "centro": { lat: 19.4326, lon: -99.1332 },
        "reforma": { lat: 19.4270, lon: -99.1677 },
        "guadalajara": { lat: 20.6597, lon: -103.3496 },
        "monterrey": { lat: 25.6866, lon: -100.3161 },
        "puebla": { lat: 19.0413, lon: -98.2062 },
        "queretaro": { lat: 20.5888, lon: -100.3899 },
        "merida": { lat: 20.9674, lon: -89.5926 }
    };
    for (const key in COORD_MAP) {
        if (dir.includes(key)) {
            return COORD_MAP[key];
        }
    }
    let hash = 0;
    for (let i = 0; i < dir.length; i++) {
        hash = dir.charCodeAt(i) + ((hash << 5) - hash);
    }
    const latOffset = (Math.abs(hash % 100)) / 1000;
    const lonOffset = (Math.abs((hash >> 8) % 100)) / 1000;
    return { lat: 19.4326 + latOffset, lon: -99.1332 + lonOffset };
}

function ejecutarFlujoFiltrado() {
    const checkboxes = document.querySelectorAll(".chk-servicio:checked");
    const serviciosSeleccionados = Array.from(checkboxes).map(cb => cb.value);

    const precioMin = parseFloat(document.getElementById("precio-min").value) || 0;
    const precioMax = parseFloat(document.getElementById("precio-max").value) || Infinity;
    const calificacionMin = parseFloat(document.getElementById("select-calificacion").value) || 0;

    const queryServicio = (document.getElementById("servicio")?.value || "").trim().toLowerCase();
    const queryUbicacion = (document.getElementById("ubicacion")?.value || document.getElementById("filtro-ubicacion")?.value || "").trim().toLowerCase();

    const inputDistancia = document.getElementById("filtro-distancia");
    const maxDistancia = parseFloat(inputDistancia?.value) || Infinity;

    listaFiltradaActual = profesionalesData.filter(pro => {
        const cumpleServicioCheckbox = serviciosSeleccionados.length === 0 || serviciosSeleccionados.includes(pro.servicio);
        const cumpleServicioQuery = !queryServicio || pro.servicio.toLowerCase().includes(queryServicio) || pro.nombre.toLowerCase().includes(queryServicio);
        const cumplePrecio = pro.precio >= precioMin && pro.precio <= precioMax;
        const cumpleStars = pro.calificacion >= calificacionMin;
        
        let cumpleUbicacion = true;
        if (queryUbicacion) {
            if (maxDistancia !== Infinity) {
                const coordCliente = clientCoordinates || obtenerCoordenadasSync(queryUbicacion);
                const coordPro = {
                    lat: pro.latitud || obtenerCoordenadasSync(pro.direccion).lat,
                    lon: pro.longitud || obtenerCoordenadasSync(pro.direccion).lon
                };
                const dist = calcularDistanciaKm(coordCliente.lat, coordCliente.lon, coordPro.lat, coordPro.lon);
                cumpleUbicacion = dist <= maxDistancia;
            } else {
                cumpleUbicacion = pro.direccion.toLowerCase().includes(queryUbicacion);
            }
        }

        return cumpleServicioCheckbox && cumpleServicioQuery && cumplePrecio && cumpleStars && cumpleUbicacion;
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
        
        if (listMarkersGroup) {
            listMarkersGroup.clearLayers();
        }
        return;
    }

    const bounds = [];

    segmentoAMostrar.forEach(pro => {
        const col = document.createElement("div");
        col.className = "col";
        col.innerHTML = `
            <div class="card h-100 border text-start shadow-sm card-profesional" style="border-radius: 8px; overflow: hidden; cursor: pointer;">
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

        const card = col.querySelector('.card-profesional');
        if (card) {
            card.addEventListener('click', (e) => {
                e.preventDefault();
                const currentUser = JSON.parse(localStorage.getItem('currentUser') || 'null');
                if (!currentUser || !currentUser.email) {
                    window.location.hash = '#login';
                } else {
                    window.location.hash = `#perfil-profesional/${pro.id}`;
                }
            });
        }

        grid.appendChild(col);

        // Mapa markers logic
        if (listMarkersGroup) {
            const lat = pro.latitud || obtenerCoordenadasSync(pro.direccion).lat;
            const lon = pro.longitud || obtenerCoordenadasSync(pro.direccion).lon;
            const marker = L.marker([lat, lon]).bindPopup(`
                <strong>${pro.nombre}</strong><br>
                <small>${pro.servicio}</small><br>
                <a href="#perfil-profesional/${pro.id}" class="btn btn-xs btn-primary text-white py-0 px-2 mt-1" style="font-size: 0.75rem;">Ver Perfil</a>
            `);
            listMarkersGroup.addLayer(marker);
            bounds.push([lat, lon]);
        }
    });

    if (listMap && bounds.length > 0) {
        try {
            listMap.fitBounds(bounds, { padding: [20, 20] });
        } catch (e) {
            console.error("Error setting map bounds:", e);
        }
    }

    if (btnCargarMas) {
        if (profesionalesVisibles >= listaFiltradaActual.length) {
            btnCargarMas.style.display = "none";
        } else {
            btnCargarMas.style.display = "inline-block";
        }
    }
}

function inicializarMapa() {
    const mapDiv = document.getElementById("mapa-profesionales");
    if (!mapDiv) return;

    if (listMap) {
        listMap.remove();
    }

    try {
        listMap = L.map('mapa-profesionales').setView([19.4326, -99.1332], 12);
        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
            attribution: '&copy; OpenStreetMap'
        }).addTo(listMap);

        listMarkersGroup = L.layerGroup().addTo(listMap);
    } catch (e) {
        console.error("Error initializing Leaflet map in list:", e);
    }
}

function actualizarCoordenadasYFiltrar(address) {
    if (geocodeTimeout) clearTimeout(geocodeTimeout);

    if (!address.trim()) {
        clientCoordinates = null;
        ejecutarFlujoFiltrado();
        return;
    }

    geocodeTimeout = setTimeout(async () => {
        const coords = await geocodeAddress(address);
        if (coords) {
            clientCoordinates = coords;
        }
        ejecutarFlujoFiltrado();
    }, 500);
}