package edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;

public interface UsuarioSolicitudListarConFiltroProyección {
    Long getId();
    String getCorreo();
    String getNombres();
    String getApellidos();
    TipoDocumento getTipoDocumento();
    String getNumeroDocumento();
    TipoUsuario getTipoUsuario();
    EstadoSolicitudUsuario getEstado();
}
