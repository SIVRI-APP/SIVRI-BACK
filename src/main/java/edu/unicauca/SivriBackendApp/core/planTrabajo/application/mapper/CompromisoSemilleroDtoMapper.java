package edu.unicauca.SivriBackendApp.core.planTrabajo.application.mapper;

import edu.unicauca.SivriBackendApp.core.planTrabajo.application.dto.response.CompromisoSemilleroObtenerDTO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.application.dto.response.PlanTrabajoObtenerDTO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.CompromisoSemillero;
import edu.unicauca.SivriBackendApp.core.planTrabajo.domain.model.PlanTrabajo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompromisoSemilleroDtoMapper {
    CompromisoSemilleroObtenerDTO obtenerCompromisos(final CompromisoSemillero compromisoSemilleroModel);

}
