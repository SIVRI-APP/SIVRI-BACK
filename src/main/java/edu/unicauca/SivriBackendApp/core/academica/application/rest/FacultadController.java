package edu.unicauca.SivriBackendApp.core.academica.application.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.academica.application.dto.response.FacultadDTO;
import edu.unicauca.SivriBackendApp.core.academica.application.mapper.FacultadDtoMapper;
import edu.unicauca.SivriBackendApp.core.academica.domain.model.Facultad;
import edu.unicauca.SivriBackendApp.core.academica.domain.port.in.FacultadObtenerCU;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("facultad")
@CrossOrigin(origins = "#",allowedHeaders = "#")
public class FacultadController {

    private final FacultadObtenerCU facultadObtenerCU;

    private final FacultadDtoMapper facultadDtoMapper;


    public FacultadController(FacultadObtenerCU facultadObtenerCU, FacultadDtoMapper facultadDtoMapper) {
        this.facultadObtenerCU = facultadObtenerCU;
        this.facultadDtoMapper = facultadDtoMapper;
    }

    @GetMapping("")
    public ResponseEntity<Respuesta> obtenerFacultades(){

        Respuesta<List<Facultad>> respuestaCU= facultadObtenerCU.obtenerFacultades();
        Respuesta<List<FacultadDTO>> respuesta=new Respuesta<>();
        respuesta.setData(respuestaCU.getData().stream().map(facultadDtoMapper::obtenerFacultad).toList());
        respuesta.setStatus(respuestaCU.getStatus());
        respuesta.setUserMessage(respuestaCU.getUserMessage());
        respuesta.setDeveloperMessage(respuestaCU.getDeveloperMessage());
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerPorId(@PathVariable(value = "id") int id){
        Respuesta respuesta= facultadObtenerCU.obtenerPorId(id);
        respuesta.setData(facultadDtoMapper.obtenerFacultad((Facultad) respuesta.getData()));
        return ResponseEntity.ok().body(respuesta);
    }

}
