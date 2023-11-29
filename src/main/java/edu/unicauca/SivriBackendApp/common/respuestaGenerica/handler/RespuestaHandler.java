package edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler;

import edu.unicauca.SivriBackendApp.common.resourceBundleMessages.BundleMessage;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
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
