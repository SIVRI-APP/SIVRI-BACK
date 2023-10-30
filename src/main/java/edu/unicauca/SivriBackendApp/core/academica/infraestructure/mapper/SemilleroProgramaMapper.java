package edu.unicauca.SivriBackendApp.core.academica.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.academica.domain.model.Programa;
import edu.unicauca.SivriBackendApp.core.academica.domain.model.SemilleroPrograma;
import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity.ProgramaEntity;
import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity.SemilleroProgramaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SemilleroProgramaMapper {
    SemilleroPrograma obtenerModelo(final SemilleroProgramaEntity entity);
    SemilleroProgramaEntity obtenerEntity(final SemilleroPrograma model);

}
