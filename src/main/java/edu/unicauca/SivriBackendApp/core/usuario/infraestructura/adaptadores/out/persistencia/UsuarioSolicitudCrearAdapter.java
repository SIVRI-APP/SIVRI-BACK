package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.UsuarioSolicitudCrearREPO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.mapper.UsuarioSolicitudInfraMapper;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.repository.UsuarioSolicitudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UsuarioSolicitudCrearAdapter implements UsuarioSolicitudCrearREPO {

    private final UsuarioSolicitudRepository usuarioSolicitudRepository;
    private final UsuarioSolicitudInfraMapper usuarioSolicitudInfraMapper;

    @Override
    public UsuarioSolicitud crearUsuarioSolicitud(UsuarioSolicitud usuario) {
        return usuarioSolicitudInfraMapper.toModel(usuarioSolicitudRepository.save(usuarioSolicitudInfraMapper.toEntity(usuario)));
    }

    @Override
    public UsuarioSolicitud actualizarUsuarioSolicitud(UsuarioSolicitud usuario) {
        return usuarioSolicitudInfraMapper.toModel(usuarioSolicitudRepository.save(usuarioSolicitudInfraMapper.toEntity(usuario)));
    }
}
