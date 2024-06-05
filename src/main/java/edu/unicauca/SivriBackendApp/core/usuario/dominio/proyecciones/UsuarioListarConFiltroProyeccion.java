package edu.unicauca.SivriBackendApp.core.usuario.dominio.proyecciones;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;

public interface UsuarioListarConFiltroProyeccion {

    Long getId();
    String getCorreo();
    String getNombre();
    String getApellido();
    TipoDocumento getTipoDocumento();
    String getNumeroDocumento();
    TipoUsuario getTipoUsuario();

}