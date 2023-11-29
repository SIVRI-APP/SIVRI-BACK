package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.entity;

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
@Table(name = "usuario_solicitud_observaciones")
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
