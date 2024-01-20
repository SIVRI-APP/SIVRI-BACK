package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Disciplina;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.SubArea;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.respuesta.ObtenerDisciplinaDTO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.respuesta.ObtenerSubAreasDTO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.SubAreaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubAreaDtoMapper {
    List<SubArea>  dtoObtenerSubAreas(final List<SubAreaEntity> subAreasEntity);

    ObtenerSubAreasDTO dtoObtenerSubArea(final SubArea subArea);

    List<ObtenerDisciplinaDTO> dtoObtenerDisciplinas(final List<Disciplina> disciplinas);

    ObtenerDisciplinaDTO dtoObtenerDisciplina(final Disciplina disciplina);
   }
