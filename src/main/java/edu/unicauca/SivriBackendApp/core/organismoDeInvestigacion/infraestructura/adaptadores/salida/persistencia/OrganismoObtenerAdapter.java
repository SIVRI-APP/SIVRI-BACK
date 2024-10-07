package edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.OrganismoDeInvestigacion;
import edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.aplicacion.puertos.salida.OrganismoObtenerREPO;
import edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.dominio.modelos.proyecciones.ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion;
import edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.dominio.modelos.proyecciones.ListarOrganismosParaAsociarProyectoProyeccion;
import edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.infraestructura.adaptadores.salida.persistencia.mappers.OrganismoInfraMapper;
import edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.infraestructura.adaptadores.salida.persistencia.repositorios.OrganismoRepository;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.OrganismoDeInvestigacionEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class OrganismoObtenerAdapter implements OrganismoObtenerREPO {

    private final OrganismoRepository organismoRepository;
    private final OrganismoInfraMapper organismoInfraMapper;

    @Override
    public Page<ListarOrganismosParaAsociarProyectoProyeccion> listarConFiltro(Pageable page, String tipoOrganismo, Integer id, String nombre, Long usuarioAutenticadoId) {

        if (tipoOrganismo.equals("GRUPO")){
            return organismoRepository.listarConFiltroGrupo(id, nombre, usuarioAutenticadoId, page);
        } else {
            return organismoRepository.listarConFiltroSemillero(id, nombre, usuarioAutenticadoId, page);
        }
    }

    @Override
    public Optional<ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion> listarIntegrantesDocenteOrganismo(Integer organismoId) {

        if (organismoRepository.isGrupo(organismoId) > 0){
            System.out.println("Es Grupo");
            return organismoRepository.listarConFiltroIntegrantesDocenteGrupo(organismoId);

        }else  {
            System.out.println("Es Semillero");
            return organismoRepository.listarConFiltroIntegrantesDocenteSemillero(organismoId);
        }
    }

    @Override
    public Optional<ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion> listarIntegrantesOrganismo(Integer organismoId) {

        if (organismoRepository.isGrupo(organismoId) > 0){
            return organismoRepository.listarConFiltroIntegrantesGrupo(organismoId);

        }else  {
            return organismoRepository.listarConFiltroIntegrantesSemillero(organismoId);
        }
    }

    @Override
    public Optional<OrganismoDeInvestigacion> findById(Integer id) {
        Optional<OrganismoDeInvestigacionEntity> org = organismoRepository.findById(id);

        if (org.isEmpty()){
            return Optional.empty();

        }
        return Optional.of(organismoInfraMapper.toModelSoloPorId(org.get()));
    }
}
