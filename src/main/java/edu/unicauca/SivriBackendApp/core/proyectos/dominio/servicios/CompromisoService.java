package edu.unicauca.SivriBackendApp.core.proyectos.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada.CompromisosCU;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada.ProyectoObtenerCU;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.salida.CompromisoREPO;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones.PrepararAgregarCompromisoDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompromisoService implements CompromisosCU {

    /**
     * Adaptadores
     */
    private final CompromisoREPO compromisoREPO;

    /** Servicios */
    private final ProyectoObtenerCU proyectoObtenerCU;


    @Override
    public Respuesta<PrepararAgregarCompromisoDTO> prepararAgregarCompromiso(long proyectoId) {
        PrepararAgregarCompromisoDTO prepararAgregarCompromisoDTO = compromisoREPO.prepararAgregarCompromiso(proyectoId);

        return new RespuestaHandler<>(200, "ok", "", prepararAgregarCompromisoDTO).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> agregarCompromiso(long proyectoId, long integranteId, int productoEnumId) {

        Proyecto proyecto = proyectoObtenerCU.obtenerProyecto(proyectoId).getData();


        boolean respuesta = compromisoREPO.agregarCompromiso(proyecto, integranteId, productoEnumId);

        return new RespuestaHandler<>(200, "ok.compromiso.asociado", "", respuesta).getRespuesta();
    }
}
