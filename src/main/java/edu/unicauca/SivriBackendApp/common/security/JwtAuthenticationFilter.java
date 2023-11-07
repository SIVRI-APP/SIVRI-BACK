package edu.unicauca.SivriBackendApp.common.security;

import edu.unicauca.SivriBackendApp.common.security.token.TokenRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Filtro de autenticación JWT que intercepta las solicitudes entrantes y verifica la autenticación
 * del usuario utilizando tokens JWT.
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final TokenRepository tokenRepository;

    /**
     * Realiza la autenticación del usuario a partir del token JWT en las solicitudes entrantes.
     *
     * @param request       Objeto HttpServletRequest que representa la solicitud entrante.
     * @param response      Objeto HttpServletResponse que representa la respuesta.
     * @param filterChain   Cadena de filtros para continuar el procesamiento de la solicitud.
     * @throws ServletException Si ocurre un error en el procesamiento de la solicitud.
     * @throws IOException      Si ocurre un error de E/S durante el procesamiento.
     */
    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        // Comprobar si la solicitud está relacionada con la autenticación
        if (request.getServletPath().contains("/api/v1/auth")) {
            filterChain.doFilter(request, response);
            return;
        }

        // Extraer el encabezado de autorización (token JWT)
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String usuarioCorreo;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            // Si no se proporciona un token JWT válido, continuar con la cadena de filtros
            filterChain.doFilter(request, response);
            return;
        }

        // Extraer el token JWT
        jwt = authHeader.substring(7);
        usuarioCorreo = jwtService.extractUsername(jwt);

        // Comprobar si el usuario está autenticado y el token JWT es válido
        if (usuarioCorreo != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(usuarioCorreo);
            var isTokenValid = tokenRepository.findByToken(jwt)
                    .map(t -> !t.isExpired() && !t.isRevoked())
                    .orElse(false);

            // Si el token JWT es válido, autenticar al usuario
            if (jwtService.isTokenValid(jwt, userDetails) && isTokenValid) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        // Continuar con la cadena de filtros
        filterChain.doFilter(request, response);
    }
}
