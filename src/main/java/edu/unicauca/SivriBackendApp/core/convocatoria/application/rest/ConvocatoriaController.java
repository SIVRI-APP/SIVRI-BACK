package edu.unicauca.SivriBackendApp.core.convocatoria.application.rest;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.convocatoria.application.dto.request.ConvocatoriaActualizarDTO;
import edu.unicauca.SivriBackendApp.core.convocatoria.application.dto.request.ConvocatoriaCrearDTO;
import edu.unicauca.SivriBackendApp.core.convocatoria.application.mapper.ConvocatoriaDtoMapper;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.ConvocatoriaActualizarCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.ConvocatoriaCrearCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.ConvocatoriaEliminarCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.ConvocatoriaObtenerCU;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("convocatoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ConvocatoriaController {

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
    public ResponseEntity<Respuesta> obtenerPorId(@PathVariable(value = "id") long id) {
        Respuesta respuesta = convocatoriaObtenerCU.obtenerPorId(id);

        respuesta.setData(convocatoriaDtoMapper.obtenerDto((Convocatoria) respuesta.getData()));

        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("")
    public ResponseEntity<Respuesta> obtenerListado() {
        Respuesta respuesta = convocatoriaObtenerCU.obtenerListado();

        List<Proyecto> proyectos = (List<Proyecto>) respuesta.getData();

        respuesta.setData(
                ((List<Convocatoria>) respuesta.getData())
                        .stream()
                        .map(convocatoriaDtoMapper::obtenerDto)
                        .toList()
        );

        return ResponseEntity.ok().body(respuesta);
    }

    @PostMapping("")
    public ResponseEntity<Respuesta> crear(@RequestBody ConvocatoriaCrearDTO nuevosDatos) {
        Respuesta respuesta = convocatoriaCrearCU.crear(convocatoriaDtoMapper.crear(nuevosDatos));

        return ResponseEntity.ok().body(respuesta);
    }

    @PatchMapping("")
    public ResponseEntity<Respuesta> actualizar(@RequestBody ConvocatoriaActualizarDTO nuevosDatos) {
        Respuesta respuesta = convocatoriaActualizarCU.actualizar(convocatoriaDtoMapper.actualizar(nuevosDatos));

        return ResponseEntity.ok().body(respuesta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Respuesta> eliminadoLogicoPorId(@PathVariable(value = "id") long id) {
        Respuesta respuesta = convocatoriaEliminarCU.eliminadoLogico(id);

        return ResponseEntity.ok().body(respuesta);
    }




}
