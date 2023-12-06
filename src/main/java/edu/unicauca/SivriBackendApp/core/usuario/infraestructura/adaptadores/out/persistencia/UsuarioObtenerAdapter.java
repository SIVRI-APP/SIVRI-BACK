package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.ListarUsuarioSolicitudConFiltroProyección;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.UsuarioObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@AllArgsConstructor
public class UsuarioObtenerAdapter implements UsuarioObtenerREPO {

    private final UsuarioRepository usuarioRepository;
//    private final UsuarioInfraMapper usuarioInfraMapper;

//    @Override
//    public Optional<InformacionPublicaUsuario> obtenerUsuario(String tipoDocumento, String numeroDocumento) {
//        return usuarioRepository.validarExistenciaUsuarioSistema(tipoDocumento, numeroDocumento);
//    }
//
//    @Override
//    public Boolean existePorTipoDocumentoNumeroDocumento(TipoDocumento tipoDocumento, String numeroDocumento) {
//        return usuarioRepository.existsByTipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocumento);
//    }
//
//    @Override
//    public Boolean existePorCorreo(String correo) {
//        return usuarioRepository.existsByCorreo(correo);
//    }
//
//    @Override
//    public Boolean existePorId(Long id) {
//        return usuarioRepository.existsById(id);
//    }

    @Override
    public boolean existsByCorreoOrTipoDocumentoAndNumeroDocumento(String correo, TipoDocumento tipoDocumento, String numeroDocumento) {
        return usuarioRepository.existsByCorreoOrTipoDocumentoAndNumeroDocumento(correo, tipoDocumento, numeroDocumento);
    }

    @Override
    public Page<List<ListarUsuarioSolicitudConFiltroProyección>> listarConFiltro(Pageable pageable, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombres, String apellidos, TipoUsuario tipoUsuario) {

        String tipoDoc = (tipoDocumento != null) ? tipoDocumento.toString() : null;
        String tipoUsu = (tipoUsuario != null) ? tipoUsuario.toString() : null;


        return usuarioRepository.listarConFiltro(correo, tipoDoc, numeroDocumento, nombres, apellidos, tipoUsu, pageable);
    }

}
