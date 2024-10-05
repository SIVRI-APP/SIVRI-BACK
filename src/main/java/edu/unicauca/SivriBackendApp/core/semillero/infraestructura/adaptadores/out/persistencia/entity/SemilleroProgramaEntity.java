package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity;

import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.entity.ProgramaEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.SemilleroEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "semillero_programa",uniqueConstraints = {@UniqueConstraint(columnNames = {"semilleroId","idPrograma"})})
@Data
public class SemilleroProgramaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "semillero_programa_seq")
    @SequenceGenerator(name = "semillero_programa_seq",sequenceName = "semillero_programa_sequence", initialValue = 3, allocationSize = 1)
    private long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "semillero_Id",referencedColumnName = "id")
    private SemilleroEntity semillero;
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_Programa", referencedColumnName = "id")
    private ProgramaEntity programa;

}
