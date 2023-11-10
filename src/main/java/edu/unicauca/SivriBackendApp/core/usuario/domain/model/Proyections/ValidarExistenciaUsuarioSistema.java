package edu.unicauca.SivriBackendApp.core.usuario.domain.model.Proyections;


import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoUsuario;

public interface ValidarExistenciaUsuarioSistema {
    Long getId();
    String getNombres();
    String getApellidos();
    TipoDocumento getTipoDocumento();
    String getNumeroDocumento();
    String getCorreo();
    String getTelefono();
    TipoUsuario getTipoUsuario();
}
