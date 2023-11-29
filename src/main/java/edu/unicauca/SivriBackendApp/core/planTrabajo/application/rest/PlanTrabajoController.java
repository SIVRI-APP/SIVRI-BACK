package edu.unicauca.SivriBackendApp.core.planTrabajo.application.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.application.dto.request.PlanTrabajoActualizarDTO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.application.dto.request.PlanTrabajoCrearDTO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.application.mapper.PlanTrabajoDtoMapper;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.PlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.in.PlanTrabajoActualizarCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.in.PlanTrabajoCrearCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.in.PlanTrabajoObtenerCU;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("planesTrabajo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PlanTrabajoController {
    private final PlanTrabajoObtenerCU planTrabajoObtenerCU;
    private final PlanTrabajoCrearCU planTrabajoCrearCU;
    private final PlanTrabajoActualizarCU planTrabajoActualizarCU;
    private final PlanTrabajoDtoMapper planTrabajoDtoMapper;

    public PlanTrabajoController(PlanTrabajoObtenerCU planTrabajoObtenerCU, PlanTrabajoCrearCU planTrabajoCrearCU, PlanTrabajoActualizarCU planTrabajoActualizarCU, PlanTrabajoDtoMapper planTrabajoDtoMapper) {
        this.planTrabajoObtenerCU = planTrabajoObtenerCU;
        this.planTrabajoCrearCU = planTrabajoCrearCU;
        this.planTrabajoActualizarCU = planTrabajoActualizarCU;
        this.planTrabajoDtoMapper = planTrabajoDtoMapper;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerPlanTrabajoPorId(@PathVariable(value = "id") int id){
        Respuesta respuesta = planTrabajoObtenerCU.obtenerPorId(id);
        respuesta.setData(planTrabajoDtoMapper.obtenerPlanTrabajo((PlanTrabajo) respuesta.getData()));
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("/planesPorSemilleroId/{id}")
    public ResponseEntity<Respuesta> obtenerPlanTrabajoPorIdSemillero(@PathVariable(value = "id") int idSemillero){
        Respuesta respuesta = planTrabajoObtenerCU.obtenerPlanesPorIdSemillero(idSemillero);
        respuesta.setData(((List<PlanTrabajo>) respuesta.getData()).stream().map(planTrabajoDtoMapper::obtenerPlanTrabajo).toList());
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("")
    public ResponseEntity<Respuesta> obtenerPlanesTrabajo(){
        Respuesta respuesta = planTrabajoObtenerCU.obtenerListadoPlanes();
        respuesta.setData(((List<PlanTrabajo>) respuesta.getData()).stream().map(planTrabajoDtoMapper::obtenerPlanTrabajo).toList());
        return ResponseEntity.ok().body(respuesta);
    }
    @PostMapping("/crearPlanTrabajo/{id}")
    public ResponseEntity<Respuesta> crear(@PathVariable(value = "id") int idSemillero,@Valid @RequestBody PlanTrabajoCrearDTO nuevoPlan){
        System.out.println("DATOS QUE LLEGAN al controller "+idSemillero+" dto "+nuevoPlan);
        Respuesta respuesta = planTrabajoCrearCU.crear(idSemillero,planTrabajoDtoMapper.crear(nuevoPlan));
        System.out.println("respuesta "+respuesta);
        return ResponseEntity.ok().body(respuesta);

    }
    @PatchMapping("/actualizarPlan/{id}")
    public ResponseEntity<Respuesta> actualizar(@PathVariable(value = "id") int idPlan, @Valid @RequestBody PlanTrabajoActualizarDTO nuevoPlanDto){
        Respuesta respuesta = planTrabajoActualizarCU.actualizar(idPlan,planTrabajoDtoMapper.actualizar(nuevoPlanDto));
        return ResponseEntity.ok().body(respuesta);
    }

}
