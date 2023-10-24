package edu.unicauca.SivriBackendApp.core.usuario.application.rest;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.application.mapper.UsuarioDtoMapper;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.in.UsuarioObtenerCU;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController<T> {

    private UsuarioObtenerCU usuarioObtenerCU;

    private UsuarioDtoMapper usuarioDtoMapper;

    public UsuarioController(UsuarioObtenerCU usuarioObtenerCU, UsuarioDtoMapper usuarioDtoMapper) {
        this.usuarioObtenerCU = usuarioObtenerCU;
        this.usuarioDtoMapper = usuarioDtoMapper;
    }

    @GetMapping("/validar_vinculacion")
    public ResponseEntity<Respuesta> validarVinculacionUsuarioGrupo(
            @RequestParam(value = "tipoDocumento", required = true) TipoDocumento tipoDocumento,
            @RequestParam(value = "numeroDocumento", required = true) String numeroDocumento
    ) {
        Respuesta respuesta = usuarioObtenerCU.validarVinculacionUsuarioGrupo(tipoDocumento, numeroDocumento);

        return ResponseEntity.ok().body(respuesta);
    }
}
