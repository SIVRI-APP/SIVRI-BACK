package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioSolicitudObservacionesEliminarCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioSolicitudObservacionesObtenerCU;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarioSolicitudObservaciones")
@AllArgsConstructor
@Tag(name = "Controlador de Observaciones de Solicitud de Usuario", description = "Endpoints para gestionar observaciones de solicitudes de usuarios")
public class UsuarioSolicitudObservacionesController<T> {

    private final UsuarioSolicitudObservacionesObtenerCU usuarioSolicitudObservacionesObtenerCU;
    private final UsuarioSolicitudObservacionesEliminarCU usuarioSolicitudObservacionesEliminarCU;

    @GetMapping("listar")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR', " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:USUARIOS')")
    @Operation(
            summary = "Listar observaciones de solicitud de usuario",
            description = "Lista todas las observaciones asociadas a una solicitud de usuario."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Observaciones listadas exitosamente",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Respuesta.class)
            )
    )
    public ResponseEntity<Respuesta> listarTodoConFiltro(
            @Parameter(
                    name = "solicitudUsuarioId",
                    description = "ID de la solicitud de usuario asociada a las observaciones",
                    required = true
            )
            @RequestParam @Min(value = 0, message = "El valor de solicitudUsuarioId debe ser positivo") long solicitudUsuarioId,

            @Parameter(
                    name = "pageNo",
                    description = "Número de página",
                    required = true
            )
            @RequestParam @Min(value = 0, message = "El valor de pageNo debe ser positivo") int pageNo,

            @Parameter(
                    name = "pageSize",
                    description = "Tamaño de la página",
                    required = true
            )
            @RequestParam @Min(value = 0, message = "El valor de pageSize debe ser positivo") int pageSize
    ) {
        Respuesta respuesta = usuarioSolicitudObservacionesObtenerCU.listar(pageNo, pageSize, solicitudUsuarioId);
        return ResponseEntity.ok().body(respuesta);
    }

    @DeleteMapping("eliminar")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:USUARIOS')")
    @Operation(
            summary = "Eliminar observación de solicitud de usuario",
            description = "Elimina una observación asociada a una solicitud de usuario."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Observación de solicitud de usuario eliminada exitosamente",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Respuesta.class)
            )
    )
    public ResponseEntity<Respuesta> eliminar(
            @Parameter(
                    name = "solicitudUsuarioObservaciónId",
                    description = "ID de la observación de solicitud de usuario a eliminar",
                    required = true
            )
            @RequestParam long solicitudUsuarioObservaciónId
    ) {
        Respuesta respuesta = usuarioSolicitudObservacionesEliminarCU.eliminar(solicitudUsuarioObservaciónId);
        return ResponseEntity.ok().body(respuesta);
    }
}

