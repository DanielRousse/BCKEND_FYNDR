export function renderSoporte() {
    return `
        <main class="soporte-container">
            <div class="soporte-grid">

                <div class="soporte-sidebar">

                    <div class="info-card">
                        <div class="info-card-icon">
                            <i class="bi bi-envelope"></i> </div>
                        <div class="info-card-text">
                            <h4>Correo electronico</h4>
                            <p>hola@gmail.com</p>
                        </div>
                    </div>

                    <div class="info-card">
                        <div class="info-card-icon">
                            <i class="bi bi-telephone"></i> </div>
                        <div class="info-card-text">
                            <h4>Teléfono</h4>
                            <p>55-5555-555</p>
                        </div>
                    </div>

                    <div class="info-card">
                        <div class="info-card-icon">
                            <i class="bi bi-whatsapp"></i>
                        </div>
                        <div class="info-card-text">
                            <h4>WhatsApp</h4>
                            <p>+52 55-5555-5555</p>
                        </div>
                    </div>

                    <div class="info-card">
                        <div class="info-card-icon">
                            <i class="bi bi-clock"></i> </div>
                        <div class="info-card-text">
                            <h4>Horario de atención</h4>
                            <p>Lunes a Viernes</p>
                            <span>9:00 am - 6:00pm</span>
                        </div>
                    </div>

                </div>

                <div class="soporte-form-container">
                    <h2>Envíanos un mensaje</h2>

                    <form id="support-form" novalidate>
                        <div class="form-row-double">
                            <div class="form-field-group">
                                <label for="user_name">Nombre completo</label>
                                <input type="text" id="user_name" name="user_name" placeholder="Tu nombre" required>
                                <div class="error-msg" id="user_name_error"></div>
                            </div>
                            <div class="form-field-group">
                                <label for="user_phone">Número de teléfono</label>
                                <input type="tel" id="user_phone" name="user_phone" placeholder="10 dígitos (ej. 5512345678)" required>
                                <div class="error-msg" id="user_phone_error"></div>
                            </div>
                        </div>

                        <div class="form-row-double">
                            <div class="form-field-group">
                                <label for="user_email">Correo electrónico</label>
                                <input type="email" id="user_email" name="user_email" placeholder="ejemplo@email.com" required>
                                <div class="error-msg" id="user_email_error"></div>
                            </div>
                            <div class="form-field-group">
                                <label for="subject">Asunto</label>
                                <input type="text" id="subject" name="subject" placeholder="¿En qué podemos ayudarte?" required>
                                <div class="error-msg" id="subject_error"></div>
                            </div>
                        </div>

                        <div class="form-field-group">
                            <label for="message">Mensaje</label>
                            <textarea id="message" name="message" placeholder="Escribe tu mensaje aquí..." required></textarea>
                            <div class="error-msg" id="message_error"></div>
                        </div>

                        <div class="form-submit-container">
                            <button type="submit" class="btn-submit-form" id="btn-submit-text">Enviar mensaje</button>
                        </div>
                    </form>
                </div>

            </div>

            <section class="banner-ayuda-inmediata">
                <div class="banner-ayuda-content">
                    <div class="banner-ayuda-icon">
                        <i class="bi bi-headset"></i> </div>
                    <div class="banner-ayuda-text">
                        <h4>¿Necesitas ayuda inmediata?</h4>
                        <p>Habla con nuestro equipo por WhatsApp y obtén atención rápida.</p>
                    </div>
                </div>
                <button class="btn-banner-whatsapp">Contactar por WhatsApp</button>
            </section>
        </main>
    `;
}

export function initSoporte() {
    const form = document.getElementById('support-form');
    const nameInput = document.getElementById('user_name');
    const phoneInput = document.getElementById('user_phone');
    const emailInput = document.getElementById('user_email');
    const subjectInput = document.getElementById('subject');
    const messageInput = document.getElementById('message');

    const nameError = document.getElementById('user_name_error');
    const phoneError = document.getElementById('user_phone_error');
    const emailError = document.getElementById('user_email_error');
    const subjectError = document.getElementById('subject_error');
    const messageError = document.getElementById('message_error');

    if (!form || !nameInput || !phoneInput || !emailInput || !subjectInput || !messageInput) return;

    const nameRegex = /^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\s]{3,50}$/;
    const phoneRegex = /^[2-9][0-9]{9}$/;

    function validateName() {
        const val = nameInput.value.trim();
        if (nameRegex.test(val)) {
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

    function validateSubject() {
        const val = subjectInput.value.trim();
        if (val.length >= 3 && val.length <= 100) {
            subjectInput.classList.remove('is-invalid');
            subjectInput.classList.add('is-valid');
            subjectError.textContent = '';
            return true;
        } else {
            subjectInput.classList.remove('is-valid');
            subjectInput.classList.add('is-invalid');
            subjectError.textContent = 'El asunto debe tener entre 3 y 100 caracteres.';
            return false;
        }
    }

    function validateMessage() {
        const val = messageInput.value.trim();
        if (val.length >= 10 && val.length <= 1000) {
            messageInput.classList.remove('is-invalid');
            messageInput.classList.add('is-valid');
            messageError.textContent = '';
            return true;
        } else {
            messageInput.classList.remove('is-valid');
            messageInput.classList.add('is-invalid');
            messageError.textContent = 'El mensaje debe tener entre 10 y 1000 caracteres.';
            return false;
        }
    }

    nameInput.addEventListener('input', validateName);
    phoneInput.addEventListener('input', validatePhone);
    emailInput.addEventListener('input', validateEmail);
    subjectInput.addEventListener('input', validateSubject);
    messageInput.addEventListener('input', validateMessage);

    form.addEventListener('reset', () => {
        nameInput.classList.remove('is-valid', 'is-invalid');
        phoneInput.classList.remove('is-valid', 'is-invalid');
        emailInput.classList.remove('is-valid', 'is-invalid');
        subjectInput.classList.remove('is-valid', 'is-invalid');
        messageInput.classList.remove('is-valid', 'is-invalid');
        nameError.textContent = '';
        phoneError.textContent = '';
        emailError.textContent = '';
        subjectError.textContent = '';
        messageError.textContent = '';
    });

    form.addEventListener('submit', (e) => {
        e.preventDefault();
        const isNameValid = validateName();
        const isPhoneValid = validatePhone();
        const isEmailValid = validateEmail();
        const isSubjectValid = validateSubject();
        const isMessageValid = validateMessage();

        if (isNameValid && isPhoneValid && isEmailValid && isSubjectValid && isMessageValid) {
            if (typeof window.sendMail === 'function') {
                window.sendMail();
            }
        }
    });
}
