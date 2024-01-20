package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.GrupoDisciplina;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.GrupoDisciplinaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GrupoDisciplinaMapper {
    GrupoDisciplina obtenerModelo(final GrupoDisciplinaEntity entity);
    GrupoDisciplinaEntity obtenerEntity(final GrupoDisciplina model);
}
