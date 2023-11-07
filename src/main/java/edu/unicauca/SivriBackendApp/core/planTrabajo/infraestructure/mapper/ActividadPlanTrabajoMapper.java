package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.ActividadPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaEntity.ActividadPlanTrabajoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.web.bind.annotation.GetMapping;

@Mapper(componentModel = "spring")
public interface ActividadPlanTrabajoMapper {
    ActividadPlanTrabajo obtenerModelo(final ActividadPlanTrabajoEntity actividadPlanTrabajoEntity);
    //coloco un maper ientras se define bien el usuario
    @Mapping(source = "responsableUsuarioId",target = "responsableUsuario.numeroDocumento")
    ActividadPlanTrabajoEntity obtenerEntity(final ActividadPlanTrabajo actividadPlanTrabajo);

}
