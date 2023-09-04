package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "funcion_administrativa")

public class FuncionAdministrativaEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 45, nullable = false, unique = true)
    private String nombre;

    @OneToMany(mappedBy = "funcionAdministrativa", fetch = FetchType.LAZY)
    private List<FuncionAdministrativaFuncionarioEntity> funcionAdministrativaFuncionarios;

}
