package edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;

public interface UsuarioListarConFiltroProyección {
    Long getId();
    String getCorreo();
    TipoDocumento getTipoDocumento();
    String getNumeroDocumento();
    String getNombres();
    String getApellidos();
    TipoUsuario getTipoUsuario();

}
