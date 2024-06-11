package edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.EtapaDocumento;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.ResponsableDocumento;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Checklist {

    private long id;

    private Convocatoria convocatoria;

    private DocumentoConvocatoria documentoConvocatoria;

    private EtapaDocumento etapaDocumento;

    private ResponsableDocumento responsableDocumento;

    private int cantidad;

    private boolean obligatorio;

    private boolean completado;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Checklist checklist = (Checklist) o;
        return id == checklist.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
