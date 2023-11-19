package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Area;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Disciplina;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.AreaEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.DisciplinaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DisciplinaMapper {

    List<Disciplina> obtenerModelo(final List<DisciplinaEntity> areasEntity);
    Disciplina obtenerModeloUno(final DisciplinaEntity areasEntity);
    DisciplinaEntity obtenerEntityDisciplina(final Disciplina modelDisciplina);
    AreaEntity obtenerEntity(final Area area);
}
