package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.entrada.rest;

import edu.unicauca.SivriBackendApp.common.file.StorageService;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada.CompromisosCU;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones.PrepararAgregarCompromisoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public ResponseEntity<Respuesta<Boolean>> prepararAgregarCompromiso(
            @Valid @RequestParam @Positive(message = "Proyecto Id no valido") Long proyectoId,
            @Valid @RequestParam @Positive(message = "Integrante Id no valido") Long integranteId,
            @Valid @RequestParam @Positive(message = "Producto Id no valido") Integer productoId
    ){
        Respuesta<Boolean> respuesta = compromisosCU.agregarCompromiso(proyectoId, integranteId, productoId);
        return ResponseEntity.ok().body(respuesta);
    }

    @PostMapping("upload/compromiso")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:VICERRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'FUNCIONARIO:PROYECTOS_EXTERNOS')")
    public ResponseEntity<Respuesta<String>> handleFileUpload(@RequestParam("file") MultipartFile file,
                                                              @RequestParam("organismo") String organismo,
                                                              @RequestParam("organismoId") String organismoId,
                                                              @RequestParam("documentoConvocatoriaId") String documentoConvocatoriaId
    )
    {
        Respuesta<String> respuesta = storageService.store(file, organismo, organismoId, documentoConvocatoriaId);

        return ResponseEntity.ok().body(respuesta);
    }


}
