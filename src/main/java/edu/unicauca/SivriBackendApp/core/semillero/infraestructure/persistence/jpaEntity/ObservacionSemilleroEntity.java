package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "observacion_semillero")
@Data
public class ObservacionSemilleroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 1445)
    private String observacion;
    @PastOrPresent
    private LocalDate fecha;
    //relacion *a1 semillero
    @ManyToOne
    @JoinColumn(name = "semilleroId")
    private SemilleroEntity semillero;

    //TODO ROLFUNCIONARIO
    //relacion *a1 funcionario
    /*@ManyToOne
    @JoinColumn(name = "RolFuncionarioId")
    private RolFuncionarioEntity rolFuncionarioSemillero;*/
}
