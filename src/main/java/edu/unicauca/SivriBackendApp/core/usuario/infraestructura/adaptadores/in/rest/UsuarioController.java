package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.in.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in.UsuarioObtenerCU;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController<T> {

    private final UsuarioObtenerCU usuarioObtenerCU;

    @GetMapping("obtenerUsuario")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR',  " +
            "'SEMILLERO:MENTOR',  " +
            "'PROYECTO:DIRECTOR',    " +
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

}
