package edu.unicauca.SivriBackendApp.common.seguridad.acceso.controlador;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.CambioContraseñaPetición;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.AutenticaciónPetición;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.AutenticaciónRespuesta;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeAutenticación;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeCredencial;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/v1/acceso")
@RequiredArgsConstructor
@Tag(name = "Controlador de Autenticación", description = "Endpoints para la autenticación de usuarios ante el sistema")
public class ControladorDeAcceso {

  private final ServicioDeAutenticación servicioDeAutenticación;
  private final ServicioDeCredencial servicioDeCredencial;

  @PostMapping("/autenticar")
  @Operation(
          summary = "Autenticar a un usuario ante el sistema",
          description = "Autenticar a un usuario con las credenciales proporcionadas.",
          responses = {
                  @ApiResponse(
                          responseCode = "200",
                          description = "Autenticación exitosa",
                          content = @Content(
                                  mediaType = "application/json",
                                  schema = @Schema(implementation = AutenticaciónRespuesta.class)
                          )
                  ),
                  @ApiResponse(responseCode = "403", description = "Acceso no autorizado")
          }
  )
  public ResponseEntity<AutenticaciónRespuesta> autenticar(@Valid @RequestBody AutenticaciónPetición request) {
    return ResponseEntity.ok(servicioDeAutenticación.autenticar(request));
  }

  @PostMapping("/olvideMiContraseña")
  @Operation(
          summary = "Solicitar al sistema el cambio de contraseña",
          description = "Permite el cambio de una contraseña en caso de haberla olvidado por medio de un correo electrónico.",
          responses = {
                  @ApiResponse(
                          responseCode = "200",
                          description = "Se ha enviado un correo electrónico a {}",
                          content = @Content(
                                  mediaType = "application/json",
                                  schema = @Schema(implementation = Respuesta.class)
                          )
                  )
          }
  )
  public ResponseEntity<Respuesta> olvideMiContraseña(@Valid @RequestParam String email) {
    return ResponseEntity.ok(servicioDeCredencial.olvideMiContraseña(email));
  }

    @PatchMapping("/recuperarContraseña/{codigoRecuperarContraseña}")
    @Operation(
            summary = "Cambiar contraseña cuando el usuario a seleccionado la opción olvide contraseña",
            description = "Una vez el usuario recibe un correo electrónico para recuperar la contraseña el usuario puede llenar un formulario para recuperar la contraseña por medio de esta API",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Cambio de contraseña exitoso",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Boolean.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Solicitud inválida",
                            content = @Content(mediaType = "application/json")
                    )
            }
    )
    public ResponseEntity<Boolean> recuperarContraseña(@Min (value = 1, message = "El código de validación es obligatorio") @PathVariable int codigoRecuperarContraseña,
                                                       @NotNull(message = "El campo email es obligatorio") @RequestParam String email,
                                                       @NotEmpty(message = "Contraseña no puede ser nula") @Size(min = 5, max = 200, message = "Contraseña debe tener entre 5 y 200 caracteres") @RequestParam String nuevaClave) {
        return ResponseEntity.ok(servicioDeCredencial.recuperarContraseña(email, nuevaClave, codigoRecuperarContraseña));
    }

  @PatchMapping("/cambiarContraseña")
  @Operation(
          summary = "Cambiar contraseña",
          description = "Cambiar la contraseña del usuario conectado.",
          responses = {
                  @ApiResponse(
                          responseCode = "200",
                          description = "Cambio de contraseña exitoso",
                          content = @Content(
                                  mediaType = "application/json",
                                  schema = @Schema(implementation = Boolean.class)
                          )
                  ),
                  @ApiResponse(
                          responseCode = "400",
                          description = "Solicitud inválida",
                          content = @Content(mediaType = "application/json")
                  )
          }
  )
  public ResponseEntity<Boolean> cambiarContraseña(@RequestBody CambioContraseñaPetición request, Principal connectedUser) {
    return ResponseEntity.ok(servicioDeCredencial.cambiarContraseña(request, connectedUser));
  }
}
