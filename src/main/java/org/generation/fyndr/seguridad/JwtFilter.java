package org.generation.fyndr.seguridad;

import jakarta.servlet.*;
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

        // 2. Permitir el registro de usuarios y el inicio de sesión
        // POST /api/login
        // POST /api/usuarios-comunes/
        // POST /api/usuarios-trabajadores/
        if ("POST".equalsIgnoreCase(method)) {
            if (path.endsWith("/api/login") || path.endsWith("/api/login/") || 
                path.endsWith("/api/usuarios-comunes") || path.endsWith("/api/usuarios-comunes/") ||
                path.endsWith("/api/usuarios-trabajadores") || path.endsWith("/api/usuarios-trabajadores/")) {
                chain.doFilter(request, response);
                return;
            }
        } // public endpoints

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
                // Token es válido, continuar la cadena de filtros
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
