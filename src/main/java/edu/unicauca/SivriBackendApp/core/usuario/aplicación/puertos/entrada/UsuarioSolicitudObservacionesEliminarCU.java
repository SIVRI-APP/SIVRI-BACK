package edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;

/**
 * La interfaz UsuarioSolicitudObservacionesEliminarCU define el puerto de entrada para la eliminación
 * de observaciones asociadas a solicitudes de usuario.
 */
public interface UsuarioSolicitudObservacionesEliminarCU {

    /**
     * Elimina una observación asociada a una solicitud de usuario.
     *
     * @param solicitudUsuarioObservaciónId Identificador único de la observación asociada a la solicitud de usuario.
     * @return Respuesta que indica si la eliminación de la observación fue exitosa o no.
     */
    Respuesta<Boolean> eliminar(long solicitudUsuarioObservaciónId);
}
