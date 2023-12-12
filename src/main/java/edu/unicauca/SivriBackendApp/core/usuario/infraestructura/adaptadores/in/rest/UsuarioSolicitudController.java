package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.in.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in.UsuarioSolicitudCrearCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in.UsuarioSolicitudObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.in.rest.dto.petición.RegistroUsuarioDTO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.in.rest.dto.petición.devolverSolicitudConObservacionesDTO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.in.rest.mapper.UsuarioSolicitudRestMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarioSolicitud")
@AllArgsConstructor
public class UsuarioSolicitudController<T> {

    private final UsuarioSolicitudCrearCU usuarioSolicitudCrearCU;
    private final UsuarioSolicitudObtenerCU usuarioSolicitudObtenerCU;
    private  final UsuarioSolicitudRestMapper usuarioSolicitudRestMapper;

    @PostMapping("crearSolicitudUsuario")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:USUARIOS')")
    public  ResponseEntity<Respuesta> crearSolicitudUsuario(@Valid @RequestBody RegistroUsuarioDTO registro){
        Respuesta respuesta = usuarioSolicitudCrearCU.crearSolicitudUsuario(usuarioSolicitudRestMapper.registrarUsuario(registro));
        return ResponseEntity.ok().body(respuesta);
    }

    @PatchMapping("editarSolicitudUsuario")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:USUARIOS')")
    public  ResponseEntity<Respuesta> editarSolicitudUsuario(
            @RequestParam() long solicitudUsuarioId,
            @Valid @RequestBody RegistroUsuarioDTO registro){
        Respuesta respuesta = usuarioSolicitudCrearCU.editarSolicitudUsuario(solicitudUsuarioId, usuarioSolicitudRestMapper.registrarUsuario(registro));
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("listarTodoConFiltro")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR', " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:USUARIOS')")
    public  ResponseEntity<Respuesta> listarTodoConFiltro(
            @RequestParam(required = false) String correo,
            @RequestParam(required = false) TipoDocumento tipoDocumento,
            @RequestParam(required = false) String numeroDocumento,
            @RequestParam(required = false) String nombres,
            @RequestParam(required = false) String apellidos,
            @RequestParam(required = false) TipoUsuario tipoUsuario,
            @RequestParam(required = false) EstadoSolicitudUsuario estado,
            @RequestParam(required = false) Integer grupoId,
            @RequestParam() int pageNo,
            @RequestParam() int pageSize
    ){
        Respuesta respuesta = usuarioSolicitudObtenerCU.listarConFiltro(pageNo, pageSize, correo, tipoDocumento, numeroDocumento, nombres, apellidos, tipoUsuario, estado, grupoId);
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("obtenerSolicitudUsuario")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR', " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:USUARIOS')")
    public  ResponseEntity<Respuesta> obtenerSolicitudUsuario(@RequestParam() long solicitudUsuarioId){
        Respuesta respuesta = usuarioSolicitudObtenerCU.obtenerSolicitudUsuarioInformaciónDetallada(solicitudUsuarioId);
        return ResponseEntity.ok().body(respuesta);
    }

    @PostMapping("devolverSolicitudConObservaciones")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:USUARIOS')")
    public  ResponseEntity<Respuesta> devolverSolicitudConObservaciones(@Valid @RequestBody devolverSolicitudConObservacionesDTO petición){
        Respuesta respuesta = usuarioSolicitudCrearCU.devolverSolicitudConObservaciones(petición.getSolicitudUsuarioId(), petición.getObservación());
        return ResponseEntity.ok().body(respuesta);
    }

}
