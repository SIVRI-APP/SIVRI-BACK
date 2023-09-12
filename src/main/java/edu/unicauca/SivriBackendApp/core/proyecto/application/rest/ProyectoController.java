package edu.unicauca.SivriBackendApp.core.proyecto.application.rest;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.request.ActualizarProyectoInfoGeneralDTO;
import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.request.CrearProyectoDTO;
import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.response.ObtenerProyectoDetalladoDTO;
import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.response.ObtenerProyectosDataTableDTO;
import edu.unicauca.SivriBackendApp.core.proyecto.application.mapper.ProyectoDtoMapper;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in.ActualizarProyectoCU;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in.CrearProyectoCU;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in.ObtenerProyectosCU;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("proyecto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProyectoController {

    private final ObtenerProyectosCU obtenerProyectosCU;
    private final CrearProyectoCU crearProyectoCU;
    private final ActualizarProyectoCU actualizarProyectoCU;
    private final ProyectoDtoMapper proyectoDtoMapper;

    public ProyectoController(ObtenerProyectosCU obtenerProyectosCU, CrearProyectoCU crearProyectoCU, ActualizarProyectoCU actualizarProyectoCU, ProyectoDtoMapper proyectoDtoMapper) {
        this.obtenerProyectosCU = obtenerProyectosCU;
        this.crearProyectoCU = crearProyectoCU;
        this.actualizarProyectoCU = actualizarProyectoCU;
        this.proyectoDtoMapper = proyectoDtoMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerPorId(@PathVariable(value = "id") int id) {
        Respuesta respuesta = obtenerProyectosCU.obtenerProyectoPorId(id);

        respuesta.setData(proyectoDtoMapper.obtenerProyectoDetallado((Proyecto) respuesta.getData()));

        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("")
    public ResponseEntity<Respuesta<List<ObtenerProyectosDataTableDTO>>> obtenerProyectosDataTable() {
        Respuesta respuesta = obtenerProyectosCU.obtenerProyectos();

        List<Proyecto> proyectos = (List<Proyecto>) respuesta.getData();
        respuesta.setData(
                proyectos.stream()
                        .map(proyectoDtoMapper::obtenerProyectosDataTable)
                        .toList()
        );

        return ResponseEntity.ok().body(respuesta);
    }

    @PostMapping("")
    public ResponseEntity<Respuesta> crearProyecto(@RequestBody CrearProyectoDTO crearProyectoDTO) {
        Respuesta<Boolean> respuesta = crearProyectoCU.crearProyecto(proyectoDtoMapper.crearProyectoMapper(crearProyectoDTO));

        return ResponseEntity.ok().body(respuesta);
    }

    @PatchMapping("")
    public ResponseEntity<Respuesta> actualizarProyectoInfoGeneral(@RequestBody ActualizarProyectoInfoGeneralDTO proyecto) {
        Respuesta<Boolean> respuesta = actualizarProyectoCU.actualizarProyecto(proyectoDtoMapper.actualizarProyectoInfoGeneral(proyecto));

        return ResponseEntity.ok().body(respuesta);
    }


}
