package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.SemilleroActualizarCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.SemilleroCrearCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.SemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.SemilleroEstado;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.SemilleroActualizarEstadoDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.SemilleroActualizarPorApoyoDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.SemilleroActualizarPorMentorDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.SemilleroCrearDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.respuesta.SemilleroObtenerDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.mapper.SemilleroDtoMapper;
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
@AllArgsConstructor
@RequestMapping("semilleros")
@CrossOrigin(origins = "htt://localhost:4200/")
public class SemilleroControlller {
    private final SemilleroObtenerCU semilleroObtenerCU;
    private final SemilleroCrearCU semilleroCrearCU;
    private final SemilleroActualizarCU semilleroActualizarCU;
    private final SemilleroDtoMapper semilleroDtoMapper;

    @GetMapping("/obtenerSemillero")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:SEMILLEROS'," +
            "'GRUPO:DIRECTOR',  " +
            "'SEMILLERO:MENTOR' )"
            )
    public ResponseEntity<Respuesta> obtenerSemilleroPorId(
            @RequestParam(required = true) Integer semilleroId
            ){
        Respuesta respuesta=semilleroObtenerCU.obtenerSemilleroPorId(semilleroId);
        respuesta.setData(semilleroDtoMapper.dtoObtenerSemillero((Semillero) respuesta.getData()));
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("/semillerosPorGrupoId/{id}")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR',  " +
            "'FUNCIONARIO:GRUPOS')")
    public ResponseEntity<Respuesta> obtenerSemillerosPorIdGrupo(@PathVariable(value = "id") int idGrupo){
        Respuesta<List<Semillero>> respuestaCU=semilleroObtenerCU.obtenerSemillerosPorIdGrupo(idGrupo);
        Respuesta<List<SemilleroObtenerDTO>> respuesta=new Respuesta<>();
        respuesta.setData(respuestaCU.getData().stream().map(semilleroDtoMapper::dtoObtenerSemillero).toList());
        respuesta.setStatus(respuestaCU.getStatus());
        respuesta.setUserMessage(respuestaCU.getUserMessage());
        respuesta.setDeveloperMessage(respuestaCU.getDeveloperMessage());
        return ResponseEntity.ok().body(respuesta);

    }
    @GetMapping("/semillerosPorIdDirectorGrupo/{id}")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR')")
    public ResponseEntity<Respuesta> obtenerSemillerosPorIdDirectorGrupo(@PathVariable(value = "id") int idDirectorGrupo){
        Respuesta<List<Semillero>> respuestaCU=semilleroObtenerCU.obtenerSemillerosPorIdDirectorGrupo(idDirectorGrupo);
        Respuesta<List<SemilleroObtenerDTO>> respuesta=new Respuesta<>();
        respuesta.setData(respuestaCU.getData().stream().map(semilleroDtoMapper::dtoObtenerSemillero).toList());
        respuesta.setStatus(respuestaCU.getStatus());
        respuesta.setUserMessage(respuestaCU.getUserMessage());
        respuesta.setDeveloperMessage(respuestaCU.getDeveloperMessage());
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:VICERRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:SEMILLEROS')")
    public ResponseEntity<Respuesta> obtenerSemilleros(){
        Respuesta<List<Semillero>> respuestaCU=semilleroObtenerCU.obtenerSemilleros();
        Respuesta<List<SemilleroObtenerDTO>> respuesta=new Respuesta<>();
        respuesta.setData(respuestaCU.getData().stream().map(semilleroDtoMapper::dtoObtenerSemillero).toList());
        respuesta.setStatus(respuestaCU.getStatus());
        respuesta.setUserMessage(respuestaCU.getUserMessage());
        respuesta.setDeveloperMessage(respuestaCU.getDeveloperMessage());
        return ResponseEntity.ok().body(respuesta);
    }

    @PatchMapping("/actualizarEstadoSemillero/{id}")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:SEMILLEROS')")
   public ResponseEntity<Respuesta> actualizarEstadoSemillero(@PathVariable(value = "id") int idSemillero, @Valid @RequestBody SemilleroActualizarEstadoDTO semilleroActualizarEstadoDTO){
        Respuesta respuesta=semilleroActualizarCU.actualizarEstadoSemillero(idSemillero,semilleroDtoMapper.actualizarEstadoSemillero(semilleroActualizarEstadoDTO));
        return ResponseEntity.ok().body(respuesta);
   }

    @PatchMapping("/semilleroPorApoyo")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:SEMILLEROS')")
    public ResponseEntity<Respuesta> actualizarPorApoyo(@Valid @RequestBody SemilleroActualizarPorApoyoDTO nuevoSemilleroDto){
        Respuesta respuesta= semilleroActualizarCU.actualizarPorApoyo(semilleroDtoMapper.actualizarPorApoyo(nuevoSemilleroDto));
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("paginado")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:VICERRECTOR',  " +
            "'FUNCIONARIO:SUPER_ADMIN', " +
            "'FUNCIONARIO:SEMILLEROS')")
    public ResponseEntity<Respuesta> obtenerListadoSemillerosPaginado(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ){
        Respuesta respuesta = semilleroObtenerCU.obtenerSemillerosPaginado(pageNo,pageSize);
        Page<Semillero> dataService= (Page<Semillero>) respuesta.getData();
        List dataRespuesta= dataService.stream().map(semilleroDtoMapper::dtoObtenerSemillero)
                .collect(Collectors.toList());
        respuesta.setData(new PageImpl<>(dataRespuesta,dataService.getPageable(),dataService.getTotalElements()));

        return ResponseEntity.ok().body(respuesta);

    }
    @PostMapping("/crearSemillero")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR')")
    public ResponseEntity<Respuesta> crear(@Valid @RequestBody SemilleroCrearDTO nuevoSemillero){

        Respuesta respuesta= semilleroCrearCU.crear(semilleroDtoMapper.crear(nuevoSemillero), nuevoSemillero.getMentorId());
        return ResponseEntity.ok().body(respuesta);

    }

    @PatchMapping("/actualizarSemilleroxMentor")
    @PreAuthorize("hasAnyAuthority(" +
            "'SEMILLERO:MENTOR','FUNCIONARIO:SEMILLEROS')")
    public ResponseEntity<Respuesta> actualizarPorMentor(@Valid @RequestBody SemilleroActualizarPorMentorDTO nuevoSemilleroDto){
        Respuesta respuesta=semilleroActualizarCU.actualizarPorMentor(semilleroDtoMapper.actualizarPorMentor(nuevoSemilleroDto));
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("/listarSemilleroConFiltro")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:SEMILLEROS')")
    public ResponseEntity<Respuesta> listarSemilleroConFiltro(

            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String correo,
            @RequestParam(required = false) SemilleroEstado estado,
            @RequestParam(required = false) int pageNo,
            @RequestParam(required = false) int pageSize
    ){
        Respuesta respuesta = semilleroObtenerCU.listarSemillerosConfiltro(pageNo,pageSize,nombre,correo,estado);
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("/listarSemilleroConFiltroxmentor")
    @PreAuthorize("hasAnyAuthority(" +
            "'SEMILLERO:MENTOR')")
    public ResponseEntity<Respuesta> listarsemillerosConFiltroxMentor(
            @RequestParam(required = false) Integer semilleroId,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) SemilleroEstado estado,
            @RequestParam(required = false) int pageNo,
            @RequestParam(required = false) int pageSize
    ){

        Respuesta respuesta = semilleroObtenerCU.listarSemilleroConFiltroxMentor(pageNo,pageSize,semilleroId,nombre,estado);
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("/listarSemilleroConFiltroPorIdDirector")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR',  " +
            "'SEMILLERO:MENTOR')")
    public ResponseEntity<Respuesta> listarSemilleroPorIdDirector(
            @RequestParam(required = false) Integer semilleroId,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) SemilleroEstado estado,
            @RequestParam(required = false) int pageNo,
            @RequestParam(required = false) int pageSize
    ){

        Respuesta respuesta = semilleroObtenerCU.obtenerSemillerosConFiltroxIdDirector(pageNo,pageSize,semilleroId,nombre,estado);
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("/listarSemilleroPorIdMentor")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR',  " +
            "'SEMILLERO:MENTOR')")
    public ResponseEntity<Respuesta> listarSemilleroPorIdMentor(
            @RequestParam(required = true) int idMentor,
            @RequestParam(required = false) int pageNo,
            @RequestParam(required = false) int pageSize
    ){
       Respuesta respuesta = semilleroObtenerCU.obtenerSemillerosPorIdMentor(pageNo,pageSize,idMentor);
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("/emailRevisionVri")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR',  " +
            "'SEMILLERO:MENTOR')")
    public ResponseEntity<Respuesta> revisionVri(
            @RequestParam() Integer semilleroId
    ){
       Respuesta respuesta=semilleroObtenerCU.envioEmailRevisionVri(semilleroId);
       return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("/emailnotificacionMentorSemillero")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR',  " +
            "'SEMILLERO:MENTOR')")
    public ResponseEntity<Respuesta> notificacionMentorSemilleroEmail(
            @RequestParam() Integer semilleroId
    ){
        Respuesta respuesta=semilleroObtenerCU.notificacionCorreoMentorSemillero(semilleroId,"nombre nuevo semillero",8);
        return ResponseEntity.ok().body(respuesta);
    }
}
