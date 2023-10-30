package edu.unicauca.SivriBackendApp.core.academica.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.academica.domain.model.Programa;
import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity.ProgramaEntity;
import edu.unicauca.SivriBackendApp.core.convocatoria.domain.model.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.mapper.TipoFinanciacionInfraMapper;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.jpaEntity.ConvocatoriaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProgramaMapper {
    Programa obtenerModelo(final ProgramaEntity entity);

    ProgramaEntity obtenerEntity(final Programa model);
}
