package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Proyections.validarVinculacionUsuarioGrupo;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Usuario;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.out.UsuarioObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.mapper.UsuarioInfraMapper;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.UsuarioEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaRepository.UsuarioRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioObtenerAdapter implements UsuarioObtenerREPO {

    private UsuarioRepository usuarioRepository;
    private UsuarioInfraMapper usuarioInfraMapper;

    public UsuarioObtenerAdapter(UsuarioRepository usuarioRepository, UsuarioInfraMapper usuarioInfraMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioInfraMapper = usuarioInfraMapper;
    }

    @Override
    public Optional<validarVinculacionUsuarioGrupo> validarVinculacionUsuarioGrupo(TipoDocumento tipoDocumento, String numeroDocumento) {
        Optional<validarVinculacionUsuarioGrupo> respuestaJpa = usuarioRepository.validarVinculacionUsuarioGrupo(numeroDocumento, String.valueOf(tipoDocumento));

        return respuestaJpa;
    }

}
