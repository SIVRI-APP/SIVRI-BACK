package edu.unicauca.SivriBackendApp.core.usuario.dominio.model.proyecciones;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.TipoUsuario;

public interface ListarConFiltro {
    Long getId();
    String getCorreo();
    String getNombres();
    String getApellidos();
    TipoDocumento getTipoDocumento();
    String getNumeroDocumento();
    TipoUsuario getTipoUsuario();
}
