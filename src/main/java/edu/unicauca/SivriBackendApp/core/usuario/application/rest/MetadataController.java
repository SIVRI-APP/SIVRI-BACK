package edu.unicauca.SivriBackendApp.core.usuario.application.rest;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.in.MetadataCU;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("metadata")
@AllArgsConstructor
public class MetadataController {

    private final MetadataCU metadataCU;

    @GetMapping("tiposDocumento")
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
    public ResponseEntity<Respuesta> obtenerTiposDocumento() {

        Respuesta respuesta = metadataCU.obtenerTiposDocumento();
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("sexo")
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
    public ResponseEntity<Respuesta> obtenerSexo() {

        Respuesta respuesta = metadataCU.obtenerSexo();
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("tiposUsuario")
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
    public ResponseEntity<Respuesta> obtenerTiposUsuario() {

        Respuesta respuesta = metadataCU.obtenerTiposUsuario();
        return ResponseEntity.ok().body(respuesta);
    }
}
