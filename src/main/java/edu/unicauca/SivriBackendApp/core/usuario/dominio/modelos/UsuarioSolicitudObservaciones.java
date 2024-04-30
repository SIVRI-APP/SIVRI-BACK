package edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * La clase UsuarioSolicitudObservaciones representa las observaciones realizadas a una solicitud de usuario por parte de un funcionario.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioSolicitudObservaciones {

    /**
     * Identificador único de la observación.
     */
    private Long id;

    /**
     * Solicitud de usuario a la que se asocia la observación.
     */
    private UsuarioSolicitud solicitudUsuario;

    /**
     * Funcionario que realiza la observación.
     */
    private Funcionario funcionario;

    /**
     * Observación realizada al solicitante.
     */
    private String observación;

    /**
     * Fecha en la que se realiza la observación.
     */
    private LocalDate fechaObservación;

    /**
     * Indica si la observación ha sido resuelta.
     */
    private Boolean resuelta;

    /**
     * Indica si se ha enviado una notificación de vencimiento de la observación.
     */
    private Boolean notificaciónDeVencimiento;
}
