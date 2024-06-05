package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades;

import jakarta.persistence.*;
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

    /** Identificador único de la observacion asociada a la solicitud de usuario */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Solicitud de usuario a la que está asociada la observacion. Es un campo obligatorio */
    @OneToOne(optional = false)
    @JoinColumn(name = "solicitudUsuarioId")
    private UsuarioSolicitudEntity solicitudUsuario;

    /** Funcionario que realiza la observacion. Es un campo obligatorio */
    @ManyToOne(optional = false)
    @JoinColumn(name = "funcionarioId", referencedColumnName = "id")
    private FuncionarioEntity funcionario;

    /** Conversaciones entórno a esta observacion */
    @OneToMany(mappedBy = "usuarioSolicitudObservaciones", cascade = CascadeType.REMOVE)
    private Set<UsuarioSolicitudConversacionEntity> conversacion;

    /** Texto de la observacion. Tiene una longitud máxima de 1000 caracteres y es un campo obligatorio */
    @Column(length = 1000, nullable = false)
    private String observacion;

    /** Fecha en que se realiza la observacion. Debe ser una fecha presente o futura */
    private LocalDate fechaObservacion;

    /** Indica si la observacion ha sido resuelta o no */
    private Boolean resuelta;

    /** Indica si se ha enviado una notificación de vencimiento asociada a esta observacion */
    private Boolean notificacionDeVencimiento;


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

