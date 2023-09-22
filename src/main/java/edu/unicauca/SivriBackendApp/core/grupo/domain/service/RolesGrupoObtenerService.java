package edu.unicauca.SivriBackendApp.core.grupo.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.RolGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.in.RolesGrupoObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.out.RolesGrupoObtenerREPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class RolesGrupoObtenerService implements RolesGrupoObtenerCU {

    @Autowired
    private RolesGrupoObtenerREPO obtenerRolesGrupoREPO;

    @Override
    public Respuesta<RolGrupo> obtenerRolGrupoPorId(int id) {
        Optional<RolGrupo> respuestaBd= obtenerRolesGrupoREPO.obtenerRolGrupoPorId(id);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("el id "+id+" no existe.");
        }

        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<List<RolGrupo>> obtenerRolesGrupo() {
        List<RolGrupo> respuestaBd= obtenerRolesGrupoREPO.obtenerRolesGrupo();
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("No hay roles en el grupo");
        }

        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuestaBd).getRespuesta();
    }
}
