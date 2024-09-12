package edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.aplicacion.puertos.salida;

import edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.dominio.modelos.proyecciones.ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion;
import edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.dominio.modelos.proyecciones.ListarOrganismosParaAsociarProyectoProyeccion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface OrganismoObtenerREPO {

    Page<ListarOrganismosParaAsociarProyectoProyeccion> listarConFiltro(Pageable page, String tipoOrganismo, Integer id, String nombre, Long usuarioAutenticadoId);

    Optional<ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion> listarIntegrantesDocenteOrganismo(Integer organismoId);

    Optional<ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion> listarIntegrantesOrganismo(Integer organismoId);
}
