package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.ActividadPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.entity.ActividadPlanTrabajoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActividadPlanTrabajoMapper {
    ActividadPlanTrabajo obtenerModelo(final ActividadPlanTrabajoEntity actividadPlanTrabajoEntity);
    //coloco un maper ientras se define bien el usuario
   //TODO COLOCAR EL MAPEO DEL RESPONSABLEID
    // @Mapping(source = "responsableUsuarioId",target = "responsableUsuario.numeroDocumento")
    ActividadPlanTrabajoEntity obtenerEntity(final ActividadPlanTrabajo actividadPlanTrabajo);

}
