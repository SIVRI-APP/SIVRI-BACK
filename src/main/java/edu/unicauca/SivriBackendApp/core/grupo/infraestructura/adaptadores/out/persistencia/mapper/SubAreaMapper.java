package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.SubArea;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.SubAreaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubAreaMapper {

    SubArea obtenerModelo(final SubAreaEntity subAreaEntity);

    SubAreaEntity obtenerEntity(final SubArea subArea);

}
