package edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida;

/**
 * La interfaz UsuarioSolicitudObservaciónEliminarREPO define el puerto de salida para la eliminación
 * de observaciones de solicitudes de usuarios en el repositorio de persistencia.
 */
public interface UsuarioSolicitudObservaciónEliminarREPO {

    /**
     * Elimina una observación de solicitud de usuario por su identificador único.
     *
     * @param solicitudUsuarioObservaciónId Identificador único de la observación de solicitud de usuario.
     * @return True si la eliminación fue exitosa, de lo contrario, False.
     */
    boolean eliminar(long solicitudUsuarioObservaciónId);
}
