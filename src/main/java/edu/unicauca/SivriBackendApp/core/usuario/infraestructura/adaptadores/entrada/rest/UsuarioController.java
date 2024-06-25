package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.entrada.UsuarioObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.proyecciones.UsuarioInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.proyecciones.UsuarioListarConFiltroProyeccion;

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
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR', " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:USUARIOS')")
    public ResponseEntity<Respuesta<Page<UsuarioListarConFiltroProyeccion>>> listarTodoConFiltro(@RequestParam(required = false) String correo,
                                                                                                 @RequestParam(required = false) TipoDocumento tipoDocumento,
                                                                                                 @RequestParam(required = false) String numeroDocumento,
                                                                                                 @RequestParam(required = false) String nombre,
                                                                                                 @RequestParam(required = false) String apellido,
                                                                                                 @RequestParam(required = false) TipoUsuario tipoUsuario,
                                                                                                 @RequestParam(required = false) Integer organismoDeInvestigacionId,
                                                                                                 @RequestParam @Min(value = 0, message = "El valor de pageNo debe ser positivo") int pageNo,
                                                                                                 @RequestParam @Min(value = 0, message = "El valor de pageSize debe ser positivo") int pageSize) {
        Respuesta<Page<UsuarioListarConFiltroProyeccion>> respuesta = usuarioObtenerCU.listarConFiltro(pageNo, pageSize, correo, tipoDocumento, numeroDocumento, nombre, apellido, tipoUsuario, organismoDeInvestigacionId);
        return ResponseEntity.ok().body(respuesta);
    }


    @GetMapping("obtenerUsuario")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR', " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:USUARIOS')")
    public ResponseEntity<Respuesta<UsuarioInformacionDetalladaProyeccion>> obtenerUsuario(
            @RequestParam @Min(value = 0, message = "El valor de usuarioId debe ser positivo") long usuarioId
    ) {
        Respuesta<UsuarioInformacionDetalladaProyeccion> respuesta = usuarioObtenerCU.obtenerUsuarioInformacionDetallada(usuarioId);
        return ResponseEntity.ok().body(respuesta);
    }

}
