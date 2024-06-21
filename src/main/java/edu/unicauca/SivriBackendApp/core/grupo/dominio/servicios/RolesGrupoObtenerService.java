package edu.unicauca.SivriBackendApp.core.grupo.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in.RolesGrupoObtenerCU;
import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out.RolesGrupoObtenerREPO;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.RolGrupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class RolesGrupoObtenerService implements RolesGrupoObtenerCU {

    @Autowired
    private RolesGrupoObtenerREPO obtenerRolesGrupoREPO;

    @Override
    public Respuesta<Boolean> existePorId(int id) {

        Boolean respuesta=obtenerRolesGrupoREPO.existePorId(id);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Roles Grupo", "Id", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta();
    }

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
