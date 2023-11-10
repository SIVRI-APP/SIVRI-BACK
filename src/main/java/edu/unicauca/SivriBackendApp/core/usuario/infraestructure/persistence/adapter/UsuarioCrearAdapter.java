package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.out.UsuarioCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.mapper.UsuarioInfraMapper;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaRepository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UsuarioCrearAdapter implements UsuarioCrearREPO {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioInfraMapper usuarioInfraMapper;

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioInfraMapper.toModel(usuarioRepository.save(usuarioInfraMapper.toEntity(usuario)));
    }
}
