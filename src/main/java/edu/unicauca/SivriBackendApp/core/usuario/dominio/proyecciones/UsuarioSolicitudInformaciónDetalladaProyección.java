package edu.unicauca.SivriBackendApp.core.usuario.dominio.proyecciones;


import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;

public interface UsuarioSolicitudInformaciónDetalladaProyección {
    Long getId();
    String getCorreo();
    TipoDocumento getTipoDocumento();
    String getNumeroDocumento();
    Sexo getSexo();
    TipoUsuario getTipoUsuario();
    String getNombre();
    String getApellido();
    String getTelefono();
    String getCvLac();
    EstadoSolicitudUsuario getEstado();
    String getNota();

}
