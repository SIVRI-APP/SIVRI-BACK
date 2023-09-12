package edu.unicauca.SivriBackendApp.core.convocatoria.application.rest;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.convocatoria.application.dto.request.ConvocatoriaActualizarDTO;
import edu.unicauca.SivriBackendApp.core.convocatoria.application.dto.request.ConvocatoriaCrearDTO;
import edu.unicauca.SivriBackendApp.core.convocatoria.application.mapper.ConvocatoriaDtoMapper;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.ActualizarConvocatoriaCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.CrearConvocatoriaCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.EliminarConvocatoriaCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.port.in.ObtenerConvocatoriaCU;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("convocatoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ConvocatoriaController {

    private final ObtenerConvocatoriaCU obtenerConvocatoriaCU;
    private final CrearConvocatoriaCU crearConvocatoriaCU;
    private final ActualizarConvocatoriaCU actualizarConvocatoriaCU;
    private final EliminarConvocatoriaCU eliminarConvocatoriaCU;
    private final ConvocatoriaDtoMapper convocatoriaDtoMapper;

    public ConvocatoriaController(ObtenerConvocatoriaCU obtenerConvocatoriaCU, CrearConvocatoriaCU crearConvocatoriaCU, ActualizarConvocatoriaCU actualizarConvocatoriaCU, EliminarConvocatoriaCU eliminarConvocatoriaCU, ConvocatoriaDtoMapper convocatoriaDtoMapper) {
        this.obtenerConvocatoriaCU = obtenerConvocatoriaCU;
        this.crearConvocatoriaCU = crearConvocatoriaCU;
        this.actualizarConvocatoriaCU = actualizarConvocatoriaCU;
        this.eliminarConvocatoriaCU = eliminarConvocatoriaCU;
        this.convocatoriaDtoMapper = convocatoriaDtoMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerPorId(@PathVariable(value = "id") long id) {
        Respuesta respuesta = obtenerConvocatoriaCU.obtenerPorId(id);

        respuesta.setData(convocatoriaDtoMapper.obtenerDto((Convocatoria) respuesta.getData()));

        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("")
    public ResponseEntity<Respuesta> obtenerListado() {
        Respuesta respuesta = obtenerConvocatoriaCU.obtenerListado();

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
        Respuesta respuesta = crearConvocatoriaCU.crear(convocatoriaDtoMapper.crear(nuevosDatos));

        return ResponseEntity.ok().body(respuesta);
    }

    @PatchMapping("")
    public ResponseEntity<Respuesta> actualizar(@RequestBody ConvocatoriaActualizarDTO nuevosDatos) {
        Respuesta respuesta = actualizarConvocatoriaCU.actualizar(convocatoriaDtoMapper.actualizar(nuevosDatos));

        return ResponseEntity.ok().body(respuesta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Respuesta> eliminadoLogicoPorId(@PathVariable(value = "id") long id) {
        Respuesta respuesta = eliminarConvocatoriaCU.eliminadoLogico(id);

        return ResponseEntity.ok().body(respuesta);
    }




}
