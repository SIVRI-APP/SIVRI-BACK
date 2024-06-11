package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.entidad;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.EtapaDocumento;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.ResponsableDocumento;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "checklist")
public class ChecklistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne()
    @JoinColumn(name = "convocatoriaId")
    private ConvocatoriaEntity convocatoria;

    @ManyToOne()
    @JoinColumn(name = "documentoConvocatoriaId")
    private DocumentoConvocatoriaEntity documentoConvocatoria;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EtapaDocumento etapaDocumento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ResponsableDocumento responsableDocumento;

    @Min(value = 0)
    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private boolean obligatorio;

    @Column(nullable = false)
    private boolean completado;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChecklistEntity that = (ChecklistEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
