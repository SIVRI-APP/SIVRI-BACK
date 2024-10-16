package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.entrada.rest;

import edu.unicauca.SivriBackendApp.common.file.StorageService;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada.CompromisosCU;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones.PrepararAgregarCompromisoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("/compromiso")
@AllArgsConstructor
public class CompromisoController {

    /**
     * Puertos
     */
    private final CompromisosCU compromisosCU;
    private final StorageService storageService;

    @GetMapping("prepararAgregarCompromiso")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:VICERRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'FUNCIONARIO:PROYECTOS_EXTERNOS')")
    public ResponseEntity<Respuesta<PrepararAgregarCompromisoDTO>> prepararAgregarCompromiso(@Valid @RequestParam @Positive(message = "Proyecto Id no valido") Long proyectoId){
        Respuesta<PrepararAgregarCompromisoDTO> respuesta = compromisosCU.prepararAgregarCompromiso(proyectoId);
        return ResponseEntity.ok().body(respuesta);
    }

    @PostMapping("agregarCompromiso")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:VICERRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'FUNCIONARIO:PROYECTOS_EXTERNOS')")
    public ResponseEntity<Respuesta<Boolean>> agregarCompromiso(
            @Valid @RequestParam @Positive(message = "Proyecto Id no valido") Long proyectoId,
            @Valid @RequestParam @Positive(message = "Integrante Id no valido") Long integranteId,
            @Valid @RequestParam @Positive(message = "Producto Id no valido") Integer productoId
    ){
        Respuesta<Boolean> respuesta = compromisosCU.agregarCompromiso(proyectoId, integranteId, productoId);
        return ResponseEntity.ok().body(respuesta);
    }

    @PostMapping("uploadDocCompromiso")
    public ResponseEntity<Respuesta<String>> handleFileUpload(@RequestParam("file") MultipartFile file,
                                                              @RequestParam("organismo") String organismo,
                                                              @RequestParam("organismoId") String organismoId,
                                                              @RequestParam("documentoConvocatoriaId") String documentoConvocatoriaId
    )
    {
        Respuesta<String> respuesta = storageService.store(file, organismo, organismoId, documentoConvocatoriaId, "ProyectoDocumentoCompromiso");

        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("downloadDocCompromiso/{organismo}/{organismoId}/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(
            @PathVariable String organismo,
            @PathVariable String organismoId,
            @PathVariable String filename) throws IOException {

        // Llama al servicio de almacenamiento para cargar el archivo como un recurso.
        Resource file = storageService.loadAsResource(filename, organismo, organismoId, "ProyectoDocumentoCompromiso");

        // Verifica si el archivo fue encontrado.
        if (file == null) {
            return ResponseEntity.notFound().build(); // Devuelve 404 si el archivo no se encuentra.
        }

        // Determina el tipo de contenido del archivo.
        String contentType = Files.probeContentType(file.getFile().toPath());

        // Devuelve la respuesta HTTP con el archivo y su tipo de contenido.
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, contentType)
                .body(file);
    }


}
