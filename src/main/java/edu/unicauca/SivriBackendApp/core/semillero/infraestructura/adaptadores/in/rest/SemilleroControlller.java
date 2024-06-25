package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.SemilleroActualizarCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.SemilleroCrearCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.SemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.SemilleroEstado;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.SemilleroActualizarEstadoDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.SemilleroActualizarPorApoyoDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.SemilleroActualizarPorMentorDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.SemilleroCrearDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.respuesta.SemilleroObtenerDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.mapper.SemilleroDtoMapper;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("semilleros")
@CrossOrigin(origins = "htt://localhost:4200/")
public class SemilleroControlller {
    private final SemilleroObtenerCU semilleroObtenerCU;
    private final SemilleroCrearCU semilleroCrearCU;
    private final SemilleroActualizarCU semilleroActualizarCU;
    private final SemilleroDtoMapper semilleroDtoMapper;

    public SemilleroControlller(SemilleroObtenerCU semilleroObtenerCU, SemilleroCrearCU semilleroCrearCU, SemilleroActualizarCU semilleroActualizarCU, SemilleroDtoMapper semilleroDtoMapper) {
        this.semilleroObtenerCU = semilleroObtenerCU;
        this.semilleroCrearCU = semilleroCrearCU;
        this.semilleroActualizarCU = semilleroActualizarCU;
        this.semilleroDtoMapper = semilleroDtoMapper;
    }
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
        //System.out.println("LISSTADO RESPUESTA: "+respuestaCU);
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
        System.out.println("IDSemillero controller "+idSemillero+" datosque recibe delDto "+semilleroActualizarEstadoDTO);
        Respuesta respuesta=semilleroActualizarCU.actualizarEstadoSemillero(idSemillero,semilleroDtoMapper.actualizarEstadoSemillero(semilleroActualizarEstadoDTO));
        System.out.println("RESPUESTA DELCONTROLLER "+respuesta);
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
    @PostMapping("")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR')")
    public ResponseEntity<Respuesta> crear(@Valid @RequestBody SemilleroCrearDTO nuevoSemillero){
        System.out.println("DATOS QUE RECIBE SEMILLERO PARA CREAR "+nuevoSemillero);

        Respuesta respuesta= semilleroCrearCU.crear(semilleroDtoMapper.crear(nuevoSemillero), nuevoSemillero.getMentorId());
        //System.out.println("DATOS RESPUESTA DE CONTROLLER: "+respuesta);
        return ResponseEntity.ok().body(respuesta);

    }

    @PatchMapping("/actualizarSemilleroxMentor")
    @PreAuthorize("hasAnyAuthority(" +
            "'SEMILLERO:MENTOR')")
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
        System.out.println("semillero id"+semilleroId);

        System.out.println("estado"+estado);
        System.out.println("pagen"+pageNo+"size"+pageSize);

        Respuesta respuesta = semilleroObtenerCU.listarSemilleroConFiltroxMentor(pageNo,pageSize,semilleroId,nombre,estado);
        return ResponseEntity.ok().body(respuesta);
    }
    // la consulta de listar semillero por idmentor sirve para consultar los semilleros del director tambien
    @GetMapping("/listarSemilleroPorIdMentor")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR',  " +
            "'SEMILLERO:MENTOR')")
    public ResponseEntity<Respuesta> listarSemilleroPorIdMentor(
            @RequestParam(required = true) int idMentor,
            @RequestParam(required = false) int pageNo,
            @RequestParam(required = false) int pageSize
    ){
        System.out.println(idMentor+" "+pageNo+" "+pageSize);
        Respuesta respuesta = semilleroObtenerCU.obtenerSemillerosPorIdMentor(pageNo,pageSize,idMentor);
        return ResponseEntity.ok().body(respuesta);
    }

}
