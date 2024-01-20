package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.PlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.DTO.petición.PlanTrabajoActualizarDTO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.DTO.petición.PlanTrabajoCrearDTO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.DTO.respuesta.PlanTrabajoObtenerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlanTrabajoDtoMapper {
    @Mapping(source = "semillero.id",target = "semilleroId")
    PlanTrabajoObtenerDTO obtenerPlanTrabajo(final PlanTrabajo planTrabajoModel);
  //  @Mapping(source = "semilleroId",target = "semillero.semilleroId")
    PlanTrabajo crear(final PlanTrabajoCrearDTO nuevoPlan);
    PlanTrabajo actualizar(final PlanTrabajoActualizarDTO nuevoPlan);
}
