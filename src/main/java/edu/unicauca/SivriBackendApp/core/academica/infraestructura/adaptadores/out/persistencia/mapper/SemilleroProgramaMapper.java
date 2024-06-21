package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.academica.dominio.modelos.SemilleroPrograma;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.entity.SemilleroProgramaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SemilleroProgramaMapper {
    SemilleroPrograma obtenerModelo(final SemilleroProgramaEntity entity);
    SemilleroProgramaEntity obtenerEntity(final SemilleroPrograma model);

}
