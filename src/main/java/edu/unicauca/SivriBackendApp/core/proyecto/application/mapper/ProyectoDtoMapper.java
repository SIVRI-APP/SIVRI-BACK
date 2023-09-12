package edu.unicauca.SivriBackendApp.core.proyecto.application.mapper;

import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.request.ActualizarProyectoInfoGeneralDTO;
import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.request.CrearProyectoDTO;
import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.response.ObtenerProyectoDetalladoDTO;
import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.response.ObtenerProyectosDataTableDTO;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProyectoDtoMapper {

    ObtenerProyectosDataTableDTO obtenerProyectosDataTable(final Proyecto proyecto);

    @Mapping(source = "convocatoria.id", target = "convocatoriaId")
    ObtenerProyectoDetalladoDTO obtenerProyectoDetallado(final Proyecto proyecto);

    Proyecto crearProyectoMapper(final CrearProyectoDTO crearProyectoDTO);

    Proyecto actualizarProyectoInfoGeneral(final ActualizarProyectoInfoGeneralDTO proyecto);

}
