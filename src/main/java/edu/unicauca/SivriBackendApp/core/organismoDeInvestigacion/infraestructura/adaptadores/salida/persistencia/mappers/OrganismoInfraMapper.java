package edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.infraestructura.adaptadores.salida.persistencia.mappers;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.OrganismoDeInvestigacion;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.OrganismoDeInvestigacionEntity;
import org.springframework.stereotype.Component;

@Component
public class OrganismoInfraMapper {

    public OrganismoDeInvestigacion toModelSoloPorId(OrganismoDeInvestigacionEntity entity) {
        OrganismoDeInvestigacion solo = new OrganismoDeInvestigacion();
        solo.setId(entity.getId());

        return solo;
    }
}
