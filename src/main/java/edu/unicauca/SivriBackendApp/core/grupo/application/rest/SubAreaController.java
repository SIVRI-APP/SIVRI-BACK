package edu.unicauca.SivriBackendApp.core.grupo.application.rest;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.application.mapper.SubAreaDtoMapper;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Disciplina;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.SubAreaObtenerCU;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subArea")
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
