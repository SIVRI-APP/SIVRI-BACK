package edu.unicauca.SivriBackendApp.common.response.handler;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import lombok.Getter;

@Getter
public class RespuestaHandler<T> {

    private final Respuesta<T> respuesta;

    public RespuestaHandler(int status, String userMessage, String developerMessage, T data) {
        this.respuesta = new Respuesta<>();

        respuesta.setStatus(status);
        respuesta.setUserMessage(userMessage);
        respuesta.setDeveloperMessage(developerMessage);
        respuesta.setData(data);
    }

}
