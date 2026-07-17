export function renderPerfilProfesionalPage(id) {
    return `
        <div class="container py-5 animate-appear">
            <div class="row">
                <div class="col-md-4 mb-4">
                    <div class="card border-0 shadow-sm p-4 text-center" style="border-radius: 12px; background: rgba(255, 255, 255, 0.9); backdrop-filter: blur(10px);">
                        <div class="d-flex justify-content-center mb-3">
                            <img id="perf-foto" src="data:image/svg+xml;utf8,<svg xmlns='http://www.w3.org/2000/svg' width='150' height='150' viewBox='0 0 24 24' fill='none' stroke='%23ccc' stroke-width='2' stroke-linecap='round' stroke-linejoin='round'><path d='M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2'></path><circle cx='12' cy='7' r='4'></circle></svg>" class="rounded-circle img-fluid border" style="width: 150px; height: 150px; object-fit: cover;" alt="Avatar">
                        </div>
                        <h4 id="perf-nombre" class="fw-bold mb-1">Cargando...</h4>
                        <p id="perf-servicio" class="text-muted mb-2">Especialidad</p>
                        <div class="d-flex justify-content-center align-items-center gap-1 mb-3">
                            <span id="perf-rating" class="fw-bold text-dark">5.0</span>
                            <span class="text-warning">★</span>
                            <span class="text-muted">(Calificación)</span>
                        </div>
                        <h4 id="perf-precio" class="text-primary fw-bold mb-4">$-- / hora</h4>
                        
                        <div class="d-grid gap-2">
                            <button id="btn-contratar" class="btn btn-primary btn-custom py-2" style="border-radius: 8px;">Contratar Servicio</button>
                            <button id="btn-chatear" class="btn btn-outline-secondary py-2" style="border-radius: 8px;">Enviar Mensaje</button>
                        </div>
                        
                        <!-- Mini mapa de ubicación -->
                        <div class="mt-4 text-start">
                            <h6 class="fw-bold mb-2"><i class="bi bi-geo-alt-fill text-danger me-1"></i>Zona de Cobertura</h6>
                            <div id="mini-mapa-profesional" style="height: 180px; border-radius: 8px; border: 1px solid #ddd; z-index: 1;"></div>
                        </div>
                    </div>
                </div>
                
                <div class="col-md-8">
                    <div class="card border-0 shadow-sm p-4" style="border-radius: 12px; background: rgba(255, 255, 255, 0.9); backdrop-filter: blur(10px);">
                        <h5 class="fw-bold mb-3"><i class="bi bi-person-badge me-2 text-primary"></i>Sobre mí</h5>
                        <p id="perf-descripcion" class="text-muted" style="line-height: 1.6;">Cargando descripción...</p>
                        
                        <hr class="my-4">
                        
                        <h5 class="fw-bold mb-3"><i class="bi bi-file-earmark-text me-2 text-primary"></i>Publicaciones de Trabajo</h5>
                        <div id="perf-publicaciones-container" class="row row-cols-1 row-cols-md-2 g-3">
                            <div class="col text-center py-3 text-muted">Buscando publicaciones...</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    `;
}

