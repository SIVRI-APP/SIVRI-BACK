package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "grupo_disciplina", uniqueConstraints = {@UniqueConstraint(columnNames = {"grupoId","disciplinaId"})})
@Data
public class GrupoDisciplinaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "grupoId",referencedColumnName = "id")
    private GrupoEntity grupo;
    @ManyToOne(optional = false)
    @JoinColumn(name = "disciplinaId",referencedColumnName = "id")
    private DisciplinaEntity disciplina;
}
