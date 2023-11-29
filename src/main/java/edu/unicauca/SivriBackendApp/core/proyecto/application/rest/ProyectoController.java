package edu.unicauca.SivriBackendApp.core.proyecto.application.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.request.ProyectoActualizarDTO;
import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.request.ProyectoCrearDTO;
import edu.unicauca.SivriBackendApp.core.proyecto.application.mapper.ProyectoDtoMapper;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in.ProyectoActualizarCU;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in.ProyectoCrearCU;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in.ProyectoEliminarCU;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in.ProyectoObtenerCU;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/proyecto")
public class ProyectoController<T> {

    private final ProyectoObtenerCU proyectoObtenerCU;
    private final ProyectoCrearCU proyectoCrearCU;
    private final ProyectoActualizarCU proyectoActualizarCU;
    private final ProyectoEliminarCU proyectoEliminarCU;
    private final ProyectoDtoMapper proyectoDtoMapper;

    public ProyectoController(ProyectoObtenerCU proyectoObtenerCU, ProyectoCrearCU proyectoCrearCU, ProyectoActualizarCU proyectoActualizarCU, ProyectoEliminarCU proyectoEliminarCU, ProyectoDtoMapper proyectoDtoMapper) {
        this.proyectoObtenerCU = proyectoObtenerCU;
        this.proyectoCrearCU = proyectoCrearCU;
        this.proyectoActualizarCU = proyectoActualizarCU;
        this.proyectoEliminarCU = proyectoEliminarCU;
        this.proyectoDtoMapper = proyectoDtoMapper;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerFullDetallePorId(@PathVariable(value = "id") long id) {
        Respuesta respuesta = proyectoObtenerCU.obtenerPorId(id);

        respuesta.setData(proyectoDtoMapper.fullInfoProyecto((Proyecto) respuesta.getData()));

        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("")
    public ResponseEntity<Respuesta> obtenerListadoFullDetalle() {
        Respuesta respuesta = proyectoObtenerCU.obtenerListado();

        respuesta.setData(
                ((List<Proyecto>) respuesta.getData())
                        .stream()
                        .map(proyectoDtoMapper::fullInfoProyecto)
                        .toList()
        );

        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("paginado")
    public ResponseEntity<Respuesta> obtenerListadoFullDetallePaginado(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ) {
        Respuesta respuesta = proyectoObtenerCU.obtenerListadoPaginado(pageNo, pageSize);

        Page<Proyecto> dataService = (Page<Proyecto>) respuesta.getData();
        List dataRespuesta = dataService
                        .stream()
                        .map(proyectoDtoMapper::fullInfoProyecto)
                        .collect(Collectors.toList());


        respuesta.setData(new PageImpl<>(dataRespuesta, dataService.getPageable(), dataService.getTotalElements()));

        return ResponseEntity.ok().body(respuesta);
    }

    @PostMapping("")
    public ResponseEntity<Respuesta> crear(@Valid @RequestBody ProyectoCrearDTO nuevosDatos) {
        Respuesta respuesta = proyectoCrearCU.crear(proyectoDtoMapper.crear(nuevosDatos));

        return ResponseEntity.ok().body(respuesta);
    }

    @PatchMapping("")
    public ResponseEntity<Respuesta> actualizar(@Valid @RequestBody ProyectoActualizarDTO nuevosDatos) {
        Respuesta respuesta = proyectoActualizarCU.actualizar(proyectoDtoMapper.actualizar(nuevosDatos));

        return ResponseEntity.ok().body(respuesta);
    }

    @PatchMapping("/asociarProyectoConvocatoria")
    public ResponseEntity<Respuesta> actualizar(@Valid @RequestParam @Positive Long idProyecto, @Valid @RequestParam @Positive Long idConvocatoria) {
        Respuesta respuesta = proyectoActualizarCU.asociarProyectoAconvocaotira(idProyecto, idConvocatoria);

        return ResponseEntity.ok().body(respuesta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Respuesta> eliminadoLogicoPorId(@PathVariable(value = "id") long id) {
        Respuesta respuesta = proyectoEliminarCU.eliminadoLogico(id);

        return ResponseEntity.ok().body(respuesta);
    }




}
