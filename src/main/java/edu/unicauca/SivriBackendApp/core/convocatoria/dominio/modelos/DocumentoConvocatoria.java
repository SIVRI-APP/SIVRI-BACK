package edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos;

import lombok.*;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DocumentoConvocatoria {

    private Long id;

    private String nombre;

    private Set<Checklist> documentacion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentoConvocatoria that = (DocumentoConvocatoria) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
