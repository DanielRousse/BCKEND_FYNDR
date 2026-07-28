/**
 * Módulo utilitario para geocodificación usando la API gratuita de Nominatim (OpenStreetMap).
 * 
 * IMPORTANTE: Nominatim requiere:
 * - Máximo 1 request/segundo (rate limit)
 * - Header User-Agent identificando la aplicación
 * - No usar para producción masiva (pero perfecto para proyecto escolar)
 * 
 * Incluye caché en memoria para evitar llamadas repetidas a la API.
 */

const geocodeCache = new Map();

const COORD_MAP_FALLBACK = {
    "cdmx": { lat: 19.4326, lon: -99.1332 },
    "ciudad de mexico": { lat: 19.4326, lon: -99.1332 },
    "centro": { lat: 19.4326, lon: -99.1332 },
    "reforma": { lat: 19.4270, lon: -99.1677 },
    "guadalajara": { lat: 20.6597, lon: -103.3496 },
    "monterrey": { lat: 25.6866, lon: -100.3161 },
    "puebla": { lat: 19.0413, lon: -98.2062 },
    "queretaro": { lat: 20.5888, lon: -100.3899 },
    "merida": { lat: 20.9674, lon: -89.5926 },
    "cancun": { lat: 21.1619, lon: -86.8515 },
    "tijuana": { lat: 32.5149, lon: -117.0382 },
    "leon": { lat: 21.1221, lon: -101.6840 },
    "toluca": { lat: 19.2826, lon: -99.6557 },
    "chihuahua": { lat: 28.6353, lon: -106.0889 }
};

/**
 * Obtiene coordenadas de una dirección usando el fallback local determinista.
 * Se usa cuando Nominatim falla o no hay conexión.
 */
function fallbackCoordenadas(direccion) {
    const dir = (direccion || "").toLowerCase();
    for (const key in COORD_MAP_FALLBACK) {
        if (dir.includes(key)) {
            return COORD_MAP_FALLBACK[key];
        }
    }
    // Coordenadas deterministas basadas en hash de la dirección
    let hash = 0;
    for (let i = 0; i < dir.length; i++) {
        hash = dir.charCodeAt(i) + ((hash << 5) - hash);
    }
    const latOffset = (Math.abs(hash % 100)) / 1000;
    const lonOffset = (Math.abs((hash >> 8) % 100)) / 1000;
    return { lat: 19.4326 + latOffset, lon: -99.1332 + lonOffset };
}

/**
 * Geocodifica una dirección a coordenadas usando Nominatim API (gratuito).
 * Usa caché en memoria para evitar repetir llamadas.
 * 
 * @param {string} address - La dirección a geocodificar
 * @returns {Promise<{lat: number, lon: number} | null>}
 */
export async function geocodeAddress(address) {
    if (!address || !address.trim()) return null;

    const cacheKey = address.trim().toLowerCase();

    // Revisar caché primero
    if (geocodeCache.has(cacheKey)) {
        return geocodeCache.get(cacheKey);
    }

    try {
        const query = encodeURIComponent(address.trim());
        const response = await fetch(
            `https://nominatim.openstreetmap.org/search?format=json&limit=1&countrycodes=mx&q=${query}`,
            {
                headers: {
                    'User-Agent': 'FyndrApp/1.0 (proyecto-escolar)'
                }
            }
        );

        if (response.ok) {
            const data = await response.json();
            if (data && data.length > 0) {
                const coords = {
                    lat: parseFloat(data[0].lat),
                    lon: parseFloat(data[0].lon)
                };
                geocodeCache.set(cacheKey, coords);
                return coords;
            }
        }
    } catch (err) {
        console.warn("Geocodificación Nominatim falló, usando fallback local:", err.message);
    }

    // Fallback local determinista
    const fallback = fallbackCoordenadas(address);
    geocodeCache.set(cacheKey, fallback);
    return fallback;
}

/**
 * Geocodificación inversa: coordenadas → dirección legible.
 * 
 * @param {number} lat - Latitud
 * @param {number} lon - Longitud
 * @returns {Promise<string | null>}
 */
export async function reverseGeocode(lat, lon) {
    try {
        const response = await fetch(
            `https://nominatim.openstreetmap.org/reverse?format=json&lat=${lat}&lon=${lon}`,
            {
                headers: {
                    'User-Agent': 'FyndrApp/1.0 (proyecto-escolar)'
                }
            }
        );
        if (response.ok) {
            const data = await response.json();
            return data.display_name || null;
        }
    } catch (err) {
        console.warn("Geocodificación inversa falló:", err.message);
    }
    return null;
}

/**
 * Calcula la distancia en km entre dos coordenadas usando la fórmula de Haversine.
 * 
 * @param {number} lat1 - Latitud punto 1
 * @param {number} lon1 - Longitud punto 1
 * @param {number} lat2 - Latitud punto 2
 * @param {number} lon2 - Longitud punto 2
 * @returns {number} Distancia en kilómetros
 */
export function calcularDistanciaKm(lat1, lon1, lat2, lon2) {
    const R = 6371; // Radio de la Tierra en km
    const dLat = (lat2 - lat1) * Math.PI / 180;
    const dLon = (lon2 - lon1) * Math.PI / 180;
    const a =
        Math.sin(dLat / 2) * Math.sin(dLat / 2) +
        Math.cos(lat1 * Math.PI / 180) * Math.cos(lat2 * Math.PI / 180) *
        Math.sin(dLon / 2) * Math.sin(dLon / 2);
    const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    return R * c;
}
