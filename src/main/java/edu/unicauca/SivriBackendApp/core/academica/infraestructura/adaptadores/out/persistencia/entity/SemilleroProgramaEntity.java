package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.entity;

import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.SemilleroEntity;
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
