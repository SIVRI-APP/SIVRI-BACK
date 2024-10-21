package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.GrupoActualizarCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.GrupoCrearCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.GrupoObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Grupo;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.GrupoEstado;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.petición.GrupoActualizarPorApoyoDTO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.petición.GrupoActualizarPorDirectorDTO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.petición.GrupoCrearDTO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.respuesta.ObtenerGruposDTO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.mapper.GrupoDtoMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("grupos")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class GrupoController {

    private final GrupoObtenerCU grupoObtenerCU;
    private final GrupoCrearCU grupoCrearCU;
    private final GrupoActualizarCU grupoActualizarCU;
    private final GrupoDtoMapper grupoDtoMapper;

    @GetMapping("/obtenerxid")
    @PreAuthorize("hasAnyAuthority(" +
            "'SEMILLERO:MENTOR', " +
            "'GRUPO:DIRECTOR'," +
            "'FUNCIONARIO:SEMILLEROS')")
    public ResponseEntity<Respuesta> obtenerPorId(@RequestParam(value = "idgrupo",required = true) int id){
        System.out.println("grupo id controller "+id);
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
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:GRUPOS')")
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
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:GRUPOS')")
    public ResponseEntity<Respuesta> crear(@Valid @RequestBody GrupoCrearDTO nuevoGrupo){
        Respuesta respuesta= grupoCrearCU.crear(grupoDtoMapper.crear(nuevoGrupo));
        return ResponseEntity.ok().body(respuesta);
    }
    @PatchMapping("/apoyo/{id}")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:GRUPOS')")
    public ResponseEntity<Respuesta> actualizarPorApoyo(@PathVariable(value = "id") int idGrupo,@Valid @RequestBody GrupoActualizarPorApoyoDTO nuevosDatos){
        Respuesta respuesta=grupoActualizarCU.actualizarPorApoyo(idGrupo,grupoDtoMapper.actualizarPorApoyo(nuevosDatos));
        return ResponseEntity.ok().body(respuesta);
    }
    @PatchMapping("/director/{id}")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR')")
    public ResponseEntity<Respuesta> actualizarPorDirector(@PathVariable(value = "id") int idGrupo,@Valid @RequestBody GrupoActualizarPorDirectorDTO nuevosDatos){
        Respuesta respuesta=grupoActualizarCU.actualizarPorDirector(idGrupo,grupoDtoMapper.actualizarPorDirector(nuevosDatos));
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("/listarGruposPorIdDirectorPaginado")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR')")
    public ResponseEntity<Respuesta> listarGruposPorIdDirectorPaginado(
            @RequestParam(required = true) int idDirector,
            @RequestParam(required = false) int pageNo,
            @RequestParam(required = false) int pageSize
    ){
        Respuesta respuesta = grupoObtenerCU.obtenerGruposPorIdDirectorPaginado(pageNo,pageSize,idDirector);
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("/listarGruposPorIdDirector")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR')")
    public ResponseEntity<Respuesta> listarGruposPorIdDirector(
         //   @RequestParam(required = true) int idDirector
    ){
        Respuesta respuesta = grupoObtenerCU.obtenerGruposPorIdDirector();
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("/listarGruposConFiltro")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:GRUPOS')")
    public ResponseEntity<Respuesta> obtenerGruposConFiltro(
            @RequestParam(required = false) String grupo,
            @RequestParam(required = false) GrupoEstado estado,
            @RequestParam(required = false) String facultad,
            @RequestParam(required = false) String director,
            @RequestParam(required = false) int pageNo,
            @RequestParam(required = false) int pageSize
            ){
        Respuesta respuesta = grupoObtenerCU.obtenerGruposConFiltro(pageNo,pageSize,grupo,estado,facultad,director);
        return ResponseEntity.ok().body(respuesta);
    }
}
