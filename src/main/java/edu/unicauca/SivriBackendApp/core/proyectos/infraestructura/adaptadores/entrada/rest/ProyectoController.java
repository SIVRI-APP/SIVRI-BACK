package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.entrada.rest;

import edu.unicauca.SivriBackendApp.common.file.StorageService;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.TipoFinanciacion;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada.ProyectoCrearCU;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada.ProyectoObtenerCU;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.EstadoProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.RolProyectoEnum;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones.ProyectoDetalladoDTO;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones.ProyectoListarConFiltroProyeccion;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.entrada.rest.dto.entrada.CrearProyectoDTO;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.entrada.rest.dto.entrada.FormalizarProyectoDTO;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.entrada.rest.dto.entrada.GuardarProyectoDTO;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.entrada.rest.mapper.ProyectoRestMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;

@RestController
@RequestMapping("/proyecto")
@AllArgsConstructor
public class ProyectoController {

    /**
     * Adaptadores
     */
    private final ProyectoCrearCU proyectoCrearCU;
    private final ProyectoObtenerCU proyectoObtenerCU;
    private final StorageService storageService;

    /**
     * Mappers
     */
    private final ProyectoRestMapper proyectoRestMapper;

    @PostMapping("crear")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:VICERRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'FUNCIONARIO:PROYECTOS_EXTERNOS')")
    public ResponseEntity<Respuesta<Boolean>> crearProyecto(@Valid @RequestBody CrearProyectoDTO proyecto){
        Respuesta<Boolean> respuesta = proyectoCrearCU.crearProyecto(proyecto);
        return ResponseEntity.ok().body(respuesta);
    }

    @PostMapping("formalizar")
    @PreAuthorize("hasAnyAuthority(" +
            "'PROYECTO:DIRECTOR',  " +
            "'FUNCIONARIO:VICERRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'FUNCIONARIO:PROYECTOS_EXTERNOS')")
    public ResponseEntity<Respuesta<Boolean>> formalizarProyecto(@Valid @RequestBody FormalizarProyectoDTO proyecto){
        Respuesta<Boolean> respuesta = proyectoCrearCU.formalizarProyecto(proyectoRestMapper.formalizarProyectoDto(proyecto));
        return ResponseEntity.ok().body(respuesta);
    }

    @PostMapping("guardar")
    @PreAuthorize("hasAnyAuthority(" +
            "'PROYECTO:DIRECTOR',  " +
            "'FUNCIONARIO:VICERRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'FUNCIONARIO:PROYECTOS_EXTERNOS')")
    public ResponseEntity<Respuesta<Boolean>> guardarProyecto(@Valid @RequestBody GuardarProyectoDTO proyectoDto){
        Respuesta<Boolean> respuesta = proyectoCrearCU.guardarProyecto(proyectoDto);
        return ResponseEntity.ok().body(respuesta);
    }

    @PostMapping("agregarIntegrante")
    @PreAuthorize("hasAnyAuthority(" +
            "'PROYECTO:DIRECTOR',  " +
            "'FUNCIONARIO:VICERRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'FUNCIONARIO:PROYECTOS_EXTERNOS')")
    public ResponseEntity<Respuesta<Boolean>> agregarIntegrante(
            @Valid @RequestParam @Positive(message = "Proyecto Id no valido") Long proyectoId,
            @Valid @RequestParam @Positive(message = "Usuario Id no valido")Long usuarioId,
            @Valid @RequestParam @Positive(message = "Rol Id no valido") RolProyectoEnum rolId
    ){
        Respuesta<Boolean> respuesta = proyectoCrearCU.agregarIntegrante(proyectoId, usuarioId, rolId);
        return ResponseEntity.ok().body(respuesta);
    }

    @PostMapping("asociarConvocatoria")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:VICERRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'PROYECTO:DIRECTOR')")
    public ResponseEntity<Respuesta<Boolean>> asociarConvocatoria(
            @Valid @RequestParam @PositiveOrZero @NotNull(message = "No puede ser nulo") Long proyectoId,
            @Valid @RequestParam @PositiveOrZero @NotNull(message = "No puede ser nulo ") Long convocatoriaId
    ){
        Respuesta<Boolean> respuesta = proyectoCrearCU.asociarConvocatoria(proyectoId, convocatoriaId);
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("obtenerInformacionDetallada")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:VICERRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'PROYECTO:DIRECTOR')")
    public ResponseEntity<Respuesta<ProyectoDetalladoDTO>> obtenerProyectoInformacionDetallada(@Valid @RequestParam @PositiveOrZero(message = "El Id deL proyecto debe ser positivo") long proyectoId){
        Respuesta<ProyectoDetalladoDTO> respuesta = proyectoObtenerCU.obtenerProyectoInformacionDetallada(proyectoId);
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("listarTodoConFiltro")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:VICERRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'PROYECTO:DIRECTOR')")
    public ResponseEntity<Respuesta<Page<ProyectoListarConFiltroProyeccion>>> listarTodoConFiltro(
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) EstadoProyecto estado,
            @RequestParam(required = false) LocalDate fechaInicio,
            @RequestParam(required = false) LocalDate fechaFin,
            @RequestParam(required = false) Integer organismoDeInvestigacionId,
            @RequestParam(required = false) TipoFinanciacion tipoFinanciacion,
            @RequestParam @Min(value = 0, message = "El valor de pageNo debe ser positivo") int pageNo,
            @RequestParam @Min(value = 0, message = "El valor de pageSize debe ser positivo") int pageSize
    ) {
        Respuesta<Page<ProyectoListarConFiltroProyeccion>> respuesta = proyectoObtenerCU.listarConFiltro(
                pageNo,
                pageSize,
                id,
                nombre,
                estado,
                fechaInicio,
                fechaFin,
                organismoDeInvestigacionId,
                tipoFinanciacion
        );
        return ResponseEntity.ok().body(respuesta);
    }

    @PostMapping("uploadDocConvocatoria")
    public ResponseEntity<Respuesta<String>> handleFileUpload(@RequestParam("file") MultipartFile file,
                                                              @RequestParam("organismo") String organismo,
                                                              @RequestParam("organismoId") String organismoId,
                                                              @RequestParam("documentoConvocatoriaId") String documentoConvocatoriaId
    )
    {
        Respuesta<String> respuesta = storageService.store(file, organismo, organismoId, documentoConvocatoriaId, "ProyectoDocumentoConvocatoria");

        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("downloadDocConvocatoria/{organismo}/{organismoId}/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(
            @PathVariable String organismo,
            @PathVariable String organismoId,
            @PathVariable String filename) throws IOException {

        // Llama al servicio de almacenamiento para cargar el archivo como un recurso.
        Resource file = storageService.loadAsResource(filename, organismo, organismoId, "ProyectoDocumentoConvocatoria");

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
