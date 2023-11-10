package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Proyections.ValidarExistenciaUsuarioSistema;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoDocumento;
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
    public Boolean existsByTipoDocumentoAndNumeroDocumento(TipoDocumento tipoDocumento, String numeroDocumento) {
        return usuarioRepository.existsByTipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocumento);
    }

    @Override
    public Boolean existsByCorreo(String correo) {
        return usuarioRepository.existsByCorreo(correo);
    }

    @Override
    public Boolean existsById(Long id) {
        return usuarioRepository.existsById(id);
    }

}
