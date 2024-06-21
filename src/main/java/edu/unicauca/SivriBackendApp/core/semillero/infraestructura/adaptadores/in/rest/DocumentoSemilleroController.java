package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.DocumentoSemilleroActualizarCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.DocumentoSemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.DocumentoSemilleroActualizarDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.mapper.DocumentoSemilleroDtoMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("documentoSemillero")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DocumentoSemilleroController {
    private final DocumentoSemilleroObtenerCU documentoSemilleroObtenerCU;
    private final DocumentoSemilleroActualizarCU documentoSemilleroActualizarCU;
    private final DocumentoSemilleroDtoMapper documentoSemilleroDtoMapper;

    public DocumentoSemilleroController(DocumentoSemilleroObtenerCU documentoSemilleroObtenerCU, DocumentoSemilleroActualizarCU documentoSemilleroActualizarCU, DocumentoSemilleroDtoMapper documentoSemilleroDtoMapper) {
        this.documentoSemilleroObtenerCU = documentoSemilleroObtenerCU;
        this.documentoSemilleroActualizarCU = documentoSemilleroActualizarCU;
        this.documentoSemilleroDtoMapper = documentoSemilleroDtoMapper;
    }

    @GetMapping("/documentoPorId/{id}")
    public ResponseEntity<Respuesta> obtenerDocumentoSemilleroPorId(
            @PathVariable(value = "id") int id
    ){
        Respuesta respuesta = documentoSemilleroObtenerCU.obtenerPorId(id);
        respuesta.setData(documentoSemilleroDtoMapper.obtenerDocumentoSemillero((DocumentoSemillero) respuesta.getData()));
        return ResponseEntity.ok().body(respuesta);
    }

    @PatchMapping("/actualizarDocumentoSemillero/{id}")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:SEMILLEROS')")
    public ResponseEntity<Respuesta> actualizarDocumentoSemillero(
            @PathVariable(value = "id") int idDocumento,
            @Valid @RequestBody DocumentoSemilleroActualizarDTO documentoSemilleroActualizarDTO
            ){
        Respuesta respuesta= documentoSemilleroActualizarCU.actualizar(idDocumento,documentoSemilleroDtoMapper.actualizarDocumento(documentoSemilleroActualizarDTO));
        return ResponseEntity.ok().body(respuesta);
    }

}
