package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity;

import edu.unicauca.SivriBackendApp.core.proyecto.infraestructure.persistence.jpaEntity.IntegranteProyectoEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity {
    @Id
    @Column(name = "numeroDocumento", length = 45)
    private String numeroDocumento;

    @Column(name = "tipoDocumento", length = 45, nullable = false)
    private String tipoDocumento;

    @Column(name = "sexo", length = 20, nullable = false)
    private String sexo;

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

    @OneToMany(mappedBy="usuarioNumeroDocumento", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<RolUsuarioEntity> rolesAcademicos;

    @OneToMany(mappedBy="usuario", cascade = CascadeType.REMOVE)
    private List<IntegranteProyectoEntity> participacionProyectos;
}
