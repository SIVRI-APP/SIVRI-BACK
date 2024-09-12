package edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.aplicacion.puertos.entrada;


import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.dominio.modelos.proyecciones.ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion;
import edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.dominio.modelos.proyecciones.ListarOrganismosParaAsociarProyectoProyeccion;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface OrganismoObtenerCU {

    Respuesta<Page<ListarOrganismosParaAsociarProyectoProyeccion>> listarConFiltro(int pageNo, int pageSize, String tipoOrganismo, Integer id, String nombre);

    Respuesta<Optional<ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion>> listarIntegrantesDocenteOrganismo(Integer organismoId);

    Respuesta<Optional<ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion>> listarIntegrantesOrganismo(Integer organismoId);
}
