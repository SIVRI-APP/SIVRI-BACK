package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "funcion_administrativa_funcionario")
@Data
public class FuncionAdministrativaFuncionarioEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fechaInicio")
    private LocalDate fechaInicio;

    @Column(name = "fechaFin")
    private LocalDate fechaFin;

    @ManyToOne
    @JoinColumn(name = "funcionAdministrativaId")
    private FuncionAdministrativaEntity funcionAdministrativa;

    @ManyToOne
    @JoinColumn(name = "rolFuncionarioId")
    private RolFuncionarioEntity rolFuncionarioId;
}
