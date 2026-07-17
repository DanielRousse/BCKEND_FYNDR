export function renderPdfPage(type) {
    let pdfUrl = '';
    let title = '';
    if (type === 'terminos') {
        pdfUrl = './assets/terminos.pdf';
        title = 'Términos y Condiciones';
    } else if (type === 'privacidad') {
        pdfUrl = './assets/privacidad.pdf';
        title = 'Aviso de Privacidad';
    } else {
        pdfUrl = './assets/terminos.pdf';
        title = 'Documento';
    }

    return `
        <div class="container py-5 text-center animate-appear" style="min-height: 80vh;">
            <h2 class="fw-bold mb-4" style="color: var(--azul-rey-profundo);">${title}</h2>
            <div class="card shadow mx-auto" style="max-width: 900px; height: 750px; overflow: hidden; border-radius: 12px; border: 1px solid #e0e0e0;">
                <object data="${pdfUrl}" type="application/pdf" width="100%" height="100%">
                    <iframe src="${pdfUrl}" width="100%" height="100%" style="border: none;">
                        Este navegador no soporta visualizar PDFs de forma directa. Puedes descargarlo aquí: 
                        <a href="${pdfUrl}" target="_blank" class="btn btn-primary mt-3">Descargar PDF</a>
                    </iframe>
                </object>
            </div>
            <div class="mt-4">
                <a href="#inicio" class="btn btn-outline-dark px-4 py-2" style="border-radius: 8px; font-weight: 600;">Regresar a Inicio</a>
            </div>
        </div>
    `;
}

export function initPdfPage(type) {
    // No special initialization required
}
