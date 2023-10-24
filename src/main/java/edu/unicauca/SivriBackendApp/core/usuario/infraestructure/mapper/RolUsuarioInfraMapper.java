package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.mapper;

import edu.unicauca.SivriBackendApp.core.usuario.domain.model.RolPosgrado;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.RolAcademicoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RolUsuarioInfraMapper {

    @Mapping(target = "programa", ignore = true)
    @Mapping(target = "rolDeUsuarios", ignore = true)
    RolPosgrado validarExistenciaUsuarioPosgrado(final RolAcademicoEntity entidad);
}
