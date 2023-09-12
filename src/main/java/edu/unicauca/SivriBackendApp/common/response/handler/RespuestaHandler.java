package edu.unicauca.SivriBackendApp.common.response.handler;

import edu.unicauca.SivriBackendApp.common.ResourceBundleMessages.BundleMessage;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import lombok.Getter;

import java.util.List;

@Getter
public class RespuestaHandler<T> {

    private final Respuesta<T> respuesta;

    public RespuestaHandler(int status, String userMessageKey, String developerMessage, T data) {
        this.respuesta = new Respuesta<>();

        respuesta.setStatus(status);
        respuesta.setUserMessage(BundleMessage.getResponseMessage(userMessageKey));
        respuesta.setDeveloperMessage(developerMessage);
        respuesta.setData(data);
    }

    public RespuestaHandler(int status, String userMessageKey, List userMessageArgs, String developerMessage, T data) {
        this.respuesta = new Respuesta<>();

        respuesta.setStatus(status);
        respuesta.setUserMessage(BundleMessage.getResponsenMessage(userMessageKey, userMessageArgs));
        respuesta.setDeveloperMessage(developerMessage);
        respuesta.setData(data);
    }

}
