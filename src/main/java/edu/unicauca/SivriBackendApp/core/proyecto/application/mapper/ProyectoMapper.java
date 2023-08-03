package edu.unicauca.SivriBackendApp.core.proyecto.application.mapper;

import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.request.ActualizarProyectoRequest;
import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.request.CrearProyectoRequest;
import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.response.ObtenerProyectoResponse;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProyectoMapper {

    Proyecto crearProyectoRequestToDomain(final CrearProyectoRequest crearProyectoRequest);

    Proyecto actualizarProyectoRequestToDomain(final ActualizarProyectoRequest actualizarProyectoRequest);

    ObtenerProyectoResponse domainToObtenerProyectoResponse(final Proyecto proyecto);
}
