let chatInterval = null;

export function renderChatPage(id) {
    return `
        <div class="container py-5 animate-appear">
            <div class="row justify-content-center">
                <div class="col-md-8">
                    <div class="card border-0 shadow-sm" style="border-radius: 12px; background: rgba(255, 255, 255, 0.95); backdrop-filter: blur(10px); height: 600px; display: flex; flex-direction: column;">
                        
                        <!-- Chat Header -->
                        <div class="card-header bg-primary text-white p-3 d-flex align-items-center justify-content-between" style="border-top-left-radius: 12px; border-top-right-radius: 12px;">
                            <div class="d-flex align-items-center gap-3">
                                <button id="btn-back-profile" class="btn btn-link text-white p-0" style="font-size: 1.5rem;"><i class="bi bi-arrow-left"></i></button>
                                <div>
                                    <h5 id="chat-nombre" class="fw-bold mb-0">Cargando...</h5>
                                    <small id="chat-servicio" class="opacity-75">Servicios de Soporte</small>
                                </div>
                            </div>
                            <span class="badge bg-success">En línea</span>
                        </div>
                        
                        <!-- Chat Messages -->
                        <div id="chat-messages-container" class="card-body p-4" style="flex: 1; overflow-y: auto; background-color: #f7f9fa; display: flex; flex-direction: column; gap: 15px;">
                            <div class="text-center py-5 text-muted">Iniciando conversación...</div>
                        </div>
                        
                        <!-- Chat Input -->
                        <div class="card-footer bg-white p-3 border-0" style="border-bottom-left-radius: 12px; border-bottom-right-radius: 12px;">
                            <form id="chat-form" class="d-flex gap-2">
                                <input type="text" id="chat-input" class="form-control py-2 px-3" placeholder="Escribe un mensaje aquí..." style="border-radius: 20px; border: 1px solid #ced4da;" required autocomplete="off">
                                <button type="submit" class="btn btn-primary d-flex align-items-center justify-content-center" style="width: 45px; height: 45px; border-radius: 50%;">
                                    <i class="bi bi-send-fill" style="font-size: 1.1rem;"></i>
                                </button>
                            </form>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
    `;
}

