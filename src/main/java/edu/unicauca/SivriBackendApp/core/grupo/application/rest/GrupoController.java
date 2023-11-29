package edu.unicauca.SivriBackendApp.core.grupo.application.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.application.dto.request.*;
import edu.unicauca.SivriBackendApp.core.grupo.application.dto.response.ObtenerGruposDTO;
import edu.unicauca.SivriBackendApp.core.grupo.application.mapper.GrupoDtoMapper;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Grupo;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.GrupoActualizarCU;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.GrupoCrearCU;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.GrupoObtenerCU;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    @GetMapping("paginado")
    public ResponseEntity<Respuesta> obtenerGruposPaginado(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ){
        Respuesta respuesta = grupoObtenerCU.obtenerGruposPaginado(pageNo,pageSize);
        Page<Grupo> dataService=(Page<Grupo>) respuesta.getData();
        List dataRespuesta = dataService.stream().map(grupoDtoMapper::dtoObtenerGrupo).collect(Collectors.toList());
        respuesta.setData(new PageImpl<>(dataRespuesta,dataService.getPageable(),dataService.getTotalElements()));
        return ResponseEntity.ok().body(respuesta);
    }
    @PostMapping("")
    public ResponseEntity<Respuesta> crear(@Valid @RequestBody GrupoCrearDTO nuevoGrupo){
      //  System.out.println("datos que llegan al controlador por parametro del grupo "+ nuevoGrupo);
        Respuesta respuesta= grupoCrearCU.crear(grupoDtoMapper.crear(nuevoGrupo));

        return ResponseEntity.ok().body(respuesta);
    }
    @PatchMapping("/apoyo/{id}")
    public ResponseEntity<Respuesta> actualizarPorApoyo(@PathVariable(value = "id") int idGrupo,@Valid @RequestBody GrupoActualizarPorApoyoDTO nuevosDatos){
        Respuesta respuesta=grupoActualizarCU.actualizarPorApoyo(idGrupo,grupoDtoMapper.actualizarPorApoyo(nuevosDatos));
        return ResponseEntity.ok().body(respuesta);
    }
    @PatchMapping("/director/{id}")
    public ResponseEntity<Respuesta> actualizarPorDirector(@PathVariable(value = "id") int idGrupo,@Valid @RequestBody GrupoActualizarPorDirectorDTO nuevosDatos){
        Respuesta respuesta=grupoActualizarCU.actualizarPorDirector(idGrupo,grupoDtoMapper.actualizarPorDirector(nuevosDatos));
        return ResponseEntity.ok().body(respuesta);
    }
    /*@PatchMapping("/grupoFormuladoDirector")
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
*/
}
