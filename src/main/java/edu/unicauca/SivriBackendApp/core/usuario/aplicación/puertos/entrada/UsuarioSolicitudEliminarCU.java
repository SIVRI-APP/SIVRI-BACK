package edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;

/**
 * La interfaz UsuarioSolicitudEliminarCU define el puerto de entrada para realizar la eliminación programada
 * de solicitudes de usuario.
 */
public interface UsuarioSolicitudEliminarCU {

    /**
     * Realiza la eliminación programada de solicitudes de usuario.
     *
     * @return Respuesta que indica si la eliminación programada de solicitudes de usuario fue exitosa o no.
     */
    Respuesta<Boolean> eliminadoProgramado();
}
