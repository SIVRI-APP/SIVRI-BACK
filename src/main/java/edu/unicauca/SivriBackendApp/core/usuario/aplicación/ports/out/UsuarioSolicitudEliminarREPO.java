package edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.out;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones.UsuarioSolicitudEliminadoProgramadoProyección;

import java.util.List;

public interface UsuarioSolicitudEliminarREPO {
    boolean eliminar(long solicitudUsuarioId);

    List<UsuarioSolicitudEliminadoProgramadoProyección> eliminadoProgramado();
}
