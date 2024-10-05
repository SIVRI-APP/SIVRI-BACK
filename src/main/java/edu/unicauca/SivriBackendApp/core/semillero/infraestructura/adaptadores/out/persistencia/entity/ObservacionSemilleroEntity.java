package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity;

import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.FuncionarioEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "observacion_semillero")
@Data
public class ObservacionSemilleroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "observacion_semillero_seq")
    @SequenceGenerator(name = "observacion_semillero_seq",sequenceName = "observacionSemillero_sequence", initialValue = 1, allocationSize = 1)
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
    @JoinColumn(name = "funcionarioId")
    private FuncionarioEntity funcionario;
}
