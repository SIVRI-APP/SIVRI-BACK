package edu.unicauca.SivriBackendApp.core.convocatoria.application.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.convocatoria.application.dto.request.ConvocatoriaActualizarDTO;
import edu.unicauca.SivriBackendApp.core.convocatoria.application.dto.request.ConvocatoriaCrearDTO;
import edu.unicauca.SivriBackendApp.core.convocatoria.application.mapper.ConvocatoriaDtoMapper;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.ConvocatoriaActualizarCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.ConvocatoriaCrearCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.ConvocatoriaEliminarCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.ConvocatoriaObtenerCU;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("convocatoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ConvocatoriaController<T> {

    private final ConvocatoriaObtenerCU convocatoriaObtenerCU;
    private final ConvocatoriaCrearCU convocatoriaCrearCU;
    private final ConvocatoriaActualizarCU convocatoriaActualizarCU;
    private final ConvocatoriaEliminarCU convocatoriaEliminarCU;
    private final ConvocatoriaDtoMapper convocatoriaDtoMapper;

    public ConvocatoriaController(ConvocatoriaObtenerCU convocatoriaObtenerCU, ConvocatoriaCrearCU convocatoriaCrearCU, ConvocatoriaActualizarCU convocatoriaActualizarCU, ConvocatoriaEliminarCU convocatoriaEliminarCU, ConvocatoriaDtoMapper convocatoriaDtoMapper) {
        this.convocatoriaObtenerCU = convocatoriaObtenerCU;
        this.convocatoriaCrearCU = convocatoriaCrearCU;
        this.convocatoriaActualizarCU = convocatoriaActualizarCU;
        this.convocatoriaEliminarCU = convocatoriaEliminarCU;
        this.convocatoriaDtoMapper = convocatoriaDtoMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerFullDetallePorId(@PathVariable(value = "id") long id) {
        Respuesta respuesta = convocatoriaObtenerCU.obtenerPorId(id);

        respuesta.setData(convocatoriaDtoMapper.fullInfoConvocatoria((Convocatoria) respuesta.getData()));

        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("")
    public ResponseEntity<Respuesta> obtenerListadoFullDetalle() {
        Respuesta respuesta = convocatoriaObtenerCU.obtenerListado();

        respuesta.setData(
                ((List<Convocatoria>) respuesta.getData())
                        .stream()
                        .map(convocatoriaDtoMapper::fullInfoConvocatoria)
                        .toList()
        );

        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("paginado")
    public ResponseEntity<Respuesta> obtenerListadoFullDetallePaginado(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ) {
        Respuesta respuesta = convocatoriaObtenerCU.obtenerListadoPaginado(pageNo, pageSize);

        Page<Convocatoria> dataService = (Page<Convocatoria>) respuesta.getData();
        List dataRespuesta = dataService
                        .stream()
                        .map(convocatoriaDtoMapper::fullInfoConvocatoria)
                        .collect(Collectors.toList());


        respuesta.setData(new PageImpl<>(dataRespuesta, dataService.getPageable(), dataService.getTotalElements()));

        return ResponseEntity.ok().body(respuesta);
    }

    @PostMapping("")
    public ResponseEntity<Respuesta> crear(@Valid @RequestBody ConvocatoriaCrearDTO nuevosDatos) {
        Respuesta respuesta = convocatoriaCrearCU.crear(convocatoriaDtoMapper.crear(nuevosDatos));

        return ResponseEntity.ok().body(respuesta);
    }

    @PatchMapping("")
    public ResponseEntity<Respuesta> actualizar(@Valid @RequestBody ConvocatoriaActualizarDTO nuevosDatos) {
        Respuesta respuesta = convocatoriaActualizarCU.actualizar(convocatoriaDtoMapper.actualizar(nuevosDatos));

        return ResponseEntity.ok().body(respuesta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Respuesta> eliminadoLogicoPorId(@PathVariable(value = "id") long id) {
        Respuesta respuesta = convocatoriaEliminarCU.eliminadoLogico(id);

        return ResponseEntity.ok().body(respuesta);
    }




}
