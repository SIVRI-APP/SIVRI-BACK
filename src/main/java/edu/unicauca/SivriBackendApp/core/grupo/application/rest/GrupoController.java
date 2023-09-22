package edu.unicauca.SivriBackendApp.core.grupo.application.rest;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.application.dto.response.ObtenerGruposDTO;
import edu.unicauca.SivriBackendApp.core.grupo.application.mapper.GrupoDtoMapper;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Grupo;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.GrupoObtenerCU;
import org.mapstruct.Mapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("grupo")
@CrossOrigin(origins = "#",allowedHeaders = "#")
public class GrupoController {

    private final GrupoObtenerCU grupoObtenerCU;
    private final GrupoDtoMapper grupoDtoMapper;

    public GrupoController(GrupoObtenerCU grupoObtenerCU, GrupoDtoMapper grupoDtoMapper) {
        this.grupoObtenerCU = grupoObtenerCU;
        this.grupoDtoMapper = grupoDtoMapper;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerPorId(@PathVariable(value = "id") int id){
        Respuesta respuesta=grupoObtenerCU.obtenerGrupoPorId(id);
        respuesta.setData(grupoDtoMapper.dtoObtenerGrupo((Grupo) respuesta.getData()));
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("")
    public ResponseEntity<Respuesta> obtenerGrupos(){
        Respuesta<List<Grupo>> respuestaCU=grupoObtenerCU.obtenerGrupos();
        Respuesta<List<ObtenerGruposDTO>> respuesta=new Respuesta<>();
        respuesta.setData(respuestaCU.getData().stream().map(grupoDtoMapper::dtoObtenerGrupo).toList());
        respuesta.setStatus(respuestaCU.getStatus());
        respuesta.setUserMessage(respuestaCU.getUserMessage());
        respuesta.setDeveloperMessage(respuestaCU.getDeveloperMessage());
        return ResponseEntity.ok().body(respuesta);
    }

}
