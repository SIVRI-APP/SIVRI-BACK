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
public class UsuarioObtenerService implements UsuarioObtenerCU{

    private UsuarioObtenerREPO usuarioObtenerREPO;

    public UsuarioObtenerService(UsuarioObtenerREPO usuarioObtenerREPO) {
        this.usuarioObtenerREPO = usuarioObtenerREPO;
    }

    @Override
    public Respuesta<validarVinculacionUsuarioGrupo> validarVinculacionUsuarioGrupo(TipoDocumento tipoDocumento, String numeroDocumento) {
        return null;
    }

    @Override
    public Respuesta<Boolean> validarExistencia(TipoDocumento tipoDocumento, String numeroDocumento) {
        return null;
    }
}
