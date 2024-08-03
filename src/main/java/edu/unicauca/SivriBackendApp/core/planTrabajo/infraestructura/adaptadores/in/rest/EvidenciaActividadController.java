package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in.EvidenciaActividadCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.EvidenciaActividad;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.mapper.EvidenciaActividadDtoMapper;
import jakarta.annotation.Resource;
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

@RestController
@AllArgsConstructor
@RequestMapping("evidenciaActividad")
@CrossOrigin(origins = "htt://localhost:4200/", allowedHeaders = "*")
public class EvidenciaActividadController {
    private final EvidenciaActividadCU evidenciaActividadCrearCU;
    private final EvidenciaActividadDtoMapper evidenciaActividadDtoMapper;
    @PostMapping("/subirEvidenciaActividad")
    @PreAuthorize("hasAnyAuthority(" +
            "'SEMILLERO:MENTOR' )")
    public ResponseEntity<Respuesta> subirEvidencia(@RequestParam(value = "actividadId") Integer idActividad,@RequestBody Base64FileDto base64FileDto) throws Exception {
        byte[] fileBytes = Base64.decodeBase64(base64FileDto.getFile());
        String fileName = base64FileDto.getFileName();
        Respuesta respuesta = evidenciaActividadCrearCU.subirEvidenciaActividad(idActividad,fileBytes,fileName); // Llama a tu servicio para manejar la lógica de negocio
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("/obtenerxId/{idEvidencia}")
    @PreAuthorize("hasAnyAuthority(" +
            "'SEMILLERO:MENTOR' )")
    public ResponseEntity<Respuesta> obtenerEvidenciaxId(@PathVariable(value = "idEvidencia") int id){
        Respuesta respuesta = evidenciaActividadCrearCU.obtenerPorId(id);
        respuesta.setData(evidenciaActividadDtoMapper.obtenerEvidenciaActividad((EvidenciaActividad) respuesta.getData()));
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("/descargarEvidenciaActividad/{idEvidencia}")
    @PreAuthorize("hasAnyAuthority(" +
            "'SEMILLERO:MENTOR' )")
    public ResponseEntity<?> descargarEvidencia(@PathVariable(value = "idEvidencia") int id){
        try {
            var file = evidenciaActividadCrearCU.obtenerArchivoPorActividadId(id);
            ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(file.toPath()));

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName());
            headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");

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
class Base64FileDto {
    private String file;
    private String fileName;

    // Getters y setters
    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
