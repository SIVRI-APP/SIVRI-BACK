package edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida;

/**
 * La interfaz UsuarioSolicitudObservacionesObtenerREPO define el puerto de salida para obtener
 * información relacionada con observaciones de solicitudes de usuario desde el repositorio de persistencia.
 */
public interface UsuarioSolicitudObservacionesObtenerREPO {


    /**
     * Obtiene la cantidad de observaciones pendientes para una solicitud de usuario.
     *
     * @param solicitudUsuarioId Identificador único de la solicitud de usuario.
     * @return Cantidad de observaciones pendientes.
     */
    Integer solicitudConObservacionesPendientes(long solicitudUsuarioId);

}
