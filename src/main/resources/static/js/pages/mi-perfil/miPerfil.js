export function renderPerfilUsuarioPage() {
    return `
        <div class="container py-5 animate-appear">
            <div class="row">
                <!-- Sidebar de Navegación del Perfil -->
                <div class="col-md-3 mb-4">
                    <div class="card border-0 shadow-sm p-3" style="border-radius: 12px; background: rgba(255, 255, 255, 0.95); backdrop-filter: blur(10px);">
                        <div class="text-center py-3 border-bottom mb-3">
                            <div class="d-flex justify-content-center mb-2 position-relative">
                                <img id="user-prof-pic" src="data:image/svg+xml;utf8,<svg xmlns='http://www.w3.org/2000/svg' width='100' height='100' viewBox='0 0 24 24' fill='none' stroke='%23ccc' stroke-width='2' stroke-linecap='round' stroke-linejoin='round'><path d='M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2'></path><circle cx='12' cy='7' r='4'></circle></svg>" class="rounded-circle img-fluid border" style="width: 100px; height: 100px; object-fit: cover;" alt="Avatar">
                                <label for="upload-avatar" class="position-absolute bottom-0 end-0 bg-primary text-white rounded-circle d-flex align-items-center justify-content-center" style="width: 32px; height: 32px; cursor: pointer; border: 2px solid white; transform: translate(-20px, 0px);">
                                    <i class="bi bi-camera-fill" style="font-size: 0.85rem;"></i>
                                </label>
                                <input type="file" id="upload-avatar" class="d-none" accept="image/*">
                            </div>
                            <h5 id="user-prof-name" class="fw-bold mb-0">Cargando...</h5>
                            <span id="user-prof-badge" class="badge bg-secondary mt-1">Usuario Común</span>
                        </div>
                        
                        <div class="nav flex-column nav-pills" id="profile-tabs" role="tablist" aria-orientation="vertical">
                            <button class="nav-link active text-start py-2 px-3 mb-1" id="tab-info-btn" data-bs-toggle="pill" data-bs-target="#tab-info" type="button" role="tab"><i class="bi bi-person me-2"></i>Mi Perfil</button>
                            <button class="nav-link text-start py-2 px-3 mb-1" id="tab-direcciones-btn" data-bs-toggle="pill" data-bs-target="#tab-direcciones" type="button" role="tab"><i class="bi bi-geo-alt me-2"></i>Direcciones</button>
                            <button class="nav-link text-start py-2 px-3 mb-1" id="tab-pagos-btn" data-bs-toggle="pill" data-bs-target="#tab-pagos" type="button" role="tab"><i class="bi bi-credit-card me-2"></i>Métodos de Pago</button>
                            <button class="nav-link text-start py-2 px-3 mb-1" id="tab-seguridad-btn" data-bs-toggle="pill" data-bs-target="#tab-seguridad" type="button" role="tab"><i class="bi bi-shield-lock me-2"></i>Seguridad</button>
                            <button class="nav-link text-start py-2 px-3 mb-1 d-none" id="tab-profesional-btn" data-bs-toggle="pill" data-bs-target="#tab-profesional" type="button" role="tab"><i class="bi bi-briefcase me-2"></i>Panel Profesional</button>
                            <button class="nav-link text-start py-2 px-3 mb-1 d-none" id="tab-publicaciones-btn" data-bs-toggle="pill" data-bs-target="#tab-publicaciones" type="button" role="tab"><i class="bi bi-card-list me-2"></i>Mis Publicaciones</button>
                        </div>
                    </div>
                </div>
                
                <!-- Contenido de las Pestañas -->
                <div class="col-md-9">
                    <div class="card border-0 shadow-sm p-4" style="border-radius: 12px; background: rgba(255, 255, 255, 0.95); backdrop-filter: blur(10px); min-height: 480px;">
                        <div class="tab-content" id="profile-tabs-content">
                            
                            <!-- 1. MI PERFIL -->
                            <div class="tab-pane fade show active" id="tab-info" role="tabpanel">
                                <h4 class="fw-bold mb-4 text-primary">Información General</h4>
                                <form id="form-perfil-general">
                                    <div class="row g-3">
                                        <div class="col-md-6">
                                            <label class="form-label fw-bold">Nombre Completo</label>
                                            <input type="text" id="prof-input-nombre" class="form-control py-2" required>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label fw-bold">Correo Electrónico</label>
                                            <input type="email" id="prof-input-email" class="form-control py-2" disabled>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label fw-bold">Número de Teléfono</label>
                                            <input type="text" id="prof-input-telefono" class="form-control py-2" required>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-primary btn-custom mt-4 px-4 py-2" style="border-radius: 8px;">Guardar Cambios</button>
                                </form>
                            </div>
                            
                            <!-- 2. DIRECCIONES -->
                            <div class="tab-pane fade" id="tab-direcciones" role="tabpanel">
                                <h4 class="fw-bold mb-4 text-primary">Direcciones Guardadas</h4>
                                <div class="row g-3 mb-4">
                                    <div class="col-md-6">
                                        <div class="card border p-3 shadow-sm h-100" style="border-radius: 8px;">
                                            <div class="d-flex justify-content-between align-items-start mb-2">
                                                <span class="badge bg-primary">Principal</span>
                                                <i class="bi bi-house-door text-muted" style="font-size: 1.2rem;"></i>
                                            </div>
                                            <h6 class="fw-bold mb-1">Domicilio Residencial</h6>
                                            <p class="text-muted small mb-0">Calle Paseo de la Reforma 115, Col. Centro, Delegación Cuauhtémoc, CDMX, C.P. 06000</p>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="card border p-3 shadow-sm h-100" style="border-radius: 8px; border-style: dashed !important; background-color: #fafafa; cursor: pointer;">
                                            <div class="d-flex flex-column align-items-center justify-content-center h-100 py-3">
                                                <i class="bi bi-plus-circle display-6 text-muted mb-2"></i>
                                                <h6 class="fw-bold text-muted mb-0">Agregar nueva dirección</h6>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <!-- 3. MÉTODOS DE PAGO -->
                            <div class="tab-pane fade" id="tab-pagos" role="tabpanel">
                                <h4 class="fw-bold mb-4 text-primary">Métodos de Pago</h4>
                                <div class="row g-3">
                                    <div class="col-md-6">
                                        <!-- Tarjeta de Crédito Premium -->
                                        <div class="p-4 text-white shadow-sm" style="border-radius: 12px; background: linear-gradient(135deg, #1e3c72 0%, #2a5298 100%); height: 180px; position: relative;">
                                            <div class="d-flex justify-content-between align-items-start">
                                                <div>
                                                    <small class="opacity-75">FYNDR Card</small>
                                                    <h5 class="fw-bold mb-0 mt-1">Visa Classic</h5>
                                                </div>
                                                <i class="bi bi-wallet2" style="font-size: 1.5rem;"></i>
                                            </div>
                                            <div class="my-3 text-center">
                                                <span class="fs-5 tracking-wide">••••  ••••  ••••  4829</span>
                                            </div>
                                            <div class="position-absolute bottom-0 start-0 p-4 w-100 d-flex justify-content-between">
                                                <div>
                                                    <small class="opacity-50 text-uppercase" style="font-size: 0.65rem;">Titular</small>
                                                    <div class="small fw-bold" id="card-holder-name">Nombre de Usuario</div>
                                                </div>
                                                <div class="text-end">
                                                    <small class="opacity-50 text-uppercase" style="font-size: 0.65rem;">Vence</small>
                                                    <div class="small fw-bold">12/29</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="card border p-4 shadow-sm h-100" style="border-radius: 12px; border-style: dashed !important; background-color: #fafafa; cursor: pointer;">
                                            <div class="d-flex flex-column align-items-center justify-content-center h-100 py-3">
                                                <i class="bi bi-plus-circle display-6 text-muted mb-2"></i>
                                                <h6 class="fw-bold text-muted mb-0">Agregar tarjeta bancaria</h6>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <!-- 4. SEGURIDAD -->
                            <div class="tab-pane fade" id="tab-seguridad" role="tabpanel">
                                <h4 class="fw-bold mb-4 text-primary">Seguridad de la Cuenta</h4>
                                <form id="form-perfil-password">
                                    <div class="row g-3">
                                        <div class="col-md-6">
                                            <label class="form-label fw-bold">Nueva Contraseña</label>
                                            <input type="password" id="prof-input-newpass" class="form-control py-2" required>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label fw-bold">Confirmar Nueva Contraseña</label>
                                            <input type="password" id="prof-input-confpass" class="form-control py-2" required>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-primary btn-custom mt-4 px-4 py-2" style="border-radius: 8px;">Actualizar Contraseña</button>
                                </form>
                            </div>
                            
                            <!-- 5. PANEL PROFESIONAL (Únicamente para Trabajadores) -->
                            <div class="tab-pane fade" id="tab-profesional" role="tabpanel">
                                <h4 class="fw-bold mb-4 text-primary">Configuración del Profesional</h4>
                                <form id="form-perfil-profesional">
                                    <div class="row g-3">
                                        <div class="col-md-6">
                                            <label class="form-label fw-bold">Tarifa por Hora (MXN)</label>
                                            <input type="number" id="prof-input-tarifa" class="form-control py-2" required>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label fw-bold">Años de Experiencia</label>
                                            <input type="number" id="prof-input-experiencia" class="form-control py-2" required>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label fw-bold">Especialidades (Separado por comas)</label>
                                            <input type="text" id="prof-input-subspecialidades" class="form-control py-2" placeholder="Ej. Reparaciones, Instalaciones" required>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label fw-bold">Banco</label>
                                            <input type="text" id="prof-input-banco" class="form-control py-2" placeholder="Ej. BBVA">
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label fw-bold">CLABE Bancaria (18 dígitos)</label>
                                            <input type="text" id="prof-input-clabe" class="form-control py-2" placeholder="0121800...">
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label fw-bold">RFC</label>
                                            <input type="text" id="prof-input-rfc" class="form-control py-2" placeholder="ABCD123456...">
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label fw-bold">CURP</label>
                                            <input type="text" id="prof-input-curp" class="form-control py-2" placeholder="ABCD123456...">
                                        </div>
                                        <div class="col-md-12">
                                            <label class="form-label fw-bold">Dirección Completa de Trabajo (para cálculo de distancia en km)</label>
                                            <input type="text" id="prof-input-direccion" class="form-control py-2" placeholder="Ej. Paseo de la Reforma 115, CDMX" required>
                                        </div>
                                        <div class="col-12">
                                            <label class="form-label fw-bold">Descripción sobre tus servicios</label>
                                            <textarea id="prof-input-descripcion" class="form-control py-2" rows="4" required></textarea>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-primary btn-custom mt-4 px-4 py-2" style="border-radius: 8px;">Guardar Configuración</button>
                                </form>
                            </div>

                            <!-- 6. MIS PUBLICACIONES (Únicamente para Trabajadores) -->
                            <div class="tab-pane fade" id="tab-publicaciones" role="tabpanel">
                                <div class="d-flex justify-content-between align-items-center mb-4">
                                    <h4 class="fw-bold mb-0 text-primary">Mis Publicaciones de Servicios</h4>
                                    <a href="#crear-publicacion" class="btn btn-sm btn-primary px-3" style="border-radius: 8px;"><i class="bi bi-plus-circle me-1"></i>Crear Publicación</a>
                                </div>
                                <div id="panel-publicaciones-list" class="row row-cols-1 g-3">
                                    <div class="col text-center py-4 text-muted">Cargando tus publicaciones...</div>
                                </div>
                            </div>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    `;
}

