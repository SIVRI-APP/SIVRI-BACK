package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.out.UsuarioCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.mapper.UsuarioInfraMapper;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.UsuarioEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.UsuarioEntityID;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaRepository.UsuarioRepository;
import org.springframework.stereotype.Component;

@Component
public class UsuarioCrearAdapter implements UsuarioCrearREPO {

    private UsuarioRepository usuarioRepository;
    private UsuarioInfraMapper usuarioInfraMapper;

    public UsuarioCrearAdapter(UsuarioRepository usuarioRepository, UsuarioInfraMapper usuarioInfraMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioInfraMapper = usuarioInfraMapper;
    }

    @Override
    public Boolean solicitudCreacionDeUsuario(Usuario nuevoUsuario) {
        UsuarioEntity nuevoUsuarioEntity = usuarioInfraMapper.solicitudCreacionDeUsuario(nuevoUsuario);
        nuevoUsuarioEntity.setId(new UsuarioEntityID(nuevoUsuario.getTipoDocumento(), nuevoUsuario.getNumeroDocumento()));

        UsuarioEntity usuarioCreado = usuarioRepository.save(nuevoUsuarioEntity);

        return usuarioRepository.existsById(usuarioCreado.getId());
    }
}
