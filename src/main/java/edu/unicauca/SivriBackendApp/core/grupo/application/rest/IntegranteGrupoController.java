package edu.unicauca.SivriBackendApp.core.grupo.application.rest;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.application.dto.request.IntegranteGrupoActualizarDTO;
import edu.unicauca.SivriBackendApp.core.grupo.application.dto.request.IntegranteGrupoCrearDTO;
import edu.unicauca.SivriBackendApp.core.grupo.application.mapper.IntegranteGrupoDtoMapper;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.IntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.GrupoObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.IntegranteGrupoActualizarCU;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.IntegranteGrupoCrearCU;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.IntegranteGrupoObtenerCU;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("integrantes")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class IntegranteGrupoController {

    private final IntegranteGrupoObtenerCU integranteGrupoObtenerCU;
    private final IntegranteGrupoDtoMapper integranteGrupoDtoMapper;
    private final IntegranteGrupoCrearCU integranteGrupoCrearCU;
    private final IntegranteGrupoActualizarCU integranteGrupoActualizarCU;

    public IntegranteGrupoController(IntegranteGrupoObtenerCU integranteGrupoObtenerCU, IntegranteGrupoDtoMapper integranteGrupoDtoMapper, IntegranteGrupoCrearCU integranteGrupoCrearCU, IntegranteGrupoActualizarCU integranteGrupoActualizarCU, GrupoObtenerCU grupoObtenerCU) {
        this.integranteGrupoObtenerCU = integranteGrupoObtenerCU;
        this.integranteGrupoDtoMapper = integranteGrupoDtoMapper;
        this.integranteGrupoCrearCU = integranteGrupoCrearCU;
        this.integranteGrupoActualizarCU = integranteGrupoActualizarCU;

    }
    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerInfoPorId(@PathVariable(value = "id") int id){
        Respuesta respuesta= integranteGrupoObtenerCU.obtenerIntegrantePorId(id);

        respuesta.setData(integranteGrupoDtoMapper.obtenerIntegranteGrupo((IntegranteGrupo) respuesta.getData()));
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("")
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
    @PostMapping("/asociarGrupo")
    public ResponseEntity<Respuesta> asociarIntegrante(@Valid @RequestBody IntegranteGrupoCrearDTO nuevosDatos){

        Respuesta respuesta=integranteGrupoCrearCU.asociarIntegranteGrupo(integranteGrupoDtoMapper.asociarIntegranteGrupo(nuevosDatos));
        return ResponseEntity.ok().body(respuesta);
    }

    @PatchMapping("")
    public ResponseEntity<Respuesta> actualizar(@Valid @RequestBody IntegranteGrupoActualizarDTO nuevosDatos){

        //System.out.println("DATOS DE INTEGRANTE quE LLEGAN EN EL CONTROLER POARA ACTUALIZAR "+nuevosDatos);
        Respuesta respuesta=integranteGrupoActualizarCU.actualizar(integranteGrupoDtoMapper.actualizar(nuevosDatos));
        //System.out.println("DATOS DESPUES DEL MAPEO EN CONTROLLER "+respuesta);
        return ResponseEntity.ok().body(respuesta);
    }

}
