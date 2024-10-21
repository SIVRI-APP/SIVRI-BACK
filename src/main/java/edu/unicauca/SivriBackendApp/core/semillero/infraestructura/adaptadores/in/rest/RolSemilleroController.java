package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.RolesSemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.RolSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.respuesta.RolesSemilleroObtenerDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.mapper.RolSemilleroDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @GetMapping("obtenerRoles")
    @PreAuthorize("hasAnyAuthority(" +
            "'SEMILLERO:MENTOR', " +
            "'FUNCIONARIO:SEMILLEROS','GRUPO:DIRECTOR')")
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
