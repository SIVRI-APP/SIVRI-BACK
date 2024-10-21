package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.IntegranteGrupoActualizarCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.IntegranteGrupoCrearCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.IntegranteGrupoObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.IntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.petición.IntegranteGrupoActualizarDTO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.petición.IntegranteGrupoCrearDTO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.mapper.IntegranteGrupoDtoMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("integrantes")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class IntegranteGrupoController {

    private final IntegranteGrupoObtenerCU integranteGrupoObtenerCU;
    private final IntegranteGrupoDtoMapper integranteGrupoDtoMapper;
    private final IntegranteGrupoCrearCU integranteGrupoCrearCU;
    private final IntegranteGrupoActualizarCU integranteGrupoActualizarCU;

    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerInfoPorId(@PathVariable(value = "id") int id){
        Respuesta respuesta= integranteGrupoObtenerCU.obtenerIntegrantePorId(id);

        respuesta.setData(integranteGrupoDtoMapper.obtenerIntegranteGrupo((IntegranteGrupo) respuesta.getData()));
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("")
    @PreAuthorize("hasAnyAuthority(" +
            "'GRUPO:DIRECTOR')")
    public ResponseEntity<Respuesta> obtenerIntegrantesPorGrupo(){
        Respuesta respuesta= integranteGrupoObtenerCU.obtenerIntegrantesGrupo();

        respuesta.setData(
                ((List<IntegranteGrupo>) respuesta.getData())
                        .stream()
                        .map(integranteGrupoDtoMapper::obtenerIntegranteGrupo)
                        .toList()
        );
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("integrantesMentoresPorGrupoId")
    @PreAuthorize("hasAnyAuthority(" +
            "'SEMILLERO:MENTOR', " +
            "'GRUPO:DIRECTOR'," +
            "'FUNCIONARIO:SEMILLEROS')")
    public ResponseEntity<Respuesta> obtenerIntegrantesMentoresGrupoPorIdGrupo(
            @RequestParam(value = "idGrupo",required = true) int idGrupo
    ){
        Respuesta respuesta=integranteGrupoObtenerCU.obtenerIntegrantesMentoresxGrupoId(idGrupo);
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("integrantesPorGrupoId")
    @PreAuthorize("hasAnyAuthority(" +
            "'SEMILLERO:MENTOR', " +
            "'GRUPO:DIRECTOR')")
    public ResponseEntity<Respuesta> obtenerIntegrantesGrupoPorIdGrupo(
            @RequestParam(value = "idGrupo",required = true) int idGrupo
    ){
        Respuesta respuesta = integranteGrupoObtenerCU.obtenerIntegranteGrupoPorIdGrupo(idGrupo);
        respuesta.setData(((List<IntegranteGrupo>) respuesta.getData()).stream().map(integranteGrupoDtoMapper::obtenerIntegranteGrupo).toList());
      return ResponseEntity.ok().body(respuesta);
    }
    @PostMapping("/asociarGrupo")
    public ResponseEntity<Respuesta> asociarIntegrante(@Valid @RequestBody IntegranteGrupoCrearDTO nuevosDatos){

        Respuesta respuesta=integranteGrupoCrearCU.asociarIntegranteGrupo(integranteGrupoDtoMapper.asociarIntegranteGrupo(nuevosDatos));
        return ResponseEntity.ok().body(respuesta);
    }

    @PatchMapping("/actualizarIntegranteGrupo")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:GRUPOS')")
    public ResponseEntity<Respuesta> actualizar(@Valid @RequestBody IntegranteGrupoActualizarDTO nuevosDatos){

        Respuesta respuesta=integranteGrupoActualizarCU.actualizar(integranteGrupoDtoMapper.actualizar(nuevosDatos));
        return ResponseEntity.ok().body(respuesta);
    }

}
