package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.usuario.domain.model.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.out.UsuariosSolicitudCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.mapper.UsuarioSolicitudInfraMapper;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaRepository.UsuarioSolicitudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UsuarioSolicitudCrearAdapter implements UsuariosSolicitudCrearREPO {

    private final UsuarioSolicitudRepository usuarioSolicitudRepository;
    private final UsuarioSolicitudInfraMapper usuarioSolicitudInfraMapper;

    @Override
    public UsuarioSolicitud save(UsuarioSolicitud usuario) {
        return usuarioSolicitudInfraMapper.toModel(usuarioSolicitudRepository.save(usuarioSolicitudInfraMapper.toEntity(usuario)));
    }
}
