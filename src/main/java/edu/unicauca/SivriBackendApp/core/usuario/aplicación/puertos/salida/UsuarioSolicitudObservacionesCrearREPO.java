package edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.salida;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitudObservaciones;

public interface UsuarioSolicitudObservacionesCrearREPO {


    /**
     * Crea una observacion para la solicitud de un Usuario
     *
     * @param observacion nueva Observación.
     * @return Bandera con el estado de la transaccion.
     */
    Boolean crearObservacionSolicitudUsuario(UsuarioSolicitudObservaciones observacion);

}
