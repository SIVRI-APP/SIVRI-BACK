package edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.dominio.modelos.proyecciones;

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
        }
    }
}
