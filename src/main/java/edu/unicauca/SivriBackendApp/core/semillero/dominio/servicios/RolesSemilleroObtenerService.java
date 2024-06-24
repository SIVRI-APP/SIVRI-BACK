package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.RolesSemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.RolesSemilleroObtenerREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.RolSemillero;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class RolesSemilleroObtenerService implements RolesSemilleroObtenerCU {
    private final RolesSemilleroObtenerREPO rolesSemilleroObtenerREPO;

    public RolesSemilleroObtenerService(RolesSemilleroObtenerREPO rolesSemilleroObtenerREPO) {
        this.rolesSemilleroObtenerREPO = rolesSemilleroObtenerREPO;
    }

    @Override
    public Respuesta<Boolean> existePorId(int id) {
        Boolean respuesta=rolesSemilleroObtenerREPO.existePorId(id);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Roles Semillero", "Id", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta();
    }

    @Override
    public Respuesta<RolSemillero> obtenerRolSemilleroPorId(int id) {
        Optional<RolSemillero> respuestaBd= rolesSemilleroObtenerREPO.obtenerRolSemilleroPorId(id);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("el id "+id+" no existe.");
        }

        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<List<RolSemillero>> obtenerRolesSemillero() {
        List<RolSemillero> respuestaBd= rolesSemilleroObtenerREPO.obtenerRolesSemillero();
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("No hay roles en el semillero");
        }

        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuestaBd).getRespuesta();
    }
}
