package edu.unicauca.SivriBackendApp.core.usuario.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.Sexo;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.enums.TipoUsuario;
import edu.unicauca.SivriBackendApp.core.usuario.aplicación.puertos.entrada.MetadataCU;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * El servicio MetadataService proporciona métodos para obtener información sobre tipos de documentos, sexos y tipos de usuario.
 */
@Service
public class MetadataService implements MetadataCU {

    /**
     * Obtiene la lista de tipos de documento disponibles.
     *
     * @return Respuesta que contiene la lista de tipos de documento.
     */
    @Override
    public Respuesta<List<TipoDocumento>> obtenerTiposDocumento() {
        return new RespuestaHandler<>(200, "ok", "", Arrays.stream(TipoDocumento.values()).collect(Collectors.toList())).getRespuesta();
    }

    /**
     * Obtiene la lista de géneros o sexos disponibles.
     *
     * @return Respuesta que contiene la lista de sexos.
     */
    @Override
    public Respuesta<List<Sexo>> obtenerSexo() {
        return new RespuestaHandler<>(200, "ok", "", Arrays.stream(Sexo.values()).collect(Collectors.toList())).getRespuesta();
    }

    /**
     * Obtiene la lista de tipos de usuario disponibles.
     *
     * @return Respuesta que contiene la lista de tipos de usuario.
     */
    @Override
    public Respuesta<List<TipoUsuario>> obtenerTiposUsuario() {
        return new RespuestaHandler<>(200, "ok", "", Arrays.stream(TipoUsuario.values()).collect(Collectors.toList())).getRespuesta();
    }
}
