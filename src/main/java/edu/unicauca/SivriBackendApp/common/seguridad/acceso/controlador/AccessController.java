package edu.unicauca.SivriBackendApp.common.seguridad.acceso.controlador;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.AuthenticationDTORequest;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.AuthenticationDTOResponse;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.CrearActualizarCredencialRequest;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.AuthenticationService;

import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.CredentialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/access")
@RequiredArgsConstructor
public class AccessController {

  private final AuthenticationService authenticationService;
  private final CredentialService credentialService;

  /**
   * Servicio Rest para la autenticación de un Usuario en el sistema
   * @param request {@link AuthenticationDTORequest}
   * @return {@link AuthenticationDTOResponse}
   */
  @PostMapping("/auth")
  public ResponseEntity<AuthenticationDTOResponse> authenticate(@Valid @RequestBody AuthenticationDTORequest request) {
    return ResponseEntity.ok(authenticationService.authenticate(request));
  }

  /**
   * Servicio Rest para que el usuario pueda crear o actualizar una contraseña
   * @param request {@link CrearActualizarCredencialRequest}
   * @return Bandera con el estado de la transacción
   */
  @PostMapping("/crearActualizarCredencial")
  public ResponseEntity<Boolean> crearActualizarCredencial(@Valid @RequestBody CrearActualizarCredencialRequest request) {
    credentialService.crearActualizarCredencial(request);
    return ResponseEntity.ok(true);
  }

}
