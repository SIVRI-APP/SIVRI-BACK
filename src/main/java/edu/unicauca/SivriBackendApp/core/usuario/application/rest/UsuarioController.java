package edu.unicauca.SivriBackendApp.core.usuario.application.rest;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.application.dto.request.RegistroUsuarioDTO;
import edu.unicauca.SivriBackendApp.core.usuario.application.mapper.UsuarioAppMapper;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.in.UsuarioCrearCU;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.in.UsuarioObtenerCU;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("usuario")
@AllArgsConstructor
public class UsuarioController<T> {

    private final UsuarioObtenerCU usuarioObtenerCU;
    private final UsuarioCrearCU usuarioCrearCU;
    private  final UsuarioAppMapper usuarioAppMapper;

    @GetMapping("validarExistenciaSistema")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR',  " +
            "'SEMILLERO:MENTOR',  " +
            "'PROYECTO:DIRECTOR',    " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:SUPER_ADMIN',  " +
            "'FUNCIONARIO:USUARIOS',   " +
            "'FUNCIONARIO:GRUPOS',  " +
            "'FUNCIONARIO:SEMILLEROS',  " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'FUNCIONARIO:PROYECTOS_EXTERNOS')")
    public ResponseEntity<Respuesta> validarExistenciaUsuarioSistema(
            @RequestParam(name = "tipoDocumento") String tipoDocumento,
            @RequestParam(name = "numeroDocumento") String numeroDocumento
    ) {

        Respuesta respuesta = usuarioObtenerCU.validarExistenciaUsuarioSistema(tipoDocumento, numeroDocumento);

        return ResponseEntity.ok().body(respuesta);
    }

    @PostMapping("registrarUsuario")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:USUARIOS')")
    public  ResponseEntity<Respuesta> registrarUsuario(@Valid @RequestBody RegistroUsuarioDTO registro){
        Respuesta respuesta = usuarioCrearCU.guardar(usuarioAppMapper.registrarUsuario(registro));
        return ResponseEntity.ok().body(respuesta);
    }

}
