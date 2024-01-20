package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.SubAreaObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Disciplina;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.mapper.SubAreaDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subAreas")
@CrossOrigin(origins = "#",allowedHeaders = "#")
public class SubAreaController {

    private final SubAreaObtenerCU obtenerSubAreaCU;
    private final SubAreaDtoMapper subAreaDtoMapper;

    public SubAreaController(SubAreaObtenerCU obtenerSubAreaCU, SubAreaDtoMapper subAreaDtoMapper) {
        this.obtenerSubAreaCU = obtenerSubAreaCU;
        this.subAreaDtoMapper = subAreaDtoMapper;
    }
    @GetMapping("/{id}/disciplinas")
    public ResponseEntity<Respuesta> obtenerDisciplinasPorIdSubArea(@PathVariable(value = "id") int id){
        Respuesta respuesta=obtenerSubAreaCU.obtenerDisciplinasPorIdSubArea(id);

        respuesta.setData(subAreaDtoMapper.dtoObtenerDisciplinas((List<Disciplina>) respuesta.getData()));

        return ResponseEntity.ok().body(respuesta);

    }
}
