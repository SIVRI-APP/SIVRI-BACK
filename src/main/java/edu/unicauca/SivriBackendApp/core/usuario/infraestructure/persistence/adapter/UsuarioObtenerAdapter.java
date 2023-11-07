package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Proyections.validarVinculacionUsuarioGrupo;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.out.UsuarioObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaRepository.UsuarioRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioObtenerAdapter implements UsuarioObtenerREPO {

    private UsuarioRepository usuarioRepository;

    public UsuarioObtenerAdapter(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<validarVinculacionUsuarioGrupo> validarVinculacionUsuarioGrupo(TipoDocumento tipoDocumento, String numeroDocumento) {
        Optional<validarVinculacionUsuarioGrupo> respuestaJpa = usuarioRepository.validarVinculacionUsuarioGrupo(numeroDocumento, String.valueOf(tipoDocumento));

        return respuestaJpa;
    }

    @Override
    public Boolean validarExistencia(TipoDocumento tipoDocumento, String numeroDocumento) {
        return usuarioRepository.existsByTipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocumento);
    }

    @Override
    public Boolean validarExistenciaCorreo(String correo) {
        return usuarioRepository.existsByCorreo(correo);
    }

}
