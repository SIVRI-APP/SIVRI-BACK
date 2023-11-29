package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.ActividadPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructure.persistence.jpaEntity.ActividadPlanTrabajoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActividadPlanTrabajoMapper {
    ActividadPlanTrabajo obtenerModelo(final ActividadPlanTrabajoEntity actividadPlanTrabajoEntity);
    //coloco un maper ientras se define bien el usuario
   //TODO COLOCAR EL MAPEO DEL RESPONSABLEID
    // @Mapping(source = "responsableUsuarioId",target = "responsableUsuario.numeroDocumento")
    ActividadPlanTrabajoEntity obtenerEntity(final ActividadPlanTrabajo actividadPlanTrabajo);

}