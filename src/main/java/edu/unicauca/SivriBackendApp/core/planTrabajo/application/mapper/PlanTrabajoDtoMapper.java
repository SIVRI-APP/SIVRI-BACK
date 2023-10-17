package edu.unicauca.SivriBackendApp.core.planTrabajo.application.mapper;

import edu.unicauca.SivriBackendApp.core.planTrabajo.application.dto.request.PlanTrabajoCrearDTO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.PlanTrabajo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlanTrabajoDtoMapper {
    @Mapping(source = "semilleroId",target = "semillero.semilleroId")
    PlanTrabajo crear(final PlanTrabajoCrearDTO nuevoPlan);
}
