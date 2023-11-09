package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "rol_administrativo")
@Data
public class RolAdministrativoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "funcionarioId")
    private FuncionarioEntity funcionario;

    @ManyToOne
    @JoinColumn(name = "rolFuncionarioId")
    private RolFuncionarioEntity rolFuncionario;

    private Boolean estado;

    @FutureOrPresent
    private LocalDate fechaInicio;

    @FutureOrPresent
    private LocalDate fechaFin;
}
