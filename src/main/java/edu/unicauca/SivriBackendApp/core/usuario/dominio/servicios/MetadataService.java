package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.ports.in.MetadataCU;
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
