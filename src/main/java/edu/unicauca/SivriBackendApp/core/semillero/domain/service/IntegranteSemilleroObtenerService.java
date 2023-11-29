package edu.unicauca.SivriBackendApp.core.semillero.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.in.IntegranteSemilleroObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.out.IntegranteSemilleroObtenerREPO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class IntegranteSemilleroObtenerService implements IntegranteSemilleroObtenerCU {
    private final IntegranteSemilleroObtenerREPO integranteSemilleroObtenerREPO;

    public IntegranteSemilleroObtenerService(IntegranteSemilleroObtenerREPO integranteSemilleroObtenerREPO) {
        this.integranteSemilleroObtenerREPO = integranteSemilleroObtenerREPO;
    }

    @Override
    public Respuesta<IntegranteSemillero> obtenerPorId(int id) {
        Optional<IntegranteSemillero> respuestaBd=integranteSemilleroObtenerREPO.obtenerPorId(id);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Integrante Semillero", "Id", String.valueOf(id)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<List<IntegranteSemillero>> obtenerIntegrantesSemillero() {

        List<IntegranteSemillero> respuestaBd=integranteSemilleroObtenerREPO.obtenerIntegrantesSemillero();

        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }

    @Override
    public Respuesta<List<Semillero>> obtenerSemillerosPorIdMentor(String idMentor) {
        System.out.println("ENTRA A SERVICE ");
        List<Semillero> respuesta=integranteSemilleroObtenerREPO.obtenerSemillerosPorIdMentor(idMentor);
        //System.out.println("respuesta de service "+respuesta);
        if (respuesta.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros.semilleros.mentor");
        }

        return new RespuestaHandler<>(200,"sucess.operacion.exitosa","Exitoso",respuesta).getRespuesta();

    }
}
