package edu.unicauca.SivriBackendApp.core.usuario.domain.model.Proyections;


import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoUsuario;

public interface InformacionDetalladaUsuario {
    Long getId();
    String getCorreo();
    TipoDocumento getTipoDocumento();
    String getNumeroDocumento();
    Sexo getSexo();
    TipoUsuario getTipoUsuario();
    String getNombres();
    String getApellidos();
    String getTelefono();
    String getCvLac();

}
