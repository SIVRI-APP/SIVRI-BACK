package edu.unicauca.SivriBackendApp.common.seguridad.acceso.service;



import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.AutenticaciónPetición;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.AutenticaciónRespuesta;
import edu.unicauca.SivriBackendApp.common.seguridad.config.JwtService;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial.Credencial;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.credencial.RepositorioCredencial;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.token.Token;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.token.TokenRepository;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.persistencia.token.TokenType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioDeAutenticación {
  private final RepositorioCredencial repository;
  private final TokenRepository tokenRepository;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AutenticaciónRespuesta autenticar(AutenticaciónPetición request) {

    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

    var user = repository.findByEmail(request.getEmail())
        .orElseThrow();

    var jwtToken = jwtService.generateToken(user);
    var refreshToken = jwtService.generateRefreshToken(user);

    revokeAllUserTokens(user);
    saveUserToken(user, jwtToken);

    return AutenticaciónRespuesta.builder()
        .accessToken(jwtToken)
            .refreshToken(refreshToken)
        .build();
  }

  private void saveUserToken(Credencial credential, String jwtToken) {
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
    var validUserTokens = tokenRepository.findAllValidTokenByUser(credential.getId());
    if (validUserTokens.isEmpty())
      return;
    validUserTokens.forEach(token -> {
      token.setExpired(true);
      token.setRevoked(true);
    });
    tokenRepository.saveAll(validUserTokens);
  }
}
