package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Area;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Disciplina;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.AreaEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.DisciplinaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DisciplinaMapper {

    List<Disciplina> obtenerModelo(final List<DisciplinaEntity> areasEntity);
    Disciplina obtenerModeloUno(final DisciplinaEntity areasEntity);
    DisciplinaEntity obtenerEntityDisciplina(final Disciplina modelDisciplina);
    AreaEntity obtenerEntity(final Area area);
}
