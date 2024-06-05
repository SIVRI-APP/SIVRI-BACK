package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.entrada.UsuarioObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.proyecciones.UsuarioInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.proyecciones.UsuarioListarConFiltroProyeccion;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
@Tag(name = "Controlador de Usuario", description = "Endpoints para gestionar usuarios")
public class UsuarioController {

    private final UsuarioObtenerCU usuarioObtenerCU;

    @GetMapping("listarTodoConFiltro")
    @PreAuthorize("hasAnyAuthority(" + "'GRUPO:DIRECTOR', " + "'FUNCIONARIO:SUPER_ADMIN', " + "'FUNCIONARIO:USUARIOS')")
    @Operation(summary = "Listar todas las solicitudes con filtro", description = "Lista todas las solicitudes aplicando filtros opcionales.")
    @ApiResponse(responseCode = "200", description = "Solicitudes listadas exitosamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Respuesta.class)))
    public ResponseEntity<Respuesta<Page<UsuarioListarConFiltroProyeccion>>> listarTodoConFiltro(@Parameter(name = "correo", description = "Correo del solicitante") @RequestParam(required = false) String correo,

                                                                                                 @Parameter(name = "tipoDocumento", description = "Tipo de documento del solicitante") @RequestParam(required = false) TipoDocumento tipoDocumento,

                                                                                                 @Parameter(name = "numeroDocumento", description = "Número de documento del solicitante") @RequestParam(required = false) String numeroDocumento,

                                                                                                 @Parameter(name = "nombre", description = "Nombres del solicitante") @RequestParam(required = false) String nombre,

                                                                                                 @Parameter(name = "apellido", description = "Apellidos del solicitante") @RequestParam(required = false) String apellido,

                                                                                                 @Parameter(name = "tipoUsuario", description = "Tipo de usuario solicitante") @RequestParam(required = false) TipoUsuario tipoUsuario,

                                                                                                 @Parameter(name = "organismoDeInvestigacionId", description = "ID del grupo asociado a la solicitud") @RequestParam(required = false) Integer organismoDeInvestigacionId,

                                                                                                 @Parameter(name = "pageNo", description = "Número de página", required = true) @RequestParam @Min(value = 0, message = "El valor de pageNo debe ser positivo") int pageNo,

                                                                                                 @Parameter(name = "pageSize", description = "Tamaño de la página", required = true) @RequestParam @Min(value = 0, message = "El valor de pageSize debe ser positivo") int pageSize) {
        Respuesta<Page<UsuarioListarConFiltroProyeccion>> respuesta = usuarioObtenerCU.listarConFiltro(pageNo, pageSize, correo, tipoDocumento, numeroDocumento, nombre, apellido, tipoUsuario, organismoDeInvestigacionId);
        return ResponseEntity.ok().body(respuesta);
    }


    @GetMapping("obtenerUsuario")
    @PreAuthorize("hasAnyAuthority(" + "'GRUPO:DIRECTOR', " + "'FUNCIONARIO:SUPER_ADMIN', " + "'FUNCIONARIO:USUARIOS')")
    @Operation(summary = "Obtener información detallada de solicitud de usuario", description = "Obtiene información detallada de una solicitud de usuario por su ID.")
    @ApiResponse(responseCode = "200", description = "Información detallada de solicitud de usuario obtenida exitosamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Respuesta.class)))
    public ResponseEntity<Respuesta<UsuarioInformacionDetalladaProyeccion>> obtenerSolicitudUsuario(@Parameter(name = "usuarioId", description = "ID del usuario a obtener", required = true) @RequestParam @Min(value = 0, message = "El valor de usuarioId debe ser positivo") long usuarioId) {
        Respuesta<UsuarioInformacionDetalladaProyeccion> respuesta = usuarioObtenerCU.obtenerUsuarioInformacionDetallada(usuarioId);
        return ResponseEntity.ok().body(respuesta);
    }

}
