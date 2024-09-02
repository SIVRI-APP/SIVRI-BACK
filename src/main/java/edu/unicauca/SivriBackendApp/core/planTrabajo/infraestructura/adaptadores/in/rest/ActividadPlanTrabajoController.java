package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in.ActividadPlanTrabajoActualizarCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in.ActividadPlanTrabajoCrearCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in.ActividadPlanTrabajoEliminarCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.in.ActividadPlanTrabajoObtenerCU;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.ActividadPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.proyecciones.ListarActividadesConFiltro;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.DTO.petición.ActividadPlanTrabajoActualizarDTO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.DTO.petición.ActividadPlanTrabajoCrearDTO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.mapper.ActividadPlanTrabajoDtoMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("actividadesPlanTrabajo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ActividadPlanTrabajoController {
    private final ActividadPlanTrabajoObtenerCU actividadPlanTrabajoObtenerCU;
    private final ActividadPlanTrabajoCrearCU actividadPlanTrabajoCrearCU;
    private final ActividadPlanTrabajoActualizarCU actividadPlanTrabajoActualizarCU;
    private final ActividadPlanTrabajoEliminarCU actividadPlanTrabajoEliminarCU;
    private final ActividadPlanTrabajoDtoMapper actividadPlanTrabajoDtoMapper;



    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:SEMILLEROS', " +
            "'SEMILLERO:MENTOR')")
    public ResponseEntity<Respuesta> obtenerActividadPlanTrabajoPorId(@PathVariable(value = "id") int id){
        Respuesta respuesta = actividadPlanTrabajoObtenerCU.obtenerPorId(id);
        respuesta.setData(actividadPlanTrabajoDtoMapper.obtenerActividadPlanTrabajo((ActividadPlanTrabajo) respuesta.getData()));
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("/actividadesPorIdPlan/{id}")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:SEMILLEROS', " +
            "'FUNCIONARIO:GRUPOS', " +
            "'SEMILLERO:MENTOR' )")
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

    @PostMapping("/crearActividadPlanTrabajo/{id}")
    @PreAuthorize("hasAnyAuthority(" +
            "'SEMILLERO:MENTOR' )"
    )
    public ResponseEntity<Respuesta> crear(@PathVariable(value = "id") int idPlan,@Valid @RequestBody ActividadPlanTrabajoCrearDTO nuevaActividad){
        Respuesta respuesta = actividadPlanTrabajoCrearCU.crear(idPlan,actividadPlanTrabajoDtoMapper.crear(nuevaActividad));
        return ResponseEntity.ok().body(respuesta);
    }
    @PatchMapping("/actualizarActividad/{id}")
    @PreAuthorize("hasAnyAuthority(" +
            "'FUNCIONARIO:SEMILLEROS', " +
            "'SEMILLERO:MENTOR')")
    public ResponseEntity<Respuesta> actualizar(@PathVariable(value = "id") int idActividad, @Valid @RequestBody ActividadPlanTrabajoActualizarDTO nuevaActividadDto){
        Respuesta respuesta =actividadPlanTrabajoActualizarCU.actualizar(idActividad,actividadPlanTrabajoDtoMapper.actualizar(nuevaActividadDto));
        return ResponseEntity.ok().body(respuesta);
    }
    @DeleteMapping("/eliminarActividad/{id}")
    @PreAuthorize("hasAnyAuthority(" +
            "'SEMILLERO:MENTOR' )"
    )
    public ResponseEntity<Respuesta> eliminarActividad(@PathVariable(value = "id") int idActividad){
        Respuesta respuesta =actividadPlanTrabajoEliminarCU.eliminadoFisico(idActividad);
        return ResponseEntity.ok().body(respuesta);
    }
    @GetMapping("/listarActividadesConFiltro/{idPlan}")
    @PreAuthorize("hasAnyAuthority(" +
            "'SEMILLERO:MENTOR','FUNCIONARIO:SEMILLEROS' )"
    )
    public ResponseEntity<Respuesta<Page<List<ListarActividadesConFiltro>>>> listarActividadesxidPlanSemilleroConFIltro(
            @PathVariable(value = "idPlan") Integer idPlan,
            @RequestParam(required = false) LocalDate fechaInicio,
            @RequestParam(required = false) LocalDate fechaFin,
            @RequestParam(required = false) int pageNo,
            @RequestParam(required = false) int pageSize
    ){
        Respuesta respuesta = actividadPlanTrabajoObtenerCU.ListarActividadesConFiltro(pageNo,pageSize,idPlan,fechaInicio,fechaFin);
        return ResponseEntity.ok().body(respuesta);
    }
}
