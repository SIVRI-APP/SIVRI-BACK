package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioSolicitudEliminarCU;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
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
@RequestMapping("/usuario")
@AllArgsConstructor
@Tag(name = "Controlador de Usuario", description = "Endpoints para gestionar usuarios")
public class UsuarioController<T> {

    private final UsuarioObtenerCU usuarioObtenerCU;
    private final UsuarioSolicitudEliminarCU usuarioSolicitudEliminarCU;

    @GetMapping("obtenerUsuario")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:VICERRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:USUARIOS',   " +
            "'FUNCIONARIO:GRUPOS',  " +
            "'FUNCIONARIO:SEMILLEROS',  " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'FUNCIONARIO:PROYECTOS_EXTERNOS')")
    @Operation(
            summary = "Obtener usuario por ID",
            description = "Obtiene la información de un usuario por su ID."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Usuario obtenido exitosamente",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Respuesta.class)
            )
    )
    public ResponseEntity<Respuesta> obtenerUsuario(
            @Parameter(
                    name = "usuarioId",
                    description = "ID del usuario a obtener",
                    required = true
            )
            @RequestParam @Min(value = 0, message = "El valor de usuarioId debe ser positivo") long usuarioId
    ) {
        Respuesta respuesta = usuarioObtenerCU.obtenerUsuario(usuarioId);
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("listarConFiltro")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:VICERRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:USUARIOS',   " +
            "'FUNCIONARIO:GRUPOS',  " +
            "'FUNCIONARIO:SEMILLEROS',  " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'FUNCIONARIO:PROYECTOS_EXTERNOS')")
    @Operation(
            summary = "Listar usuarios con filtro",
            description = "Lista usuarios aplicando filtros opcionales."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Usuarios listados exitosamente",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Respuesta.class)
            )
    )
    public ResponseEntity<Respuesta> listarConFiltro(
            @Parameter(
                    name = "correo",
                    description = "Correo del usuario",
                    required = false
            )
            @RequestParam(required = false) String correo,

            @Parameter(
                    name = "tipoDocumento",
                    description = "Tipo de documento del usuario",
                    required = false
            )
            @RequestParam(required = false) TipoDocumento tipoDocumento,

            @Parameter(
                    name = "numeroDocumento",
                    description = "Número de documento del usuario",
                    required = false
            )
            @RequestParam(required = false) String numeroDocumento,

            @Parameter(
                    name = "nombres",
                    description = "Nombres del usuario",
                    required = false
            )
            @RequestParam(required = false) String nombres,

            @Parameter(
                    name = "apellidos",
                    description = "Apellidos del usuario",
                    required = false
            )
            @RequestParam(required = false) String apellidos,

            @Parameter(
                    name = "tipoUsuario",
                    description = "Tipo de usuario",
                    required = false
            )
            @RequestParam(required = false) TipoUsuario tipoUsuario,

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
        usuarioSolicitudEliminarCU.eliminadoProgramado();
        Respuesta respuesta = usuarioObtenerCU.listarConFiltro(pageNo, pageSize, correo, tipoDocumento, numeroDocumento, nombres, apellidos, tipoUsuario);
        return ResponseEntity.ok().body(respuesta);
    }
}

