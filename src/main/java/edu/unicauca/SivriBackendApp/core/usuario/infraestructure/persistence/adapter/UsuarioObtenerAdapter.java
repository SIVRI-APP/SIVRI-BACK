package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Proyections.validarVinculacionUsuarioGrupo;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.out.UsuarioObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaRepository.UsuarioRepository;
import org.springframework.stereotype.Component;

import java.util.List;
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

}
