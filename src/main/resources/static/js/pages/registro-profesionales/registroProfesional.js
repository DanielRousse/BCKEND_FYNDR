import { renderPaso1 } from './paso1.js';
import { renderPaso2 } from './paso2.js';
import { renderPaso3 } from './paso3.js';
import { renderPaso4 } from './paso4.js';

// =========================
// ESTADO GLOBAL PERSISTENTE
// =========================
const defaultState = {
    pasoActual: 1,
    datos: {
        nombre: "",
        correo: "",
        password: "",
        telefono: "",
        fechaNacimiento: ""
    }
};

const saved = JSON.parse(localStorage.getItem("registroProfesionalState"));

window.registroProfesionalState = saved || defaultState;

// IMPORTANTÍSIMO: asegurar valores siempre válidos
window.registroProfesionalState.pasoActual =
    window.registroProfesionalState.pasoActual || 1;

window.registroProfesionalState.datos =
    window.registroProfesionalState.datos || { ...defaultState.datos };

let pasoActual = window.registroProfesionalState.pasoActual;
let datosRegistro = window.registroProfesionalState.datos;



// 🔥 FIX: asegurar que siempre se restaure correctamente desde localStorage
if (!window.registroProfesionalState.datos) {
    window.registroProfesionalState.datos = {
        nombre: "",
        correo: "",
        password: "",
        telefono: "",
        fechaNacimiento: ""
    };
}

if (!window.registroProfesionalState.pasoActual) {
    window.registroProfesionalState.pasoActual = 1;
}

// =========================
// 🔥 AUTOSAVE PASO 1 (AÑADIDO)
// =========================
function activarAutoSavePaso1() {

    setTimeout(() => {

        const nombre = document.getElementById("nombre");
        const correo = document.getElementById("correo");
        const password = document.getElementById("password");
        const telefono = document.getElementById("telefono");
        const fecha = document.getElementById("fechaNacimiento");

        if (nombre) {
            nombre.oninput = (e) => {
                window.registroProfesionalState.datos.nombre = e.target.value;
                localStorage.setItem("registroProfesionalState",
                    JSON.stringify(window.registroProfesionalState));
            };
        }

        if (correo) {
            correo.oninput = (e) => {
                window.registroProfesionalState.datos.correo = e.target.value;
                localStorage.setItem("registroProfesionalState",
                    JSON.stringify(window.registroProfesionalState));
            };
        }

        if (password) {
            password.oninput = (e) => {
                window.registroProfesionalState.datos.password = e.target.value;
                localStorage.setItem("registroProfesionalState",
                    JSON.stringify(window.registroProfesionalState));
            };
        }

        if (telefono) {
    telefono.oninput = (e) => {

    // Solo números y máximo 10 dígitos
    e.target.value = e.target.value.replace(/\D/g, "").slice(0, 10);

    window.registroProfesionalState.datos.telefono = e.target.value;

    localStorage.setItem(
        "registroProfesionalState",
        JSON.stringify(window.registroProfesionalState)
    );
};
}

        if (fecha) {
            fecha.oninput = (e) => {
                window.registroProfesionalState.datos.fechaNacimiento = e.target.value;
                localStorage.setItem("registroProfesionalState",
                    JSON.stringify(window.registroProfesionalState));
            };
        }

    }, 0);
}

// =========================
// VALIDACIONES GLOBALES
// =========================

window.validarCURP = function (input) {

    const curp = input.value.trim().toUpperCase();

    const regexCURP =
        /^[A-Z][AEIOUX][A-Z]{2}\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\d|3[01])[HM][A-Z]{2}[B-DF-HJ-NP-TV-Z]{3}[A-Z0-9]\d$/;

    if (!regexCURP.test(curp)) {

        Swal.fire({
            icon: "error",
            title: "CURP inválida",
            text: "Verifica el formato de la CURP"
        });

        input.value = "";
        return false;
    }

    input.value = curp;
    return true;
};

window.validarImagen = function (input) {

    const file = input.files[0];
    if (!file) return;

    const ok = ["image/jpeg", "image/png"];

    if (!ok.includes(file.type)) {
        Swal.fire({
            icon: "warning",
            title: "Archivo inválido",
            text: "Solo JPG o PNG"
        });
        input.value = "";
    }
};

