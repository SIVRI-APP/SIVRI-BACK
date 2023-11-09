package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity;

import edu.unicauca.SivriBackendApp.core.usuario.domain.model.EstadoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoUsuario;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "correo", length = 50, nullable = false, unique = true)
    private String correo;

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    @Column(name = "numeroDocumento", length = 45)
    private String numeroDocumento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Enumerated(EnumType.STRING)
    private EstadoUsuario estado;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    @Column(name = "nombres", length = 100, nullable = false)
    private String nombres;

    @Column(name = "apellidos", length = 100, nullable = false)
    private String apellidos;

    @Column(name = "telefono", length = 45, nullable = false)
    private String telefono;

    @Column(name = "cvLac", length = 150)
    private String cvLac;

}