export function initPerfilProfesionalPage(id) {
    if (!id) return;
    
    // 1. Cargar datos del profesional
    fetch(`/api/usuarios-trabajadores/${id}`)
        .then(res => {
            if (!res.ok) throw new Error('Error al obtener profesional');
            return res.json();
        })
        .then(match => {
            if (match) {
                document.getElementById('perf-nombre').textContent = match.nombre;
                document.getElementById('perf-servicio').textContent = match.subespecialidades || 'Servicios Generales';
                document.getElementById('perf-rating').textContent = match.calificacionPromedio ? parseFloat(match.calificacionPromedio).toFixed(1) : '5.0';
                document.getElementById('perf-precio').textContent = `$${match.tarifaHora || 150} / hora`;
                document.getElementById('perf-descripcion').textContent = match.descripcion || 'Sin descripción disponible por el momento.';
                
                if (match.fotografiaPath) {
                    document.getElementById('perf-foto').src = match.fotografiaPath;
                } else {
                    const nombreBase = match.nombre.split(' ')[0].toLowerCase();
                    const knownAvatars = ["juan", "carlos", "maria", "luis", "fernando", "beatriz", "alicia", "andres", "clara", "elena", "gabriela", "hugo", "jorge", "manuel", "miguelina", "pedro", "ricardo", "roberto", "sonia", "tomas"];
                    if (knownAvatars.includes(nombreBase)) {
                        document.getElementById('perf-foto').src = `./assets/${nombreBase}.svg`;
                    } else {
                        document.getElementById('perf-foto').src = `./assets/juan.svg`;
                    }
                }

                // Inicializar mini-mapa si Leaflet está cargado
                if (window.L) {
                    setTimeout(() => {
                        const mapContainer = document.getElementById('mini-mapa-profesional');
                        if (mapContainer) {
                            let lat = match.latitud;
                            let lon = match.longitud;
                            
                            // fallback determinista si no tiene coordenadas reales en BD
                            if (!lat || !lon) {
                                const dir = (match.direccion || "").toLowerCase();
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
                                let resolved = false;
                                for (const key in COORD_MAP) {
                                    if (dir.includes(key)) {
                                        lat = COORD_MAP[key].lat;
                                        lon = COORD_MAP[key].lon;
                                        resolved = true;
                                        break;
                                    }
                                }
                                if (!resolved) {
                                    let hash = 0;
                                    for (let i = 0; i < dir.length; i++) {
                                        hash = dir.charCodeAt(i) + ((hash << 5) - hash);
                                    }
                                    const latOffset = (Math.abs(hash % 100)) / 1000;
                                    const lonOffset = (Math.abs((hash >> 8) % 100)) / 1000;
                                    lat = 19.4326 + latOffset;
                                    lon = -99.1332 + lonOffset;
                                }
                            }
                            
                            try {
                                const map = L.map('mini-mapa-profesional').setView([lat, lon], 14);
                                L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
                                    attribution: '&copy; OpenStreetMap'
                                }).addTo(map);
                                
                                L.marker([lat, lon]).addTo(map)
                                    .bindPopup(`<strong>${match.nombre}</strong><br>${match.direccion || 'CDMX'}`)
                                    .openPopup();
                            } catch (e) {
                                console.error("Error al inicializar mapa de Leaflet:", e);
                            }
                        }
                    }, 100);
                }
            } else {
                document.getElementById('perf-nombre').textContent = 'Profesional no encontrado';
            }
        })
        .catch(err => {
            console.error(err);
            document.getElementById('perf-nombre').textContent = 'Error al cargar datos';
        });

    // 2. Cargar publicaciones de este profesional
    fetch(`/api/publicaciones/trabajador/${id}`)
        .then(res => {
            if (!res.ok) return [];
            return res.json();
        })
        .then(filtered => {
            const container = document.getElementById('perf-publicaciones-container');
            if (!container) return;
            
            container.innerHTML = '';
            
            if (filtered.length === 0) {
                container.innerHTML = `<div class="col-12 text-muted">Este profesional no tiene publicaciones de servicios registradas aún.</div>`;
                return;
            }
            
            filtered.forEach(pub => {
                const card = document.createElement('div');
                card.className = 'col';
                
                let imgHtml = '';
                if (pub.imagenPath) {
                    imgHtml = `<img src="${pub.imagenPath}" class="card-img-top border-bottom mb-2" style="height: 140px; object-fit: cover; border-radius: 4px;" alt="Servicio">`;
                } else {
                    const cleanTitle = (pub.titulo || "").toLowerCase();
                    let defaultImg = './assets/carpintero.jpg';
                    if (cleanTitle.includes('plom') || cleanTitle.includes('tub') || cleanTitle.includes('fuga') || cleanTitle.includes('agua') || cleanTitle.includes('calentador')) {
                        defaultImg = './assets/plomero.jpg';
                    }
                    imgHtml = `<img src="${defaultImg}" class="card-img-top border-bottom mb-2" style="height: 140px; object-fit: cover; border-radius: 4px;" alt="Servicio">`;
                }

                card.innerHTML = `
                    <div class="card h-100 border p-3 shadow-sm" style="border-radius: 8px; background-color: #fafafa;">
                        ${imgHtml}
                        <h6 class="fw-bold mb-1 mt-1">${pub.titulo}</h6>
                        <p class="text-muted small mb-2" style="display: -webkit-box; -webkit-line-clamp: 3; -webkit-box-orient: vertical; overflow: hidden; min-height: 3.6em;">${pub.descripcion}</p>
                        <div class="fw-bold text-primary">$${pub.precio} MXN</div>
                    </div>
                `;
                container.appendChild(card);
            });
        })
        .catch(err => {
            console.error('Error al cargar publicaciones:', err);
            const container = document.getElementById('perf-publicaciones-container');
            if (container) {
                container.innerHTML = `<div class="col-12 text-danger">No se pudieron cargar las publicaciones.</div>`;
            }
        });

    // 3. Manejadores de botones
    const btnContratar = document.getElementById('btn-contratar');
    if (btnContratar) {
        btnContratar.addEventListener('click', () => {
            window.location.hash = `#hacer-pedido/${id}`;
        });
    }

    const btnChatear = document.getElementById('btn-chatear');
    if (btnChatear) {
        btnChatear.addEventListener('click', () => {
            window.location.hash = `#chat/${id}`;
        });
    }
}
