package edu.unicauca.SivriBackendApp.core.semillero.application.rest;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.application.mapper.LineaInvestigacionDtoMapper;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.LineaInvestigacion;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.LineaInvestigacionObtenerCU;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lineasInvestigacion")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LineaInvestigacionController {
    private final LineaInvestigacionObtenerCU lineaInvestigacionObtenerCU;
    private final LineaInvestigacionDtoMapper lineaInvestigacionDtoMapper;

    public LineaInvestigacionController(LineaInvestigacionObtenerCU lineaInvestigacionObtenerCU, LineaInvestigacionDtoMapper lineaInvestigacionDtoMapper) {
        this.lineaInvestigacionObtenerCU = lineaInvestigacionObtenerCU;
        this.lineaInvestigacionDtoMapper = lineaInvestigacionDtoMapper;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerLineasInvestigacionPorId(@PathVariable(value = "id") int id){
        Respuesta respuesta = lineaInvestigacionObtenerCU.obtenerPorId(id);
        respuesta.setData(lineaInvestigacionDtoMapper.obtenerLineasInvestigacion((LineaInvestigacion) respuesta.getData()));
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("/LineasInvestigacionPorIdSemillero/{id}")
    public ResponseEntity<Respuesta> obtenerLineasInvestigacionPorSemilleroId(@PathVariable(value = "id") int idSemillero){
        Respuesta respuesta = lineaInvestigacionObtenerCU.obtenerLineasInvestigacionPorSemilleroId(idSemillero);
        respuesta.setData(((List<LineaInvestigacion>) respuesta.getData()).stream().map(lineaInvestigacionDtoMapper::obtenerLineasInvestigacion).toList());
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("")
    public ResponseEntity<Respuesta> obtenerLineasInvestigacion(){
        Respuesta respuesta =lineaInvestigacionObtenerCU.obtenerListadoLineasInvestigacion();
        respuesta.setData(((List<LineaInvestigacion>) respuesta.getData()).stream().map(lineaInvestigacionDtoMapper::obtenerLineasInvestigacion).toList());
        return ResponseEntity.ok().body(respuesta);
    }

}
