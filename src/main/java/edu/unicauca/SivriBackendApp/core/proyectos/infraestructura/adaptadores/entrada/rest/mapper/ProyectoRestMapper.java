package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.entrada.rest.mapper;

import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.entrada.rest.dto.entrada.FormalizarProyectoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ProyectoRestMapper {

    @Mapping(target = "lineasDeInvestigacion", ignore = true)
    @Mapping(target = "integrantes", ignore = true)
    @Mapping(target = "enfoquesDiferenciales", ignore = true)
    @Mapping(target = "convocatoria", ignore = true)
    @Mapping(target = "eliminadoLogico", ignore = true)
    Proyecto formalizarProyectoDto(FormalizarProyectoDTO dto);

}
