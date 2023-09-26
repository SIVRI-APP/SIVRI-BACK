package edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.LineaDeInvestigacionProyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaEntity.LineaDeInvestigacionProyectoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface LineaDeInvestigacionProyectoInfraMapper {

    @Named("LineaDeInvestigacionProyectoFullInfoProyecto")
    LineaDeInvestigacionProyecto fullInfoProyecto(final LineaDeInvestigacionProyectoEntity entity);

    LineaDeInvestigacionProyectoEntity obtenerEntity(final LineaDeInvestigacionProyecto model);

}
