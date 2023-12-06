package edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.UsuarioSolicitud;

public interface UsuarioSolicitudCrearCU {
    Respuesta<Boolean> crearSolicitudUsuario(UsuarioSolicitud usuario);
}
