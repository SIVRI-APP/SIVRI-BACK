package edu.unicauca.SivriBackendApp.core.grupo.application.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.application.dto.response.ObtenerDisciplinaDTO;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Disciplina;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.DisciplinaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
@Mapper(componentModel = "spring")
public interface DisciplinaDtoMapper {
  //  ObtenerSubAreasDTO dtoObtenerSubArea(final SubArea subArea);
    //List<Disciplina> dtoObtenerDisciplinas(final List<DisciplinaEntity> disciplinasEntity);

    ObtenerDisciplinaDTO dtoObtenerDisciplina(final Disciplina disciplina);
}
