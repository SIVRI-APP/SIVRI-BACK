package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in.UsuarioSolicitudObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out.UsuarioSolicitudObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudInformaciónDetalladaProyección;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudListarConFiltroProyección;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class UsuarioSolicitudObtenerService implements UsuarioSolicitudObtenerCU {

    private final UsuarioSolicitudObtenerREPO usuarioSolicitudObtenerREPO;

    @Override
    public Respuesta<Page<UsuarioSolicitudListarConFiltroProyección>> listarConFiltro(int pageNo, int pageSize, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombres, String apellidos, TipoUsuario tipoUsuario, EstadoSolicitudUsuario estado, Integer grupoId) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<UsuarioSolicitudListarConFiltroProyección> respuestaBd = usuarioSolicitudObtenerREPO.listarConFiltro(pageable, correo, tipoDocumento, numeroDocumento, nombres, apellidos, tipoUsuario, estado, grupoId);
        return new RespuestaHandler<>(200, "ok", "",respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<UsuarioSolicitudInformaciónDetalladaProyección> obtenerSolicitudUsuarioInformaciónDetallada(long solicitudUsuarioId) {
        UsuarioSolicitudInformaciónDetalladaProyección respuestaBd = usuarioSolicitudObtenerREPO.obtenerSolicitudUsuarioInformaciónDetallada(solicitudUsuarioId).orElseThrow(
                () -> new ReglaDeNegocioException("bad.solicitud.no.existe", List.of(Long.toString(solicitudUsuarioId))));

        return new RespuestaHandler<>(200, "ok", "",respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<UsuarioSolicitud> obtenerSolicitudUsuario(long solicitudUsuarioId) {
        UsuarioSolicitud respuestaBd = usuarioSolicitudObtenerREPO.obtenerSolicitudUsuario(solicitudUsuarioId).orElseThrow(
                () -> new ReglaDeNegocioException("bad.solicitud.no.existe", List.of(Long.toString(solicitudUsuarioId))));

        return new RespuestaHandler<>(200, "ok", "",respuestaBd).getRespuesta();
    }
}
