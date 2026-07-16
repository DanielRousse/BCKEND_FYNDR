export function renderFormulario() {
    return `
        <section class="registro-section py-5">
            <div class="container">
                <div class="row g-4 align-items-stretch justify-content-center">
                    <div class="col-12 col-lg-6">
                        <div class="beneficios-card">
                            <h2 class="beneficios-titulo">¿Por qué unirte a FYNDR?</h2>
                            <ul class="beneficios-list">
                                <li class="beneficio-item">
                                    <div class="beneficio-icon">
                                        <i class="bi bi-person-check-fill"></i>
                                    </div>
                                    <div class="beneficio-text">
                                        <h3>Acceso a profesionales verificados</h3>
                                        <p>Miles de expertos listos para ayudarte</p>
                                    </div>
                                </li>
                                <li class="beneficio-item">
                                    <div class="beneficio-icon">
                                        <i class="bi bi-clock"></i>
                                    </div>
                                    <div class="beneficio-text">
                                        <h3>Ahorra tiempo y dinero</h3>
                                        <p>Compara opciones y elige la mejor</p>
                                    </div>
                                </li>
                                <li class="beneficio-item">
                                    <div class="beneficio-icon">
                                        <i class="bi bi-shield-fill-check"></i>
                                    </div>
                                    <div class="beneficio-text">
                                        <h3>Tranquilidad y seguridad</h3>
                                        <p>Pagos protegidos y soporte siempre</p>
                                    </div>
                                </li>
                                <li class="beneficio-item">
                                    <div class="beneficio-icon">
                                        <i class="bi bi-geo-alt-fill"></i>
                                    </div>
                                    <div class="beneficio-text">
                                        <h3>Disponible en todo el país</h3>
                                        <p>Encuentra servicios en donde estés</p>
                                    </div>
                                </li>
                            </ul>
                            <div class="beneficio-img-container">
                                <img src="assets/trabajador_registro.png" alt="Trabajador" class="img-fluid beneficio-img">
                            </div>
                        </div>
                    </div>
                    <div class="col-12 col-lg-6">
                        <div class="registro-card">
                            <h2 class="registro-titulo">Registro</h2>
                            <p class="registro-subtitulo">Rellena la información para completar tu registro</p>
                            <div id="formAlertContainer"></div>
                            <form id="registroForm" novalidate>
                                <div class="mb-3">
                                    <label for="regName" class="form-label">Nombre Completo</label>
                                    <input type="text" class="form-control input-custom" id="regName" placeholder="Nombre Completo">
                                    <div class="error-msg" id="regNameError"></div>
                                </div>
                                <div class="mb-3">
                                    <label for="regPhone" class="form-label">Número de teléfono</label>
                                    <input type="tel" class="form-control input-custom" id="regPhone" placeholder="Número de teléfono">
                                    <div class="error-msg" id="regPhoneError"></div>
                                </div>
                                <div class="mb-3">
                                    <label for="regEmail" class="form-label">Correo electrónico</label>
                                    <input type="email" class="form-control input-custom" id="regEmail" placeholder="correo@example.com">
                                    <div class="error-msg" id="regEmailError"></div>
                                </div>
                                <div class="mb-3">
                                    <label for="regPassword" class="form-label d-flex align-items-center gap-1">
                                        Contraseña
                                        <span class="password-info-container">
                                            <i class="bi bi-info-circle" id="pwInfoIcon"></i>
                                            <span class="password-tooltip">
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
                                    <div class="password-wrapper position-relative">
                                        <input type="password" class="form-control input-custom" id="regPassword" placeholder="Contraseña">
                                        <i class="bi bi-eye-slash toggle-password-icon" id="togglePassword" style="position: absolute; right: 20px; top: 50%; transform: translateY(-50%); cursor: pointer; color: var(--azul-rey-profundo); z-index: 5;"></i>
                                    </div>
                                    <div class="error-msg" id="regPasswordError"></div>
                                </div>
                                <div class="mb-3">
                                    <label for="regConfirmPassword" class="form-label">Repite tu contraseña</label>
                                    <div class="password-wrapper position-relative">
                                        <input type="password" class="form-control input-custom" id="regConfirmPassword" placeholder="Repite tu contraseña">
                                        <i class="bi bi-eye-slash toggle-password-icon" id="toggleConfirmPassword" style="position: absolute; right: 20px; top: 50%; transform: translateY(-50%); cursor: pointer; color: var(--azul-rey-profundo); z-index: 5;"></i>
                                    </div>
                                    <div class="error-msg" id="regConfirmPasswordError"></div>
                                </div>
                                <button type="submit" class="btn-registrar w-100 mt-2">Registrarte</button>
                                <div class="divider d-flex align-items-center my-4">
                                    <div class="line"></div>
                                    <span class="px-3">o continúa con</span>
                                    <div class="line"></div>
                                </div>
                                <div class="social-buttons d-flex gap-3">
                                    <button type="button" class="btn-social btn-google flex-fill" id="btnGoogleReg">
                                        <i class="bi bi-google"></i> Google
                                    </button>
                                    <button type="button" class="btn-social btn-facebook flex-fill" id="btnFacebookReg">
                                        <i class="bi bi-facebook"></i> Facebook
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    `;
}

