package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in.PlanTrabajoActualizarCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in.PlanTrabajoCrearCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in.PlanTrabajoObtenerCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.PlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.DTO.petición.PlanTrabajoActualizarDTO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.DTO.petición.PlanTrabajoCrearDTO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.mapper.PlanTrabajoDtoMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("planesTrabajo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PlanTrabajoController {
    private final PlanTrabajoObtenerCU planTrabajoObtenerCU;
    private final PlanTrabajoCrearCU planTrabajoCrearCU;
    private final PlanTrabajoActualizarCU planTrabajoActualizarCU;
    private final PlanTrabajoDtoMapper planTrabajoDtoMapper;
// TODO AHI QUE AGUEGAR UN CAMPO A LA TABLA PLAN DE TRABAJO ANIO
    public PlanTrabajoController(PlanTrabajoObtenerCU planTrabajoObtenerCU, PlanTrabajoCrearCU planTrabajoCrearCU, PlanTrabajoActualizarCU planTrabajoActualizarCU, PlanTrabajoDtoMapper planTrabajoDtoMapper) {
        this.planTrabajoObtenerCU = planTrabajoObtenerCU;
        this.planTrabajoCrearCU = planTrabajoCrearCU;
        this.planTrabajoActualizarCU = planTrabajoActualizarCU;
        this.planTrabajoDtoMapper = planTrabajoDtoMapper;
    }
    @GetMapping("/obtenerPlanxId")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:SEMILLEROS' )"
    )
    public ResponseEntity<Respuesta> obtenerPlanTrabajoPorId(
            @RequestParam(required = true) Integer id
            ){
        Respuesta respuesta = planTrabajoObtenerCU.obtenerPorId(id);
        respuesta.setData(planTrabajoDtoMapper.obtenerPlanTrabajo((PlanTrabajo) respuesta.getData()));
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("/planesPorSemilleroId/{id}")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:SEMILLEROS' )"
    )
    public ResponseEntity<Respuesta> obtenerPlanTrabajoPorIdSemillero(@PathVariable(value = "id") int idSemillero){
        Respuesta respuesta = planTrabajoObtenerCU.obtenerPlanesPorIdSemillero(idSemillero);
        respuesta.setData(((List<PlanTrabajo>) respuesta.getData()).stream().map(planTrabajoDtoMapper::obtenerPlanTrabajo).toList());
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("/obtenerPlanTrabajoxAnioySemilleroId")
    @PreAuthorize("hasAnyAuthority(" +
            "'SEMILLERO:MENTOR' )"
    )
    public ResponseEntity<Respuesta> obtenerPlanTrabajoPorIdSemilleroyAnio(
            @RequestParam(value = "id") int idSemillero,
            @RequestParam(value = "anio") int anio){
        Respuesta respuesta = planTrabajoObtenerCU.existePorIdSemilleroyAnio(idSemillero,anio);
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("/obtenerPlanTrabajoxAnio")
    @PreAuthorize("hasAnyAuthority(" +
            "'SEMILLERO:MENTOR' )"
    )
    public ResponseEntity<Respuesta> obtenerPlanTrabajoxAnio(
            @RequestParam(required = true) Integer anio,
            @RequestParam(required = true) Integer idSemillero,
            @RequestParam(required = false) LocalDate fechaInicio,
            @RequestParam(required = false) LocalDate fechaFin,
            @RequestParam(required = false) int pageNo,
            @RequestParam(required = false) int pageSize
    ){
        Respuesta respuesta= planTrabajoObtenerCU.obtenerPlanTrabajoxAnio(pageNo, pageSize, anio,idSemillero, fechaInicio, fechaFin);
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("")
    public ResponseEntity<Respuesta> obtenerPlanesTrabajo(){
        Respuesta respuesta = planTrabajoObtenerCU.obtenerListadoPlanes();
        respuesta.setData(((List<PlanTrabajo>) respuesta.getData()).stream().map(planTrabajoDtoMapper::obtenerPlanTrabajo).toList());
        return ResponseEntity.ok().body(respuesta);
    }
    @PostMapping("/crearPlanTrabajo")
    @PreAuthorize("hasAnyAuthority(" +
            "'SEMILLERO:MENTOR' )"
    )
    public ResponseEntity<Respuesta> crear(@Valid @RequestBody PlanTrabajoCrearDTO nuevoPlan){
        System.out.println("DATOS QUE LLEGAN al controller "+nuevoPlan.getIdSemillero()+" dto "+nuevoPlan);
        Respuesta respuesta = planTrabajoCrearCU.crear(planTrabajoDtoMapper.crear(nuevoPlan));
        System.out.println("respuesta "+respuesta);
        return ResponseEntity.ok().body(respuesta);

    }
    @PatchMapping("/actualizarPlan/{id}")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:SEMILLEROS' )"
    )
    public ResponseEntity<Respuesta> actualizar(@PathVariable(value = "id") int idPlan, @Valid @RequestBody PlanTrabajoActualizarDTO nuevoPlanDto){
        Respuesta respuesta = planTrabajoActualizarCU.actualizar(idPlan,planTrabajoDtoMapper.actualizar(nuevoPlanDto));
        return ResponseEntity.ok().body(respuesta);
    }

}
