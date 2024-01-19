package edu.unicauca.SivriBackendApp.common.seguridad.acceso.controlador;

import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.CambioContraseñaPetición;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.AutenticaciónPetición;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.RegistroCredencialPetición;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.AutenticaciónRespuesta;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeAutenticación;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeCredencial;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/v1/acceso")
@RequiredArgsConstructor
@Tag(name = "Controlador de Autenticación", description = "Endpoints para la autenticación de usuarios")
public class ControladorDeAcceso {

  private final ServicioDeAutenticación servicioDeAutenticación;
  private final ServicioDeCredencial servicioDeCredencial;

  @PostMapping("/autenticar")
  @Operation(
          summary = "Autenticar usuario",
          description = "Autenticar a un usuario con las credenciales proporcionadas."
  )
  @ApiResponse(
          responseCode = "200",
          description = "Autenticación exitosa",
          content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = AutenticaciónRespuesta.class)
          )
  )
  @ApiResponse(
          responseCode = "400",
          description = "Solicitud inválida",
          content = @Content(mediaType = "application/json")
  )
  public ResponseEntity<AutenticaciónRespuesta> autenticar(
          @Valid @RequestBody AutenticaciónPetición request
  ) {
    return ResponseEntity.ok(servicioDeAutenticación.autenticar(request));
  }

  @PatchMapping
  @Operation(
          summary = "Cambiar contraseña",
          description = "Cambiar la contraseña del usuario conectado."
  )
  @ApiResponse(
          responseCode = "200",
          description = "Cambio de contraseña exitoso",
          content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Boolean.class)
          )
  )
  @ApiResponse(
          responseCode = "400",
          description = "Solicitud inválida",
          content = @Content(mediaType = "application/json")
  )
  public ResponseEntity<Boolean> cambiarContraseña(
          @RequestBody CambioContraseñaPetición request,
          Principal connectedUser
  ) {
    return ResponseEntity.ok(servicioDeCredencial.cambiarContraseña(request, connectedUser));
  }
}
