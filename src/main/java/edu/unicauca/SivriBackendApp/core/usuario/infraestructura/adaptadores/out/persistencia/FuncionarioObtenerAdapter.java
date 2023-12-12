package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.FuncionarioObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.entity.FuncionarioEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@AllArgsConstructor
public class FuncionarioObtenerAdapter implements FuncionarioObtenerREPO {

    private final FuncionarioRepository funcionarioRepository;

    @Override
    public Optional<FuncionarioEntity> obtenerEntidadFuncionarioPorUsuarioId(long usuarioId) {
        return funcionarioRepository.findByUsuarioId(usuarioId);
    }
}
