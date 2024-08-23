package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.entrada.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.TipoFinanciacion;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada.ProyectoCrearCU;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada.ProyectoObtenerCU;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.EstadoProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones.ProyectoInformacionDetalladaProyeccion;
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
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
            @Valid @RequestParam @Positive(message = "Rol Id no valido")Integer rolId
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
    public ResponseEntity<Respuesta<ProyectoInformacionDetalladaProyeccion>> obtenerProyectoInformacionDetallada(@Valid @RequestParam @PositiveOrZero(message = "El Id deL proyecto debe ser positivo") long proyectoId){
        Respuesta<ProyectoInformacionDetalladaProyeccion> respuesta = proyectoObtenerCU.obtenerProyectoInformacionDetallada(proyectoId);
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
}
