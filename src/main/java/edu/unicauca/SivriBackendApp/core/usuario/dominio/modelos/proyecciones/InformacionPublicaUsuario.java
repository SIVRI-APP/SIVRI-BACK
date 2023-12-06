package edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.proyecciones;


import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoUsuario;

public interface InformacionPublicaUsuario {
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
