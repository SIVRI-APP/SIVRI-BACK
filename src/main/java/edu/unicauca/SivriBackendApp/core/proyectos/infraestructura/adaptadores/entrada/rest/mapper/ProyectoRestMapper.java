package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.entrada.rest.mapper;

import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.entrada.rest.dto.entrada.CrearProyectoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ProyectoRestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "lineasDeInvestigacion", ignore = true)
    @Mapping(target = "integrantes", ignore = true)
    @Mapping(target = "enfoquesDiferenciales", ignore = true)
    @Mapping(target = "convocatoria", ignore = true)
    Proyecto crearConvocatoriaDTO(CrearProyectoDTO dto);

}
