package edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity;

import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity.SemilleroEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "semillero_programa",uniqueConstraints = {@UniqueConstraint(columnNames = {"semilleroId","idPrograma"})})
@Data
public class SemilleroProgramaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "semilleroId",referencedColumnName = "id")
    private SemilleroEntity semillero;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idPrograma", referencedColumnName = "id")
    private ProgramaEntity programa;

}
