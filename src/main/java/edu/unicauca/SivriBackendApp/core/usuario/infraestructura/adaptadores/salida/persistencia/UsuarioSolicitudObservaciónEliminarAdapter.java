package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida.UsuarioSolicitudObservaciónEliminarREPO;
import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.repositorio.UsuarioSolicitudObservacionesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Adaptador de salida que implementa el puerto de eliminación de observaciones para solicitudes de usuario.
 * Esta implementación utiliza un repositorio de UsuarioSolicitudObservaciones para acceder a la capa de persistencia.
 */
@Component
@AllArgsConstructor
public class UsuarioSolicitudObservaciónEliminarAdapter implements UsuarioSolicitudObservaciónEliminarREPO {

    /**
     * Repositorio de UsuarioSolicitudObservaciones que proporciona el acceso a la capa de persistencia.
     */
    private final UsuarioSolicitudObservacionesRepository usuarioSolicitudObservacionesRepository;

    /**
     * Elimina una observación de solicitud de usuario con el identificador proporcionado.
     *
     * @param solicitudUsuarioObservaciónId Identificador de la observación de solicitud de usuario.
     * @return true si la eliminación fue exitosa, false de lo contrario.
     */
    @Override
    public boolean eliminar(long solicitudUsuarioObservaciónId) {
        usuarioSolicitudObservacionesRepository.deleteById(solicitudUsuarioObservaciónId);

        return true;
    }
}
