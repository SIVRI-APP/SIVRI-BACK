package edu.unicauca.SivriBackendApp.core.grupo.application.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.application.dto.response.ObtenerRolesGrupoDTO;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.RolGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.SubArea;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.SubAreaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubAreaDtoMapper {
    List<SubArea>  dtoObtenerSubAreas(final List<SubAreaEntity> subAreasEntity);
}
