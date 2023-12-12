package edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;

public interface UsuarioSolicitudObservacionesEliminarCU {

    Respuesta<Boolean> eliminar(long solicitudUsuarioObservaciónId);

}
