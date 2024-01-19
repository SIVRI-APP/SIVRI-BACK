package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.entrada.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.MetadataCU;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/metadata")
@AllArgsConstructor
@Tag(name = "Controlador de Metadata", description = "Endpoints para obtener información de metadata")
public class MetadataController {

    private final MetadataCU metadataCU;

    @GetMapping("tiposDocumento")
    @Operation(
            summary = "Obtener tipos de documento",
            description = "Obtiene la lista de tipos de documento disponibles."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Tipos de documento obtenidos exitosamente",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Respuesta.class)
            )
    )
    public ResponseEntity<Respuesta> obtenerTiposDocumento() {
        Respuesta respuesta = metadataCU.obtenerTiposDocumento();
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("sexo")
    @Operation(
            summary = "Obtener opciones de sexo",
            description = "Obtiene la lista de opciones de sexo disponibles."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Opciones de sexo obtenidas exitosamente",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Respuesta.class)
            )
    )
    public ResponseEntity<Respuesta> obtenerSexo() {
        Respuesta respuesta = metadataCU.obtenerSexo();
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("tiposUsuario")
    @Operation(
            summary = "Obtener tipos de usuario",
            description = "Obtiene la lista de tipos de usuario disponibles."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Tipos de usuario obtenidos exitosamente",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Respuesta.class)
            )
    )
    public ResponseEntity<Respuesta> obtenerTiposUsuario() {
        Respuesta respuesta = metadataCU.obtenerTiposUsuario();
        return ResponseEntity.ok().body(respuesta);
    }
}

