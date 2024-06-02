package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.IntegranteSemilleroActualizarCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.IntegranteSemilleroCrearCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.in.IntegranteSemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.EstadoIntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.IntegranteSemilleroActualizarDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.IntegranteSemilleroCrearDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.petición.IntegranteSemilleroCrearMentorDto;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.respuesta.SemilleroObtenerDTO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.mapper.IntegranteSemilleroDtoMapper;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("integranteSemillero")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class IntegranteSemilleroController {
     private final IntegranteSemilleroObtenerCU integranteSemilleroObtenerCU;
     private final IntegranteSemilleroCrearCU integranteSemilleroCrearCU;
     private final IntegranteSemilleroActualizarCU integranteSemilleroActualizarCU;
     private final IntegranteSemilleroDtoMapper integranteSemilleroDtoMapper;

     public IntegranteSemilleroController(IntegranteSemilleroObtenerCU integranteSemilleroObtenerCU, IntegranteSemilleroCrearCU integranteSemilleroCrearCU, IntegranteSemilleroActualizarCU integranteSemilleroActualizarCU, IntegranteSemilleroDtoMapper integranteSemilleroDtoMapper) {
          this.integranteSemilleroObtenerCU = integranteSemilleroObtenerCU;
          this.integranteSemilleroCrearCU = integranteSemilleroCrearCU;
          this.integranteSemilleroActualizarCU = integranteSemilleroActualizarCU;
          this.integranteSemilleroDtoMapper = integranteSemilleroDtoMapper;
     }
     @GetMapping("paginado")
     @PreAuthorize("hasAnyAuthority(" +
             "'FUNCIONARIO:SEMILLEROS')")
     public ResponseEntity<Respuesta> obtenerIntegrantesSemilleroPaginado(
             @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
             @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
     ) {
          Respuesta respuesta= integranteSemilleroObtenerCU.obtenerListadoIntegrantesSemilleroPaginado(pageNo,pageSize);
          Page<IntegranteSemillero> dataService=(Page<IntegranteSemillero>) respuesta.getData();
          List dataRespuesta=dataService.stream().map(integranteSemilleroDtoMapper::obtenerDtoIntegranteSemillero).collect(Collectors.toList());
          respuesta.setData(new PageImpl<>(dataRespuesta,dataService.getPageable(),dataService.getTotalElements()));

          return ResponseEntity.ok().body(respuesta);
     }
     @GetMapping("integrantesPorSemilleroId")
     @PreAuthorize("hasAnyAuthority(" +
             "'GRUPO:DIRECTOR', " +
             "'FUNCIONARIO:SEMILLEROS')")
     public ResponseEntity<Respuesta> obtenerIntegrantesSemilleroPorIdSemillero(
             @RequestParam(value = "semilleroId",required = true) int semilleroId
     ) {
          Respuesta respuesta = integranteSemilleroObtenerCU.obtenerIntegranteSemilleroPorIdSemillero(semilleroId);
          respuesta.setData(((List<IntegranteSemillero>) respuesta.getData()).stream().map(integranteSemilleroDtoMapper::obtenerDtoIntegranteSemillero).toList());
          return ResponseEntity.ok().body(respuesta);
     }


     @GetMapping("/{id}")
     @PreAuthorize("hasAnyAuthority(" +
             "'FUNCIONARIO:SEMILLEROS', " +
             "'SEMILLERO:MENTOR')")
     public ResponseEntity<Respuesta> obtenerIntegranteSemilleroPorId(@PathVariable(value = "id") int id) {
          Respuesta respuesta=integranteSemilleroObtenerCU.obtenerPorId(id);
          respuesta.setData(integranteSemilleroDtoMapper.obtenerDtoIntegranteSemillero((IntegranteSemillero) respuesta.getData()));
          return ResponseEntity.ok().body(respuesta);
     }
     @PostMapping("")
     @PreAuthorize("hasAnyAuthority(" +
             "'FUNCIONARIO:SEMILLEROS', " +
             "'SEMILLERO:MENTOR')")
     public ResponseEntity<Respuesta> crear(@Valid @RequestBody IntegranteSemilleroCrearDTO nuevoIntegranteSemillero){
          Respuesta respuesta=integranteSemilleroCrearCU.crear(integranteSemilleroDtoMapper.crear(nuevoIntegranteSemillero));
          return ResponseEntity.ok().body(respuesta);

     }
     @PostMapping("/director")
     @PreAuthorize("hasAnyAuthority("+
             "'GRUPO:DIRECTOR')")
     public ResponseEntity<Respuesta> crearMentor(@Valid @RequestBody IntegranteSemilleroCrearMentorDto nuevoIntegranteSemillero){
          Respuesta respuesta=integranteSemilleroCrearCU.crear(integranteSemilleroDtoMapper.crearMentor(nuevoIntegranteSemillero));
          return ResponseEntity.ok().body(respuesta);
     }

     @PatchMapping("")
     @PreAuthorize("hasAnyAuthority(" +
             "'FUNCIONARIO:SEMILLEROS', " +
             "'SEMILLERO:MENTOR')")
     public ResponseEntity<Respuesta> actualizar(@Valid @RequestBody IntegranteSemilleroActualizarDTO nuevoIntegrante){
          Respuesta respuesta = integranteSemilleroActualizarCU.actualizar(integranteSemilleroDtoMapper.actualizar(nuevoIntegrante));
          return ResponseEntity.ok().body(respuesta);
     }

     @GetMapping("/semillerosPorMentorId/{id}")
     public ResponseEntity<Respuesta> obtenerSemillerosPorIdMentor(@PathVariable(value = "id")String idMentor){
          System.out.println("ENTRA A CONTROLLER CON DATOS: "+idMentor);
          Respuesta<List<Semillero>> respuestaCU=integranteSemilleroObtenerCU.obtenerSemillerosPorIdMentor(idMentor);
          //System.out.println("RESPUESTA CU DE CONTROLLER "+respuestaCU);
          Respuesta<List<SemilleroObtenerDTO>> respuesta=new Respuesta<>();
          respuesta.setData(respuestaCU.getData().stream().map(integranteSemilleroDtoMapper::dtoObtenerSemillero).toList());
          respuesta.setStatus(respuestaCU.getStatus());
          respuesta.setUserMessage(respuestaCU.getUserMessage());
          respuesta.setDeveloperMessage(respuestaCU.getDeveloperMessage());
          return ResponseEntity.ok().body(respuesta);
     }
     @GetMapping("listarIntegrantesSemilleroPorSemilleroId")
     @PreAuthorize("hasAnyAuthority(" +
             "'GRUPO:DIRECTOR', " +
             "'SEMILLERO:MENTOR', " +
             "'FUNCIONARIO:SEMILLEROS')")
     public ResponseEntity<Respuesta> listarIntegrantesSemilleroPorIdSemillero(
             @RequestParam(value = "semilleroId",required = true) int semilleroId,
             @RequestParam(value = "numeroDocumento",required = false) String numeroDocumento,
             @RequestParam(value = "estado",required = false) EstadoIntegranteSemillero estado,
             @RequestParam(value = "rolSemillero",required = false) String rolSemillero,
             @RequestParam(required = false) int pageNo,
             @RequestParam(required = false) int pageSize
     ) {
          Respuesta respuesta = integranteSemilleroObtenerCU.obtenerIntegrantesSemilleroPorIdSemillero(pageNo,pageSize,semilleroId,numeroDocumento,rolSemillero,estado);
          return ResponseEntity.ok().body(respuesta);
     }
     @GetMapping("listarIntegrantesConFiltro")
     @PreAuthorize("hasAnyAuthority(" +
             "'SEMILLERO:MENTOR', " +
             "'FUNCIONARIO:SEMILLEROS')")
     public ResponseEntity<Respuesta> listarIntegrantesSemilleroConFiltro(
             @RequestParam(required = false) String numeroDocumento,
             @RequestParam(required = false) String rolSemillero,
             @RequestParam(required = false) EstadoIntegranteSemillero estado,
             @RequestParam(required = false) int pageNo,
             @RequestParam(required = false) int pageSize
     ){
          Respuesta respuesta = integranteSemilleroObtenerCU.listarIntegrantesSemilleroConFiltro(pageNo,pageSize,numeroDocumento,rolSemillero,estado);
          return ResponseEntity.ok().body(respuesta);
     }


}
