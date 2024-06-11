package edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.salida;

/**
 * La interfaz UsuarioSolicitudEliminarREPO define el puerto de salida para la eliminación
 * de solicitudes de usuarios en el repositorio de persistencia.
 */
public interface UsuarioSolicitudEliminarREPO {

    /**
     * Crea una nueva solicitud de usuario en el repositorio de persistencia.
     *
     * @param usuarioSolicitudId Id de la solicitud de usuario a eliminar.
     */
    void eliminarSolicitudUsuario(Long usuarioSolicitudId);

}
