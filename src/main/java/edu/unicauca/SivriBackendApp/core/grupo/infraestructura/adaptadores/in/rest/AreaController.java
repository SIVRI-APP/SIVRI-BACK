package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest;


import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.AreasObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Area;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.SubArea;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.respuesta.ObtenerAreasDTO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.mapper.AreaDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("areas")
@CrossOrigin(origins = "#",allowedHeaders = "#")
public class AreaController {

    private final AreasObtenerCU obtenerAreaCU;

    private final AreaDtoMapper areaDtoMapper;

    public AreaController(AreasObtenerCU obtenerAreaCU, AreaDtoMapper areaDtoMapper) {
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
        Respuesta<List<Area>> respuestaCU= obtenerAreaCU.obtenerAreas();
        Respuesta<List<ObtenerAreasDTO>> respuesta=new Respuesta<>();
        respuesta.setData(respuestaCU.getData().stream().map(areaDtoMapper::dtoObtenerArea).toList());
        respuesta.setStatus(respuestaCU.getStatus());
        respuesta.setUserMessage(respuestaCU.getUserMessage());
        respuesta.setDeveloperMessage(respuestaCU.getDeveloperMessage());

        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("/{id}/subareas")
    public ResponseEntity<Respuesta> obtenerSubAreasPorArea(@PathVariable(value = "id") int id) {
        Respuesta respuesta = obtenerAreaCU.obtenerSubAreasPorIdArea(id);
        respuesta.setData(areaDtoMapper.dtoObtenerSubAreas((List<SubArea>) respuesta.getData()));
        return ResponseEntity.ok().body(respuesta);
    }
}



