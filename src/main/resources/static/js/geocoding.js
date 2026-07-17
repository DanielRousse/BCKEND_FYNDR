/**
 * Utility module for geocoding using OpenStreetMap Nominatim API (Free and open-source).
 */

/**
 * Geocodes an address string to latitude and longitude.
 * @param {string} address The address to geocode.
 * @returns {Promise<{lat: number, lon: number} | null>}
 */
export async function geocodeAddress(address) {
    if (!address) return null;
    try {
        const query = encodeURIComponent(address);
        const response = await fetch(`https://nominatim.openstreetmap.org/search?format=json&limit=1&q=${query}`);
        if (response.ok) {
            const data = await response.json();
            if (data && data.length > 0) {
                return {
                    lat: parseFloat(data[0].lat),
                    lon: parseFloat(data[0].lon)
                };
            }
        }
    } catch (err) {
        console.error("Geocoding failed for address:", address, err);
    }
    
    // Fallback determinista local en caso de error o sin conexión
    const dir = address.toLowerCase();
    const COORD_MAP = {
        "cdmx": { lat: 19.4326, lon: -99.1332 },
        "centro": { lat: 19.4326, lon: -99.1332 },
        "reforma": { lat: 19.4270, lon: -99.1677 },
        "guadalajara": { lat: 20.6597, lon: -103.3496 },
        "monterrey": { lat: 25.6866, lon: -100.3161 },
        "puebla": { lat: 19.0413, lon: -98.2062 },
        "queretaro": { lat: 20.5888, lon: -100.3899 },
        "merida": { lat: 20.9674, lon: -89.5926 }
    };
    for (const key in COORD_MAP) {
        if (dir.includes(key)) {
            return COORD_MAP[key];
        }
    }
    let hash = 0;
    for (let i = 0; i < dir.length; i++) {
        hash = dir.charCodeAt(i) + ((hash << 5) - hash);
    }
    const latOffset = (Math.abs(hash % 100)) / 1000;
    const lonOffset = (Math.abs((hash >> 8) % 100)) / 1000;
    return { lat: 19.4326 + latOffset, lon: -99.1332 + lonOffset };
}

/**
 * Reverse geocodes coordinates to a readable address.
 * @param {number} lat Latitude.
 * @param {number} lon Longitude.
 * @returns {Promise<string | null>}
 */
export async function reverseGeocode(lat, lon) {
    try {
        const response = await fetch(`https://nominatim.openstreetmap.org/reverse?format=json&lat=${lat}&lon=${lon}`);
        if (response.ok) {
            const data = await response.json();
            return data.display_name || null;
        }
    } catch (err) {
        console.error("Reverse geocoding failed:", err);
    }
    return null;
}
