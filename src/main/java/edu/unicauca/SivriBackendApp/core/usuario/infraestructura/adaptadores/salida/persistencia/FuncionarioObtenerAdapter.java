package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.FuncionarioObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidad.FuncionarioEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorio.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


/**
 * Adaptador de salida que implementa el puerto de obtener funcioario por identificador de usuario.
 * Esta implementación utiliza un repositorio de Funcionario para realizar la operación.
 */
@Component
@AllArgsConstructor
public class FuncionarioObtenerAdapter implements FuncionarioObtenerREPO {

    /**
     * Repositorio de Funcionario que proporciona el acceso a la capa de persistencia.
     */
    private final FuncionarioRepository funcionarioRepository;

    /**
     * Obtiene la entidad de Funcionario asociada al identificador de usuario proporcionado.
     *
     * @param usuarioId Identificador del usuario para el cual se desea obtener el Funcionario.
     * @return Un objeto Optional que puede contener la entidad Funcionario o estar vacío si no se encuentra.
     */
    @Override
    public Optional<FuncionarioEntity> obtenerEntidadFuncionarioPorUsuarioId(long usuarioId) {
        return funcionarioRepository.findByUsuarioId(usuarioId);
    }
}
