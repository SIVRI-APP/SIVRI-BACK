package edu.unicauca.SivriBackendApp.core.usuario.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Proyections.ValidarExistenciaUsuarioSistema;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.in.UsuarioObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.out.UsuarioObtenerREPO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UsuarioObtenerService implements UsuarioObtenerCU{

    private final UsuarioObtenerREPO usuarioObtenerREPO;

    @Override
    public Respuesta validarExistenciaUsuarioSistema(String tipoDocumento, String numeroDocumento) {
        Optional<ValidarExistenciaUsuarioSistema> respuestaBd = usuarioObtenerREPO.validarExistenciaUsuarioSistema(tipoDocumento, numeroDocumento);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.usuario", List.of(tipoDocumento, numeroDocumento));
        }

        return new RespuestaHandler<>(200, "ok.usuario.encontrado", List.of(tipoDocumento, numeroDocumento), "",respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> existsByTipoDocumentoAndNumeroDocumento(TipoDocumento tipoDocumento, String numeroDocumento) {
        Boolean respuestaBd = usuarioObtenerREPO.existsByTipoDocumentoAndNumeroDocumento(tipoDocumento, numeroDocumento);
        return new RespuestaHandler<>(200, "ok.usuario.encontrado", List.of(tipoDocumento.toString(), numeroDocumento), "",respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> existsByCorreo(String correo) {
        Boolean respuestaBd = usuarioObtenerREPO.existsByCorreo(correo);
        return new RespuestaHandler<>(200, "ok.usuario.correo.encontrado", List.of(correo), "",respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> existsById(Long id) {
        Boolean respuestaBd = usuarioObtenerREPO.existsById(id);
        return new RespuestaHandler<>(200, "ok.usuario.correo.encontrado", List.of(id), "",respuestaBd).getRespuesta();
    }
}
