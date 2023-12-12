package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.in.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in.UsuarioObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in.UsuarioSolicitudEliminarCU;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoUsuario;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
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
    public ResponseEntity<Respuesta> obtenerUsuario(@RequestParam() long usuarioId) {

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
    public  ResponseEntity<Respuesta> listarConFiltro(
            @RequestParam(required = false) String correo,
            @RequestParam(required = false) TipoDocumento tipoDocumento,
            @RequestParam(required = false) String numeroDocumento,
            @RequestParam(required = false) String nombres,
            @RequestParam(required = false) String apellidos,
            @RequestParam(required = false) TipoUsuario tipoUsuario,
            @RequestParam() int pageNo,
            @RequestParam() int pageSize
    ){
        usuarioSolicitudEliminarCU.eliminadoProgramado();
        Respuesta respuesta = usuarioObtenerCU.listarConFiltro(pageNo, pageSize, correo, tipoDocumento, numeroDocumento, nombres, apellidos, tipoUsuario);
        return ResponseEntity.ok().body(respuesta);
    }

}
