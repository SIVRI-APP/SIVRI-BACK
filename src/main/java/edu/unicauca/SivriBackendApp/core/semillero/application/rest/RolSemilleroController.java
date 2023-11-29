package edu.unicauca.SivriBackendApp.core.semillero.application.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.application.dto.response.RolesSemilleroObtenerDTO;
import edu.unicauca.SivriBackendApp.core.semillero.application.mapper.RolSemilleroDtoMapper;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.RolSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.RolesSemilleroObtenerCU;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rolesSemillero")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RolSemilleroController {
    private final RolesSemilleroObtenerCU rolesSemilleroObtenerCU;
    private final RolSemilleroDtoMapper rolSemilleroDtoMapper;

    public RolSemilleroController(RolesSemilleroObtenerCU rolesSemilleroObtenerCU, RolSemilleroDtoMapper rolSemilleroDtoMapper) {
        this.rolesSemilleroObtenerCU = rolesSemilleroObtenerCU;
        this.rolSemilleroDtoMapper = rolSemilleroDtoMapper;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerRolesSemilleroPorId(@PathVariable(value = "id")int id){
        Respuesta respuesta=rolesSemilleroObtenerCU.obtenerRolSemilleroPorId(id);
        respuesta.setData(rolSemilleroDtoMapper.dtoObtenerRolSemillero((RolSemillero) respuesta.getData()));
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("")
    public ResponseEntity<Respuesta> obtenerRolesSemillero(){
        Respuesta<List<RolSemillero>> respuestaCU=rolesSemilleroObtenerCU.obtenerRolesSemillero();

        Respuesta<List<RolesSemilleroObtenerDTO>> respuesta=new Respuesta<>();
        respuesta.setData(respuestaCU.getData().stream().map(
                rolSemilleroDtoMapper::dtoObtenerRolSemillero
        ).toList());
        respuesta.setStatus(respuestaCU.getStatus());
        respuesta.setUserMessage(respuestaCU.getUserMessage());
        respuesta.setDeveloperMessage(respuestaCU.getDeveloperMessage());
        return ResponseEntity.ok().body(respuesta);
    }

}
