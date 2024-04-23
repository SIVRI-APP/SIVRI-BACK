package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioSolicitudObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorios.UsuarioSolicitudRepository;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.proyecciones.UsuarioSolicitudListarConFiltroProyección;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


/**
 * Adaptador de salida que implementa los puertos de obtención de solicitudes de usuario.
 * Esta implementación utiliza un repositorio de UsuarioSolicitud y un mapeador de infraestructura para acceder a la capa de persistencia.
 */
@Component
@AllArgsConstructor
public class UsuarioSolicitudObtenerAdapter implements UsuarioSolicitudObtenerREPO {

    /**
     * Repositorio de UsuarioSolicitud que proporciona el acceso a la capa de persistencia.
     */
    private final UsuarioSolicitudRepository usuarioSolicitudRepository;


    /**
     * Lista las solicitudes de usuario con filtros opcionales paginados.
     *
     * @param pageable      Objeto Pageable para la paginación.
     * @param correo        Correo de la solicitud de usuario.
     * @param tipoDocumento Tipo de documento de la solicitud de usuario.
     * @param numeroDocumento Número de documento de la solicitud de usuario.
     * @param nombre       Nombres de la solicitud de usuario.
     * @param apellidos    Apellidos de la solicitud de usuario.
     * @param tipoUsuario   Tipo de usuario de la solicitud.
     * @param estado        Estado de la solicitud de usuario.
     * @param organismoDeInvestigacionId       ID del grupo al que pertenece la solicitud de usuario.
     * @return Página de solicitudes de usuario que cumplen con los filtros especificados.
     */
    @Override
    public Page<UsuarioSolicitudListarConFiltroProyección> listarConFiltro(
            Pageable pageable, String correo, TipoDocumento tipoDocumento, String numeroDocumento, String nombre, String apellido,
            TipoUsuario tipoUsuario, EstadoSolicitudUsuario estado, Integer organismoDeInvestigacionId) {

        String tipoDoc = (tipoDocumento != null) ? tipoDocumento.toString() : null;
        String tipoUsu = (tipoUsuario != null) ? tipoUsuario.toString() : null;
        String estadoUsu = (estado != null) ? estado.toString() : null;

        return usuarioSolicitudRepository.listarConFiltro(correo, tipoDoc, numeroDocumento, nombre, apellido, tipoUsu, estadoUsu, organismoDeInvestigacionId, pageable);
    }

}

