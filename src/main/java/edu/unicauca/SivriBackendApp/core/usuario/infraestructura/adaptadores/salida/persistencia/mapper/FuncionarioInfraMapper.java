package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.mapper;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Funcionario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.FuncionarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FuncionarioInfraMapper {

    FuncionarioEntity toEntity(Usuario usuario);

    Funcionario toModel(FuncionarioEntity usuario);
}
