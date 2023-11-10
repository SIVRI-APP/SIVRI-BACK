package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Proyections.ValidarExistenciaUsuarioSistema;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.out.UsuarioObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.mapper.UsuarioInfraMapper;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaRepository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@AllArgsConstructor
public class UsuarioObtenerAdapter implements UsuarioObtenerREPO {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioInfraMapper usuarioInfraMapper;

    @Override
    public Optional<ValidarExistenciaUsuarioSistema> validarExistenciaUsuarioSistema(String tipoDocumento, String numeroDocumento) {
        return usuarioRepository.validarExistenciaUsuarioSistema(tipoDocumento, numeroDocumento);
    }

    @Override
    public Boolean existsByCorreoAndTipoDocumentoAndNumeroDocumento(String correo, String tipoDocumento, String numeroDocumento) {
        return usuarioRepository.existsByCorreoAndTipoDocumentoAndNumeroDocumento(correo, tipoDocumento, numeroDocumento);
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioInfraMapper.toModel(usuarioRepository.save(usuarioInfraMapper.toEntity(usuario)));
    }
}
