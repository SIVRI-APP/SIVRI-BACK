package edu.unicauca.SivriBackendApp.core.planTrabajo.application.rest;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.application.dto.request.PlanTrabajoCrearDTO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.application.mapper.PlanTrabajoDtoMapper;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.in.PlanTrabajoCrearCU;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("planTrabajo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PlanTrabajoController {

    private final PlanTrabajoCrearCU planTrabajoCrearCU;
    private final PlanTrabajoDtoMapper planTrabajoDtoMapper;

    public PlanTrabajoController(PlanTrabajoCrearCU planTrabajoCrearCU, PlanTrabajoDtoMapper planTrabajoDtoMapper) {
        this.planTrabajoCrearCU = planTrabajoCrearCU;
        this.planTrabajoDtoMapper = planTrabajoDtoMapper;
    }

    @PostMapping("")
    public ResponseEntity<Respuesta> crear(@Valid @RequestBody PlanTrabajoCrearDTO nuevoPlan){
        System.out.println("DATOS QUE LLEGAN "+nuevoPlan);
        Respuesta respuesta = planTrabajoCrearCU.crear(planTrabajoDtoMapper.crear(nuevoPlan));
        System.out.println("respuesta "+respuesta);
        return ResponseEntity.ok().body(respuesta);

    }
}
