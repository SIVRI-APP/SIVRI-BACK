package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Funcionario;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.entity.FuncionarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface FuncionarioInfraMapper {

    @Named("toEntity")
    FuncionarioEntity toEntity(Funcionario funcionario);

    @Named("toModel")
    Funcionario toModel(FuncionarioEntity funcionario);
}
