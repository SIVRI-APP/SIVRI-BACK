package edu.unicauca.SivriBackendApp.core.convocatoria.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.convocatoria.aplicación.puertos.entrada.ConvocatoriaCrearCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.aplicación.puertos.salida.ConvocatoriaCrearREPO;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Convocatoria;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConvocatoriaCrearService implements ConvocatoriaCrearCU {

    private final ConvocatoriaCrearREPO convocatoriaCrearREPO;

    @Override
    public Respuesta<Boolean> crearConvocatoria(Convocatoria convocatoria) {
        convocatoriaCrearREPO.crearConvocatoria(convocatoria);

        return new RespuestaHandler<>(200, "ok.convocatoria.creada", "", true).getRespuesta();
    }
}
