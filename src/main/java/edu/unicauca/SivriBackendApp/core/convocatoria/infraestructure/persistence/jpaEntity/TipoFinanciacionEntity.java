package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tipofinanciacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoFinanciacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false)
    private String tipo;

    @OneToMany(mappedBy = "tipoFinanciacion", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<ChecklistEntity> checklist;

    @OneToMany(mappedBy = "tipoFinanciacion", fetch = FetchType.EAGER)
    private List<ConvocatoriaEntity> convocatorias;
}