window.validarImagenOPdf = function (input) {

    const file = input.files[0];
    if (!file) return;

    const ok = ["image/jpeg", "image/png", "application/pdf"];

    if (!ok.includes(file.type)) {
        Swal.fire({
            icon: "warning",
            title: "Archivo inválido",
            text: "Solo JPG, PNG o PDF"
        });
        input.value = "";
    }
};

window.validarPDF = function (input) {

    const file = input.files[0];
    if (!file) return;

    if (file.type !== "application/pdf") {
        Swal.fire({
            icon: "warning",
            title: "Archivo inválido",
            text: "Solo PDF"
        });
        input.value = "";
    }
};

// =========================
// RENDER PRINCIPAL
// =========================

export function renderRegistroProfesionalPage() {

    pasoActual = window.registroProfesionalState.pasoActual;
    datosRegistro = window.registroProfesionalState.datos;

    if (!window.listenerRegistroProfesional) {

        window.listenerRegistroProfesional = true;

        document.addEventListener('click', (e) => {

            const contenedor = document.getElementById('pasos-registro');
            if (!contenedor) return;

            // =========================
            // BOTÓN SIGUIENTE
            // =========================
            if (e.target.closest('#btn-siguiente')) {

                if (pasoActual === 1) {

                    const nombre = document.getElementById("nombre")?.value.trim();
                    const correo = document.getElementById("correo")?.value.trim();
                    const password = document.getElementById("password")?.value;
                    const confirm = document.getElementById("confirmarPassword")?.value;
                    const telefono = document.getElementById("telefono")?.value.trim();
                    const fecha = document.getElementById("fechaNacimiento")?.value;

                    let valido = true;
                      const regexTelefono = /^(?!.*(\d)\1{2})[2-9]\d{9}$/;

                    if (!nombre || nombre.length < 3) {
                        Swal.fire("Error", "Nombre inválido", "error");
                        valido = false;
                    }

                    const regexCorreo = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                    if (!regexCorreo.test(correo)) {
                        Swal.fire("Error", "Correo inválido", "error");
                        valido = false;
                    }

                    if (!password || password.length < 4) {
                        Swal.fire("Error", "Contraseña muy corta", "error");
                        valido = false;
                    }

                    if (password !== confirm) {
                        Swal.fire("Error", "Las contraseñas no coinciden", "error");
                        valido = false;
                    }


if (!regexTelefono.test(telefono)) {
    Swal.fire({
        icon: "error",
        title: "Teléfono inválido",
        text: "Debe contener 10 dígitos y no tener números repetidos 3 veces seguidas."
    });
    valido = false;
}
else if (/^[2-9]0{9}$/.test(telefono)) {
    Swal.fire({
        icon: "error",
        title: "Teléfono inválido",
        text: "El número telefónico no es válido."
    });
    valido = false;
}


                    if (!fecha) {

                        Swal.fire({
                            icon: "error",
                            title: "Fecha requerida",
                            text: "Selecciona tu fecha de nacimiento"
                        });

                        valido = false;

                    } else {

                        const nacimiento = new Date(fecha);
                        const hoy = new Date();

                        if (nacimiento > hoy) {

                            Swal.fire({
                                icon: "error",
                                title: "Fecha inválida",
                                text: "La fecha de nacimiento no puede ser futura"
                            });

                            valido = false;

                        } else {

                            let edad = hoy.getFullYear() - nacimiento.getFullYear();

                            const mes = hoy.getMonth() - nacimiento.getMonth();
                            const dia = hoy.getDate() - nacimiento.getDate();

                            if (mes < 0 || (mes === 0 && dia < 0)) {
                                edad--;
                            }

                            if (edad < 18) {

                                Swal.fire({
                                    icon: "warning",
                                    title: "Edad no válida",
                                    text: "Debes ser mayor de 18 años"
                                });

                                valido = false;
                            }
                        }
                    }

                    if (!valido) return;

                    datosRegistro.nombre = nombre;
                    datosRegistro.correo = correo;
                    datosRegistro.password = password;
                    datosRegistro.telefono = telefono;
                    datosRegistro.fechaNacimiento = fecha;

                    window.registroProfesionalState.datos = datosRegistro;
                }

                if (pasoActual === 2) {

                    const curp = document.getElementById("curp")?.value?.trim();
                    const foto = window.registroProfesionalState.datos.fotografiaFile;
                    const ine = document.getElementById("ine");
                    const domicilio = document.getElementById("comprobante");
                    const noPenales = document.getElementById("antecedentes");

                    let valido = true;

                    if (!curp) {
                        Swal.fire({
                            icon: "error",
                            title: "Falta información",
                            text: "Debes llenar la CURP"
                        });
                        valido = false;
                    }

                    if (!foto) {
                        Swal.fire({
                            icon: "error",
                            title: "Falta fotografía",
                            text: "Debes subir una fotografía."
                        });
                        valido = false;
                    }

                    if (!ine || !ine.files || ine.files.length === 0) {
                        Swal.fire({
                            icon: "error",
                            title: "Falta documento",
                            text: "Debes subir tu INE"
                        });
                        valido = false;
                    }

                    if (!domicilio || !domicilio.files || domicilio.files.length === 0) {
                        Swal.fire({
                            icon: "error",
                            title: "Falta documento",
                            text: "Debes subir tu comprobante de domicilio"
                        });
                        valido = false;
                    }

                    if (!noPenales || !noPenales.files || noPenales.files.length === 0) {
                        Swal.fire({
                            icon: "error",
                            title: "Falta documento",
                            text: "Debes subir tu carta de no antecedentes penales"
                        });
                        valido = false;
                    }

                    if (!valido) return;

                    window.registroProfesionalState.datos.curp = curp;
                }
                if (pasoActual === 3) {

                    const especialidad = document.getElementById("especialidad")?.value;
                    const subespecialidades = [...document.getElementById("subespecialidades").selectedOptions]
                        .map(opcion => opcion.value);

                    const experiencia = document.getElementById("experiencia")?.value;
                    const descripcion = document.getElementById("descripcion")?.value.trim();

                    const certificaciones = document.getElementById("certificaciones");
                    const portafolio = document.getElementById("portafolio");

                    let valido = true;

                    if (!especialidad || especialidad === "Selecciona una opción") {
                        Swal.fire({
                            icon: "error",
                            title: "Falta información",
                            text: "Selecciona tu oficio o especialidad principal."
                        });
                        valido = false;
                    }
                    if (subespecialidades.length === 0) {
                        Swal.fire({
                            icon: "error",
                            title: "Falta información",
                            text: "Selecciona al menos una subespecialidad."
                        });
                        valido = false;
                    }

                    if (!experiencia) {
                        Swal.fire({
                            icon: "error",
                            title: "Falta información",
                            text: "Ingresa tus años de experiencia."
                        });
                        valido = false;
                    }

                    if (!descripcion || descripcion.length < 20) {
    Swal.fire({
        icon: "error",
        title: "Falta información",
        text: "Describe tu experiencia profesional (mínimo 20 caracteres)."
    });
    valido = false;
}

                    if (!certificaciones.files.length) {
                        Swal.fire({
                            icon: "error",
                            title: "Falta documento",
                            text: "Debes subir tus certificaciones o títulos."
                        });
                        valido = false;
                    }

                    if (!portafolio.files.length) {
                        Swal.fire({
                            icon: "error",
                            title: "Falta documento",
                            text: "Debes subir una galería de trabajos."
                        });
                        valido = false;
                    }

                    if (!valido) return;

                    window.registroProfesionalState.datos.especialidad = especialidad;
                    window.registroProfesionalState.datos.subespecialidades = subespecialidades;
                    window.registroProfesionalState.datos.experiencia = experiencia;
                    window.registroProfesionalState.datos.descripcion = descripcion;
                }

                if (pasoActual === 4) {

    const rfc = document.getElementById("rfc")?.value.trim().toUpperCase();
    const constancia = document.getElementById("constanciaFiscal");
    const clabe = document.getElementById("clabe")?.value.trim();
    const banco = document.getElementById("banco")?.value;

    let valido = true;

    const regexRFC = /^[A-ZÑ&]{3,4}\d{6}[A-Z0-9]{3}$/;
    const regexClabe = /^\d{18}$/;

    if (!rfc || !regexRFC.test(rfc)) {
        Swal.fire({
            icon: "error",
            title: "RFC inválido",
            text: "Verifica el RFC."
        });
        valido = false;
    }

    if (!constancia.files.length) {
        Swal.fire({
            icon: "error",
            title: "Documento requerido",
            text: "Debes subir tu constancia fiscal."
        });
        valido = false;
    }

    if (!regexClabe.test(clabe)) {
        Swal.fire({
            icon: "error",
            title: "CLABE inválida",
            text: "Debe contener exactamente 18 dígitos."
        });
        valido = false;
    }

    if (!banco) {
        Swal.fire({
            icon: "error",
            title: "Banco requerido",
            text: "Selecciona un banco."
        });
        valido = false;
    }

    if (!valido) return;

    window.registroProfesionalState.datos.rfc = rfc;
    window.registroProfesionalState.datos.clabe = clabe;
    window.registroProfesionalState.datos.banco = banco;
}


               if (pasoActual < 4) {
    pasoActual++;
    window.registroProfesionalState.pasoActual = pasoActual;
    renderPaso();
} else {
    // Preparar objeto para enviar al backend
    const stateDatos = window.registroProfesionalState.datos;
    const nuevoTrabajador = {
        nombre: stateDatos.nombre,
        email: stateDatos.correo,
        contrasena: stateDatos.password,
        telefono: stateDatos.telefono,
        fechaNacimiento: stateDatos.fechaNacimiento,
        inePath: stateDatos.ine || "",
        curp: stateDatos.curp || "",
        fotografiaPath: stateDatos.fotografia || "",
        comprobantePath: stateDatos.comprobante || "",
        antecedentesPath: stateDatos.antecedentes || "",
        experienciaAnos: parseInt(stateDatos.experiencia) || 0,
        descripcion: stateDatos.descripcion || "",
        subespecialidades: Array.isArray(stateDatos.subespecialidades) ? stateDatos.subespecialidades.join(", ") : "",
        certificacionesPath: stateDatos.certificaciones || "",
        portafolioPath: stateDatos.portafolio || "",
        rfc: stateDatos.rfc || "",
        clabe: stateDatos.clabe || "",
        banco: stateDatos.banco || "",
        tarifaHora: 0.0,
        calificacionPromedio: 0.0
    };

    fetch('/api/usuarios-trabajadores/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(nuevoTrabajador)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error al registrar profesional');
        }
        return response.json();
    })
    .then(data => {
        Swal.fire({
            icon: "success",
            title: "Registro completado",
            text: "Tu registro como profesional ha sido enviado y guardado correctamente."
        }).then(() => {
            // resetear estado
            window.registroProfesionalState = {
                pasoActual: 1,
                datos: {
                    nombre: "",
                    correo: "",
                    password: "",
                    telefono: "",
                    fechaNacimiento: ""
                }
            };

            // limpiar localStorage
            localStorage.setItem(
                "registroProfesionalState",
                JSON.stringify(window.registroProfesionalState)
            );

            // reset variables locales
            pasoActual = 1;
            datosRegistro = window.registroProfesionalState.datos;

            // volver a renderizar paso 1
            renderPaso();
            
            // Redirigir a login
            setTimeout(() => {
                window.location.hash = '#login';
            }, 1000);
        });
    })
    .catch(error => {
        Swal.fire({
            icon: "error",
            title: "Error de registro",
            text: "Hubo un problema al guardar tus datos de profesional. El correo podría estar registrado."
        });
    });
}
            }

            // =========================
            // BOTÓN ANTERIOR
            // =========================
            if (e.target.closest('#btn-anterior')) {

                if (pasoActual > 1) {
                    pasoActual--;
                    window.registroProfesionalState.pasoActual = pasoActual;
                    renderPaso();
                }
            }
        });
    }

    // activar autosave al cargar si ya está en paso 1
    switch (pasoActual) {
        case 1:
            activarAutoSavePaso1();
            break;
        case 2:
            activarAutoSavePaso2();
            break;
        case 3:
            activarAutoSavePaso3();
            break;

            case 4:
    activarAutoSavePaso4();
    break;
    }

    return `
        <div class="container py-5">

            <h1 class="text-center mb-5">Registro Profesional</h1>

            <div class="row g-4">

                <div class="col-lg-4">
                    <div class="info-card">
                        <h3>Beneficios</h3>

                        <div class="ben">
                            <h5>✔ Profesionales verificados</h5>
                            <p>Confianza total</p>
                        </div>

                        <div class="ben">
                            <h5>🕒 Ahorro de tiempo</h5>
                            <p>Encuentra rápido</p>
                        </div>

                        <div class="ben">
                            <h5>🛡 Seguridad</h5>
                            <p>Pagos protegidos</p>
                        </div>

                        <div class="ben">
                            <h5>📍 Disponible</h5>
                            <p>En todo México</p>
                        </div>

                        <img src="./assets/plomero.jpg" class="img-fluid mt-3">
                    </div>
                </div>

                <div class="col-lg-7">
    <div id="pasos-registro">
        ${pasoActual === 1 ? renderPaso1() :
            pasoActual === 2 ? renderPaso2() :
                pasoActual === 3 ? renderPaso3() :
                    renderPaso4()
        }
    </div>
</div>
            </div>

        </div>
    `;
}

