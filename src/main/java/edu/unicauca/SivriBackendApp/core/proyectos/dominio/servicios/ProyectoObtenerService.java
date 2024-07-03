package edu.unicauca.SivriBackendApp.core.proyectos.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeIdentificacionDeUsuario;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.enums.TipoFinanciacion;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada.ProyectoObtenerCU;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.salida.ProyectoObtenerREPO;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.EstadoProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones.ProyectoInformacionDetalladaProyeccion;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones.ProyectoListarConFiltroProyeccion;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ProyectoObtenerService implements ProyectoObtenerCU {

    /**
     * Adaptadores
     */
    private final ProyectoObtenerREPO proyectoObtenerREPO;

    /**
     *
     * Servicio
     */
    private final ServicioDeIdentificacionDeUsuario servicioDeIdentificacionDeUsuario;

    @Override
    public Respuesta<ProyectoInformacionDetalladaProyeccion> obtenerProyectoInformacionDetallada(long proyectoId) {
        Optional<ProyectoInformacionDetalladaProyeccion> respuesta = proyectoObtenerREPO.obtenerProyectoInformacionDetallada(proyectoId);

        if (respuesta.isEmpty()){
            throw new ReglaDeNegocioException("bad.proyectoNoExiste", List.of(String.valueOf(proyectoId)));
        }

        return new RespuestaHandler<>(200, "ok", "", respuesta.get()).getRespuesta();
    }

    @Override
    public Respuesta<Page<ProyectoListarConFiltroProyeccion>> listarConFiltro(int pageNo, int pageSize, String id, String nombre, EstadoProyecto estado, LocalDate fechaInicio, LocalDate fechaFin, Integer organismoDeInvestigacionId, TipoFinanciacion tipoFinanciacion) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<ProyectoListarConFiltroProyeccion> respuesta;

        // Si es funcionario filtramos todos los registros
        if (servicioDeIdentificacionDeUsuario.esFuncionario()){
            respuesta = proyectoObtenerREPO.listarConFiltro(pageable, id, nombre, estado, fechaInicio, fechaFin, organismoDeInvestigacionId, tipoFinanciacion, null);

        }else{ // Si no es funcionario filtramos solo a los que el usuario pertenece
            respuesta = proyectoObtenerREPO.listarConFiltro(pageable, id, nombre, estado, fechaInicio, fechaFin, organismoDeInvestigacionId, tipoFinanciacion, servicioDeIdentificacionDeUsuario.obtenerUsuario().getId());
        }

        return new RespuestaHandler<>(200, "ok", "", respuesta).getRespuesta();
    }

    @Override
    public Respuesta<Proyecto> obtenerProyecto(long proyectoId) {

        Optional<Proyecto> proyecto = proyectoObtenerREPO.obtenerProyecto(proyectoId);

        if (proyecto.isEmpty()){
            throw new ReglaDeNegocioException("bad.proyectoNoExiste", List.of(String.valueOf(proyectoId)));
        }

        return new RespuestaHandler<>(200, "ok", "", proyecto.get()).getRespuesta();
    }
}
