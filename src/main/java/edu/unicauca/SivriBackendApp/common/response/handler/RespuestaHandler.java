package edu.unicauca.SivriBackendApp.common.response.handler;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Area;
import lombok.Getter;

import java.util.List;

@Getter
public class RespuestaHandler<T> {
    private final Respuesta<T> respuesta;

    public RespuestaHandler(int status, String userMessage, String developerMessage, T data) {
        respuesta = new Respuesta<>();

        respuesta.setStatus(status);
        respuesta.setUserMessage(userMessage);
        respuesta.setDeveloperMessage(developerMessage);
        respuesta.setData(data);
    }

}
