package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "funcionario")
@Data
public class FuncionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private UsuarioEntity usuario;
    
}
