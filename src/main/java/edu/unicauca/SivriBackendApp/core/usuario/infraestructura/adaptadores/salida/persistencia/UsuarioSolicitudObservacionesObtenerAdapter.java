package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioSolicitudObservacionesObtenerREPO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorios.UsuarioSolicitudObservacionesRepository;
import lombok.AllArgsConstructor;
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
     * Obtiene la cantidad de observaciones pendientes para una solicitud de usuario.
     *
     * @param solicitudUsuarioId Identificador de la solicitud de usuario.
     * @return Cantidad de observaciones pendientes como un entero.
     */
    @Override
    public Integer solicitudConObservacionesPendientes(long solicitudUsuarioId) {
        return usuarioSolicitudObservacionesRepository.solicitudConObservacionesPendientes(solicitudUsuarioId);
    }

}
