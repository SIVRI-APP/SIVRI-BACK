package edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.EtapaDocumento;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.ResponsableDocumento;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.TipoFinanciacion;

import java.util.Set;

public interface ProyectoConvocatoriaProyeccion {

    ConvocatoriaProyeccion getConvocatoria();

    interface ConvocatoriaProyeccion {
        Long getId();
        String getNombre();
        TipoFinanciacion getTipoFinanciacion();
        Set<ChecklistProyeccion> getChecklist();
    }

    interface ChecklistProyeccion {
        long getId();
        EtapaDocumento getEtapaDocumento();
        ResponsableDocumento getResponsableDocumento();
        int getCantidad();
        boolean getObligatorio();
        boolean getCompletado();
        DocumentoProyeccion getDocumentoConvocatoria();

        interface DocumentoProyeccion {
            Long getId();
            String getNombre();
        }
    }
}
