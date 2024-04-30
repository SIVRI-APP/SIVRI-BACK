package edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida;

/**
 * La interfaz UsuarioSolicitudEliminarREPO define el puerto de salida para la eliminación
 * y obtención de información sobre solicitudes de usuarios en el repositorio de persistencia.
 */
public interface UsuarioSolicitudEliminarREPO {

    /**
     * Elimina una solicitud de usuario por su identificador único.
     *
     * @param solicitudUsuarioId Identificador único de la solicitud de usuario.
     * @return True si la eliminación fue exitosa, de lo contrario, False.
     */
    boolean eliminar(long solicitudUsuarioId);
}
