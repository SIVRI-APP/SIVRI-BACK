package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity;

import edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity.RolFuncionarioEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "observacion_grupo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    //relacion *a1 con entidad funcionario
    @ManyToOne
    @JoinColumn(name = "rolfuncionarioId",nullable = false)
    private RolFuncionarioEntity funcionarioRol;

}
