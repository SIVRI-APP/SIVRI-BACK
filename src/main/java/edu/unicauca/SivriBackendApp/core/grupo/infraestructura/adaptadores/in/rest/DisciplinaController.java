package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.DisciplinaObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Disciplina;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.mapper.DisciplinaDtoMapper;
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