export function initFormulario() {
    const form = document.getElementById('registroForm');
    const nameInput = document.getElementById('regName');
    const phoneInput = document.getElementById('regPhone');
    const emailInput = document.getElementById('regEmail');
    const passwordInput = document.getElementById('regPassword');
    const confirmPasswordInput = document.getElementById('regConfirmPassword');
    const alertContainer = document.getElementById('formAlertContainer');
    const pwInfoIcon = document.getElementById('pwInfoIcon');
    const googleBtn = document.getElementById('btnGoogleReg');
    const facebookBtn = document.getElementById('btnFacebookReg');

    const nameError = document.getElementById('regNameError');
    const phoneError = document.getElementById('regPhoneError');
    const emailError = document.getElementById('regEmailError');
    const passwordError = document.getElementById('regPasswordError');
    const confirmPasswordError = document.getElementById('regConfirmPasswordError');

    const nameRegex = /^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\s]{3,50}$/;
    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&.])[A-Za-z\d@$!%*?&.]{8,}$/;
    const phoneRegex = /^[2-9][0-9]{9}$/;

    const params = new URLSearchParams(window.location.search);
    if (params.has('social')) {
        const provider = params.get('social');
        const socialName = params.get('name') || '';
        const socialEmail = params.get('email') || '';
        const userModel = {
            nombre: socialName,
            telefono: '',
            email: socialEmail,
            proveedor: provider
        };
        const jsonString = JSON.stringify(userModel, null, 2);
        localStorage.setItem('registeredUser', jsonString);
        
        const registeredUsers = JSON.parse(localStorage.getItem('registeredUsers') || '[]');
        registeredUsers.push(userModel);
        localStorage.setItem('registeredUsers', JSON.stringify(registeredUsers, null, 2));

        console.log(jsonString);
        alertContainer.innerHTML = `
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                <strong>¡Registro exitoso con ${provider === 'google' ? 'Google' : 'Facebook'}!</strong> Tu cuenta ha sido creada y vinculada correctamente.
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        `;
        history.replaceState({}, document.title, window.location.pathname + window.location.hash);
    }

    function validateName() {
        const value = nameInput.value.trim();
        if (nameRegex.test(value)) {
            nameInput.classList.remove('is-invalid');
            nameInput.classList.add('is-valid');
            nameError.textContent = '';
            return true;
        } else {
            nameInput.classList.remove('is-valid');
            nameInput.classList.add('is-invalid');
            nameError.textContent = 'El nombre debe tener entre 3 y 50 letras y espacios.';
            return false;
        }
    }

    function validatePhone() {
        const cleanVal = phoneInput.value.replace(/[\s\-\(\)]/g, '');
        if (!phoneRegex.test(cleanVal)) {
            phoneInput.classList.remove('is-valid');
            phoneInput.classList.add('is-invalid');
            phoneError.textContent = 'El teléfono debe tener 10 dígitos y comenzar con 2-9 (México).';
            return false;
        }
        if (/(\d)\1\1/.test(cleanVal)) {
            phoneInput.classList.remove('is-valid');
            phoneInput.classList.add('is-invalid');
            phoneError.textContent = 'El teléfono no puede tener más de 2 dígitos idénticos consecutivos.';
            return false;
        }
        phoneInput.classList.remove('is-invalid');
        phoneInput.classList.add('is-valid');
        phoneError.textContent = '';
        return true;
    }

    function validateEmail() {
        const val = emailInput.value.trim();
        emailInput.classList.remove('is-valid', 'is-invalid');

        if (!val) {
            emailInput.classList.add('is-invalid');
            emailError.textContent = 'Introduce tu correo electrónico.';
            return false;
        }

        if (!val.includes('@')) {
            emailInput.classList.add('is-invalid');
            emailError.textContent = 'El correo electrónico debe contener un símbolo "@".';
            return false;
        }

        const parts = val.split('@');
        if (parts.length !== 2) {
            emailInput.classList.add('is-invalid');
            emailError.textContent = 'El correo electrónico debe tener solo un símbolo "@".';
            return false;
        }

        const localPart = parts[0];
        const domainPart = parts[1];

        if (!localPart) {
            emailInput.classList.add('is-invalid');
            emailError.textContent = 'Falta el usuario antes del símbolo "@".';
            return false;
        }

        if (!domainPart) {
            emailInput.classList.add('is-invalid');
            emailError.textContent = 'Falta el dominio después del símbolo "@".';
            return false;
        }

        if (!domainPart.includes('.')) {
            emailInput.classList.add('is-invalid');
            emailError.textContent = 'Al dominio le falta una extensión (ej. .com, .mx).';
            return false;
        }

        const popularDomains = [
            'gmail.com', 'hotmail.com', 'outlook.com',
            'yahoo.com', 'yahoo.com.mx', 'live.com',
            'icloud.com', 'live.com.mx'
        ];

        const lowerDomain = domainPart.toLowerCase();
        if (!popularDomains.includes(lowerDomain)) {
            emailInput.classList.add('is-invalid');
            emailError.textContent = 'Utiliza un proveedor de correo popular (ej. gmail.com, hotmail.com).';
            return false;
        }

        const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        if (!emailRegex.test(val)) {
            emailInput.classList.add('is-invalid');
            emailError.textContent = 'Introduce un formato de correo electrónico válido.';
            return false;
        }

        emailInput.classList.add('is-valid');
        emailError.textContent = '';
        return true;
    }

    function validatePassword() {
        const value = passwordInput.value;
        if (passwordRegex.test(value)) {
            passwordInput.classList.remove('is-invalid');
            passwordInput.classList.add('is-valid');
            passwordError.textContent = '';
            return true;
        } else {
            passwordInput.classList.remove('is-valid');
            passwordInput.classList.add('is-invalid');
            passwordError.textContent = 'Requisitos mínimos no cumplidos.';
            return false;
        }
    }

    function validateConfirmPassword() {
        const value = confirmPasswordInput.value;
        if (value && value === passwordInput.value) {
            confirmPasswordInput.classList.remove('is-invalid');
            confirmPasswordInput.classList.add('is-valid');
            confirmPasswordError.textContent = '';
            return true;
        } else {
            confirmPasswordInput.classList.remove('is-valid');
            confirmPasswordInput.classList.add('is-invalid');
            confirmPasswordError.textContent = 'Las contraseñas no coinciden.';
            return false;
        }
    }

    nameInput.addEventListener('input', validateName);
    phoneInput.addEventListener('input', validatePhone);
    emailInput.addEventListener('input', validateEmail);
    passwordInput.addEventListener('input', () => {
        validatePassword();
        if (confirmPasswordInput.value) {
            validateConfirmPassword();
        }
    });
    confirmPasswordInput.addEventListener('input', validateConfirmPassword);

    pwInfoIcon.addEventListener('click', (e) => {
        e.stopPropagation();
        pwInfoIcon.parentElement.classList.toggle('show-tooltip');
    });

    document.addEventListener('click', () => {
        const infoContainer = document.querySelector('.password-info-container');
        if (infoContainer) {
            infoContainer.classList.remove('show-tooltip');
        }
    });

    const togglePassword = document.getElementById('togglePassword');
    togglePassword.addEventListener('click', () => {
        const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
        passwordInput.setAttribute('type', type);
        togglePassword.classList.toggle('bi-eye');
        togglePassword.classList.toggle('bi-eye-slash');
    });

    const toggleConfirmPassword = document.getElementById('toggleConfirmPassword');
    toggleConfirmPassword.addEventListener('click', () => {
        const type = confirmPasswordInput.getAttribute('type') === 'password' ? 'text' : 'password';
        confirmPasswordInput.setAttribute('type', type);
        toggleConfirmPassword.classList.toggle('bi-eye');
        toggleConfirmPassword.classList.toggle('bi-eye-slash');
    });

    googleBtn.addEventListener('click', () => {
        window.location.href = 'html/google-mock.html';
    });

    facebookBtn.addEventListener('click', () => {
        window.location.href = 'html/facebook-mock.html';
    });

    form.addEventListener('submit', (e) => {
        e.preventDefault();
        const nameVal = validateName();
        const phoneVal = validatePhone();
        const emailVal = validateEmail();
        const passVal = validatePassword();
        const confVal = validateConfirmPassword();

        if (nameVal && phoneVal && emailVal && passVal && confVal) {
            const userModel = {
                nombre: nameInput.value.trim(),
                telefono: phoneInput.value.replace(/[\s\-\(\)]/g, ''),
                email: emailInput.value.trim(),
                contrasena: passwordInput.value
            };

            // Registrar usuario común mediante fetch al backend
            fetch('/api/usuarios-comunes/', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(userModel)
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error al registrar usuario');
                }
                return response.json();
            })
            .then(data => {
                alertContainer.innerHTML = `
                    <div class="alert alert-success alert-dismissible fade show" role="alert">
                        <strong>¡Registro exitoso!</strong> Tu cuenta ha sido creada correctamente.
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                `;
                form.reset();
                nameInput.classList.remove('is-valid');
                phoneInput.classList.remove('is-valid');
                emailInput.classList.remove('is-valid');
                passwordInput.classList.remove('is-valid');
                confirmPasswordInput.classList.remove('is-valid');
                passwordInput.setAttribute('type', 'password');
                confirmPasswordInput.setAttribute('type', 'password');
                togglePassword.classList.add('bi-eye-slash');
                togglePassword.classList.remove('bi-eye');
                toggleConfirmPassword.classList.add('bi-eye-slash');
                toggleConfirmPassword.classList.remove('bi-eye');

                // Redirigir a login para iniciar sesión
                setTimeout(() => {
                    window.location.hash = '#login';
                }, 1500);
            })
            .catch(error => {
                alertContainer.innerHTML = `
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        Ocurrió un error al registrar tu cuenta. El correo electrónico podría estar en uso.
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                `;
            });
        } else {
            alertContainer.innerHTML = `
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    Por favor, corrige los errores en el formulario.
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            `;
        }
    });
}
