package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioSolicitudObservacionesEliminarCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioSolicitudObservacionesObtenerCU;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarioSolicitudObservaciones")
@AllArgsConstructor
public class UsuarioSolicitudObservacionesController<T> {

    private final UsuarioSolicitudObservacionesObtenerCU usuarioSolicitudObservacionesObtenerCU;
    private final UsuarioSolicitudObservacionesEliminarCU usuarioSolicitudObservacionesEliminarCU;

    @GetMapping("listar")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR', " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:USUARIOS')")
    public  ResponseEntity<Respuesta> listarTodoConFiltro(
            @RequestParam() long solicitudUsuarioId,
            @RequestParam() int pageNo,
            @RequestParam() int pageSize
    ){
        Respuesta respuesta = usuarioSolicitudObservacionesObtenerCU.listar(pageNo, pageSize, solicitudUsuarioId);
        return ResponseEntity.ok().body(respuesta);
    }

    @DeleteMapping("eliminar")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:USUARIOS')")
    public  ResponseEntity<Respuesta> eliminar(@RequestParam() long solicitudUsuarioObservaciónId){
        Respuesta respuesta = usuarioSolicitudObservacionesEliminarCU.eliminar(solicitudUsuarioObservaciónId);
        return ResponseEntity.ok().body(respuesta);
    }

}
