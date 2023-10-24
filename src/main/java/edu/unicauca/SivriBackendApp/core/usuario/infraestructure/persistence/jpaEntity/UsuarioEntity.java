package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity;

import edu.unicauca.SivriBackendApp.core.usuario.domain.model.EstadoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Sexo;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "usuario")
@Data
public class UsuarioEntity {

    @EmbeddedId
    private UsuarioEntityID id;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Enumerated(EnumType.STRING)
    private EstadoUsuario estado;

    @Column(name = "nombres", length = 100, nullable = false)
    private String nombres;

    @Column(name = "apellidos", length = 100, nullable = false)
    private String apellidos;

    @Column(name = "telefono", length = 45, nullable = false)
    private String telefono;

    @Column(name = "correo", length = 50, nullable = false, unique = true)
    private String correo;

    @Column(name = "contraseña", length = 50)
    private String contraseña;

    @OneToMany(mappedBy = "usuario")
    private List<RolUsuarioEntity> rolesDeUsuario;

//    @OneToMany(mappedBy="usuario", cascade = CascadeType.REMOVE)
//    private List<IntegranteProyectoEntity> participacionProyectos;
}
