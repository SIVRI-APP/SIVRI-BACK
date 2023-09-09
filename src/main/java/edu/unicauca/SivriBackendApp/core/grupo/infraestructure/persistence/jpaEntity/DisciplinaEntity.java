package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "disciplina")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 160, nullable = false)
    private String disciplina;

    // relacion *a1 con entidad subarea
    @ManyToOne(optional = false)
    @JoinColumn(name = "idSubArea")
    private SubAreaEntity subArea;

    // relacion *a* con entidad grupo ESTA relacion esta en la entidad grupo


}
