package edu.unicauca.SivriBackendApp.core.usuario.domain.model.Proyections;

import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoUsuario;

public interface ListarConFiltro {
    Long getId();
    String getCorreo();
    String getNombres();
    String getApellidos();
    TipoDocumento getTipoDocumento();
    String getNumeroDocumento();
    TipoUsuario getTipoUsuario();
}
