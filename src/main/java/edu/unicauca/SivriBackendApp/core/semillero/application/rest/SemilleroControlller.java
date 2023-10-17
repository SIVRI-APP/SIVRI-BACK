package edu.unicauca.SivriBackendApp.core.semillero.application.rest;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.application.dto.request.*;
import edu.unicauca.SivriBackendApp.core.semillero.application.dto.response.SemilleroObtenerDTO;
import edu.unicauca.SivriBackendApp.core.semillero.application.mapper.SemilleroDtoMapper;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.SemilleroActualizarCU;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.SemilleroCrearCU;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.SemilleroObtenerCU;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("semilleros")
@CrossOrigin(origins = "#",allowedHeaders = "#")
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
    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerSemilleroPorId(@PathVariable(value = "id")int id){
        Respuesta respuesta=semilleroObtenerCU.obtenerSemilleroPorId(id);
        respuesta.setData(semilleroDtoMapper.dtoObtenerSemillero((Semillero) respuesta.getData()));
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("/semillerosPorGrupoId/{id}")
    public ResponseEntity<Respuesta> obtenerSemillerosPorIdGrupo(@PathVariable(value = "id") int idGrupo){
        Respuesta<List<Semillero>> respuestaCU=semilleroObtenerCU.obtenerSemillerosPorIdGrupo(idGrupo);
        Respuesta<List<SemilleroObtenerDTO>> respuesta=new Respuesta<>();
        respuesta.setData(respuestaCU.getData().stream().map(semilleroDtoMapper::dtoObtenerSemillero).toList());
        respuesta.setStatus(respuestaCU.getStatus());
        respuesta.setUserMessage(respuestaCU.getUserMessage());
        respuesta.setDeveloperMessage(respuestaCU.getDeveloperMessage());
        return ResponseEntity.ok().body(respuesta);

    }
    @PatchMapping("/actualizarEstadoSemillero/{id}")
   public ResponseEntity<Respuesta> actualizarEstadoSemillero(@PathVariable(value = "id") int idSemillero, @Valid @RequestBody SemilleroActualizarEstadoDTO semilleroActualizarEstadoDTO){
        System.out.println("IDSemillero controller "+idSemillero+" datosque recibe delDto "+semilleroActualizarEstadoDTO);
        Respuesta respuesta=semilleroActualizarCU.actualizarEstadoSemillero(idSemillero,semilleroDtoMapper.actualizarEstadoSemillero(semilleroActualizarEstadoDTO));
        System.out.println("RESPUESTA DELCONTROLLER "+respuesta);
        return ResponseEntity.ok().body(respuesta);
   }
    @PatchMapping("/semilleroPorApoyo")
    public ResponseEntity<Respuesta> actualizarPorApoyo(@Valid @RequestBody SemilleroActualizarPorApoyoDTO nuevoSemilleroDto){
        Respuesta respuesta= semilleroActualizarCU.actualizarPorApoyo(semilleroDtoMapper.actualizarPorApoyo(nuevoSemilleroDto));
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("")
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
    @GetMapping("paginado")
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
    public ResponseEntity<Respuesta> crear(@Valid @RequestBody SemilleroCrearDTO nuevoSemillero){
        //System.out.println("DATOS QUE RECIBE SEMILLERO PARA CREAR "+nuevoSemillero);
        String mentorId= nuevoSemillero.getMentorId();
        //System.out.println("id mentor "+mentorId);
        Respuesta respuesta= semilleroCrearCU.crear(semilleroDtoMapper.crear(nuevoSemillero),mentorId);
        //System.out.println("DATOS RESPUESTA DE CONTROLLER: "+respuesta);
        return ResponseEntity.ok().body(respuesta);

    }


    @PatchMapping("/semilleroPorMentor")
    public ResponseEntity<Respuesta> actualizarPorMentor(@Valid @RequestBody SemilleroActualizarPorMentorDTO nuevoSemilleroDto){
        Respuesta respuesta=semilleroActualizarCU.actualizarPorMentor(semilleroDtoMapper.actualizarPorMentor(nuevoSemilleroDto));
        return ResponseEntity.ok().body(respuesta);
    }

     /*@GetMapping("/semillerosPorMentorId/{id}")
    public ResponseEntity<Respuesta> obtenerSemillerosPorIdMentor(@PathVariable(value = "id")String idMentor){
        Respuesta<List<Semillero>> respuestaCU=semilleroObtenerCU.obtenerSemillerosPorIdMentor(idMentor);
        Respuesta<List<SemilleroObtenerDTO>> respuesta=new Respuesta<>();
        respuesta.setData(respuestaCU.getData().stream().map(semilleroDtoMapper::dtoObtenerSemillero).toList());
        respuesta.setStatus(respuestaCU.getStatus());
        respuesta.setUserMessage(respuestaCU.getUserMessage());
        respuesta.setDeveloperMessage(respuestaCU.getDeveloperMessage());
        return ResponseEntity.ok().body(respuesta);
    }
*/

}
