package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "sub_area")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubAreaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSubArea;
    @Column(length = 60,nullable = false)
    private String subArea;

    //relacion *a1 con entidad Area opcional = false indica que la relacion es obligatoria
    @ManyToOne(optional = false)
    @JoinColumn(name = "idArea")
    private AreaEntity idArea;

    //relacion 1a* con entidad disciplina
    @OneToMany(mappedBy = "subArea",fetch = FetchType.LAZY)
    private List<DisciplinaEntity> disciplinas;


}
