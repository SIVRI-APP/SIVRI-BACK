package edu.unicauca.SivriBackendApp.core.usuario.domain.service;

import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.in.MetadataCU;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MetadataService implements MetadataCU {
    @Override
    public Respuesta<List<TipoDocumento>> obtenerTiposDocumento() {
        return new RespuestaHandler<>(200, "ok", "",Arrays.stream(TipoDocumento.values()).collect(Collectors.toList())).getRespuesta();
    }

    @Override
    public Respuesta<List<Sexo>> obtenerSexo() {
        return new RespuestaHandler<>(200, "ok", "",Arrays.stream(Sexo.values()).collect(Collectors.toList())).getRespuesta();
    }

    @Override
    public Respuesta<List<TipoUsuario>> obtenerTiposUsuario() {
        return new RespuestaHandler<>(200, "ok", "",Arrays.stream(TipoUsuario.values()).collect(Collectors.toList())).getRespuesta();
    }


}
