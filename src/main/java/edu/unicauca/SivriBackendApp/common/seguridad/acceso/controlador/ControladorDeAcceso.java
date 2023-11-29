package edu.unicauca.SivriBackendApp.common.seguridad.acceso.controlador;

import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.CambioContraseñaPetición;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.AutenticaciónPetición;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.RegistroCredencialPetición;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.dto.AutenticaciónRespuesta;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeAutenticación;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeCredencial;
import io.swagger.v3.oas.annotations.Operation;
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
  @Operation(summary = "Autenticar usuario", description = "Autenticar a un usuario con las credenciales proporcionadas.")
  public ResponseEntity<AutenticaciónRespuesta> autenticar(@Valid @RequestBody AutenticaciónPetición request) {
    return ResponseEntity.ok(servicioDeAutenticación.autenticar(request));
  }

  @PatchMapping
  public ResponseEntity<Boolean> cambiarContraseña(@RequestBody CambioContraseñaPetición request, Principal connectedUser) {
    return ResponseEntity.ok(servicioDeCredencial.cambiarContraseña(request, connectedUser));
  }
}
