package edu.unicauca.SivriBackendApp.common.response.handler;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import lombok.Getter;

@Getter
public class ResponseHandler<T> {
    private final Respuesta<T> respuesta;

    public ResponseHandler(int status, String userMessage, String developerMessage, T data) {
        respuesta = new Respuesta<>();

        respuesta.setStatus(status);
        respuesta.setUserMessage(userMessage);
        respuesta.setDeveloperMessage(developerMessage);
        respuesta.setData(data);
    }

}