//Paso 2
function activarAutoSavePaso2() {

    setTimeout(() => {

        const curp = document.getElementById("curp");
        const ine = document.getElementById("ine");
        const fotografia = document.getElementById("fotografia");
        const comprobante = document.getElementById("comprobante");
        const antecedentes = document.getElementById("antecedentes");

        if (curp) {
            curp.oninput = (e) => {
                window.registroProfesionalState.datos.curp = e.target.value;
                localStorage.setItem("registroProfesionalState",
                    JSON.stringify(window.registroProfesionalState));
            };
        }


        if (fotografia) {
            fotografia.onchange = (e) => {
                const file = e.target.files[0];

                window.registroProfesionalState.datos.fotografia = file ? file.name : "";
                window.registroProfesionalState.datos.fotografiaFile = file; // 🔥 IMPORTANTE

                localStorage.setItem(
                    "registroProfesionalState",
                    JSON.stringify(window.registroProfesionalState)
                );
            };
        }



        // ⚠️ archivos: solo guardamos "nombre del archivo"
        if (ine) {
            ine.onchange = (e) => {
                window.registroProfesionalState.datos.ine = e.target.files[0]?.name || "";
                localStorage.setItem("registroProfesionalState",
                    JSON.stringify(window.registroProfesionalState));
            };
        }

        if (comprobante) {
            comprobante.onchange = (e) => {
                window.registroProfesionalState.datos.comprobante = e.target.files[0]?.name || "";
                localStorage.setItem("registroProfesionalState",
                    JSON.stringify(window.registroProfesionalState));
            };
        }

        if (antecedentes) {
            antecedentes.onchange = (e) => {
                window.registroProfesionalState.datos.antecedentes = e.target.files[0]?.name || "";
                localStorage.setItem("registroProfesionalState",
                    JSON.stringify(window.registroProfesionalState));
            };
        }

    }, 0);
}

