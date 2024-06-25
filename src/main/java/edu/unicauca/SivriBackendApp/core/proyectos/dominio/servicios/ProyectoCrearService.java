package edu.unicauca.SivriBackendApp.core.proyectos.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.convocatoria.aplicacion.puertos.entrada.ConvocatoriaObtenerCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Convocatoria;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.OrganismoDeInvestigacion;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada.*;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.salida.ProyectoCrearREPO;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.RolProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.validadores.ProyectoValidators;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.entrada.rest.dto.entrada.CrearProyectoDTO;
import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.entrada.UsuarioObtenerCU;
import jakarta.transaction.Transactional;
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
    private final CooperacionCrearCU cooperacionCrearCU;
    private final RolObtenerCU rolObtenerCU;
    private final IntegranteCrearCU integranteCrearCU;
    private final UsuarioObtenerCU usuarioObtenerCU;

    @Transactional
    @Override
    public Respuesta<Boolean> crearProyecto(CrearProyectoDTO proyecto) {

        // Validaciones
        proyectoValidators.validarCreacionDeProyecto(proyecto.getNombre());

        // Crear Proyecto
        Proyecto nuevoProyecto = new Proyecto();
        nuevoProyecto.setNombre(proyecto.getNombre());
        Proyecto proyectoCreado = proyectoCrearREPO.crearProyecto(nuevoProyecto);
        Proyecto pro = proyectoObtenerCU.obtenerProyecto(proyectoCreado.getId()).getData();

        // Todo miguel Obtener Organismo de Investigacion
        OrganismoDeInvestigacion organismoDeInvestigacion = new OrganismoDeInvestigacion();

        // Crear Cooperación
        cooperacionCrearCU.crearCooperacion(pro, organismoDeInvestigacion, true);

        // Obtener Rol Proyecto
        RolProyecto rol = rolObtenerCU.obtenerRolPorId(1).getData();

        // Crear Integrante Proyecto
        integranteCrearCU.crear(usuarioObtenerCU.obtenerUsuario(proyecto.getDirectorDeProyectoId()).getData(), pro, rol);

        return new RespuestaHandler<>(200, "ok.ProyectoCreado", List.of(pro.getNombre()), "", true).getRespuesta();
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
