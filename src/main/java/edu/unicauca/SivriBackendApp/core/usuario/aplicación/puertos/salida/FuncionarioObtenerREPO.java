package edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida;

import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidad.FuncionarioEntity;

import java.util.Optional;

/**
 * La interfaz FuncionarioObtenerREPO define el puerto de salida para obtener entidades
 * relacionadas con funcionarios desde el repositorio de persistencia.
 */
public interface FuncionarioObtenerREPO {

    /**
     * Obtiene la entidad de funcionario asociada a un usuario por su identificador único.
     *
     * @param usuarioId Identificador único del usuario.
     * @return Optional que contiene la entidad Funcionario si existe, o un Optional vacío si no existe.
     */
    Optional<FuncionarioEntity> obtenerEntidadFuncionarioPorUsuarioId(long usuarioId);

}
