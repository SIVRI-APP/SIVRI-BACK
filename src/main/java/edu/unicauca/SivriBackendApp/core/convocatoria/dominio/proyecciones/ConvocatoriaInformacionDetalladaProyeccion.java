package edu.unicauca.SivriBackendApp.core.convocatoria.dominio.proyecciones;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.ConvocatoriaEstado;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.EtapaDocumento;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.ResponsableDocumento;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.TipoFinanciacion;

import java.time.LocalDate;
import java.util.Set;

public interface ConvocatoriaInformacionDetalladaProyeccion {
    Long getId();

    String getNombre();

    String getDescripcion();

    String getObjetivos();

    String getOferente();

    LocalDate getFechaInicio();

    LocalDate getFechaFin();

    ConvocatoriaEstado getEstado();

    TipoFinanciacion getTipoFinanciacion();

    Set<ChecklistProyeccion> getChecklist();

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
