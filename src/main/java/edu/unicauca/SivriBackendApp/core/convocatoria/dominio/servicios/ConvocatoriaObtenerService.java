package edu.unicauca.SivriBackendApp.core.convocatoria.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.convocatoria.aplicacion.puertos.entrada.ConvocatoriaObtenerCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.aplicacion.puertos.salida.ConvocatoriaObtenerREPO;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.proyecciones.ConvocatoriaInformacionDetalladaProyeccion;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ConvocatoriaObtenerService implements ConvocatoriaObtenerCU {

    /**
     * Adaptadores
     */
    private final ConvocatoriaObtenerREPO convocatoriaObtenerREPO;

    @Override
    public Respuesta<ConvocatoriaInformacionDetalladaProyeccion> obtenerConvocatoriaInformacionDetallada(long convocatoriaId) {
        Optional<ConvocatoriaInformacionDetalladaProyeccion> respuesta = convocatoriaObtenerREPO.obtenerConvocatoriaInformacionDetallada(convocatoriaId);

        if (respuesta.isEmpty()){
            throw new ReglaDeNegocioException("bad.convocatorioNoExiste", List.of(String.valueOf(convocatoriaId)));
        }

        return new RespuestaHandler<>(200, "ok", "", respuesta.get()).getRespuesta();
    }
}
