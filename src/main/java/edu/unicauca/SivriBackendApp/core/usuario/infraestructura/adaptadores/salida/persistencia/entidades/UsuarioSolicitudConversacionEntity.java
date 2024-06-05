package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Representa la entidad de persistencia para las observaciones asociadas a las solicitudes de usuarios en el sistema.
 */
@Entity
@Table(name = "usuario_solicitud_conversacion")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioSolicitudConversacionEntity {

    /** Identificador único de la observación asociada a la solicitud de usuario */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Solicitud de usuario a la que está asociada la observación. Es un campo obligatorio */
    @ManyToOne(optional = false)
    @JoinColumn(name = "usuarioSolicitudObservacionesId")
    private UsuarioSolicitudObservacionesEntity usuarioSolicitudObservaciones;

    /** Texto de la observación. Tiene una longitud máxima de 1000 caracteres y es un campo obligatorio */
    @Column(length = 245, nullable = false)
    private String autor;

    /** Texto de la observación. Tiene una longitud máxima de 1000 caracteres y es un campo obligatorio. */
    @Column(length = 1000, nullable = false)
    private String mensaje;

    /** Fecha en que se realiza la observación. Debe ser una fecha presente o futura */
    private LocalDateTime fechaMensaje;


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

