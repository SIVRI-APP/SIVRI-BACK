package edu.unicauca.SivriBackendApp.core.proyecto.application.mapper;

import edu.unicauca.SivriBackendApp.core.proyecto.application.dto.response.LineaDeInvestigacionProyectoDTO;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.LineaDeInvestigacionProyecto;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface LineaDeInvestigacionProyectoDtoMapper {

    @Named("LineaDeInvestigacionProyectoDtoFullInfoProyecto")
    LineaDeInvestigacionProyectoDTO fullInfoProyecto(final LineaDeInvestigacionProyecto modelo);

    LineaDeInvestigacionProyecto toModel (final LineaDeInvestigacionProyectoDTO dto);


}
