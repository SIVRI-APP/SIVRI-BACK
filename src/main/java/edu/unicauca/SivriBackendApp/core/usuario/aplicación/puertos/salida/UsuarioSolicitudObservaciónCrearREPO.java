package edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitudObservaciones;

/**
 * La interfaz UsuarioSolicitudObservaciónCrearREPO define el puerto de salida para la creación
 * de observaciones de solicitudes de usuarios en el repositorio de persistencia.
 */
public interface UsuarioSolicitudObservaciónCrearREPO {

    /**
     * Crea una nueva observación de solicitud de usuario en el repositorio de persistencia.
     *
     * @param observación Objeto UsuarioSolicitudObservaciones que contiene la información de la nueva observación.
     * @return Objeto UsuarioSolicitudObservaciones que representa la observación de solicitud de usuario creada.
     */
    UsuarioSolicitudObservaciones crearUsuarioSolicitud(UsuarioSolicitudObservaciones observación);
}