function activarAutoSavePaso3() {

    setTimeout(() => {

        const especialidad = document.getElementById("especialidad");
        const subespecialidades = document.getElementById("subespecialidades");
        const experiencia = document.getElementById("experiencia");
        const descripcion = document.getElementById("descripcion");
        const certificaciones = document.getElementById("certificaciones");
        const portafolio = document.getElementById("portafolio");

        if (especialidad) {
            especialidad.onchange = (e) => {
                window.registroProfesionalState.datos.especialidad = e.target.value;
                localStorage.setItem(
                    "registroProfesionalState",
                    JSON.stringify(window.registroProfesionalState)
                );
            };
        }

        if (subespecialidades) {
            subespecialidades.onchange = () => {

                window.registroProfesionalState.datos.subespecialidades =
                    [...subespecialidades.selectedOptions].map(op => op.value);

                localStorage.setItem(
                    "registroProfesionalState",
                    JSON.stringify(window.registroProfesionalState)
                );
            };
        }

        if (experiencia) {
            experiencia.oninput = (e) => {
                window.registroProfesionalState.datos.experiencia = e.target.value;

                localStorage.setItem(
                    "registroProfesionalState",
                    JSON.stringify(window.registroProfesionalState)
                );
            };
        }

        if (descripcion) {
            descripcion.oninput = (e) => {
                window.registroProfesionalState.datos.descripcion = e.target.value;

                localStorage.setItem(
                    "registroProfesionalState",
                    JSON.stringify(window.registroProfesionalState)
                );
            };
        }

        if (certificaciones) {
            certificaciones.onchange = (e) => {
                window.registroProfesionalState.datos.certificaciones =
                    e.target.files[0]?.name || "";

                localStorage.setItem(
                    "registroProfesionalState",
                    JSON.stringify(window.registroProfesionalState)
                );
            };
        }

        if (portafolio) {
            portafolio.onchange = (e) => {
                window.registroProfesionalState.datos.portafolio =
                    e.target.files[0]?.name || "";

                localStorage.setItem(
                    "registroProfesionalState",
                    JSON.stringify(window.registroProfesionalState)
                );
            };
        }

    }, 0);
}


