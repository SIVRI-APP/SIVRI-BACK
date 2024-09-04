package edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones;


import java.util.Set;

public interface ProyectoEvidenciasDocumentosProyeccion {

    Set<evidenciaProyeccion> getEvidenciasDocumentosConvocatoria();

    interface evidenciaProyeccion {
        Long getId();
        String getNombre();

        DocumentoConvocatoriaProyeccion getDocumentoConvocatoria();

        interface DocumentoConvocatoriaProyeccion {
            Long getId();
            String getNombre();
        }
    }
}
