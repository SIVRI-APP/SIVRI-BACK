package edu.unicauca.SivriBackendApp.core.academica.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.academica.aplicación.ports.in.FacultadObtenerCU;
import edu.unicauca.SivriBackendApp.core.academica.aplicación.ports.out.FacultadObtenerREPO;
import edu.unicauca.SivriBackendApp.core.academica.dominio.modelos.Facultad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FacultadObtenerService implements FacultadObtenerCU {

    private final FacultadObtenerREPO facultadObtenerREPO;

    @Override
    public Respuesta<Boolean> existePorId(Integer id) {
        Boolean respuesta=facultadObtenerREPO.existePorId(id);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Facultad", "Id", String.valueOf(id)));
        }
        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta();
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
