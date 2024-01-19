package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.MetadataCU;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/metadata")
@AllArgsConstructor
public class MetadataController {

    private final MetadataCU metadataCU;

    @GetMapping("tiposDocumento")
    public ResponseEntity<Respuesta> obtenerTiposDocumento() {

        Respuesta respuesta = metadataCU.obtenerTiposDocumento();
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("sexo")
    public ResponseEntity<Respuesta> obtenerSexo() {

        Respuesta respuesta = metadataCU.obtenerSexo();
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("tiposUsuario")
    public ResponseEntity<Respuesta> obtenerTiposUsuario() {

        Respuesta respuesta = metadataCU.obtenerTiposUsuario();
        return ResponseEntity.ok().body(respuesta);
    }
}
