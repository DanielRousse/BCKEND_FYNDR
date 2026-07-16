export function renderFormulario() {
    return `
        <section class="login-section py-5">
            <div class="container">
                <div class="row g-4 align-items-stretch justify-content-center">
                    <div class="col-12 col-lg-6">
                        <div class="login-registro-card">
                            <h2 class="login-registro-titulo">Iniciar sesión</h2>
                            <h4 class="mb-2">Bienvenido de nuevo<br>Ingresa para continuar</h4>
                            <div id="login-formAlertContainer"></div>
                            <form id="login-registroForm" novalidate>                                
                                <div class="mb-1">
                                    <label for="login-regEmail" class="login-form-label">Correo electrónico</label>
                                    <input type="email" class="form-control login-input-custom" id="login-regEmail" placeholder="correo@example.com">
                                    <div class="login-error-msg" id="login-regEmailError"></div>
                                </div>
                                <div class="mb-3">
                                    <label for="login-regPassword" class="login-form-label d-flex align-items-center gap-1">
                                        Contraseña
                                        <span class="login-password-info-container">
                                            <i class="bi bi-info-circle" id="login-pwInfoIcon"></i>
                                            <span class="login-password-tooltip">
                                                <strong>Requisitos de contraseña:</strong>
                                                <ul>
                                                    <li>Mínimo 8 caracteres</li>
                                                    <li>Al menos una letra mayúscula</li>
                                                    <li>Al menos una letra minúscula</li>
                                                    <li>Al menos un número</li>
                                                    <li>Al menos un carácter especial (@$!%*?&.)</li>
                                                </ul>
                                            </span>
                                        </span>
                                    </label>
                                    <div class="login-password-wrapper position-relative">
                                        <input type="password" class="form-control login-input-custom" id="login-regPassword" placeholder="Contraseña">
                                        <i class="bi bi-eye-slash toggle-password-icon" id="login-togglePassword" style="position: absolute; right: 20px; top: 50%; transform: translateY(-50%); cursor: pointer; color: var(--azul-rey-profundo); z-index: 5;"></i>
                                    </div>
                                    <div class="login-error-msg" id="login-regPasswordError"></div>
                                </div>
                                <button type="submit" class="login-btn-registrar w-100 mt-2">Iniciar sesión</button>
                                <div class="login-divider d-flex align-items-center my-4">
                                    <div class="login-line"></div>
                                    <span class="px-3">o continúa con</span>
                                    <div class="login-line"></div>
                                </div>
                                <div class="login-social-buttons d-flex gap-3">
                                    <button type="button" class="login-btn-social login-btn-google flex-fill" id="login-btnGoogleReg">
                                        <i class="bi bi-google"></i> Google
                                    </button>
                                    <button type="button" class="login-btn-social login-btn-facebook flex-fill" id="login-btnFacebookReg">
                                        <i class="bi bi-facebook"></i> Facebook
                                    </button>
                                </div>
                                <div class="row mt-5" >
                                    <div class="col-6 text-center">
                                        <p><strong>¿No tienes cuenta aún?</strong></p>
                                    </div> 
                                    <div class="col-6 text-center">
                                        <a href="#registro">Regístrate aquí</a>
                                    </div>                
                                </div>
                                
                            </form>
                        </div>
                    </div>
                    <div class="col-12 col-lg-6">
                        <div class="login-beneficios-card">
                            <div class="login-title-icon mx-auto">
                                        <i class="bi bi-check text-center icon-title"></i>
                            </div>
                            <h1 class="login-beneficios-titulo">¡Ya casi estás listo!</h1>
                            <h2 class="login-beneficios-titulo">Al crear tu cuenta podrás:</h2>
                            <ul class="login-beneficios-list">
                                <li class="login-beneficio-item">
                                    <div class="login-beneficio-icon">
                                        <i class="bi bi-check"></i>
                                    </div>
                                    <div class="login-beneficio-text">
                                        <h3>Buscar y contactar profesionales</h3>
                                    </div>
                                </li>
                                <li class="login-beneficio-item">
                                    <div class="login-beneficio-icon">
                                        <i class="bi bi-check"></i>
                                    </div>
                                    <div class="login-beneficio-text">
                                        <h3>Publicar trabajos y recibir propuestas</h3>
                                    </div>
                                </li>
                                <li class="login-beneficio-item">
                                    <div class="login-beneficio-icon">
                                        <i class="bi bi-check"></i>
                                    </div>
                                    <div class="login-beneficio-text">
                                        <h3>Guardar favoritos y más</h3>
                                    </div>
                                </li>                                
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    `;
}

export function initLogin() {
    const form = document.getElementById('login-registroForm');
    const emailInput = document.getElementById('login-regEmail');
    const passwordInput = document.getElementById('login-regPassword');
    const alertContainer = document.getElementById('login-formAlertContainer');
    const togglePassword = document.getElementById('login-togglePassword');

    
    const seedMockUser = () => {
        const registeredUsers = JSON.parse(localStorage.getItem('registeredUsers') || '[]');
        
        
        const mockUser = {
            email: btoa('test@example.com'),
            contrasena: btoa('Password123!'),
            nombre: 'Usuario de Prueba'
        };

        
        const exists = registeredUsers.some(user => user.email === mockUser.email);
        if (!exists) {
            registeredUsers.push(mockUser);
            localStorage.setItem('registeredUsers', JSON.stringify(registeredUsers));
        }
    };

    
    seedMockUser();

    
    if (togglePassword) {
        togglePassword.addEventListener('click', () => {
            const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
            passwordInput.setAttribute('type', type);
            togglePassword.classList.toggle('bi-eye');
            togglePassword.classList.toggle('bi-eye-slash');
        });
    }

    form.addEventListener('submit', (e) => {
        e.preventDefault();

        const emailVal = emailInput.value.trim();
        const passwordVal = passwordInput.value;

        if (!emailVal || !passwordVal) {
            alertContainer.innerHTML = `
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    Por favor, llena todos los campos.
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            `;
            return;
        }

        const redirigirAInicio = () => {
            setTimeout(() => {
                window.location.hash = '#inicio'; 
            }, 1500); 
        };

        // Enviar credenciales al backend mediante fetch con ruta relativa
        fetch('/api/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                email: emailVal,
                contrasena: passwordVal
            })
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Credenciales incorrectas');
            }
            return response.json();
        })
        .then(data => {
            // data contiene: accessToken, nombre, email
            localStorage.setItem('token', data.accessToken);
            
            const activeUser = { nombre: data.nombre, email: data.email };
            localStorage.setItem('currentUser', JSON.stringify(activeUser));

            alertContainer.innerHTML = `
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <strong>¡Bienvenido de nuevo, ${data.nombre}!</strong> Has iniciado sesión correctamente.
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            `;
            form.reset();
            redirigirAInicio();
        })
        .catch(error => {
            alertContainer.innerHTML = `
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    Correo electrónico o contraseña incorrectos.
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            `;
        });
    });
}