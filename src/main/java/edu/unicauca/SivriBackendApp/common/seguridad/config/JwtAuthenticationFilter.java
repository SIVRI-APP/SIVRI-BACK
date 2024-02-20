package edu.unicauca.SivriBackendApp.common.seguridad.config;

import edu.unicauca.SivriBackendApp.common.exception.CredencialIncorrectaException;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial.RepositorioCredencial;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial.IGetAuthorities;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.token.TokenRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Filtro de autenticación JWT para procesar las solicitudes de autenticación con tokens JWT.
 * Este filtro se encarga de validar y autenticar los tokens JWT presentes en las solicitudes HTTP.
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final JwtService jwtService;
  private final UserDetailsService userDetailsService;
  private final TokenRepository tokenRepository;
  private final RepositorioCredencial repositorioCredencial;

  /**
   * Obtiene las autoridades (roles) asociadas al usuario con el correo electrónico proporcionado.
   *
   * @param userEmail Correo electrónico del usuario
   * @return Conjunto de autoridades asignadas al usuario
   */
  private Set<SimpleGrantedAuthority> getAuthorities (String userEmail){
    Set<SimpleGrantedAuthority> authorities = new HashSet<>();

    //Grupo
    List<IGetAuthorities> grupoUserAuthorities = repositorioCredencial.getAuthoritiesGrupo(userEmail);
    for (IGetAuthorities auth: grupoUserAuthorities) {
      authorities.add(new SimpleGrantedAuthority(auth.getAuthorities()));
    }
    //Semillero
    List<IGetAuthorities> semilleroUserAuthorities = repositorioCredencial.getAuthoritiesSemillero(userEmail);
    for (IGetAuthorities auth: semilleroUserAuthorities) {
      authorities.add(new SimpleGrantedAuthority(auth.getAuthorities()));
    }
    //Proyecto
    // Funcionario
    List<IGetAuthorities> userAuthorities = repositorioCredencial.getAuthoritiesFuncionario(userEmail);
    for (IGetAuthorities auth: userAuthorities) {
      authorities.add(new SimpleGrantedAuthority(auth.getAuthorities()));
    }

    return authorities;
  }

  /**
   * Procesa las solicitudes HTTP para validar y autenticar los tokens JWT en el encabezado 'Authorization'.
   *
   * @param request     La solicitud HTTP actual
   * @param response    La respuesta HTTP actual
   * @param filterChain Cadena de filtros para continuar con el procesamiento de la solicitud
   * @throws ServletException Si ocurre una excepción en el servlet
   * @throws IOException      Si ocurre una excepción de entrada/salida
   */
  @Override
  protected void doFilterInternal(
      @NonNull HttpServletRequest request,
      @NonNull HttpServletResponse response,
      @NonNull FilterChain filterChain
  ) throws ServletException, IOException, CredencialIncorrectaException {
    if (request.getServletPath().contains("/v1/acceso/autenticar")) {
      filterChain.doFilter(request, response);
      return;
    }
    final String authHeader = request.getHeader("Authorization");
    final String jwt;
    final String userEmail;
    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
      filterChain.doFilter(request, response);
      return;
    }
    jwt = authHeader.substring(7);
    userEmail = jwtService.extractUsername(jwt);
    if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
      var isTokenValid = tokenRepository.findByToken(jwt)
          .map(t -> !t.isExpired() && !t.isRevoked())
          .orElse(false);
      if (jwtService.isTokenValid(jwt, userDetails) && isTokenValid) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
            userDetails,
            null,
            getAuthorities(userEmail)
        );
        authToken.setDetails(
            new WebAuthenticationDetailsSource().buildDetails(request)
        );
        SecurityContextHolder.getContext().setAuthentication(authToken);
      }
    }

    filterChain.doFilter(request, response);
  }
}
