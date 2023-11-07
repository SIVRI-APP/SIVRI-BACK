package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "rol_usuario")
@Data
public class RolUsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, length = 45)
    private String nombre;

    @OneToMany(mappedBy = "rolUsuario")
    private List<RolEntity> usuariosDeRol;


}
