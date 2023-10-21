package edu.unicauca.SivriBackendApp.core.planTrabajo.application.rest;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.application.mapper.ActividadPlanTrabajoDtoMapper;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.ActividadPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.port.in.ActividadPlanTrabajoObtenerCU;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("actividadesPlanTrabajo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ActividadPlanTrabajoController {
    private final ActividadPlanTrabajoObtenerCU actividadPlanTrabajoObtenerCU;
    private final ActividadPlanTrabajoDtoMapper actividadPlanTrabajoDtoMapper;

    public ActividadPlanTrabajoController(ActividadPlanTrabajoObtenerCU actividadPlanTrabajoObtenerCU, ActividadPlanTrabajoDtoMapper actividadPlanTrabajoDtoMapper) {
        this.actividadPlanTrabajoObtenerCU = actividadPlanTrabajoObtenerCU;
        this.actividadPlanTrabajoDtoMapper = actividadPlanTrabajoDtoMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtenerActividadPlanTrabajoPorId(@PathVariable(value = "id") int id){
        Respuesta respuesta = actividadPlanTrabajoObtenerCU.obtenerPorId(id);
        respuesta.setData(actividadPlanTrabajoDtoMapper.obtenerActividadPlanTrabajo((ActividadPlanTrabajo) respuesta.getData()));
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("/actividadesPorIdPlan/{id}")
    public ResponseEntity<Respuesta> obtenerActividadesPlanTrabajoPorIdPlan(@PathVariable(value = "id") int idPlan){
        Respuesta respuesta = actividadPlanTrabajoObtenerCU.obtenerActividadesPorIdPlanTrabajo(idPlan);
        respuesta.setData(((List<ActividadPlanTrabajo>) respuesta.getData()).stream().map(actividadPlanTrabajoDtoMapper::obtenerActividadPlanTrabajo).toList());
        return ResponseEntity.ok().body(respuesta);
    }

    @GetMapping("")
    public ResponseEntity<Respuesta> obtenerActividadesPlanTrabajo(){
        Respuesta respuesta = actividadPlanTrabajoObtenerCU.obtenerListadoActividadesPlan();
        respuesta.setData(((List<ActividadPlanTrabajo>) respuesta.getData()).stream().map(actividadPlanTrabajoDtoMapper::obtenerActividadPlanTrabajo).toList());
        return ResponseEntity.ok().body(respuesta);
    }

}
