package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out.PlanTrabajoObtenerREPO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.EstadoPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.PlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.proyecciones.ListarPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.proyecciones.ObtenerActividadPlanTrabajoxanio;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.entity.PlanTrabajoEntity;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.mapper.PlanTrabajoMapper;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.repository.IPlanTrabajoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlanTrabajoObtenerAdapter implements PlanTrabajoObtenerREPO {
    private final IPlanTrabajoRepository planTrabajoRepository;
    private final PlanTrabajoMapper planTrabajoMapper;

    public PlanTrabajoObtenerAdapter(IPlanTrabajoRepository planTrabajoRepository, PlanTrabajoMapper planTrabajoMapper) {
        this.planTrabajoRepository = planTrabajoRepository;
        this.planTrabajoMapper = planTrabajoMapper;
    }

    @Override
    public Boolean existePorId(int id) {
        return planTrabajoRepository.existsById(id);
    }

    @Override
    public Integer existePorIdSemilleroyAnio(Integer idSemillero, Integer anio) {
        return planTrabajoRepository.existePorIdsemilleroyAnio(idSemillero,anio);
    }

    @Override
    public Optional<PlanTrabajo> obtenerPorId(int  id) {
        Optional<PlanTrabajoEntity> respuestaJpa=planTrabajoRepository.findById(id);
        return respuestaJpa.map(planTrabajoMapper::obtenerModelo);
    }

    @Override
    public List<PlanTrabajo> obtenerPlanesPorIdSemillero(int idSemillero) {
        return planTrabajoRepository.findBySemilleroId(idSemillero).stream().map(planTrabajoMapper::obtenerModelo).collect(Collectors.toList());
    }

    @Override
    public Page<List<ObtenerActividadPlanTrabajoxanio>> obtenerActividadPlanTrabajoxAnio(Pageable pageable, Integer anio, Integer idSemillero, LocalDate fechaInicio, LocalDate fechaFin) {
        return planTrabajoRepository.obtenerActividadPlanxAnio(anio,idSemillero, fechaInicio, fechaFin,pageable);
    }

    @Override
    public Page<List<ListarPlanTrabajo>> listarPlanTrabajoxfiltro(Pageable pageable, Integer anio, Integer idSemillero, EstadoPlanTrabajo estado) {
        String estad= (estado != null) ? estado.toString() : null;
        return planTrabajoRepository.listarPlanTrabajoxFiltro(anio,idSemillero,estad,pageable);
    }

    @Override
    public List<PlanTrabajo> obtenerListadoPlanes() {
        return planTrabajoRepository.findAll().stream().map(planTrabajoMapper::obtenerModelo).collect(Collectors.toList());
    }
}
