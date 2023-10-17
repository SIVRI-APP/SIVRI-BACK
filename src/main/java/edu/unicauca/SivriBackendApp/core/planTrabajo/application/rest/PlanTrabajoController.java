package edu.unicauca.SivriBackendApp.core.planTrabajo.application.rest;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.application.dto.request.PlanTrabajoCrearDTO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.application.mapper.PlanTrabajoDtoMapper;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.PlanTrabajo;
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
    private final PlanTrabajoDtoMapper planTrabajoDtoMapper;

    public PlanTrabajoController(PlanTrabajoObtenerCU planTrabajoObtenerCU, PlanTrabajoCrearCU planTrabajoCrearCU, PlanTrabajoDtoMapper planTrabajoDtoMapper) {
        this.planTrabajoObtenerCU = planTrabajoObtenerCU;
        this.planTrabajoCrearCU = planTrabajoCrearCU;
        this.planTrabajoDtoMapper = planTrabajoDtoMapper;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerPlanTrabajoPorId(@PathVariable(value = "id") int id){
        Respuesta respuesta = planTrabajoObtenerCU.obtenerPorId(id);
        respuesta.setData(planTrabajoDtoMapper.obtenerPlanTrabajo((PlanTrabajo) respuesta.getData()));
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("")
    public ResponseEntity<Respuesta> obtenerPlanesTrabajo(){
        Respuesta respuesta = planTrabajoObtenerCU.obtenerListadoPlanes();
        respuesta.setData(((List<PlanTrabajo>) respuesta.getData()).stream().map(planTrabajoDtoMapper::obtenerPlanTrabajo).toList());
        return ResponseEntity.ok().body(respuesta);
    }
    @PostMapping("")
    public ResponseEntity<Respuesta> crear(@Valid @RequestBody PlanTrabajoCrearDTO nuevoPlan){
        System.out.println("DATOS QUE LLEGAN "+nuevoPlan);
        Respuesta respuesta = planTrabajoCrearCU.crear(planTrabajoDtoMapper.crear(nuevoPlan));
        System.out.println("respuesta "+respuesta);
        return ResponseEntity.ok().body(respuesta);

    }
}
