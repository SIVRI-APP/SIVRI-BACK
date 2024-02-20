package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.RolesGrupoObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.RolGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.respuesta.ObtenerRolesGrupoDTO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.mapper.RolGrupoDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rolgrupo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RolGrupoConntroller {

    private final RolesGrupoObtenerCU obtenerRolesGrupoCU;

    private final RolGrupoDtoMapper rolGrupoDtoMapper;

    public RolGrupoConntroller(RolesGrupoObtenerCU obtenerRolesGrupoCU, RolGrupoDtoMapper rolGrupoDtoMapper) {
        this.obtenerRolesGrupoCU = obtenerRolesGrupoCU;
        this.rolGrupoDtoMapper = rolGrupoDtoMapper;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerRolesGrupoPorId(@PathVariable(value = "id")int id){

        Respuesta respuesta= obtenerRolesGrupoCU.obtenerRolGrupoPorId(id);
        respuesta.setData(rolGrupoDtoMapper.dtoObtenerRolGrupo((RolGrupo) respuesta.getData()));

        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("")
    public ResponseEntity<Respuesta> obtenerRolesGrupo(){

        Respuesta<List<RolGrupo>> respuestaCU= obtenerRolesGrupoCU.obtenerRolesGrupo();

        Respuesta<List<ObtenerRolesGrupoDTO>> respuesta = new Respuesta<>();

        respuesta.setData(respuestaCU.getData().stream().
                map(rolGrupoDtoMapper::dtoObtenerRolGrupo).
                toList());
        respuesta.setStatus(respuestaCU.getStatus());
        respuesta.setUserMessage(respuestaCU.getUserMessage());
        respuesta.setDeveloperMessage(respuestaCU.getDeveloperMessage());

        return ResponseEntity.ok().body(respuesta);
    }

}
