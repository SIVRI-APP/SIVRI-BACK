package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.LineaInvestigacionActualizarCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.LineaInvestigacionCrearCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.LineaInvestigacionEliminarCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.LineaInvestigacionObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.LineaInvestigacion;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.LineaInvestigacionActualizarDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.LineaInvestigacionCrearDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.mapper.LineaInvestigacionDtoMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lineasInvestigacion")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LineaInvestigacionController {
    private final LineaInvestigacionCrearCU lineaInvestigacionCrearCU;
    private final LineaInvestigacionObtenerCU lineaInvestigacionObtenerCU;
    private final LineaInvestigacionActualizarCU lineaInvestigacionActualizarCU;
    private final LineaInvestigacionEliminarCU lineaInvestigacionEliminarCU;
    private final LineaInvestigacionDtoMapper lineaInvestigacionDtoMapper;

    public LineaInvestigacionController(LineaInvestigacionCrearCU lineaInvestigacionCrearCU, LineaInvestigacionObtenerCU lineaInvestigacionObtenerCU, LineaInvestigacionActualizarCU lineaInvestigacionActualizarCU, LineaInvestigacionEliminarCU lineaInvestigacionEliminarCU, LineaInvestigacionDtoMapper lineaInvestigacionDtoMapper) {
        this.lineaInvestigacionCrearCU = lineaInvestigacionCrearCU;
        this.lineaInvestigacionObtenerCU = lineaInvestigacionObtenerCU;
        this.lineaInvestigacionActualizarCU = lineaInvestigacionActualizarCU;
        this.lineaInvestigacionEliminarCU = lineaInvestigacionEliminarCU;
        this.lineaInvestigacionDtoMapper = lineaInvestigacionDtoMapper;
    }

    @PostMapping("/asociarLinea/{id}")
    public ResponseEntity<Respuesta> crear(@PathVariable(value = "id") int idSemillero,@Valid @RequestBody LineaInvestigacionCrearDTO nuevosDatos){
        Respuesta respuesta =lineaInvestigacionCrearCU.crear(idSemillero,lineaInvestigacionDtoMapper.asociarLineaASemillero(nuevosDatos));
        return ResponseEntity.ok().body(respuesta);
    }
    @PatchMapping("/actualizarLinea/{id}")
    public ResponseEntity<Respuesta> actualizarLinea(
            @PathVariable(value = "id") int idLinea,
            @Valid @RequestBody LineaInvestigacionActualizarDTO lineaInvestigacionActualizarDTO){
        Respuesta respuesta=lineaInvestigacionActualizarCU.actualizarLinea(idLinea,lineaInvestigacionDtoMapper.actualizarLinea(lineaInvestigacionActualizarDTO));
        return ResponseEntity.ok().body(respuesta);
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
    @DeleteMapping("/eliminarLinea/{id}")
    public ResponseEntity<Respuesta> eliminarLinea(@PathVariable(value = "id") int idLinea){
        Respuesta respuesta = lineaInvestigacionEliminarCU.eliminadoFisico(idLinea);
        return ResponseEntity.ok().body(respuesta);
    }
}
