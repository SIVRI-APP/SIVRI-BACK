package edu.unicauca.SivriBackendApp.core.semillero.application.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.semillero.application.dto.request.IntegranteSemilleroActualizarDTO;
import edu.unicauca.SivriBackendApp.core.semillero.application.dto.request.IntegranteSemilleroCrearDTO;
import edu.unicauca.SivriBackendApp.core.semillero.application.dto.response.SemilleroObtenerDTO;
import edu.unicauca.SivriBackendApp.core.semillero.application.mapper.IntegranteSemilleroDtoMapper;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.IntegranteSemilleroActualizarCU;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.IntegranteSemilleroCrearCU;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.IntegranteSemilleroObtenerCU;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("integranteSemillero")
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
     @GetMapping("")
     public ResponseEntity<Respuesta> obtenerIntegrantesSemillero() {

          Respuesta respuesta= integranteSemilleroObtenerCU.obtenerIntegrantesSemillero();

          respuesta.setData(((List<IntegranteSemillero>) respuesta.getData())
                  .stream()
                  .map(integranteSemilleroDtoMapper::obtenerDtoIntegranteSemillero)
                  .toList());
          return ResponseEntity.ok().body(respuesta);
     }
     @GetMapping("/{id}")
     public ResponseEntity<Respuesta> obtenerIntegranteSemilleroPorId(@PathVariable(value = "id") int id) {
          Respuesta respuesta=integranteSemilleroObtenerCU.obtenerPorId(id);
          respuesta.setData(integranteSemilleroDtoMapper.obtenerDtoIntegranteSemillero((IntegranteSemillero) respuesta.getData()));
          return ResponseEntity.ok().body(respuesta);
     }
     @PostMapping("")
     public ResponseEntity<Respuesta> crear(@Valid @RequestBody IntegranteSemilleroCrearDTO nuevoIntegranteSemillero){
          Respuesta respuesta=integranteSemilleroCrearCU.crear(integranteSemilleroDtoMapper.crear(nuevoIntegranteSemillero));
          return ResponseEntity.ok().body(respuesta);

     }

     @PatchMapping("")
     public ResponseEntity<Respuesta> actualizar(@Valid @RequestBody IntegranteSemilleroActualizarDTO nuevoIntegrante){
          //System.out.println("DATOS QUE INGRESAN AL CONTROLLER "+nuevoIntegrante);
          Respuesta respuesta = integranteSemilleroActualizarCU.actualizar(integranteSemilleroDtoMapper.actualizar(nuevoIntegrante));
          //System.out.println("RESPUESTA "+respuesta);
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

}
