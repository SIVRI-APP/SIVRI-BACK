package edu.unicauca.SivriBackendApp.core.convocatoria.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.convocatoria.aplicacion.puertos.entrada.ConvocatoriaObtenerCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.aplicacion.puertos.salida.ConvocatoriaObtenerREPO;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Convocatoria;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.ConvocatoriaEstado;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.TipoFinanciacion;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.proyecciones.ConvocatoriaInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.proyecciones.ConvocatoriaListarConFiltroProyeccion;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Respuesta<Page<ConvocatoriaListarConFiltroProyeccion>> listarConFiltro(int pageNo, int pageSize, String id, String nombre, ConvocatoriaEstado estado, TipoFinanciacion tipoFinanciacion) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<ConvocatoriaListarConFiltroProyeccion> respuesta = convocatoriaObtenerREPO.listarConFiltro(pageable, id, nombre, estado, tipoFinanciacion);

        return new RespuestaHandler<>(200, "ok", "", respuesta).getRespuesta();
    }

    @Override
    public Respuesta<Convocatoria> obtenerConvocatoria(long convocatoriaId) {

        Optional<Convocatoria> convocatoria = convocatoriaObtenerREPO.obtenerConvocatoria(convocatoriaId);

        if (convocatoria.isEmpty()){
            throw new ReglaDeNegocioException("bad.convocatorioNoExiste", List.of(String.valueOf(convocatoriaId)));
        }

        return new RespuestaHandler<>(200, "ok", "", convocatoria.get()).getRespuesta();
    }
}
