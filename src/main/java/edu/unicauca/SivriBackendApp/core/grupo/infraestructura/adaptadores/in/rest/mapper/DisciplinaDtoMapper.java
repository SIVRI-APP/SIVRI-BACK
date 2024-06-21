package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Disciplina;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.respuesta.ObtenerDisciplinaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DisciplinaDtoMapper {
  //  ObtenerSubAreasDTO dtoObtenerSubArea(final SubArea subArea);
    //List<Disciplina> dtoObtenerDisciplinas(final List<DisciplinaEntity> disciplinasEntity);

    ObtenerDisciplinaDTO dtoObtenerDisciplina(final Disciplina disciplina);
}
