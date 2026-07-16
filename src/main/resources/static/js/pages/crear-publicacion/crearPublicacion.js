import { renderBotonRegreso } from './botonRegreso.js';
import { renderPublicacion } from './publicacion.js';
import { renderBotonPublicar } from './botonPublicar.js';

export function renderCrearPublicacionPage() {
    return `
        <form id="crear-publicacion-form" class="crear-publicacion-page container py-5 animate-appear">
            ${renderBotonRegreso()}
            <h2 class="titulo-principal mb-4" style="color: var(--azul-rey-profundo);">
                Crear Nueva Publicación
            </h2>
            ${renderPublicacion()}
            ${renderBotonPublicar()}
        </form>
    `;
}

// FUNCIONES AUXILIARES PARA MANEJAR ARCHIVOS Y RENDERIZAR VISTA PREVIA DE EVIDENCIAS
function fileToDataUrl(file) {
    return new Promise((resolve, reject) => {
        const reader = new FileReader();
        reader.onload = () => resolve(reader.result);
        reader.onerror = () => reject(new Error(`No se pudo leer el archivo ${file.name}.`));
        reader.readAsDataURL(file);
    });
}

function formatFileSize(bytes) {
    if (bytes < 1024) {
        return `${bytes} B`;
    }

    const kilobytes = bytes / 1024;
    if (kilobytes < 1024) {
        return `${kilobytes.toFixed(1)} KB`;
    }

    return `${(kilobytes / 1024).toFixed(1)} MB`;
}


// FUNCION PARA RENDERIZAR LA VISTA PREVIA DE LAS EVIDENCIAS SELECCIONADAS
async function renderEvidencePreview(fileList, previewContainer) {
    if (!previewContainer) {
        return;
    }

    const files = Array.from(fileList || []);
    previewContainer.replaceChildren();

    if (!files.length) {
        const emptyColumn = document.createElement('div');
        emptyColumn.className = 'col-12';

        const emptyState = document.createElement('div');
        emptyState.className = 'border rounded p-4 text-center text-muted bg-light';
        emptyState.textContent = 'Aún no se han seleccionado evidencias.';

        emptyColumn.append(emptyState);
        previewContainer.append(emptyColumn);
        return;
    }

    const imageSources = await Promise.all(files.map(fileToDataUrl));
    const fragment = document.createDocumentFragment();

    files.forEach((file, index) => {
        const column = document.createElement('div');
        column.className = 'col-6 col-md-4 col-lg-3';

        const card = document.createElement('div');
        card.className = 'border rounded overflow-hidden h-100 bg-white shadow-sm';

        const imageWrapper = document.createElement('div');
        imageWrapper.style.height = '150px';
        imageWrapper.style.background = '#f8f9fa';

        const image = document.createElement('img');
        image.src = imageSources[index];
        image.alt = file.name;
        image.className = 'w-100 h-100';
        image.style.objectFit = 'cover';

        const content = document.createElement('div');
        content.className = 'p-3';

        const fileName = document.createElement('div');
        fileName.className = 'fw-semibold text-truncate';
        fileName.textContent = file.name;

        const fileSize = document.createElement('small');
        fileSize.className = 'text-muted';
        fileSize.textContent = formatFileSize(file.size);

        imageWrapper.append(image);
        content.append(fileName, fileSize);
        card.append(imageWrapper, content);
        column.append(card);
        fragment.append(column);
    });

    previewContainer.append(fragment);
}

async function buildPublicacionPayload(form) {
    const evidenceInput = form.querySelector('#evidencias-input');
    const evidenceFiles = Array.from(evidenceInput?.files || []);

    const evidencias = await Promise.all(evidenceFiles.map(async (file) => ({
        nombreArchivo: file.name,
        tipoMime: file.type,
        tamanoBytes: file.size,
        contenidoBase64: await fileToDataUrl(file)
    })));

    return {
        informacionServicio: {
            tituloServicio: form.querySelector('#titulo-servicio')?.value.trim() ?? '',
            profesionSegmento: form.querySelector('#profesion-segmento')?.value ?? '',
            categoriaServicio: form.querySelector('#categoria-servicio')?.value ?? '',
            precioEstimado: form.querySelector('#precio-estimado')?.value === ''
                ? null
                : Number(form.querySelector('#precio-estimado')?.value),
            zonaServicio: form.querySelector('#zona-servicio')?.value.trim() ?? '',
            descripcionServicio: form.querySelector('#descripcion-servicio')?.value.trim() ?? ''
        },
        evidencias
    };
}

