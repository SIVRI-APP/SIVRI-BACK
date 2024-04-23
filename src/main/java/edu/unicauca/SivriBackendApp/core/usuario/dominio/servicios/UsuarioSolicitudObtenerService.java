package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.UsuarioSolicitudObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioSolicitudObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.proyecciones.UsuarioSolicitudListarConFiltroProyección;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



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
     * @param organismoDeInvestigacionId           Identificador del grupo.
     * @return Respuesta que contiene la lista paginada de solicitudes de usuario filtradas.
     */
    @Override
    public Respuesta<Page<UsuarioSolicitudListarConFiltroProyección>> listarConFiltro(int pageNo, int pageSize, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombre, String apellido, TipoUsuario tipoUsuario, EstadoSolicitudUsuario estado, Integer organismoDeInvestigacionId) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<UsuarioSolicitudListarConFiltroProyección> respuestaBd = usuarioSolicitudObtenerREPO.listarConFiltro(pageable, correo, tipoDocumento, numeroDocumento, nombre, apellido, tipoUsuario, estado, organismoDeInvestigacionId);
        return new RespuestaHandler<>(200, "ok", "", respuestaBd).getRespuesta();
    }

}

