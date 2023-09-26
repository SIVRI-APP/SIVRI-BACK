package edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.mapper.ConvocatoriaInfraMapper;
import edu.unicauca.SivriBackendApp.core.proyecto.domain.model.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaEntity.ProyectoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {LineaDeInvestigacionProyectoInfraMapper.class, IntegrantesProyectoInfraMapper.class, EnfoqueDiferencialProyectoInfraMapper.class, ConvocatoriaInfraMapper.class})
public interface ProyectoInfraMapper {

    @Mapping(source = "lineasDeInvestigacion", target = "lineasDeInvestigacion", qualifiedByName = "LineaDeInvestigacionProyectoFullInfoProyecto")
    @Mapping(source = "integrantes", target = "integrantes", qualifiedByName = "IntegrantesProyectoFullInfoProyecto")
    @Mapping(source = "enfoquesDiferenciales", target = "enfoquesDiferenciales", qualifiedByName = "EnfoqueDiferencialProyectoFullInfoProyecto")
    @Mapping(source = "convocatoria", target = "convocatoria", qualifiedByName = "obtnerModeloParaProyecto")
    Proyecto fullInfoProyecto(final ProyectoEntity entity);

    ProyectoEntity obtenerEntity(final Proyecto model);

}
