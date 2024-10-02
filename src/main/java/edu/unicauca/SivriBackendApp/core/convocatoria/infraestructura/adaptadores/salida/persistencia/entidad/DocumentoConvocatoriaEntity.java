package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.entidad;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "documento_convocatoria")
public class DocumentoConvocatoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "documento_convocatoria_seq")
    @SequenceGenerator(name = "documento_convocatoria_seq", sequenceName = "documento_convocatoria_seq", initialValue = 10, allocationSize = 1)
    private Long id;

    @Column(nullable = false, unique = true, length = 245)
    private String nombre;

    @OneToMany(mappedBy = "documentoConvocatoria")
    private Set<ChecklistEntity> documentacion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentoConvocatoriaEntity that = (DocumentoConvocatoriaEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
