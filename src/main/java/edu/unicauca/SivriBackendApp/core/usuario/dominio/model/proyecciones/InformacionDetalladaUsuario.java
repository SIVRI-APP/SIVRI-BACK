package edu.unicauca.SivriBackendApp.core.usuario.dominio.model.proyecciones;


import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.TipoUsuario;

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
