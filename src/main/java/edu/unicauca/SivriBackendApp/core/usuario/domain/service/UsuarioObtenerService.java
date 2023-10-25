package edu.unicauca.SivriBackendApp.core.usuario.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.Proyections.validarVinculacionUsuarioGrupo;
import edu.unicauca.SivriBackendApp.core.usuario.domain.model.TipoDocumento;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.in.UsuarioObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.domain.port.out.UsuarioObtenerREPO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioObtenerService implements UsuarioObtenerCU {

    private UsuarioObtenerREPO usuarioObtenerREPO;

    public UsuarioObtenerService(UsuarioObtenerREPO usuarioObtenerREPO) {
        this.usuarioObtenerREPO = usuarioObtenerREPO;
    }

    @Override
    public Respuesta<validarVinculacionUsuarioGrupo> validarVinculacionUsuarioGrupo(TipoDocumento tipoDocumento, String numeroDocumento) {
        Optional<validarVinculacionUsuarioGrupo> respuestaBd = usuarioObtenerREPO.validarVinculacionUsuarioGrupo(tipoDocumento, numeroDocumento);

        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro.ebedded.id", List.of(tipoDocumento.getDescripcion(), numeroDocumento));
        }

        return new RespuestaHandler<>(200, "sucess.usuario.existe", List.of(tipoDocumento.getDescripcion(), numeroDocumento), "", respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> validarExistencia(TipoDocumento tipoDocumento, String numeroDocumento) {
        Boolean respuestaBd = usuarioObtenerREPO.validarExistencia(tipoDocumento, numeroDocumento);

        if (!respuestaBd){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro.ebedded.id", List.of(tipoDocumento.getDescripcion(), numeroDocumento));
        }

        return new RespuestaHandler<>(200, "sucess.usuario.existe", List.of(tipoDocumento.getDescripcion(), numeroDocumento), "", true).getRespuesta();
    }
}
