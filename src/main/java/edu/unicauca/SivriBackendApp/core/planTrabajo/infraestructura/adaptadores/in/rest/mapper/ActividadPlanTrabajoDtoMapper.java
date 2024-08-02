package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.ActividadPlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.DTO.petición.ActividadPlanTrabajoActualizarDTO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.DTO.petición.ActividadPlanTrabajoCrearDTO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.DTO.respuesta.ActividadPlanTrabajoObtenerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ActividadPlanTrabajoDtoMapper {
    @Mapping(source = "idCompromiso",target = "compromiso.id")
    ActividadPlanTrabajo crear(final ActividadPlanTrabajoCrearDTO nuevoPlan);
    @Mapping(source = "idCompromiso",target = "compromiso.id")
    ActividadPlanTrabajo actualizar(final ActividadPlanTrabajoActualizarDTO datosActividadModel);
    @Mappings(
            {@Mapping(source = "planTrabajo.id",target = "planTrabajoId"),
            @Mapping(source = "responsableUsuarioId",target = "responsableUsuarioId")}
    )

    ActividadPlanTrabajoObtenerDTO obtenerActividadPlanTrabajo(final ActividadPlanTrabajo obtenerModelo);

}
