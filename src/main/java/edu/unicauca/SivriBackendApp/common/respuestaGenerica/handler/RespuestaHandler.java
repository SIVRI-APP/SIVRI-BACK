package edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler;

import edu.unicauca.SivriBackendApp.common.resourceBundleMessages.BundleMessage;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import lombok.Getter;

import java.util.List;

/**
 * Esta clase maneja la creación de una respuesta genérica.
 * Proporciona constructores para establecer el estado, el mensaje para el usuario,
 * el mensaje para el desarrollador y los datos de la respuesta.
 *
 * @param <T> el tipo de los datos en la respuesta
 */
@Getter
public class RespuestaHandler<T> {

    /**
     * {@link Respuesta}
     */
    private final Respuesta<T> respuesta;

    /**
     * Construye un ResponseHandler con el estado especificado, la clave del mensaje para el usuario,
     * el mensaje para el desarrollador y los datos.
     *
     * @param status el código de estado de la respuesta
     * @param userMessageKey la clave para el mensaje del usuario, que se utilizará para recuperar el mensaje real
     * @param developerMessage el mensaje destinado a los desarrolladores
     * @param data los datos que se incluirán en la respuesta
     */
    public RespuestaHandler(int status, String userMessageKey, String developerMessage, T data) {
        this.respuesta = new Respuesta<>();
        respuesta.setStatus(status);
        respuesta.setUserMessage(BundleMessage.getResponseMessage(userMessageKey));
        respuesta.setDeveloperMessage(developerMessage);
        respuesta.setData(data);
    }

    /**
     * Construye un ResponseHandler con el estado especificado, la clave del mensaje para el usuario,
     * los argumentos del mensaje del usuario, el mensaje para el desarrollador y los datos.
     *
     * @param status el código de estado de la respuesta
     * @param userMessageKey la clave para el mensaje del usuario, que se utilizará para recuperar el mensaje real
     * @param userMessageArgs los argumentos que se utilizarán en el mensaje del usuario
     * @param developerMessage el mensaje destinado a los desarrolladores
     * @param data los datos que se incluirán en la respuesta
     */
    public RespuestaHandler(int status, String userMessageKey, List<String> userMessageArgs, String developerMessage, T data) {
        this.respuesta = new Respuesta<>();
        respuesta.setStatus(status);
        respuesta.setUserMessage(BundleMessage.getResponseMessage(userMessageKey, userMessageArgs));
        respuesta.setDeveloperMessage(developerMessage);
        respuesta.setData(data);
    }
}
