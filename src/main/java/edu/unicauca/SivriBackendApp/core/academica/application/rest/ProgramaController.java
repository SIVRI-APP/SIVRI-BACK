package edu.unicauca.SivriBackendApp.core.academica.application.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.academica.application.mapper.ProgramaDtoMapper;
import edu.unicauca.SivriBackendApp.core.academica.domain.model.Programa;
import edu.unicauca.SivriBackendApp.core.academica.domain.port.in.ProgramaObtenerCU;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("programas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProgramaController {
    private final ProgramaObtenerCU programaObtenerCU;
    private final ProgramaDtoMapper programaDtoMapper;

    public ProgramaController(ProgramaObtenerCU programaObtenerCU, ProgramaDtoMapper programaDtoMapper) {
        this.programaObtenerCU = programaObtenerCU;
        this.programaDtoMapper = programaDtoMapper;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerProgramaPorId(@PathVariable(value = "id") int id){
        Respuesta respuesta =programaObtenerCU.obtenerPorId(id);
        respuesta.setData(programaDtoMapper.obtenerPrograma((Programa) respuesta.getData()));
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("")
    public ResponseEntity<Respuesta> obtenerListadoProgramas(){
        Respuesta respuesta =programaObtenerCU.obtenerProgramas();
        respuesta.setData(((List<Programa>) respuesta.getData()).stream().map(programaDtoMapper::obtenerPrograma).toList());
        return ResponseEntity.ok().body(respuesta);
    }

}