export function initChatPage(id) {
    if (!id) return;
    
    const currentUser = JSON.parse(localStorage.getItem('currentUser') || 'null');
    const token = localStorage.getItem('token');
    
    if (!currentUser || !currentUser.email || !token) {
        window.alert("Debes iniciar sesión para acceder al chat.");
        window.location.hash = '#login';
        return;
    }

    let userId = null;
    let userRole = 'comun'; // o 'trabajador'
    let otherId = parseInt(id);

    // 1. Obtener información del profesional
    const fetchWorkerInfo = async (wId) => {
        try {
            const res = await fetch(`/api/usuarios-trabajadores/${wId}`);
            if (res.ok) {
                const match = await res.json();
                document.getElementById('chat-nombre').textContent = match.nombre;
                document.getElementById('chat-servicio').textContent = match.subespecialidades || 'Servicios Generales';
            }
        } catch (err) {
            console.error(err);
        }
    };

    // Obtener información del cliente
    const fetchClientInfo = async (cId) => {
        try {
            const res = await fetch(`/api/usuarios-comunes/${cId}`);
            if (res.ok) {
                const match = await res.json();
                document.getElementById('chat-nombre').textContent = match.nombre;
                document.getElementById('chat-servicio').textContent = 'Cliente de Fyndr';
            }
        } catch (err) {
            console.error(err);
        }
    };

    // 2. Obtener el ID y Rol del usuario común/trabajador logueado
    const fetchUserSession = async () => {
        try {
            const res = await fetch('/api/auth/me', {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            });
            if (res.ok) {
                const me = await res.json();
                userId = me.id;
                userRole = me.role;

                if (userRole === 'comun') {
                    fetchWorkerInfo(otherId);
                } else {
                    fetchClientInfo(otherId);
                }

                // Iniciar la carga de mensajes y polling
                loadMessages();
                if (chatInterval) clearInterval(chatInterval);
                chatInterval = setInterval(loadMessages, 3000);
            }
        } catch (err) {
            console.error('Error al resolver sesión de chat:', err);
        }
    };

    // 3. Cargar y filtrar los mensajes
    const loadMessages = async () => {
        if (!userId) return;
        
        try {
            const comunId = userRole === 'comun' ? userId : otherId;
            const trabId = userRole === 'trabajador' ? userId : otherId;
            
            const response = await fetch(`/api/mensajes/conversacion?idUsuarioComun=${comunId}&idUsuarioTrabajador=${trabId}`, {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            });
            if (response.ok) {
                const filtrados = await response.json();
                
                const container = document.getElementById('chat-messages-container');
                if (!container) return;
                
                if (filtrados.length === 0) {
                    container.innerHTML = `<div class="text-center py-5 text-muted">No hay mensajes anteriores. ¡Escribe el primero!</div>`;
                    return;
                }
                
                container.innerHTML = '';
                filtrados.forEach(msg => {
                    const isMe = (userRole === 'comun' && msg.remitente === 'comun') || 
                                 (userRole === 'trabajador' && msg.remitente === 'trabajador');
                    
                    const bubbleWrapper = document.createElement('div');
                    bubbleWrapper.className = `d-flex ${isMe ? 'justify-content-end' : 'justify-content-start'} mb-2`;
                    
                    bubbleWrapper.innerHTML = `
                        <div class="p-3" style="max-width: 70%; border-radius: 15px; 
                             background-color: ${isMe ? '#0d6efd' : '#e9ecef'}; 
                             color: ${isMe ? 'white' : 'black'};
                             box-shadow: 0 1px 2px rgba(0,0,0,0.1);">
                            <p class="mb-1" style="font-size: 0.95rem;">${msg.contenido}</p>
                            <small class="d-block text-end opacity-75" style="font-size: 0.75rem;">
                                ${new Date(msg.fechaEnvio).toLocaleTimeString([], {hour: '2-digit', minute:'2-digit'})}
                            </small>
                        </div>
                    `;
                    container.appendChild(bubbleWrapper);
                });
                
                container.scrollTop = container.scrollHeight;
            }
        } catch (err) {
            console.error('Error al cargar mensajes:', err);
        }
    };

    fetchUserSession();

    // 4. Enviar un nuevo mensaje
    const form = document.getElementById('chat-form');
    if (form) {
        form.addEventListener('submit', async (e) => {
            e.preventDefault();
            const input = document.getElementById('chat-input');
            const texto = input?.value.trim();
            if (!texto || !userId) return;
            
            try {
                const now = new Date();
                const pad = (num) => String(num).padStart(2, '0');
                const localIsoString = `${now.getFullYear()}-${pad(now.getMonth()+1)}-${pad(now.getDate())}T${pad(now.getHours())}:${pad(now.getMinutes())}:${pad(now.getSeconds())}`;
                
                const comunId = userRole === 'comun' ? userId : otherId;
                const trabId = userRole === 'trabajador' ? userId : otherId;

                const payload = {
                    idUsuarioComun: comunId,
                    idUsuarioTrabajador: trabId,
                    remitente: userRole,
                    contenido: texto,
                    fechaEnvio: localIsoString
                };

                const res = await fetch('/api/mensajes', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': `Bearer ${token}`
                    },
                    body: JSON.stringify(payload)
                });

                if (res.ok) {
                    input.value = '';
                    loadMessages();
                }
            } catch (err) {
                console.error('Error al enviar mensaje:', err);
            }
        });
    }

    // 5. Botón de volver
    const btnBack = document.getElementById('btn-back-profile');
    if (btnBack) {
        btnBack.addEventListener('click', () => {
            if (chatInterval) clearInterval(chatInterval);
            if (userRole === 'comun') {
                window.location.hash = `#perfil-profesional/${id}`;
            } else {
                window.location.hash = `#mi-perfil`;
            }
        });
    }
    
    // Limpieza al cambiar de hash
    const cleanUp = () => {
        if (chatInterval) {
            clearInterval(chatInterval);
            chatInterval = null;
        }
        window.removeEventListener('hashchange', cleanUp);
    };
    window.addEventListener('hashchange', cleanUp);
}
