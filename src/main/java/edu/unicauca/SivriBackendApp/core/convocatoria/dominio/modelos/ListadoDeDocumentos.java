package edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.EtapaDocumento;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.ResponsableDocumento;
import lombok.Data;

@Data
public class ListadoDeDocumentos {

    private long id;

    private TipoConvocatoria tipoConvocatoria;

    private DocumentoConvocatoria documentoConvocatoria;

    private EtapaDocumento etapaDocumento;

    private ResponsableDocumento responsableDocumento;

    private int cantidad;

    private boolean obligatorio;

}
