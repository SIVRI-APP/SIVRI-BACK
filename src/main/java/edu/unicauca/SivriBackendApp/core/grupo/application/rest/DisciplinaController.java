package edu.unicauca.SivriBackendApp.core.grupo.application.rest;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.application.mapper.DisciplinaDtoMapper;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Disciplina;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.DisciplinaObtenerCU;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("disciplinas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DisciplinaController {
    private final DisciplinaObtenerCU disciplinaObtenerCU;
    private final DisciplinaDtoMapper disciplinaDtoMapper;

    public DisciplinaController(DisciplinaObtenerCU disciplinaObtenerCU, DisciplinaDtoMapper disciplinaDtoMapper) {
        this.disciplinaObtenerCU = disciplinaObtenerCU;
        this.disciplinaDtoMapper = disciplinaDtoMapper;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerDisciplinaPorId(@PathVariable(value = "id") int id){
        Respuesta respuesta =disciplinaObtenerCU.obtenerPorId(id);
        respuesta.setData(disciplinaDtoMapper.dtoObtenerDisciplina((Disciplina) respuesta.getData()));
        return ResponseEntity.ok().body(respuesta);
    }

}
