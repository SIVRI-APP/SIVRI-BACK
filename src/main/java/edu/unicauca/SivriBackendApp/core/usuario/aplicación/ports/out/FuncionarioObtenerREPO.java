package edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out;

import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.entity.FuncionarioEntity;

import java.util.Optional;

public interface FuncionarioObtenerREPO {

    Optional<FuncionarioEntity> obtenerEntidadFuncionarioPorUsuarioId(long usuarioId);

}
