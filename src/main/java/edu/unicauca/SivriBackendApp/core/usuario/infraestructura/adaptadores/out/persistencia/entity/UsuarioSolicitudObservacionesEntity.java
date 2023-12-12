package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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

    @ManyToOne(optional = false)
    @JoinColumn(name = "funcionarioId", referencedColumnName = "id")
    private FuncionarioEntity funcionario;

    @Column(length = 1000, nullable = false)
    private String observación;

    @FutureOrPresent
    private LocalDate fechaObservación;

    private Boolean resuelta;
}
