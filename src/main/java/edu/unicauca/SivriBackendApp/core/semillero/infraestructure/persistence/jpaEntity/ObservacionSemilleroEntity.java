package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity;

import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.RolFuncionarioEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "observacion_semillero")
@Getter
@Setter
@AllArgsConstructor

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
    //relacion *a1 funcionario
    @ManyToOne
    @JoinColumn(name = "RolFuncionarioId")
    private RolFuncionarioEntity rolFuncionarioSemillero;
}
