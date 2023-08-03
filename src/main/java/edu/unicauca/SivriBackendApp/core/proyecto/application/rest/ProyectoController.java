package edu.unicauca.SivriBackendApp.core.proyecto.application.rest;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.RespuestaPaginada;
import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.request.ActualizarProyectoRequest;
import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.request.CrearProyectoRequest;
import edu.unicauca.SivriBackendApp.core.proyecto.application.mapper.ProyectoMapper;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.inbound.ActualizarProyectoCasoUso;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.inbound.CrearProyectoCasoUso;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.inbound.EliminarProyectoCasoUso;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.inbound.ObtenerProyectosCasoUso;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("proyecto")
public class ProyectoController {

    private final CrearProyectoCasoUso crearProyectoCasoUso;
    private final ActualizarProyectoCasoUso actualizarProyectoCasoUso;
    private final EliminarProyectoCasoUso eliminarProyectoCasoUso;
    private final ObtenerProyectosCasoUso obtenerProyectosCasoUso;

    private final ProyectoMapper proyectoMapper;

    public ProyectoController(CrearProyectoCasoUso crearProyectoCasoUso, ActualizarProyectoCasoUso actualizarProyectoCasoUso, EliminarProyectoCasoUso eliminarProyectoCasoUso, ObtenerProyectosCasoUso obtenerProyectosCasoUso, ProyectoMapper proyectoMapper) {
        this.crearProyectoCasoUso = crearProyectoCasoUso;
        this.actualizarProyectoCasoUso = actualizarProyectoCasoUso;
        this.eliminarProyectoCasoUso = eliminarProyectoCasoUso;
        this.obtenerProyectosCasoUso = obtenerProyectosCasoUso;
        this.proyectoMapper = proyectoMapper;
    }

    @PostMapping()
    public ResponseEntity<Respuesta> crear(@Valid @RequestBody CrearProyectoRequest crearProyectoRequest) {
        Respuesta respuesta = crearProyectoCasoUso.crearProyecto(proyectoMapper.crearProyectoRequestToDomain(crearProyectoRequest));
        return ResponseEntity.ok().body(respuesta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Respuesta> eliminar(@PathVariable(value = "id") int id) {
        Respuesta respuesta = eliminarProyectoCasoUso.eliminarProyecto(id);
        return ResponseEntity.ok().body(respuesta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Respuesta> actualizar(@Valid @RequestBody ActualizarProyectoRequest actualizarProyectoRequest) {
        Respuesta respuesta = actualizarProyectoCasoUso.actualizarProyecto(proyectoMapper.actualizarProyectoRequestToDomain(actualizarProyectoRequest));
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerPorId(@PathVariable(value = "id") int id) {
        Respuesta respuesta = obtenerProyectosCasoUso.obtenerProyectoPorId(id);
        respuesta.setData(proyectoMapper.domainToObtenerProyectoResponse((Proyecto) respuesta.getData()));
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("")
    public ResponseEntity<RespuestaPaginada> obtener() {
        RespuestaPaginada respuesta = obtenerProyectosCasoUso.obtenerProyectos();
        respuesta.setData(respuesta.getData().stream().map(x -> proyectoMapper.domainToObtenerProyectoResponse((Proyecto) x)).toList());
        return ResponseEntity.ok().body(respuesta);
    }

}
