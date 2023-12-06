package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.entity;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario_solicitud")
public class UsuarioSolicitudEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "correo", length = 60, nullable = false, unique = true)
    private String correo;

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    @Column(name = "numeroDocumento", length = 45)
    private String numeroDocumento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sexo sexo;

    @Enumerated(EnumType.STRING)
    private EstadoSolicitudUsuario estado;

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

    private Long facultadId;

    private Long departamentoId;

    private Long programaId;

    @Column(nullable = false)
    private Integer grupoId;

    @Column(nullable = false)
    private Integer rolGrupoId;
}