function activarAutoSavePaso4() {

    setTimeout(() => {

        const rfc = document.getElementById("rfc");
        const constancia = document.getElementById("constanciaFiscal");
        const clabe = document.getElementById("clabe");
        const banco = document.getElementById("banco");

        // RFC
        if (rfc) {
            rfc.oninput = (e) => {

                window.registroProfesionalState.datos.rfc =
                    e.target.value.toUpperCase();

                localStorage.setItem(
                    "registroProfesionalState",
                    JSON.stringify(window.registroProfesionalState)
                );
            };
        }

        // Constancia fiscal
        if (constancia) {
            constancia.onchange = (e) => {

                window.registroProfesionalState.datos.constanciaFiscal =
                    e.target.files[0]?.name || "";

                localStorage.setItem(
                    "registroProfesionalState",
                    JSON.stringify(window.registroProfesionalState)
                );
            };
        }

        // CLABE
        if (clabe) {
            clabe.oninput = (e) => {

                window.registroProfesionalState.datos.clabe =
                    e.target.value;

                localStorage.setItem(
                    "registroProfesionalState",
                    JSON.stringify(window.registroProfesionalState)
                );
            };
        }

        // Banco
        if (banco) {
            banco.onchange = (e) => {

                window.registroProfesionalState.datos.banco =
                    e.target.value;

                localStorage.setItem(
                    "registroProfesionalState",
                    JSON.stringify(window.registroProfesionalState)
                );
            };
        }

    }, 0);
}

// =========================
// CAMBIO DE PASOS
// =========================

function renderPaso() {

    const contenedor = document.getElementById('pasos-registro');
    if (!contenedor) return;

    datosRegistro = window.registroProfesionalState.datos;
    pasoActual = window.registroProfesionalState.pasoActual;

    switch (pasoActual) {

        case 1:
            contenedor.innerHTML = renderPaso1();
            activarAutoSavePaso1();
            break;

        case 2:
            contenedor.innerHTML = renderPaso2();
            activarAutoSavePaso2();

            // Restaurar CURP
            setTimeout(() => {
                const curp = document.getElementById("curp");

                if (curp) {
                    curp.value = window.registroProfesionalState.datos.curp || "";
                }
            }, 0);

            break;

        case 3:
            contenedor.innerHTML = renderPaso3();
            activarAutoSavePaso3();

            break;

        case 4:

    contenedor.innerHTML = renderPaso4();

    activarAutoSavePaso4();

    setTimeout(() => {

        const datos = window.registroProfesionalState.datos;

        document.getElementById("rfc").value = datos.rfc || "";
        document.getElementById("clabe").value = datos.clabe || "";
        document.getElementById("banco").value = datos.banco || "";

    }, 0);

    break;
    }
}
