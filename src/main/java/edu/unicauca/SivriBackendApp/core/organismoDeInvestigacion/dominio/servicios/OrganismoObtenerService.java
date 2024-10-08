package edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.dominio.servicios;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.common.respuestaGenerica.handler.RespuestaHandler;
import edu.unicauca.SivriBackendApp.common.seguridad.acceso.service.ServicioDeIdentificacionDeUsuario;
import edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.aplicacion.puertos.entrada.OrganismoObtenerCU;
import edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.aplicacion.puertos.salida.OrganismoObtenerREPO;
import edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.dominio.modelos.proyecciones.ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion;
import edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.dominio.modelos.proyecciones.ListarOrganismosParaAsociarProyectoProyeccion;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class OrganismoObtenerService implements OrganismoObtenerCU {

    /**
     * Adaptadores
     */
    private final OrganismoObtenerREPO organismoObtenerREPO;

    /**
     *
     * Servicio
     */
    private final ServicioDeIdentificacionDeUsuario servicioDeIdentificacionDeUsuario;


    @Override
    public Respuesta<Page<ListarOrganismosParaAsociarProyectoProyeccion>> listarConFiltro(int pageNo, int pageSize, String tipoOrganismo, Integer id, String nombre) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<ListarOrganismosParaAsociarProyectoProyeccion> respuesta;

        // Si es funcionario filtramos todos los registros
        if (servicioDeIdentificacionDeUsuario.esFuncionario()){
            respuesta = organismoObtenerREPO.listarConFiltro(pageable, tipoOrganismo, id, nombre, null);

        }else{ // Si no es funcionario filtramos solo a los que el usuario pertenece
            respuesta = organismoObtenerREPO.listarConFiltro(pageable, tipoOrganismo, id, nombre, servicioDeIdentificacionDeUsuario.obtenerUsuario().getId());
        }

        return new RespuestaHandler<>(200, "ok", "", respuesta).getRespuesta();
    }

    @Override
    public Respuesta<Optional<ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion>> listarIntegrantesDocenteOrganismo(Integer organismoId) {

        Optional<ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion> respuesta = organismoObtenerREPO.listarIntegrantesDocenteOrganismo(organismoId);

        return new RespuestaHandler<>(200, "ok", "", respuesta).getRespuesta();
    }

    @Override
    public Respuesta<Optional<ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion>> listarIntegrantesOrganismo(Integer organismoId, long proyectoId) {

        Optional<ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion> respuesta = organismoObtenerREPO.listarIntegrantesOrganismo(organismoId, proyectoId);

        return new RespuestaHandler<>(200, "ok", "", respuesta).getRespuesta();
    }
}
