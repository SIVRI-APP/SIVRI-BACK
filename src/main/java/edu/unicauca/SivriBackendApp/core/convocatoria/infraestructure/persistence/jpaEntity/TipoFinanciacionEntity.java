package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructure.persistence.jpaEntity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tipofinanciacion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoFinanciacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45, nullable = false)
    private String tipo;

    @OneToMany(mappedBy = "tipoFinanciacion", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ChecklistEntity> checklist;

//    @OneToMany(mappedBy = "tipoFinanciacion", fetch = FetchType.LAZY)
//    private List<ConvocatoriaEntity> convocatorias;
}

