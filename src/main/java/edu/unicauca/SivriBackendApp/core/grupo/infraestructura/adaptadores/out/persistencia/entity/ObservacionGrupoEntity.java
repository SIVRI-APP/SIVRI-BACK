package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity;

import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades.FuncionarioEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import lombok.NonNull;

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


    //relacion *a1 con entidad funcionario
    @ManyToOne
    @JoinColumn(name = "funcionarioId",nullable = false)
    private FuncionarioEntity funcionario;

}
