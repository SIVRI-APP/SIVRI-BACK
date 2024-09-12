package edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.dominio.modelos.proyecciones;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;

import java.util.List;

public interface ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion {
    Integer getId();
    String getNombre();
    List<IntegrantesProyeccion> getIntegrantes();

    interface IntegrantesProyeccion {
        Integer getId();
        UsuarioProyeccion getUsuario();

        interface UsuarioProyeccion {
            Long getId();
            String getNombre();
            String getApellido();
            TipoUsuario getTipoUsuario();
            TipoDocumento getTipoDocumento();
            String getNumeroDocumento();
        }
    }
}
