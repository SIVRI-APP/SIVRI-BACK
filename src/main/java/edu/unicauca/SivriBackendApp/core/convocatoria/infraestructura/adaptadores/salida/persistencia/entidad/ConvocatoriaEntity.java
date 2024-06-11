package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.entidad;

import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.ConvocatoriaEstado;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.TipoFinanciacion;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "convocatoria")
public class ConvocatoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 245, unique = true)
    private String nombre;

    @Column(nullable = false, length = 1000)
    private String descripcion;

    @Column(nullable = false, length = 1000)
    private String objetivos;

    @Column(nullable = false, length = 245)
    private String oferente;

    @FutureOrPresent
    private LocalDate fechaInicio;

    @FutureOrPresent
    private LocalDate fechaFin;

    @Enumerated(EnumType.STRING)
    private ConvocatoriaEstado estado;

    @Enumerated(EnumType.STRING)
    private TipoFinanciacion tipoFinanciacion;

    @OneToMany(mappedBy = "convocatoria", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<ChecklistEntity> checklist;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConvocatoriaEntity that = (ConvocatoriaEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
