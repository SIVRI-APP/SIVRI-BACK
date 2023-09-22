package edu.unicauca.SivriBackendApp.core.academica.domain.service;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.response.Respuesta;
import edu.unicauca.SivriBackendApp.common.response.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.academica.domain.model.Facultad;
import edu.unicauca.SivriBackendApp.core.academica.domain.port.in.FacultadObtenerCU;
import edu.unicauca.SivriBackendApp.core.academica.domain.port.out.FacultadObtenerREPO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FacultadObtenerService implements FacultadObtenerCU {

    private final FacultadObtenerREPO facultadObtenerREPO;

    public FacultadObtenerService(FacultadObtenerREPO facultadObtenerREPO) {
        this.facultadObtenerREPO = facultadObtenerREPO;
    }

    @Override
    public Respuesta<Facultad> obtenerPorId(Integer id) {
        Optional<Facultad> respuestaBd= facultadObtenerREPO.obtenerPorId(id);
        if (respuestaBd.isEmpty()){
//
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<List<Facultad>> obtenerFacultades() {
     List<Facultad> respuestaBd=facultadObtenerREPO.obtenerFacultades();
        if (respuestaBd.isEmpty()){
//
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }
}
