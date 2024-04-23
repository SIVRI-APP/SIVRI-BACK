package edu.unicauca.SivriBackendApp.core.academica.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.academica.aplicación.puertos.entrada.FacultadObtenerCU;
import edu.unicauca.SivriBackendApp.core.academica.aplicación.puertos.salida.FacultadObtenerREPO;
import edu.unicauca.SivriBackendApp.core.academica.dominio.modelo.Facultad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FacultadObtenerService implements FacultadObtenerCU {

    private final FacultadObtenerREPO facultadObtenerREPO;

    @Override
    public Respuesta<Facultad> obtenerPorId(int id) {
        Facultad facultad = facultadObtenerREPO.obtenerPorId(id).orElseThrow(
                () -> new ReglaDeNegocioException("bad.no.se.encontro.facultd", List.of(Long.toString(id)))
        );

        return new RespuestaHandler<>(200, "ok", "", facultad).getRespuesta();
    }
}
