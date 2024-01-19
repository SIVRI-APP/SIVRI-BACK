package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioSolicitudObservacionesObtenerREPO;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudObservaciónListarProyección;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorio.UsuarioSolicitudObservacionesRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


/**
 * Adaptador de salida que implementa el puerto de obtención de observaciones para solicitudes de usuario.
 * Esta implementación utiliza un repositorio de UsuarioSolicitudObservaciones para acceder a la capa de persistencia.
 */
@Component
@AllArgsConstructor
public class UsuarioSolicitudObservacionesObtenerAdapter implements UsuarioSolicitudObservacionesObtenerREPO {

    /**
     * Repositorio de UsuarioSolicitudObservaciones que proporciona el acceso a la capa de persistencia.
     */
    private final UsuarioSolicitudObservacionesRepository usuarioSolicitudObservacionesRepository;

    /**
     * Obtiene una página de observaciones para una solicitud de usuario.
     *
     * @param pageable          Configuración de paginación.
     * @param solicitudUsuarioId Identificador de la solicitud de usuario.
     * @return Página de observaciones como una instancia de Page<UsuarioSolicitudObservaciónListarProyección>.
     */
    @Override
    public Page<UsuarioSolicitudObservaciónListarProyección> listar(Pageable pageable, long solicitudUsuarioId) {
        return usuarioSolicitudObservacionesRepository.listar(solicitudUsuarioId, pageable);
    }

    /**
     * Obtiene la cantidad de observaciones pendientes para una solicitud de usuario.
     *
     * @param solicitudUsuarioId Identificador de la solicitud de usuario.
     * @return Cantidad de observaciones pendientes como un entero.
     */
    @Override
    public Integer solicitudConObservacionesPendientes(long solicitudUsuarioId) {
        return usuarioSolicitudObservacionesRepository.solicitudConObservacionesPendientes(solicitudUsuarioId);
    }

    /**
     * Verifica si existe una observación de solicitud de usuario con el identificador proporcionado.
     *
     * @param solicitudUsuarioId Identificador de la observación de solicitud de usuario.
     * @return true si la observación existe, false de lo contrario.
     */
    @Override
    public Boolean existePorId(long solicitudUsuarioId) {
        return usuarioSolicitudObservacionesRepository.existsById(solicitudUsuarioId);
    }
}
