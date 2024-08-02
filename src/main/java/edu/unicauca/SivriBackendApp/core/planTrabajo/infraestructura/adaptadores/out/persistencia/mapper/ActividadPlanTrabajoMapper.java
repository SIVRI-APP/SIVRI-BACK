package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.ActividadPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.entity.ActividadPlanTrabajoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ActividadPlanTrabajoMapper {
    @Mapping(source = "responsableUsuario.id",target = "responsableUsuarioId")
    ActividadPlanTrabajo obtenerModelo(final ActividadPlanTrabajoEntity actividadPlanTrabajoEntity);
    //coloco un maper ientras se define bien el usuario

     @Mapping(source = "responsableUsuarioId",target = "responsableUsuario.id")
    ActividadPlanTrabajoEntity obtenerEntity(final ActividadPlanTrabajo actividadPlanTrabajo);

}