export function initPerfilUsuarioPage() {
    const currentUser = JSON.parse(localStorage.getItem('currentUser') || 'null');
    const token = localStorage.getItem('token');
    
    if (!currentUser || !currentUser.email) {
        window.alert("Debes iniciar sesión para configurar tu perfil.");
        window.location.hash = '#login';
        return;
    }

    let userEntity = null;
    let userRole = 'comun'; // o 'trabajador'

    const cargarMisPublicaciones = async (trabajadorId) => {
        try {
            const res = await fetch(`/api/publicaciones/trabajador/${trabajadorId}`);
            const listContainer = document.getElementById('panel-publicaciones-list');
            if (!listContainer) return;
            
            listContainer.innerHTML = '';
            
            if (!res.ok) {
                listContainer.innerHTML = `<div class="col text-center py-4 text-danger">No se pudieron cargar tus publicaciones.</div>`;
                return;
            }
            
            const pubs = await res.json();
            if (pubs.length === 0) {
                listContainer.innerHTML = `
                    <div class="col text-center py-5 text-muted border rounded" style="border-style: dashed !important; background-color: #fafafa;">
                        <i class="bi bi-card-list display-4 mb-2 d-block text-secondary"></i>
                        <h6 class="fw-bold">Aún no tienes publicaciones</h6>
                        <p class="small mb-3">Publica tus servicios para que las personas te puedan contratar.</p>
                        <a href="#crear-publicacion" class="btn btn-sm btn-primary px-3" style="border-radius: 8px;">Crear mi primera publicación</a>
                    </div>
                `;
                return;
            }
            
            pubs.forEach(pub => {
                const item = document.createElement('div');
                item.className = 'col';
                
                let imgHtml = '';
                if (pub.imagenPath) {
                    imgHtml = `<img src="${pub.imagenPath}" class="rounded border me-3" style="width: 80px; height: 80px; object-fit: cover;" alt="Evidencia">`;
                } else {
                    const cleanTitle = (pub.titulo || "").toLowerCase();
                    let defaultImg = './assets/carpintero.jpg';
                    if (cleanTitle.includes('plom') || cleanTitle.includes('tub') || cleanTitle.includes('fuga') || cleanTitle.includes('agua') || cleanTitle.includes('calentador')) {
                        defaultImg = './assets/plomero.jpg';
                    }
                    imgHtml = `<img src="${defaultImg}" class="rounded border me-3" style="width: 80px; height: 80px; object-fit: cover;" alt="Evidencia">`;
                }
                
                item.innerHTML = `
                    <div class="card border p-3 shadow-sm" style="border-radius: 10px; background-color: #fcfdfe;">
                        <div class="d-flex align-items-center">
                            ${imgHtml}
                            <div class="flex-grow-1 min-w-0">
                                <h6 class="fw-bold mb-1 text-truncate">${pub.titulo}</h6>
                                <p class="text-muted small mb-1 text-truncate-2" style="max-height: 2.8em; overflow: hidden;">${pub.descripcion}</p>
                                <span class="fw-bold text-primary">$${pub.precio} MXN</span>
                            </div>
                            <div class="ms-3">
                                <button class="btn btn-sm btn-outline-danger btn-eliminar-pub" data-pub-id="${pub.id}">
                                    <i class="bi bi-trash-fill"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                `;
                listContainer.appendChild(item);
            });
            
            // Agregar listeners de eliminación
            listContainer.querySelectorAll('.btn-eliminar-pub').forEach(btn => {
                btn.addEventListener('click', async (e) => {
                    const pubId = btn.getAttribute('data-pub-id');
                    if (window.confirm('¿Estás seguro de que deseas eliminar esta publicación?')) {
                        try {
                            const delRes = await fetch(`/api/publicaciones/${pubId}`, {
                                method: 'DELETE',
                                headers: {
                                    'Authorization': `Bearer ${token}`
                                }
                            });
                            if (delRes.ok) {
                                window.alert('Publicación eliminada con éxito.');
                                cargarMisPublicaciones(trabajadorId);
                            } else {
                                window.alert('No se pudo eliminar la publicación.');
                            }
                        } catch (err) {
                            console.error('Error al eliminar publicación:', err);
                            window.alert('Error de red al intentar eliminar la publicación.');
                        }
                    }
                });
            });
            
        } catch (err) {
            console.error('Error al cargar publicaciones en el panel:', err);
        }
    };

    // 1. Cargar la sesión desde el backend e identificar rol
    const loadSessionData = async () => {
        try {
            const res = await fetch('/api/auth/me', {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            });
            if (res.ok) {
                const me = await res.json();
                userRole = me.role;
                
                if (me.role === 'comun') {
                    // Cargar detalles completos del comun
                    const resComun = await fetch(`/api/usuarios-comunes/${me.id}`, {
                        headers: {
                            'Authorization': `Bearer ${token}`
                        }
                    });
                    if (resComun.ok) {
                        userEntity = await resComun.json();
                        populateGeneralInfo(userEntity, 'comun');
                    }
                } else if (me.role === 'trabajador') {
                    // Cargar detalles completos del trabajador
                    const resWorker = await fetch(`/api/usuarios-trabajadores/${me.id}`, {
                        headers: {
                            'Authorization': `Bearer ${token}`
                        }
                    });
                    if (resWorker.ok) {
                        userEntity = await resWorker.json();
                        populateGeneralInfo(userEntity, 'trabajador');
                        populateWorkerInfo(userEntity);
                    }
                    
                    // Mostrar la pestaña de configuración del profesional
                    const profBtn = document.getElementById('tab-profesional-btn');
                    if (profBtn) profBtn.classList.remove('d-none');

                    const pubsBtn = document.getElementById('tab-publicaciones-btn');
                    if (pubsBtn) pubsBtn.classList.remove('d-none');
                    
                    cargarMisPublicaciones(me.id);
                }
            } else {
                window.alert("Sesión expirada.");
                window.location.hash = '#login';
            }
        } catch (err) {
            console.error('Error al cargar la información del perfil:', err);
        }
    };

    const populateGeneralInfo = (user, role) => {
        document.getElementById('user-prof-name').textContent = user.nombre;
        document.getElementById('user-prof-badge').textContent = role === 'trabajador' ? 'Profesional verificado' : 'Usuario Común';
        document.getElementById('user-prof-badge').className = role === 'trabajador' ? 'badge bg-success mt-1' : 'badge bg-secondary mt-1';
        
        document.getElementById('prof-input-nombre').value = user.nombre;
        document.getElementById('prof-input-email').value = user.email;
        document.getElementById('prof-input-telefono').value = user.telefono || '';
        
        const cardHolder = document.getElementById('card-holder-name');
        if (cardHolder) cardHolder.textContent = user.nombre;

        // Avatar
        const avatarImg = document.getElementById('user-prof-pic');
        if (avatarImg) {
            if (user.fotografiaPath) {
                avatarImg.src = user.fotografiaPath;
            } else {
                const nombreBase = user.nombre.split(' ')[0].toLowerCase();
                const knownAvatars = ["juan", "carlos", "maria", "luis", "fernando", "beatriz", "alicia", "andres", "clara", "elena", "gabriela", "hugo", "jorge", "manuel", "miguelina", "pedro", "ricardo", "roberto", "sonia", "tomas"];
                if (knownAvatars.includes(nombreBase)) {
                    avatarImg.src = `./assets/${nombreBase}.svg`;
                } else {
                    avatarImg.src = `./assets/juan.svg`;
                }
            }
        }
    };

    const populateWorkerInfo = (worker) => {
        document.getElementById('prof-input-tarifa').value = worker.tarifaHora || 150;
        document.getElementById('prof-input-experiencia').value = worker.experienciaAnos || 0;
        document.getElementById('prof-input-subspecialidades').value = worker.subespecialidades || '';
        document.getElementById('prof-input-banco').value = worker.banco || '';
        document.getElementById('prof-input-clabe').value = worker.clabe || '';
        document.getElementById('prof-input-rfc').value = worker.rfc || '';
        document.getElementById('prof-input-curp').value = worker.curp || '';
        document.getElementById('prof-input-direccion').value = worker.direccion || '';
        document.getElementById('prof-input-descripcion').value = worker.descripcion || '';
    };

    loadSessionData();

    // 2. Manejar envío de información general (Común o Trabajador)
    const formGeneral = document.getElementById('form-perfil-general');
    if (formGeneral) {
        formGeneral.addEventListener('submit', async (e) => {
            e.preventDefault();
            if (!userEntity) return;

            const updatedNombre = document.getElementById('prof-input-nombre').value;
            const updatedTelefono = document.getElementById('prof-input-telefono').value;

            try {
                if (userRole === 'comun') {
                    const payload = {
                        nombre: updatedNombre,
                        email: userEntity.email,
                        telefono: updatedTelefono,
                        contrasena: userEntity.contrasena // mantenemos contraseña
                    };

                    const res = await fetch(`/api/usuarios-comunes/${userEntity.id}`, {
                        method: 'PUT',
                        headers: {
                            'Content-Type': 'application/json',
                            'Authorization': `Bearer ${token}`
                        },
                        body: JSON.stringify(payload)
                    });

                    if (res.ok) {
                        window.alert('¡Perfil actualizado con éxito!');
                        // Actualizar local storage
                        currentUser.nombre = updatedNombre;
                        localStorage.setItem('currentUser', JSON.stringify(currentUser));
                        window.location.reload();
                    } else {
                        window.alert('No se pudo guardar la información del perfil.');
                    }
                } else {
                    // Trabajador
                    const payload = {
                        nombre: updatedNombre,
                        email: userEntity.email,
                        telefono: updatedTelefono,
                        contrasena: userEntity.contrasena,
                        fechaNacimiento: userEntity.fechaNacimiento,
                        inePath: userEntity.inePath,
                        curp: userEntity.curp,
                        fotografiaPath: userEntity.fotografiaPath,
                        comprobantePath: userEntity.comprobantePath,
                        antecedentesPath: userEntity.antecedentesPath,
                        experienciaAnos: userEntity.experienciaAnos,
                        descripcion: userEntity.descripcion,
                        subspecialidades: userEntity.subespecialidades,
                        direccion: userEntity.direccion,
                        certificacionesPath: userEntity.certificacionesPath,
                        portafolioPath: userEntity.portafolioPath,
                        rfc: userEntity.rfc,
                        constanciaFiscalPath: userEntity.constanciaFiscalPath,
                        clabe: userEntity.clabe,
                        banco: userEntity.banco,
                        tarifaHora: userEntity.tarifaHora,
                        calificacionPromedio: userEntity.calificacionPromedio
                    };

                    const res = await fetch(`/api/usuarios-trabajadores/${userEntity.id}`, {
                        method: 'PUT',
                        headers: {
                            'Content-Type': 'application/json',
                            'Authorization': `Bearer ${token}`
                        },
                        body: JSON.stringify(payload)
                    });

                    if (res.ok) {
                        window.alert('¡Perfil actualizado con éxito!');
                        currentUser.nombre = updatedNombre;
                        localStorage.setItem('currentUser', JSON.stringify(currentUser));
                        window.location.reload();
                    } else {
                        window.alert('No se pudo guardar la información del perfil.');
                    }
                }
            } catch (err) {
                console.error(err);
                window.alert('Error de conexión al guardar cambios.');
            }
        });
    }

    // 3. Manejar envío de información adicional de profesional
    const formProfesional = document.getElementById('form-perfil-profesional');
    if (formProfesional) {
        formProfesional.addEventListener('submit', async (e) => {
            e.preventDefault();
            if (userRole !== 'trabajador' || !userEntity) return;

            const updatedTarifa = parseFloat(document.getElementById('prof-input-tarifa').value);
            const updatedExperiencia = parseInt(document.getElementById('prof-input-experiencia').value);
            const updatedSubspecialidades = document.getElementById('prof-input-subspecialidades').value;
            const updatedBanco = document.getElementById('prof-input-banco').value;
            const updatedClabe = document.getElementById('prof-input-clabe').value;
            const updatedRfc = document.getElementById('prof-input-rfc').value;
            const updatedCurp = document.getElementById('prof-input-curp').value;
            const updatedDireccion = document.getElementById('prof-input-direccion').value;
            const updatedDescripcion = document.getElementById('prof-input-descripcion').value;

            try {
                const payload = {
                    nombre: userEntity.nombre,
                    email: userEntity.email,
                    telefono: userEntity.telefono,
                    contrasena: userEntity.contrasena,
                    fechaNacimiento: userEntity.fechaNacimiento,
                    inePath: userEntity.inePath,
                    curp: updatedCurp,
                    fotografiaPath: userEntity.fotografiaPath,
                    comprobantePath: userEntity.comprobantePath,
                    antecedentesPath: userEntity.antecedentesPath,
                    experienciaAnos: updatedExperiencia,
                    descripcion: updatedDescripcion,
                    subspecialidades: updatedSubspecialidades,
                    direccion: updatedDireccion,
                    certificacionesPath: userEntity.certificacionesPath,
                    portafolioPath: userEntity.portafolioPath,
                    rfc: updatedRfc,
                    constanciaFiscalPath: userEntity.constanciaFiscalPath,
                    clabe: updatedClabe,
                    banco: updatedBanco,
                    tarifaHora: updatedTarifa,
                    calificacionPromedio: userEntity.calificacionPromedio
                };

                const res = await fetch(`/api/usuarios-trabajadores/${userEntity.id}`, {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': `Bearer ${token}`
                    },
                    body: JSON.stringify(payload)
                });

                if (res.ok) {
                    window.alert('¡Configuración profesional guardada con éxito!');
                    window.location.reload();
                } else {
                    window.alert('No se pudo guardar la configuración profesional.');
                }
            } catch (err) {
                console.error(err);
                window.alert('Error de conexión.');
            }
        });
    }

    // 4. Actualización de Contraseña
    const formPassword = document.getElementById('form-perfil-password');
    if (formPassword) {
        formPassword.addEventListener('submit', async (e) => {
            e.preventDefault();
            if (!userEntity) return;

            const newPass = document.getElementById('prof-input-newpass').value;
            const confPass = document.getElementById('prof-input-confpass').value;

            if (newPass !== confPass) {
                window.alert('Las contraseñas nuevas no coinciden.');
                return;
            }

            try {
                if (userRole === 'comun') {
                    const payload = {
                        nombre: userEntity.nombre,
                        email: userEntity.email,
                        telefono: userEntity.telefono,
                        contrasena: newPass
                    };

                    const res = await fetch(`/api/usuarios-comunes/${userEntity.id}`, {
                        method: 'PUT',
                        headers: {
                            'Content-Type': 'application/json',
                            'Authorization': `Bearer ${token}`
                        },
                        body: JSON.stringify(payload)
                    });

                    if (res.ok) {
                        window.alert('¡Contraseña actualizada con éxito!');
                        formPassword.reset();
                    } else {
                        window.alert('No se pudo actualizar la contraseña.');
                    }
                } else {
                    // Trabajador
                    const payload = {
                        nombre: userEntity.nombre,
                        email: userEntity.email,
                        telefono: userEntity.telefono,
                        contrasena: newPass,
                        fechaNacimiento: userEntity.fechaNacimiento,
                        inePath: userEntity.inePath,
                        curp: userEntity.curp,
                        fotografiaPath: userEntity.fotografiaPath,
                        comprobantePath: userEntity.comprobantePath,
                        antecedentesPath: userEntity.antecedentesPath,
                        experienciaAnos: userEntity.experienciaAnos,
                        descripcion: userEntity.descripcion,
                        subspecialidades: userEntity.subespecialidades,
                        certificacionesPath: userEntity.certificacionesPath,
                        portafolioPath: userEntity.portafolioPath,
                        rfc: userEntity.rfc,
                        constanciaFiscalPath: userEntity.constanciaFiscalPath,
                        clabe: userEntity.clabe,
                        banco: userEntity.banco,
                        tarifaHora: userEntity.tarifaHora,
                        calificacionPromedio: userEntity.calificacionPromedio
                    };

                    const res = await fetch(`/api/usuarios-trabajadores/${userEntity.id}`, {
                        method: 'PUT',
                        headers: {
                            'Content-Type': 'application/json',
                            'Authorization': `Bearer ${token}`
                        },
                        body: JSON.stringify(payload)
                    });

                    if (res.ok) {
                        window.alert('¡Contraseña actualizada con éxito!');
                        formPassword.reset();
                    } else {
                        window.alert('No se pudo actualizar la contraseña.');
                    }
                }
            } catch (err) {
                console.error(err);
                window.alert('Error de conexión.');
            }
        });
    }

    // 5. Manejo de selección/subida de Avatar
    const uploadAvatar = document.getElementById('upload-avatar');
    if (uploadAvatar) {
        uploadAvatar.addEventListener('change', (e) => {
            const file = e.target.files[0];
            if (file) {
                const reader = new FileReader();
                reader.onload = async function(event) {
                    const base64Data = event.target.result;
                    const img = document.getElementById('user-prof-pic');
                    if (img) img.src = base64Data;

                    // Persistir el avatar en la base de datos
                    try {
                        const updatedPayload = { ...userEntity, fotografiaPath: base64Data };
                        const url = userRole === 'comun' 
                            ? `/api/usuarios-comunes/${userEntity.id}` 
                            : `/api/usuarios-trabajadores/${userEntity.id}`;

                        const res = await fetch(url, {
                            method: 'PUT',
                            headers: {
                                'Content-Type': 'application/json',
                                'Authorization': `Bearer ${token}`
                            },
                            body: JSON.stringify(updatedPayload)
                        });

                        if (res.ok) {
                            userEntity.fotografiaPath = base64Data;
                            console.log("Avatar actualizado y guardado en la base de datos exitosamente.");
                        } else {
                            console.error("Error al guardar el avatar en el servidor.");
                        }
                    } catch (err) {
                        console.error("Error de red al actualizar el avatar:", err);
                    }
                };
                reader.readAsDataURL(file);
            }
        });
    }
}
