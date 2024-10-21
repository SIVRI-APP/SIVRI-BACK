package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.PlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.entity.PlanTrabajoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlanTrabajoMapper {
    @Mapping(source = "nombrePlan",target = "nombrePlan")
    PlanTrabajo obtenerModelo(final PlanTrabajoEntity planTrabajoEntity);
    @Mapping(source = "anio",target = "anio")
    PlanTrabajoEntity obtenerEntity(final PlanTrabajo planTrabajo);

}
