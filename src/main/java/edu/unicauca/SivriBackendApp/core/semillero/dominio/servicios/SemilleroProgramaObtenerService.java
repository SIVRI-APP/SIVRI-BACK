package edu.unicauca.SivriBackendApp.core.semillero.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.in.SemilleroProgramaObtenerCU;
import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.SemilleroProgramaObtenerREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.SemilleroPrograma;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarProgramas;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class SemilleroProgramaObtenerService implements SemilleroProgramaObtenerCU {
    private final SemilleroProgramaObtenerREPO semilleroProgramaObtenerREPO;

    @Override
    public Respuesta<Boolean> existePorId(long id) {
        Boolean respuesta=semilleroProgramaObtenerREPO.existePorId(id);
        if (!respuesta){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Semillero Programa", "Id", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "",true).getRespuesta();
    }

    @Override
    public Respuesta<SemilleroPrograma> obtenerPorId(long id) {
        Optional<SemilleroPrograma> respuestaBd =semilleroProgramaObtenerREPO.obtenerPorId(id);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontro.registro", List.of("Semillero Programa", "Id", String.valueOf(id)));
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd.get()).getRespuesta();
    }

    @Override
    public Respuesta<Page<ListarProgramas>> obtenerListadoProgramasPorSemilleroId(int pageNo, int pageSize, int idSemillero) {
        System.out.println("para metros service: "+idSemillero+" "+pageNo+" "+pageSize);
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<ListarProgramas> respuestaBd=semilleroProgramaObtenerREPO.obtenerListadoProgramasPorSemilleroId(pageable, idSemillero);
        System.out.println("respuesta del service: "+respuestaBd);
        if (respuestaBd.isEmpty()){
            throw new ReglaDeNegocioException("bad.no.se.encontraron.registros");
        }

        return new RespuestaHandler<>(200, "sucess.operacion.exitosa", "", respuestaBd).getRespuesta();
    }



}
