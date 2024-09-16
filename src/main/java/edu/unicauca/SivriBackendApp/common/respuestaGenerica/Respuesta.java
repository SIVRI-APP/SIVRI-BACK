package edu.unicauca.SivriBackendApp.common.respuestaGenerica;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import lombok.*;

/**
 * Datos genéricos de respuesta para ser transmitidos en todos los servicios REST.
 *
 * @param <T> Objeto de respuesta para las transacciones realizadas en cada API.
 */
@Getter @Setter @ToString
public class Respuesta<T> {

    /** Indica el estado HTTP de la transacción */
    private int status;

    /** Mensaje informativo para el usuario */
    private String userMessage;

    /** Mensaje informativo para los desarrolladores */
    private String developerMessage;

    /** Objeto con la respuesta de la transacción */
    private T data;


}