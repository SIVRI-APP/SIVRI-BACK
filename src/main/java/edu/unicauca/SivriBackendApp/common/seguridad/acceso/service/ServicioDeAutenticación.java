package edu.unicauca.SivriBackendApp.common.seguridad.acceso.service;

import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.AutenticaciónPetición;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.AutenticaciónRespuesta;
import edu.unicauca.SivriBackendApp.common.seguridad.config.JwtAuthenticationFilter;
import edu.unicauca.SivriBackendApp.common.seguridad.config.JwtService;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial.Credencial;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial.RepositorioCredencial;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.token.Token;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.token.TokenRepository;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.token.TokenType;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.UsuarioEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorios.UsuarioRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Servicio encargado de manejar la autenticación de usuarios.
 */
@Service
@RequiredArgsConstructor
public class ServicioDeAutenticación {
  private final RepositorioCredencial repository;
  private final TokenRepository tokenRepository;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final UsuarioRepository usuarioRepository;
  private final JwtAuthenticationFilter jwtAuthenticationFilter;

  /**
   * Realiza la autenticación de un usuario con las credenciales proporcionadas.
   *
   * @param request Datos de autenticación del usuario.
   * @return Objeto AutenticaciónRespuesta con tokens de acceso y actualización generados.
   */
  public AutenticaciónRespuesta autenticar(AutenticaciónPetición request) {

    // Realiza la autenticación utilizando el AuthenticationManager
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

    // Obtiene el usuario desde el repositorio
    var user = repository.findByEmail(request.getEmail())
        .orElseThrow();

    // Genera un token de acceso y un token de actualización
    var jwtToken = jwtService.generateToken(user);
    var refreshToken = jwtService.generateRefreshToken(user);

    // Revoca todos los tokens anteriores del usuario y guarda el nuevo token de acceso
    revokeAllUserTokens(user);
    saveUserToken(user, jwtToken);

    // Obtener el usuario
    UsuarioEntity usuarioAutenticado = usuarioRepository.findById(user.getUsuario().getId()).get();

    // Obtener las autoridades de usuario
    Set<String> autoridades =  jwtAuthenticationFilter.getAuthorities(usuarioAutenticado.getCorreo()).stream()
            .map(SimpleGrantedAuthority::getAuthority)
            .collect(Collectors.toSet());

    // Construye y devuelve la respuesta de autenticación
    return AutenticaciónRespuesta.builder()
        .accessToken(jwtToken)
        .refreshToken(refreshToken)
        .nombreCompleto(usuarioAutenticado.getNombre() + " " + usuarioAutenticado.getApellido())
        .tipoUsuario(String.valueOf(usuarioAutenticado.getTipoUsuario()))
        .authorities(autoridades)
        .build();
  }

  private void saveUserToken(Credencial credential, String jwtToken) {
    // Guarda el nuevo token de usuario en el repositorio de tokens
    var token = Token.builder()
        .credencial(credential)
        .token(jwtToken)
        .tokenType(TokenType.BEARER)
        .expired(false)
        .revoked(false)
        .build();
    tokenRepository.save(token);
  }

  private void revokeAllUserTokens(Credencial credential) {
    // Obtiene todos los tokens válidos del usuario y los revoca
    var validUserTokens = tokenRepository.findAllValidTokenByUser(credential.getId());
    if (validUserTokens.isEmpty()){
      return;
    }

    validUserTokens.forEach(token -> {
      token.setExpired(true);
      token.setRevoked(true);
    });
    // Guarda los cambios en los tokens revocados
    tokenRepository.saveAll(validUserTokens);
  }
}
