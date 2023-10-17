package edu.unicauca.SivriBackendApp.core.grupo.application.rest;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.application.dto.request.*;
import edu.unicauca.SivriBackendApp.core.grupo.application.dto.response.ObtenerGruposDTO;
import edu.unicauca.SivriBackendApp.core.grupo.application.mapper.GrupoDtoMapper;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Grupo;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.GrupoActualizarCU;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.GrupoCrearCU;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.GrupoObtenerCU;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("grupos")
@CrossOrigin(origins = "#",allowedHeaders = "#")
public class GrupoController {

    private final GrupoObtenerCU grupoObtenerCU;
    private final GrupoCrearCU grupoCrearCU;
    private final GrupoActualizarCU grupoActualizarCU;
    private final GrupoDtoMapper grupoDtoMapper;
    public GrupoController(GrupoObtenerCU grupoObtenerCU, GrupoCrearCU grupoCrearCU, GrupoDtoMapper grupoDtoMapper, GrupoActualizarCU grupoActualizarCU) {
        this.grupoObtenerCU = grupoObtenerCU;
        this.grupoCrearCU = grupoCrearCU;
        this.grupoActualizarCU = grupoActualizarCU;
        this.grupoDtoMapper = grupoDtoMapper;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerPorId(@PathVariable(value = "id") int id){
        System.out.println("ENTRA A BUSCAR GRUPO POR ID EN CONTROLLER ");
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
    @PostMapping("")
    public ResponseEntity<Respuesta> crear(@Valid @RequestBody GrupoCrearDTO nuevoGrupo){
      //  System.out.println("datos que llegan al controlador por parametro del grupo "+ nuevoGrupo);
        Respuesta respuesta= grupoCrearCU.crear(grupoDtoMapper.crear(nuevoGrupo));

        return ResponseEntity.ok().body(respuesta);
    }
    @PatchMapping("/apoyo")
    public ResponseEntity<Respuesta> actualizarPorApoyo(@Valid @RequestBody GrupoActualizarPorApoyoDTO nuevosDatos){
        Respuesta respuesta=grupoActualizarCU.actualizarPorApoyo(grupoDtoMapper.actualizarPorApoyo(nuevosDatos));
        return ResponseEntity.ok().body(respuesta);
    }
    @PatchMapping("/director")
    public ResponseEntity<Respuesta> actualizarPorDirector(@Valid @RequestBody GrupoActualizarPorDirectorDTO nuevosDatos){
        Respuesta respuesta=grupoActualizarCU.actualizarPorDirector(grupoDtoMapper.actualizarPorDirector(nuevosDatos));
        return ResponseEntity.ok().body(respuesta);
    }
    @PatchMapping("/grupoFormuladoDirector")
    public ResponseEntity<Respuesta> actualizarGrupoFormuladoPorDirector(@Valid @RequestBody GrupoFormuladoActualizarPorDirectorDTO nuevoDatosGrupo){
        Respuesta respuesta=grupoActualizarCU.actualizarGrupoFormuladoPorDirector(grupoDtoMapper.actualizarGrupoFormuladoPorDirector(nuevoDatosGrupo));
        return ResponseEntity.ok().body(respuesta);
    }
    @PatchMapping("/grupoActivoDirector")
    public ResponseEntity<Respuesta> actualizarGrupoActivoPorDirector(@Valid @RequestBody GrupoActivoActualizarPorDirectorDTO nuevosDatosGrupo){
        System.out.println("DATOS DEL GRUPO ACTIVO QUE LLEGAN POR PARAMETRO: "+nuevosDatosGrupo);
        Respuesta respuesta=grupoActualizarCU.actualizarGrupoActivoPorDirector(grupoDtoMapper.actualizarGrupoActivoPorDirector(nuevosDatosGrupo));
        return ResponseEntity.ok().body(respuesta);
    }

}
