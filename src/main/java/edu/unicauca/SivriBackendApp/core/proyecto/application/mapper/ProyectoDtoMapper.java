package edu.unicauca.SivriBackendApp.core.proyecto.application.mapper;

import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.request.ProyectoActualizarDTO;
import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.request.ProyectoCrearDTO;
import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.response.ProyectoDTO;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {LineaDeInvestigacionProyectoDtoMapper.class, IntegrantesProyectoDtoMapper.class, EnfoqueDiferencialProyectoDtoMapper.class})
public interface ProyectoDtoMapper {

    @Mapping(source = "lineasDeInvestigacion", target = "lineasDeInvestigacion", qualifiedByName = "LineaDeInvestigacionProyectoDtoFullInfoProyecto")
    @Mapping(source = "integrantes", target = "integrantes", qualifiedByName = "IntegrantesProyectoDtoFullInfoProyecto")
    @Mapping(source = "enfoquesDiferenciales", target = "enfoquesDiferenciales", qualifiedByName = "EnfoqueDiferencialProyectoDtoFullInfoProyecto")
    ProyectoDTO fullInfoProyecto(final Proyecto modelo);

    Proyecto crear(final ProyectoCrearDTO modelo);

    Proyecto actualizar(final ProyectoActualizarDTO modelo);

}
