export function renderHacerPedidoPage(id) {
    return `
        <div class="container py-5 animate-appear">
            <div class="row justify-content-center">
                <div class="col-md-8">
                    <div class="card border-0 shadow-sm p-4" style="border-radius: 12px; background: rgba(255, 255, 255, 0.9); backdrop-filter: blur(10px);">
                        <h4 class="fw-bold text-center mb-4"><i class="bi bi-calendar-check text-primary me-2"></i>Solicitud de Servicio</h4>
                        
                        <div class="alert alert-info border-0 p-3" style="border-radius: 8px;">
                            <strong>Estás contratando a:</strong> <span id="contrat-nombre">Cargando...</span>
                            <br>
                            <strong>Especialidad:</strong> <span id="contrat-servicio">Cargando...</span>
                        </div>
                        
                        <form id="form-pedido">
                            <div class="mb-3">
                                <label class="form-label fw-bold">Fecha y Hora del Servicio</label>
                                <input type="datetime-local" id="pedido-fecha" class="form-control" required>
                            </div>
                            
                            <div class="mb-3">
                                <label class="form-label fw-bold">Indicaciones o descripción del problema</label>
                                <textarea id="pedido-detalles" class="form-control" rows="4" placeholder="Describe brevemente el trabajo que necesitas (ej. gotera en cocina, cambiar tubería, etc.)" required></textarea>
                            </div>
                            
                            <div class="mb-3">
                                <label class="form-label fw-bold">Dirección del domicilio</label>
                                <input type="text" id="pedido-direccion" class="form-control" placeholder="Ej. Calle Reforma #123, Col. Centro" required>
                            </div>
                            
                            <div class="d-grid gap-2 mt-4">
                                <button type="submit" class="btn btn-primary btn-custom py-2" style="border-radius: 8px;">Confirmar Contratación</button>
                                <button type="button" id="btn-cancelar-pedido" class="btn btn-outline-secondary py-2" style="border-radius: 8px;">Volver al Perfil</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    `;
}

export function initHacerPedidoPage(id) {
    if (!id) return;

    // 1. Cargar datos del profesional a contratar
    fetch(`/api/usuarios-trabajadores/${id}`)
        .then(res => res.json())
        .then(match => {
            if (match) {
                document.getElementById('contrat-nombre').textContent = match.nombre;
                document.getElementById('contrat-servicio').textContent = match.subespecialidades || 'Servicios Generales';
            }
        })
        .catch(err => console.error(err));

    // 2. Volver al perfil
    const btnCancelar = document.getElementById('btn-cancelar-pedido');
    if (btnCancelar) {
        btnCancelar.addEventListener('click', () => {
            window.location.hash = `#perfil-profesional/${id}`;
        });
    }

    // 3. Enviar solicitud de contratación
    const form = document.getElementById('form-pedido');
    if (form) {
        form.addEventListener('submit', async (e) => {
            e.preventDefault();
            
            const token = localStorage.getItem('token');
            if (!token) {
                window.alert("Debes iniciar sesión para realizar un pedido.");
                window.location.hash = '#login';
                return;
            }

            try {
                // Obtener ID del usuario común logueado
                const resMe = await fetch('/api/auth/me', {
                    headers: {
                        'Authorization': `Bearer ${token}`
                    }
                });
                if (!resMe.ok) throw new Error("Error al consultar usuario");
                const me = await resMe.json();
                
                if (me.role !== 'comun') {
                    window.alert("Solo las cuentas de usuarios comunes pueden solicitar contrataciones.");
                    return;
                }

                const fechaVal = document.getElementById('pedido-fecha').value; // Formato: YYYY-MM-DDTHH:MM
                const localDateTimeStr = fechaVal + ":00"; 
                
                const contratacionPayload = {
                    idUsuarioComun: me.id,
                    idUsuarioTrabajador: parseInt(id),
                    fechaContratacion: localDateTimeStr,
                    estado: 'Pendiente'
                };

                const response = await fetch('/api/contrataciones', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': `Bearer ${token}`
                    },
                    body: JSON.stringify(contratacionPayload)
                });

                if (response.ok) {
                    window.alert("¡Solicitud de contratación realizada con éxito!");
                    window.location.hash = `#perfil-profesional/${id}`;
                } else {
                    const errData = await response.text();
                    window.alert(`Error al registrar contratación: ${errData}`);
                }
            } catch (error) {
                console.error("Error:", error);
                window.alert(`Error de red: ${error.message}`);
            }
        });
    }
}
