package edu.unicauca.SivriBackendApp.core.proyectos.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.core.convocatoria.aplicacion.puertos.entrada.ConvocatoriaObtenerCU;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Convocatoria;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.OrganismoDeInvestigacion;
import edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.aplicacion.puertos.salida.OrganismoObtenerREPO;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.entrada.*;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.salida.ProyectoCrearREPO;
import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.salida.ProyectoObtenerREPO;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.RolProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.EstadoProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.RolProyectoEnum;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.servicios.utils.CrearProyectoUtils;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.servicios.validadores.IntegranteValidator;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.servicios.validadores.ProyectoValidators;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.entrada.rest.dto.entrada.CrearProyectoDTO;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.entrada.rest.dto.entrada.GuardarProyectoDTO;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.ProyectoEntity;
import edu.unicauca.SivriBackendApp.core.usuario.aplicacion.puertos.entrada.UsuarioObtenerCU;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProyectoCrearService implements ProyectoCrearCU {

    /**
     * Validadores
     */
    private final ProyectoValidators proyectoValidators;
    private final IntegranteValidator integranteValidator;


    /**
     * Adaptadores
     */
    private final ProyectoCrearREPO proyectoCrearREPO;
    private final ProyectoObtenerREPO proyectoObtenerREPO;
    private final OrganismoObtenerREPO organismoObtenerREPO;

    /**
     * Utils
     */
    private CrearProyectoUtils crearProyectoUtils;

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
        nuevoProyecto.setEstado(EstadoProyecto.FORMULADO);
        nuevoProyecto.setNombre(proyecto.getNombre());

        Proyecto proyectoCreado = proyectoCrearREPO.crearProyecto(nuevoProyecto);

        Proyecto pro = proyectoObtenerCU.obtenerProyecto(proyectoCreado.getId()).getData();

        Optional<OrganismoDeInvestigacion> organismoDeInvestigacion = organismoObtenerREPO.findById(proyecto.getOrganismoDeInvestigacionId());
        if (organismoDeInvestigacion.isEmpty()) {
            throw new ReglaDeNegocioException("bad.noSeEncontroOrganismo", List.of(String.valueOf(proyecto.getOrganismoDeInvestigacionId())));
        }

        // Crear Cooperación
        cooperacionCrearCU.crearCooperacion(pro, organismoDeInvestigacion.get(), true);

        // Obtener Rol Director de Proyecto
        RolProyecto rol = rolObtenerCU.obtenerRolPorId(1).getData();

        // Crear Integrante Proyecto
        integranteCrearCU.crear(usuarioObtenerCU.obtenerUsuario(proyecto.getDirectorDeProyectoId()).getData(), pro, rol);

        return new RespuestaHandler<>(200, "ok.ProyectoCreado", List.of(pro.getNombre()), "", true).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> agregarIntegrante(Long proyectoId, Long usuarioId, RolProyectoEnum rolId) {

        // Obtener Proyecto
        Proyecto proyecto = proyectoObtenerCU.obtenerProyecto(proyectoId).getData();

        // Obtener Usuario
        Usuario usuario = usuarioObtenerCU.obtenerUsuario(usuarioId).getData();

        // Obtener Rol
        RolProyecto rol = rolObtenerCU.obtenerRolPorEnum(rolId).getData();

        // Crear Integrante Proyecto
        integranteCrearCU.crear(usuario, proyecto, rol);

        return new RespuestaHandler<>(200, "ok.asociarIntegranteProyecto", List.of(usuario.getNombre(), proyecto.getNombre(), rol.getNombre().toString()), "", true).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> formalizarProyecto(Proyecto proyecto) {

        // Validaciones
        proyectoValidators.validarFormalizarProyecto(proyecto);

        proyectoCrearREPO.formalizarProyecto(proyecto);

        return new RespuestaHandler<>(200, "ok.detallesDelProyectoActualizadoCorrectamente", List.of(proyecto.getNombre()), "", true).getRespuesta();
    }

    @Override
    public Respuesta<Boolean> guardarProyecto(GuardarProyectoDTO proyecto) {
        // Validaciones
        ProyectoEntity oldProyecto = proyectoValidators.validarGuardarProyecto(proyecto);

        // Guardar Información general
        crearProyectoUtils.guardarProyecto(oldProyecto, proyecto);



        return new RespuestaHandler<>(200, "ok.guardarCambiosProyecto", List.of(proyecto.getInformacionGeneral().getNombre()), "", true).getRespuesta();
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
