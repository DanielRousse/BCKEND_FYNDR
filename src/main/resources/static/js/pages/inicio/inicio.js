import { renderBanner } from './banner.js';
import { renderCategorias } from './categorias.js';
import { renderTutorial } from './tutorial.js';

export function renderInicioPage() {
    return `
        <div class="inicio-page animate-appear">
            ${renderBanner()}
            ${renderCategorias()}
            ${renderTutorial()}
        </div>
    `;
}

export function initInicioPage() {
    const video = document.getElementById('hero-banner-video');
    if (video) {
        video.loop = true;

        const observer = new IntersectionObserver((entries) => {
            entries.forEach(entry => {
                if (entry.isIntersecting) {
                    video.play().catch(error => {
                        console.log("Autoplay was prevented: ", error);
                    });
                } else {
                    video.pause();
                }
            });
        }, {
            threshold: 0.15
        });

        observer.observe(video);
    }
}
