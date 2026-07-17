package org.generation.fyndr.seguridad;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filtro de Servlet para interceptar peticiones y validar tokens JWT.
 */
public class JwtFilter implements Filter {

    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    } // constructor

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String path = httpRequest.getRequestURI();
        String method = httpRequest.getMethod();

        // 1. Permitir solicitudes OPTIONS para CORS pre-flight sin validar token
        if ("OPTIONS".equalsIgnoreCase(method)) {
            httpResponse.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(request, response);
            return;
        } // CORS preflight

        // 2. Whitelist de endpoints públicos
        // - POST /api/login (Inicio de sesión)
        // - POST /api/usuarios-comunes y /api/usuarios-trabajadores (Registro de usuarios)
        // - GET /api/usuarios-trabajadores/** (Búsqueda y detalle de profesionales)
        // - GET /api/publicaciones/** (Ver publicaciones)
        // - GET /api/resenas/** (Ver reseñas)
        // - GET /api/profesiones/** (Ver profesiones)
        // - Endpoints de Actuator (/actuator/health, /actuator/info)
        
        if ("POST".equalsIgnoreCase(method)) {
            if (path.endsWith("/api/login") || path.endsWith("/api/login/") || 
                path.endsWith("/api/usuarios-comunes") || path.endsWith("/api/usuarios-comunes/") ||
                path.endsWith("/api/usuarios-trabajadores") || path.endsWith("/api/usuarios-trabajadores/")) {
                chain.doFilter(request, response);
                return;
            }
        }

        if ("GET".equalsIgnoreCase(method)) {
            if (path.contains("/api/usuarios-trabajadores") || 
                path.contains("/api/publicaciones") || 
                path.contains("/api/resenas") || 
                path.contains("/api/profesiones") || 
                path.contains("/actuator/") ||
                path.contains("/swagger-ui") ||
                path.contains("/v3/api-docs")) {
                chain.doFilter(request, response);
                return;
            }
        }

        // 3. Validar token para todos los demás endpoints
        String authHeader = httpRequest.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.setContentType("application/json");
            httpResponse.getWriter().write("{\"error\": \"Acceso no autorizado: Token faltante o formato incorrecto\"}");
            return;
        } // invalid header

        String token = authHeader.substring(7);

        try {
            if (jwtUtil.validateTokenWithoutEmail(token)) {
                // Agregar atributos del token a la petición para facilitar el acceso en controladores/servicios
                httpRequest.setAttribute("userEmail", jwtUtil.extractEmail(token));
                httpRequest.setAttribute("userRole", jwtUtil.extractRole(token));
                httpRequest.setAttribute("userId", jwtUtil.extractId(token));
                
                chain.doFilter(request, response);
            } else {
                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                httpResponse.setContentType("application/json");
                httpResponse.getWriter().write("{\"error\": \"Acceso no autorizado: Token inválido o expirado\"}");
            }
        } catch (Exception e) {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.setContentType("application/json");
            httpResponse.getWriter().write("{\"error\": \"Acceso no autorizado: Error al procesar el token\"}");
        }
    } // doFilter
} // class JwtFilter
