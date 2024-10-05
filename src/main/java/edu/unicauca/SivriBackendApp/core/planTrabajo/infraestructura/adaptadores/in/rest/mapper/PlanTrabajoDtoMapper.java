package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.PlanTrabajo;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.DTO.petición.PlanTrabajoActualizarDTO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.DTO.petición.PlanTrabajoCrearDTO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.in.rest.DTO.respuesta.PlanTrabajoObtenerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PlanTrabajoDtoMapper {

    @Mapping(source = "semillero.id",target = "semilleroId")
    PlanTrabajoObtenerDTO obtenerPlanTrabajo(final PlanTrabajo planTrabajoModel);
  //  @Mapping(source = "semilleroId",target = "semillero.semilleroId")

    @Mappings({@Mapping(source = "anio",target = "anio"),
               @Mapping(source = "id_Semillero", target = "semillero.semillero_Id"),
            @Mapping(source = "estado",target = "estado"),
            @Mapping(source = "nombre_Plan", target = "nombre_Plan")
    })
    PlanTrabajo crear(final PlanTrabajoCrearDTO nuevoPlan);
    @Mapping(source = "anio",target = "anio")
    PlanTrabajo actualizar(final PlanTrabajoActualizarDTO nuevoPlan);
}
