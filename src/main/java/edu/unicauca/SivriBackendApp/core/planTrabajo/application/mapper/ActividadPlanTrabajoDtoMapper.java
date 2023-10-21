package edu.unicauca.SivriBackendApp.core.planTrabajo.application.mapper;

import edu.unicauca.SivriBackendApp.core.planTrabajo.application.dto.response.ActividadPlanTrabajoObtenerDTO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.ActividadPlanTrabajo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ActividadPlanTrabajoDtoMapper {
    @Mapping(source = "planTrabajo.id",target = "planTrabajoId")
    ActividadPlanTrabajoObtenerDTO obtenerActividadPlanTrabajo(final ActividadPlanTrabajo obtenerModelo);

}
