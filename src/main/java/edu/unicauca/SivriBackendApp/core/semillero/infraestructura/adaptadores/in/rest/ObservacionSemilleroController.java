package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.ObservacionSemilleroActualizarCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.ObservacionSemilleroCrearCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.ObservacionSemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.ObservacionSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.ObservacionSemilleroCrearDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.mapper.ObservacionSemilleroDtoMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("observacionSemillero")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ObservacionSemilleroController {
    private final ObservacionSemilleroCrearCU observacionSemilleroCrearCU;
    private final ObservacionSemilleroActualizarCU observacionSemilleroActualizarCU;
    private final ObservacionSemilleroObtenerCU observacionSemilleroObtenerCU;
    private final ObservacionSemilleroDtoMapper observacionSemilleroDtoMapper;

    public ObservacionSemilleroController(ObservacionSemilleroCrearCU observacionSemilleroCrearCU, ObservacionSemilleroActualizarCU observacionSemilleroActualizarCU, ObservacionSemilleroObtenerCU observacionSemilleroObtenerCU, ObservacionSemilleroDtoMapper observacionSemilleroDtoMapper) {
        this.observacionSemilleroCrearCU = observacionSemilleroCrearCU;
        this.observacionSemilleroActualizarCU = observacionSemilleroActualizarCU;
        this.observacionSemilleroObtenerCU = observacionSemilleroObtenerCU;
        this.observacionSemilleroDtoMapper = observacionSemilleroDtoMapper;
    }
    @PostMapping("/asociarObservacion/{idSemillero}/{idFuncionario}")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:SEMILLEROS')")
    public ResponseEntity<Respuesta> crear(
            @PathVariable(value = "idSemillero") int idSemillero,
            @PathVariable(value = "idFuncionario") Long idFuncionario,
            @Valid @RequestBody ObservacionSemilleroCrearDTO nuevaObservacion
            ){

        Respuesta respuesta =observacionSemilleroCrearCU.crear(idFuncionario,idSemillero,observacionSemilleroDtoMapper.asociarObservacion(nuevaObservacion));
        return ResponseEntity.ok().body(respuesta);
    }

    @PatchMapping("/actualizarObservacion/{id}")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:SEMILLEROS')")
    public ResponseEntity<Respuesta> actualizarObservacionSemillero(
            @PathVariable(value = "id") int idObservacion,
            @Valid @RequestBody ObservacionSemilleroCrearDTO observacionSemilleroActualizarDTO
            ){
        Respuesta respuesta=observacionSemilleroActualizarCU.actualizarObservacionSemillero(idObservacion,observacionSemilleroDtoMapper.actualizarObservacionSemillero(observacionSemilleroActualizarDTO));
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerObservacionSemilleroPorId(@PathVariable(value = "id") int id){
        Respuesta respuesta = observacionSemilleroObtenerCU.obtenerPorId(id);
        respuesta.setData(observacionSemilleroDtoMapper.obtenerObservacionSemillero((ObservacionSemillero) respuesta.getData()));
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("/listarObservacionSemilleroPorIdSemillero")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR', " +
            "'SEMILLERO:MENTOR')")
    public ResponseEntity<Respuesta> listarObservacionesSemilleroPorIdSemillero(
            @RequestParam(required = true) int semilleroId,
            @RequestParam(required = false) int pageNo,
            @RequestParam(required = false) int pageSize
    ){
        Respuesta respuesta = observacionSemilleroObtenerCU.listarObservacionesPorIdSemillero(pageNo,pageSize,semilleroId);
        return ResponseEntity.ok().body(respuesta);
    }
}
