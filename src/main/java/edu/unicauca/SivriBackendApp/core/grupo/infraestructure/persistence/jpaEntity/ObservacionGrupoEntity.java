package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "observacion_grupo")
@Data
public class ObservacionGrupoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idObservacion;
    @Column(length = 1445)
    private String observacion;
    @PastOrPresent
    @NonNull
    private LocalDate fecha;

    //relacion *a1 con entidad grupo
    @ManyToOne
    @JoinColumn(name = "grupoId", nullable = false)
    private GrupoEntity grupo;
    //TODO USUARIO FUNCIONARIO
    //relacion *a1 con entidad funcionario
    /*@ManyToOne
    @JoinColumn(name = "rolfuncionarioId",nullable = false)
    private RolFuncionarioEntity funcionarioRol;
*/
}