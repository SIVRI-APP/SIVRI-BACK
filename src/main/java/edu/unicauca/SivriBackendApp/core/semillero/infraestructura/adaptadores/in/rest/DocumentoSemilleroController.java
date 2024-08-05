package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.DocumentoSemilleroActualizarCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.DocumentoSemilleroCrearCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.DocumentoSemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.DocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.TipoDocumentoSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.Base64FileDto;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.DocumentoSemilleroActualizarDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.mapper.DocumentoSemilleroDtoMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("documentoSemillero")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DocumentoSemilleroController {
    private final DocumentoSemilleroObtenerCU documentoSemilleroObtenerCU;
    private final DocumentoSemilleroActualizarCU documentoSemilleroActualizarCU;
    private final DocumentoSemilleroDtoMapper documentoSemilleroDtoMapper;
    private final DocumentoSemilleroCrearCU documentoSemilleroCrearCU;
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
    @PostMapping("/subirDocumentosSemillero")
    @PreAuthorize("hasAnyAuthority(" +
            "'SEMILLERO:MENTOR','FUNCIONARIO:SEMILLEROS' )")
    public  ResponseEntity<Respuesta> subirDocumentosSemillero(@RequestParam(value = "idSemillero") Integer idSemillero, @RequestParam(value = "tipoDocumento")String tipoDocumento,@RequestBody Base64FileDto base64FileDto) throws Exception {
        TipoDocumentoSemillero tip = null;
        if (Objects.equals(tipoDocumento, "AVAL_DEPARTAMENTO")){
            tip= TipoDocumentoSemillero.AVAL_DEPARTAMENTO;
        }else if (Objects.equals(tipoDocumento, "OTROS")){
            tip=TipoDocumentoSemillero.OTROS;
        }
        byte[] fileBytes = Base64.decodeBase64(base64FileDto.getFile());
        String fileName = base64FileDto.getFileName();
        Respuesta respuesta = documentoSemilleroCrearCU.subirDocumentoSemillero(idSemillero,tip,fileBytes,fileName);
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("/descargarDocumentosSemillero/{idSemillero}/{tipo}")
    @PreAuthorize("hasAnyAuthority(" +
            "'SEMILLERO:MENTOR','FUNCIONARIO:SEMILLEROS' )")
    public ResponseEntity<?> descargarDocumento(@PathVariable(value = "idSemillero") Integer idSemillero, @PathVariable(value = "tipo") String tipo){
        try{

            var file= documentoSemilleroObtenerCU.obtenerDocumentoSemillero(idSemillero,tipo);
            ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(file.toPath()));
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName());
            headers.add(HttpHeaders.CONTENT_TYPE,"application/pdf");
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(file.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
        } catch (FileNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

}
