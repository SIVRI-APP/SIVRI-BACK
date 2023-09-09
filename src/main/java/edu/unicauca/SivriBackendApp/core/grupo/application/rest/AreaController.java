package edu.unicauca.SivriBackendApp.core.grupo.application.rest;


import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.application.dto.response.ObtenerAreasDTO;
import edu.unicauca.SivriBackendApp.core.grupo.application.mapper.AreaDtoMapper;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Area;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.ObtenerAreasCU;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("area")
@CrossOrigin(origins = "#",allowedHeaders = "#")
public class AreaController {

    private final ObtenerAreasCU obtenerAreaCU;

    private final AreaDtoMapper areaDtoMapper;

    public AreaController(ObtenerAreasCU obtenerAreaCU, AreaDtoMapper areaDtoMapper) {
        this.obtenerAreaCU = obtenerAreaCU;
        this.areaDtoMapper = areaDtoMapper;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerPorId(@PathVariable(value = "id") int id) {
        Respuesta respuesta = obtenerAreaCU.obtenerAreaPorId(id);
        respuesta.setData(areaDtoMapper.dtoObtenerArea((Area) respuesta.getData()));
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("")
    public ResponseEntity<Respuesta> obtenerAreas(){
        System.out.println("entra obtener areas");
        Respuesta<List<Area>> respuestaCU= obtenerAreaCU.obtenerAreas();
        System.out.println("guarda la respuesta");
        Respuesta<List<ObtenerAreasDTO>> respuesta=new Respuesta<>();

        respuesta.setData(respuestaCU.getData().stream().map(areaDtoMapper::dtoObtenerArea).toList());

        respuesta.setStatus(respuestaCU.getStatus());
        respuesta.setUserMessage(respuestaCU.getUserMessage());
        respuesta.setDeveloperMessage(respuestaCU.getDeveloperMessage());

        return ResponseEntity.ok().body(respuesta);
    }
}



