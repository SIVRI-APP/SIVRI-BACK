package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.UsuarioSolicitudObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudInformaciónDetalladaProyección;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudListarConFiltroProyección;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.entity.UsuarioSolicitudEntity;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.mapper.UsuarioSolicitudInfraMapper;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.repository.UsuarioSolicitudRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@AllArgsConstructor
public class UsuarioSolicitudObtenerAdapter implements UsuarioSolicitudObtenerREPO {

    private final UsuarioSolicitudRepository usuarioSolicitudRepository;
    private final UsuarioSolicitudInfraMapper usuarioSolicitudInfraMapper;

    @Override
    public boolean existsByCorreoOrTipoDocumentoAndNumeroDocumento(String correo, TipoDocumento tipoDocumento, String numeroDocumento) {
        return usuarioSolicitudRepository.existsByCorreoOrTipoDocumentoAndNumeroDocumento(correo, tipoDocumento, numeroDocumento );
    }

    @Override
    public Page<UsuarioSolicitudListarConFiltroProyección> listarConFiltro(Pageable pageable, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombres, String apellidos, TipoUsuario tipoUsuario, EstadoSolicitudUsuario estado, Integer grupoId) {

        String tipoDoc = (tipoDocumento != null) ? tipoDocumento.toString() : null;
        String tipoUsu = (tipoUsuario != null) ? tipoUsuario.toString() : null;
        String estadoUsu = (estado != null) ? estado.toString() : null;

        return usuarioSolicitudRepository.listarConFiltro(correo, tipoDoc, numeroDocumento, nombres, apellidos, tipoUsu, estadoUsu, grupoId, pageable);

    }

    @Override
    public  Optional<UsuarioSolicitudInformaciónDetalladaProyección> obtenerSolicitudUsuarioInformaciónDetallada(long solicitudUsuarioId) {

        return usuarioSolicitudRepository.obtenerSolicitudUsuario(solicitudUsuarioId);
    }

    @Override
    public Optional<UsuarioSolicitud> obtenerSolicitudUsuario(long solicitudUsuarioId) {
        Optional<UsuarioSolicitudEntity> respuestaBd = usuarioSolicitudRepository.findById(solicitudUsuarioId);

        if (respuestaBd.isEmpty()){
            return Optional.empty();
        }

        return Optional.of(usuarioSolicitudInfraMapper.toModel(respuestaBd.get()));
    }

}
