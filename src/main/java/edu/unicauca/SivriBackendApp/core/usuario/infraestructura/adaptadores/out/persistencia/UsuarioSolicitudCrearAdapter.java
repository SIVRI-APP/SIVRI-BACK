package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.UsuariosSolicitudCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.mapper.UsuarioSolicitudInfraMapper;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.repository.UsuarioSolicitudRepository;
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
