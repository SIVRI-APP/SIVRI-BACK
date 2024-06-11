package edu.unicauca.SivriBackendApp.common.seguridad.acceso.service;

import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.AuthenticationDTORequest;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.AuthenticationDTOResponse;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial.Credencial;
import edu.unicauca.SivriBackendApp.common.seguridad.config.JwtAuthenticationFilter;
import edu.unicauca.SivriBackendApp.common.seguridad.config.JwtService;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial.CredencialRepository;
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
public class AuthenticationService {

  private final CredencialRepository credencialRepository;
  private final TokenRepository tokenRepository;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final UsuarioRepository usuarioRepository;
  private final JwtAuthenticationFilter jwtAuthenticationFilter;

  /**
   * Realiza la autenticación de un usuario con las credenciales proporcionadas.
   *
   * @param request {@link AuthenticationDTORequest}
   * @return {@link AuthenticationDTOResponse}
   */
  public AuthenticationDTOResponse authenticate(AuthenticationDTORequest request) {

    // Realiza la autenticación utilizando el AuthenticationManager
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

    // Obtiene la Credencial desde el repositorio
    Credencial credencial = credencialRepository.findByEmail(request.getEmail())
        .orElseThrow();

    // Revoca todos los tokens anteriores del usuario y guarda el nuevo token de acceso
    revokeUserTokens(credencial);

    // Genera un nuevo token y lo almacena
    var jwtToken = jwtService.generateToken(credencial);
    saveUserToken(credencial, jwtToken);

    // Obtener el usuario autenticado
    UsuarioEntity usuarioAutenticado = usuarioRepository.findById(credencial.getUser().getId()).orElseThrow();

    // Obtener las autoridades de usuario
    Set<String> autoridades =  jwtAuthenticationFilter.getAuthorities(usuarioAutenticado.getCorreo()).stream()
            .map(SimpleGrantedAuthority::getAuthority)
            .collect(Collectors.toSet());

    // Construye y devuelve la respuesta de autenticación
    return AuthenticationDTOResponse.builder()
        .accessToken(jwtToken)
        .nombreCompleto(usuarioAutenticado.getNombre() + " " + usuarioAutenticado.getApellido())
        .tipoUsuario(String.valueOf(usuarioAutenticado.getTipoUsuario()))
        .authorities(autoridades)
        .build();
  }

  /**
   * Guarda un nuevo Token asociado a una Credencial
   * @param credencial {@link Credencial}
   * @param jwtToken Valor del Token
   */
  private void saveUserToken(Credencial credencial, String jwtToken) {
    // Guarda el nuevo token de usuario en el repositorio de tokens
    tokenRepository.save(
            Token.builder()
            .credencial(credencial)
            .token(jwtToken)
            .tokenType(TokenType.BEARER)
            .build()
    );
  }

  /**
   * Método que elimina los todos Tokens de una Credencial
   * @param credencial {@link Credencial}
   */
  private void revokeUserTokens(Credencial credencial) {
    // Obtiene todos los tokens válidos del usuario y los revoca
    var validUserTokens = tokenRepository.findAllValidTokenByUser(credencial.getId());

    if (validUserTokens.isEmpty()){
      return;
    }

    tokenRepository.deleteAll(validUserTokens);
  }
}
