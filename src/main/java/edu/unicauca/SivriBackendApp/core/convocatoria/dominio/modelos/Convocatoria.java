package edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.ConvocatoriaEstado;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.TipoFinanciacion;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Convocatoria {

    private Long id;

    private String nombre;

    private String descripcion;

    private String objetivos;

    private String oferente;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private ConvocatoriaEstado estado;

    private TipoFinanciacion tipoFinanciacion;

    private Set<Checklist> checklist;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Convocatoria that = (Convocatoria) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
