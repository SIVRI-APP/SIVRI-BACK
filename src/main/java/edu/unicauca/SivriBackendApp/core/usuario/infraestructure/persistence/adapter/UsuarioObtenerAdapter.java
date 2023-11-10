package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Proyections.ListarConFiltro;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Proyections.InformacionDetalladaUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.out.UsuarioObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.mapper.UsuarioInfraMapper;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaRepository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
@AllArgsConstructor
public class UsuarioObtenerAdapter implements UsuarioObtenerREPO {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioInfraMapper usuarioInfraMapper;

    @Override
    public Optional<InformacionDetalladaUsuario> validarExistenciaUsuarioSistema(String tipoDocumento, String numeroDocumento) {
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

    @Override
    public Page<List<ListarConFiltro>> listarConFiltro(Pageable pageable, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombres, String apellidos, TipoUsuario tipoUsuario) {

        String tipoDoc = (tipoDocumento != null) ? tipoDocumento.toString() : null;
        String tipoUsu = (tipoUsuario != null) ? tipoUsuario.toString() : null;


        return usuarioRepository.listarConFiltro(correo, tipoDoc, numeroDocumento, nombres, apellidos, tipoUsu, pageable);
    }

}