export function initCrearPublicacionPage() {
    const form = document.getElementById('crear-publicacion-form');
    if (!form) {
        return;
    }

    const evidenceInput = form.querySelector('#evidencias-input');
    const previewContainer = form.querySelector('#evidencias-preview');
    const titleInput = form.querySelector('#titulo-servicio');
    const priceInput = form.querySelector('#precio-estimado');
    const zoneInput = form.querySelector('#zona-servicio');

    // AYUDA A RENDERIZAR LA VISTA PREVIA DE LAS EVIDENCIAS SELECCIONADAS
    if (evidenceInput && previewContainer) {
        evidenceInput.addEventListener('change', () => {
            renderEvidencePreview(evidenceInput.files, previewContainer);
        });
    }

    // Actualización de Vista Previa en tiempo real
    if (titleInput) {
        titleInput.addEventListener('input', (e) => {
            const previewTitle = form.querySelector('#vista-previa-titulo');
            if (previewTitle) previewTitle.textContent = e.target.value || 'Instalación eléctrica residencial';
        });
    }

    if (priceInput) {
        priceInput.addEventListener('input', (e) => {
            const previewPrice = form.querySelector('#vista-previa-precio');
            if (previewPrice) previewPrice.textContent = e.target.value ? `Desde $${e.target.value} MXN` : 'Desde $500 MXN';
        });
    }

    const descInput = form.querySelector('#descripcion-servicio');
    if (descInput) {
        descInput.addEventListener('input', (e) => {
            const previewDesc = form.querySelector('#vista-previa-descripcion');
            if (previewDesc) previewDesc.textContent = e.target.value || 'Instalaciones eléctricas seguras y eficientes...';
        });
    }

    form.addEventListener('submit', async (event) => {
        event.preventDefault();

        const missingFields = [];

        if (!titleInput?.value.trim()) {
            missingFields.push('título del servicio');
        }

        if (!priceInput?.value.trim()) {
            missingFields.push('precio estimado');
        }

        if (!zoneInput?.value.trim()) {
            missingFields.push('zona de servicio');
        }

        if (missingFields.length) {
            window.alert(`Completa los campos obligatorios: ${missingFields.join(', ')}.`);
            return;
        }

        try {
            const payload = await buildPublicacionPayload(form);
            const info = payload.informacionServicio;

            const token = localStorage.getItem('token');
            if (!token) {
                window.alert("Debes iniciar sesión para publicar un servicio.");
                window.location.hash = '#login';
                return;
            }

            // Obtener el trabajador logueado
            let idTrabajador = 1;
            try {
                const resMe = await fetch('/api/auth/me', {
                    headers: {
                        'Authorization': `Bearer ${token}`
                    }
                });
                if (resMe.ok) {
                    const me = await resMe.json();
                    if (me.role === 'trabajador') {
                        idTrabajador = me.id;
                    }
                }
            } catch (err) {
                console.error("Error al buscar ID de trabajador:", err);
            }

            // Construir payload que espera el backend
            const publicacionBackend = {
                titulo: info.tituloServicio || "Servicio",
                descripcion: info.descripcionServicio || "",
                precio: parseFloat(info.precioEstimado) || 0.0,
                idUsuarioTrabajador: idTrabajador
            };

            // Enviar al backend mediante fetch
            fetch('/api/publicaciones', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${token}`
                },
                body: JSON.stringify(publicacionBackend)
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error en la respuesta del servidor');
                }
                return response.json();
            })
            .then(data => {
                window.alert("¡Publicación creada con éxito!");
                form.reset();
                window.location.hash = '#lista-productos';
            })
            .catch(error => {
                window.alert(`No se pudo enviar la publicación al servidor: ${error.message}`);
            });

        } catch (error) {
            window.alert(`No se pudo preparar el JSON del formulario: ${error.message}`);
        }
    });
}
