package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.entrada.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.convocatoria.aplicacion.puertos.entrada.ConvocatoriaCrearCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.aplicacion.puertos.entrada.ConvocatoriaObtenerCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.ConvocatoriaEstado;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.TipoFinanciacion;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.proyecciones.ConvocatoriaInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.proyecciones.ConvocatoriaListarConFiltroProyeccion;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.entrada.rest.dto.peticion.CrearConvocatoriaDTO;

import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.entrada.rest.mapper.CheckListRestMapper;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.entrada.rest.mapper.ConvocatoriaRestMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/convocatoria")
@AllArgsConstructor
public class ConvocatoriaController {

    /**
     * Adaptadores
     */
    private final ConvocatoriaCrearCU convocatoriaCrearCU;
    private final ConvocatoriaObtenerCU convocatoriaObtenerCU;

    /**
     * Mappers
     */
    private final ConvocatoriaRestMapper convocatoriaRestMapper;
    private final CheckListRestMapper checkListRestMapper;

    @PostMapping("crear")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:VICERRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'FUNCIONARIO:PROYECTOS_EXTERNOS')")
    public ResponseEntity<Respuesta<Boolean>> crearConvocatoria(@Valid @RequestBody CrearConvocatoriaDTO convocatoria){
        Respuesta<Boolean> respuesta = convocatoriaCrearCU.crearConvocatoria(
                convocatoriaRestMapper.crearConvocatoriaDTO(convocatoria),
                checkListRestMapper.crearConvocatoriaFromListDtoToListModel(convocatoria.getChecklist()));
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("obtenerInformacionDetallada")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:VICERRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'FUNCIONARIO:PROYECTOS_EXTERNOS')")
    public ResponseEntity<Respuesta<ConvocatoriaInformacionDetalladaProyeccion>> obtenerInformacionDetallada(@Valid @RequestParam @PositiveOrZero(message = "El Id de la convocatoria debe ser positivo") long convocatoriaId){
        Respuesta<ConvocatoriaInformacionDetalladaProyeccion> respuesta = convocatoriaObtenerCU.obtenerConvocatoriaInformacionDetallada(convocatoriaId);
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("listarTodoConFiltro")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:VICERRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:PROYECTOS_INTERNOS', " +
            "'FUNCIONARIO:PROYECTOS_EXTERNOS')")
    public ResponseEntity<Respuesta<Page<ConvocatoriaListarConFiltroProyeccion>>> listarTodoConFiltro(
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) ConvocatoriaEstado estado,
            @RequestParam(required = false) TipoFinanciacion tipoFinanciacion,
            @RequestParam @Min(value = 0, message = "El valor de pageNo debe ser positivo") int pageNo,
            @RequestParam @Min(value = 0, message = "El valor de pageSize debe ser positivo") int pageSize
    ) {
        Respuesta<Page<ConvocatoriaListarConFiltroProyeccion>> respuesta = convocatoriaObtenerCU.listarConFiltro(
                pageNo,
                pageSize,
                id,
                nombre,
                estado,
                tipoFinanciacion
        );
        return ResponseEntity.ok().body(respuesta);
    }
}
