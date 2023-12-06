package edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoUsuario;

public interface ListarUsuarioSolicitudConFiltroProyección {
    Long getId();
    String getCorreo();
    String getNombres();
    String getApellidos();
    TipoDocumento getTipoDocumento();
    String getNumeroDocumento();
    TipoUsuario getTipoUsuario();
    EstadoSolicitudUsuario getEstado();
}
