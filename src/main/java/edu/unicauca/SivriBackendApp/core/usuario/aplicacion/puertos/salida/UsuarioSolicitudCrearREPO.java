package edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.salida;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.EstadoSolicitudUsuario;

/**
 * La interfaz UsuarioSolicitudCrearREPO define el puerto de salida para la creación y actualización
 * de solicitudes de usuarios en el repositorio de persistencia.
 */
public interface UsuarioSolicitudCrearREPO {

    /**
     * Crea una nueva solicitud de usuario en el repositorio de persistencia.
     *
     * @param usuario Objeto UsuarioSolicitud que contiene la información de la nueva solicitud.
     * @return {@link UsuarioSolicitud}
     */
    UsuarioSolicitud crearSolicitudUsuario(UsuarioSolicitud usuario);

    /**
     * Cambia el estado de una solicitud
     * @param solicitudId Id de la solicitud
     * @param estado nuevo estado de la solicitud
     */
    void cambiarEstado(Long solicitudId, EstadoSolicitudUsuario estado);

}
