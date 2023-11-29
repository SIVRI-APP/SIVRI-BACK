package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "rol_funcionario")
@Data
public class RolFuncionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, length = 45)
    private String nombre;

}
