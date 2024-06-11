package edu.unicauca.SivriBackendApp.core.proyectos.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.convocatoria.aplicacion.puertos.entrada.ConvocatoriaObtenerCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Convocatoria;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada.ProyectoCrearCU;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada.ProyectoObtenerCU;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.salida.ProyectoCrearREPO;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.EstadoProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.validadores.ProyectoValidators;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProyectoCrearService implements ProyectoCrearCU {

    /**
     * Validadores
     */
    private final ProyectoValidators proyectoValidators;


    /**
     * Adaptadores
     */
    private final ProyectoCrearREPO proyectoCrearREPO;

    /**
     *
     * Servicios
     */
    private final ProyectoObtenerCU proyectoObtenerCU;
    private final ConvocatoriaObtenerCU convocatoriaObtenerCU;

    @Override
    public Respuesta<Boolean> crearProyecto(Proyecto proyecto) {

        // Validaciones
        proyectoValidators.validarCreacionDeProyecto(proyecto);

        // Persistir Proyecto
        proyecto.setEstado(EstadoProyecto.FORMULADO);
        Proyecto nuevoProyecto = proyectoCrearREPO.crearProyecto(proyecto);

        return new RespuestaHandler<>(200, "ok.ProyectoCreado", List.of(nuevoProyecto.getNombre()), "", true).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> asociarConvocatoria(long proyectoId, long convocatoriaId) {

        // Validaciones
        proyectoValidators.validarAsociacionDeConvocatoria(proyectoId, convocatoriaId);

        // Obtener Convocatoria
        Convocatoria convocatoria = convocatoriaObtenerCU.obtenerConvocatoria(convocatoriaId).getData();

        // Obtener Proyecto y actualizar proyecto
        Proyecto proyecto = proyectoObtenerCU.obtenerProyecto(proyectoId).getData();
        proyecto.setConvocatoria(convocatoria);

        proyectoCrearREPO.crearProyecto(proyecto);

        return new RespuestaHandler<>(200, "ok.asociar.proyecto.convocatoria", List.of(proyecto.getNombre(), convocatoria.getNombre()), "", true).getRespuesta();
    }
}
