package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity;

import edu.unicauca.SivriBackendApp.core.usuario.domain.model.EstadoSolicitudUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoUsuario;
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
public class UsuarioSolicitudObservacionesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "solicitudUsuarioId", referencedColumnName = "id")
    private UsuarioSolicitudEntity solicitudUsuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "funcionarioId", referencedColumnName = "id")
    private FuncionarioEntity funcionario;

    @Column(length = 260, nullable = false)
    private String observacion;
}
