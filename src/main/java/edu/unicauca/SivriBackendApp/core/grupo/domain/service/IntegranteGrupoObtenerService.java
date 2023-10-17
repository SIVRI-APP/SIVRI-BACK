package edu.unicauca.SivriBackendApp.core.grupo.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.IntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.IntegranteGrupoObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.out.IntegranteGrupoObtenerREPO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class IntegranteGrupoObtenerService implements IntegranteGrupoObtenerCU {

    private final IntegranteGrupoObtenerREPO integranteGrupoObtenerREPO;

    public IntegranteGrupoObtenerService(IntegranteGrupoObtenerREPO integranteGrupoObtenerREPO) {
        this.integranteGrupoObtenerREPO = integranteGrupoObtenerREPO;
    }

    @Override
    public Respuesta<IntegranteGrupo> obtenerIntegrantePorId(int id) {
        Optional<IntegranteGrupo> respuestaBd=integranteGrupoObtenerREPO.obtenerIntegranteGrupoPorId(id);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("IntegranteGrupo", "Id", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuestaBd.get()).getRespuesta();

    }

    @Override
    public Respuesta<List<IntegranteGrupo>> obtenerIntegrantesGrupo() {
        List<IntegranteGrupo> respuestaBd=integranteGrupoObtenerREPO.obtenerIntegrantesGrupo();
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }
        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuestaBd).getRespuesta();

    }
}
