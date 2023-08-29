package edu.unicauca.SivriBackendApp.core.proyecto.application.rest;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.response.ObtenerProyectosDataTableDTO;
import edu.unicauca.SivriBackendApp.core.proyecto.application.mapper.ProyectoDtoMapper;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.port.in.ObtenerProyectosCU;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("proyecto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProyectoController {
    private final ObtenerProyectosCU obtenerProyectosCU;

    private final ProyectoDtoMapper proyectoDtoMapper;

    public ProyectoController(ObtenerProyectosCU obtenerProyectosCU, ProyectoDtoMapper proyectoDtoMapper) {
        this.obtenerProyectosCU = obtenerProyectosCU;
        this.proyectoDtoMapper = proyectoDtoMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerPorId(@PathVariable(value = "id") int id) {
        Respuesta respuesta = obtenerProyectosCU.obtenerProyectoPorId(id);

        respuesta.setData(proyectoDtoMapper.dtoObtenerProyecto((Proyecto) respuesta.getData()));
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("")
    public ResponseEntity<Respuesta> obtenerPorId() {
        Respuesta<List<Proyecto>> respuestaCU = obtenerProyectosCU.obtenerProyectos();
        Respuesta<List<ObtenerProyectosDataTableDTO>> respuesta = new Respuesta<>();

        respuesta.setData(respuestaCU.getData().stream()
                .map(proyectoDtoMapper::dtoObtenerProyecto)
                .toList());

        respuesta.setStatus(respuestaCU.getStatus());
        respuesta.setUserMessage(respuestaCU.getUserMessage());
        respuesta.setDeveloperMessage(respuestaCU.getDeveloperMessage());

        return ResponseEntity.ok().body(respuesta);
    }

}
