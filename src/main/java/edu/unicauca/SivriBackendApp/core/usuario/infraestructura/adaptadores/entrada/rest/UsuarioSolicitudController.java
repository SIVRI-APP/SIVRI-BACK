package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioSolicitudCrearCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioSolicitudObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest.mapper.UsuarioSolicitudRestMapper;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest.dto.petición.RegistroUsuarioDTO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest.dto.petición.devolverSolicitudConObservacionesDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarioSolicitud")
@AllArgsConstructor
@Tag(name = "Controlador de Solicitud de Usuario", description = "Endpoints para gestionar solicitudes de usuarios")
public class UsuarioSolicitudController<T> {

    private final UsuarioSolicitudCrearCU usuarioSolicitudCrearCU;
    private final UsuarioSolicitudObtenerCU usuarioSolicitudObtenerCU;
    private final UsuarioSolicitudRestMapper usuarioSolicitudRestMapper;

    @PostMapping("crearSolicitudUsuario")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:USUARIOS')")
    @Operation(
            summary = "Crear solicitud de usuario",
            description = "Crea una solicitud para registrar un nuevo usuario."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Solicitud de usuario creada exitosamente",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Respuesta.class)
            )
    )
    public ResponseEntity<Respuesta> crearSolicitudUsuario(
            @Parameter(
                    name = "registro",
                    description = "Datos para registrar un nuevo usuario",
                    required = true
            )
            @Valid @RequestBody RegistroUsuarioDTO registro
    ) {
        Respuesta respuesta = usuarioSolicitudCrearCU.crearSolicitudUsuario(usuarioSolicitudRestMapper.registrarUsuario(registro));
        return ResponseEntity.ok().body(respuesta);
    }

    @PatchMapping("editarSolicitudUsuario")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:USUARIOS')")
    @Operation(
            summary = "Editar solicitud de usuario",
            description = "Edita una solicitud existente para registrar un nuevo usuario."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Solicitud de usuario editada exitosamente",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Respuesta.class)
            )
    )
    public ResponseEntity<Respuesta> editarSolicitudUsuario(
            @Parameter(
                    name = "solicitudUsuarioId",
                    description = "ID de la solicitud de usuario a editar",
                    required = true
            )
            @RequestParam @Min(value = 0, message = "El valor de solicitudUsuarioId debe ser positivo") long solicitudUsuarioId,

            @Parameter(
                    name = "registro",
                    description = "Datos para registrar un nuevo usuario",
                    required = true
            )
            @Valid @RequestBody RegistroUsuarioDTO registro
    ) {
        Respuesta respuesta = usuarioSolicitudCrearCU.editarSolicitudUsuario(solicitudUsuarioId, usuarioSolicitudRestMapper.registrarUsuario(registro));
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("listarTodoConFiltro")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR', " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:USUARIOS')")
    @Operation(
            summary = "Listar todas las solicitudes con filtro",
            description = "Lista todas las solicitudes aplicando filtros opcionales."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Solicitudes listadas exitosamente",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Respuesta.class)
            )
    )
    public ResponseEntity<Respuesta> listarTodoConFiltro(
            @Parameter(
                    name = "correo",
                    description = "Correo del solicitante",
                    required = false
            )
            @RequestParam(required = false) String correo,

            @Parameter(
                    name = "tipoDocumento",
                    description = "Tipo de documento del solicitante",
                    required = false
            )
            @RequestParam(required = false) TipoDocumento tipoDocumento,

            @Parameter(
                    name = "numeroDocumento",
                    description = "Número de documento del solicitante",
                    required = false
            )
            @RequestParam(required = false) String numeroDocumento,

            @Parameter(
                    name = "nombres",
                    description = "Nombres del solicitante",
                    required = false
            )
            @RequestParam(required = false) String nombres,

            @Parameter(
                    name = "apellidos",
                    description = "Apellidos del solicitante",
                    required = false
            )
            @RequestParam(required = false) String apellidos,

            @Parameter(
                    name = "tipoUsuario",
                    description = "Tipo de usuario solicitante",
                    required = false
            )
            @RequestParam(required = false) TipoUsuario tipoUsuario,

            @Parameter(
                    name = "estado",
                    description = "Estado de la solicitud",
                    required = false
            )
            @RequestParam(required = false) EstadoSolicitudUsuario estado,

            @Parameter(
                    name = "grupoId",
                    description = "ID del grupo asociado a la solicitud",
                    required = false
            )
            @RequestParam(required = false) Integer grupoId,

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
        Respuesta respuesta = usuarioSolicitudObtenerCU.listarConFiltro(pageNo, pageSize, correo, tipoDocumento, numeroDocumento, nombres, apellidos, tipoUsuario, estado, grupoId);
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("obtenerSolicitudUsuario")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR', " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:USUARIOS')")
    @Operation(
            summary = "Obtener información detallada de solicitud de usuario",
            description = "Obtiene información detallada de una solicitud de usuario por su ID."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Información detallada de solicitud de usuario obtenida exitosamente",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Respuesta.class)
            )
    )
    public ResponseEntity<Respuesta> obtenerSolicitudUsuario(
            @Parameter(
                    name = "solicitudUsuarioId",
                    description = "ID de la solicitud de usuario a obtener",
                    required = true
            )
            @RequestParam @Min(value = 0, message = "El valor de solicitudUsuarioId debe ser positivo") long solicitudUsuarioId
    ) {
        Respuesta respuesta = usuarioSolicitudObtenerCU.obtenerSolicitudUsuarioInformaciónDetallada(solicitudUsuarioId);
        return ResponseEntity.ok().body(respuesta);
    }

    @PostMapping("devolverSolicitudConObservaciones")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:USUARIOS')")
    @Operation(
            summary = "Devolver solicitud con observaciones",
            description = "Devuelve una solicitud con observaciones."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Solicitud devuelta con observaciones exitosamente",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Respuesta.class)
            )
    )
    public ResponseEntity<Respuesta> devolverSolicitudConObservaciones(
            @Parameter(
                    name = "petición",
                    description = "Datos para devolver la solicitud con observaciones",
                    required = true
            )
            @Valid @RequestBody devolverSolicitudConObservacionesDTO petición
    ) {
        Respuesta respuesta = usuarioSolicitudCrearCU.devolverSolicitudConObservaciones(petición.getSolicitudUsuarioId(), petición.getObservación());
        return ResponseEntity.ok().body(respuesta);
    }


    @PostMapping("aprobar")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:USUARIOS')")
    @Operation(
            summary = "Aprobar solicitud de usuario",
            description = "Aprueba una solicitud de usuario."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Solicitud de usuario aprobada exitosamente",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Respuesta.class)
            )
    )
    public ResponseEntity<Respuesta> aprobar(
            @Parameter(
                    name = "solicitudUsuarioId",
                    description = "ID de la solicitud de usuario a aprobar",
                    required = true
            )
            @RequestParam @Min(value = 0, message = "El valor de solicitudUsuarioId debe ser positivo") long solicitudUsuarioId
    ) {
        Respuesta respuesta = usuarioSolicitudCrearCU.aprobarSolicitudUsuario(solicitudUsuarioId);
        return ResponseEntity.ok().body(respuesta);
    }

}
