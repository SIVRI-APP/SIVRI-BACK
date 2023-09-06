package edu.unicauca.SivriBackendApp.core.proyecto.application.mapper;

import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.request.CrearProyectoDTO;
import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.response.ObtenerProyectoDetalladoDTO;
import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.response.ObtenerProyectosDataTableDTO;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProyectoDtoMapper {
    ObtenerProyectosDataTableDTO obtenerProyectosDataTable(final Proyecto proyecto);
    Proyecto crearProyectoMapper(final CrearProyectoDTO crearProyectoDTO);
    ObtenerProyectoDetalladoDTO obtenerProyectoDetallado(final Proyecto proyecto);
}
