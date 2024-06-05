package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

/**
 * Representa la entidad de persistencia para las observaciones asociadas a las solicitudes de usuarios en el sistema.
 */
@Entity
@Table(name = "usuario_solicitud_observaciones")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioSolicitudObservacionesEntity {

    /** Identificador único de la observación asociada a la solicitud de usuario */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Solicitud de usuario a la que está asociada la observación. Es un campo obligatorio */
    @ManyToOne(optional = false)
    @JoinColumn(name = "solicitudUsuarioId")
    private UsuarioSolicitudEntity solicitudUsuario;

    /** Funcionario que realiza la observación. Es un campo obligatorio */
    @ManyToOne(optional = false)
    @JoinColumn(name = "funcionarioId", referencedColumnName = "id")
    private FuncionarioEntity funcionario;

    /** Conversaciones entórno a esta observación */
    @OneToMany(mappedBy = "usuarioSolicitudObservaciones")
    private Set<UsuarioSolicitudConversacionEntity> conversacion;

    /** Texto de la observación. Tiene una longitud máxima de 1000 caracteres y es un campo obligatorio */
    @Column(length = 1000, nullable = false)
    private String observación;

    /** Fecha en que se realiza la observación. Debe ser una fecha presente o futura */
    @FutureOrPresent
    private LocalDate fechaObservación;

    /** Indica si la observación ha sido resuelta o no */
    private Boolean resuelta;

    /** Indica si se ha enviado una notificación de vencimiento asociada a esta observación */
    private Boolean notificaciónDeVencimiento;


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

