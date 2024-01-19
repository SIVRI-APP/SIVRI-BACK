package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioSolicitudObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioSolicitudObtenerREPO;
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


/**
 * El servicio UsuarioSolicitudObtenerService implementa la lógica de negocio para la obtención
 * y filtrado de solicitudes de usuario.
 */
@Service
@AllArgsConstructor
public class UsuarioSolicitudObtenerService implements UsuarioSolicitudObtenerCU {

    private final UsuarioSolicitudObtenerREPO usuarioSolicitudObtenerREPO;

    /**
     * Lista las solicitudes de usuario filtradas y paginadas.
     *
     * @param pageNo            Número de la página.
     * @param pageSize          Tamaño de la página.
     * @param correo            Correo del usuario.
     * @param tipoDocumento     Tipo de documento del usuario.
     * @param numeroDocumento   Número de documento del usuario.
     * @param nombres           Nombres del usuario.
     * @param apellidos         Apellidos del usuario.
     * @param tipoUsuario       Tipo de usuario.
     * @param estado            Estado de la solicitud de usuario.
     * @param grupoId           Identificador del grupo.
     * @return Respuesta que contiene la lista paginada de solicitudes de usuario filtradas.
     */
    @Override
    public Respuesta<Page<UsuarioSolicitudListarConFiltroProyección>> listarConFiltro(int pageNo, int pageSize, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombres, String apellidos, TipoUsuario tipoUsuario, EstadoSolicitudUsuario estado, Integer grupoId) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<UsuarioSolicitudListarConFiltroProyección> respuestaBd = usuarioSolicitudObtenerREPO.listarConFiltro(pageable, correo, tipoDocumento, numeroDocumento, nombres, apellidos, tipoUsuario, estado, grupoId);
        return new RespuestaHandler<>(200, "ok", "", respuestaBd).getRespuesta();
    }

    /**
     * Obtiene la información detallada de una solicitud de usuario.
     *
     * @param solicitudUsuarioId Identificador de la solicitud de usuario.
     * @return Respuesta que contiene la información detallada de la solicitud de usuario.
     * @throws ReglaDeNegocioException Si la solicitud de usuario no existe.
     */
    @Override
    public Respuesta<UsuarioSolicitudInformaciónDetalladaProyección> obtenerSolicitudUsuarioInformaciónDetallada(long solicitudUsuarioId) {
        UsuarioSolicitudInformaciónDetalladaProyección respuestaBd = usuarioSolicitudObtenerREPO.obtenerSolicitudUsuarioInformaciónDetallada(solicitudUsuarioId).orElseThrow(
                () -> new ReglaDeNegocioException("bad.solicitud.no.existe", List.of(Long.toString(solicitudUsuarioId))));

        return new RespuestaHandler<>(200, "ok", "", respuestaBd).getRespuesta();
    }

    /**
     * Obtiene una solicitud de usuario por su identificador.
     *
     * @param solicitudUsuarioId Identificador de la solicitud de usuario.
     * @return Respuesta que contiene la solicitud de usuario.
     * @throws ReglaDeNegocioException Si la solicitud de usuario no existe.
     */
    @Override
    public Respuesta<UsuarioSolicitud> obtenerSolicitudUsuario(long solicitudUsuarioId) {
        UsuarioSolicitud respuestaBd = usuarioSolicitudObtenerREPO.obtenerSolicitudUsuario(solicitudUsuarioId).orElseThrow(
                () -> new ReglaDeNegocioException("bad.solicitud.no.existe", List.of(Long.toString(solicitudUsuarioId))));

        return new RespuestaHandler<>(200, "ok", "", respuestaBd).getRespuesta();
    }
}

