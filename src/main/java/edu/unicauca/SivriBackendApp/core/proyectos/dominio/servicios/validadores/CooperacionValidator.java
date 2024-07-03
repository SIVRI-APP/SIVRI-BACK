package edu.unicauca.SivriBackendApp.core.proyectos.dominio.servicios.validadores;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.OrganismoDeInvestigacion;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.Proyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.CooperacionEntity;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.repositorios.CooperacionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CooperacionValidator {
    private CooperacionRepository cooperacionRepository;

    public void crearCooperacion(Proyecto proyecto, OrganismoDeInvestigacion organismoDeInvestigacion, boolean isPrincipal) {
        List<CooperacionEntity> cooperaciones = cooperacionRepository.findAllByProyectoId(0);

        // Validar que sea el unico principal
        if (isPrincipal){
            boolean yaTienePrincipal = cooperaciones.stream()
                    .anyMatch(CooperacionEntity::getPrincipal);

            if (yaTienePrincipal){
                throw new ReglaDeNegocioException("bad.proyectoCooperacionPrincipal");
            }
        }

        // Todo descomentar cuando Yurani integre lo de Organismos
//        boolean organismoYaCoopera = cooperaciones.stream()
//                .anyMatch(cooperacionEntity ->
//                        cooperacionEntity.getOrganismoDeInvestigacion().getId().equals(organismoDeInvestigacion.getId())
//                );
//
//        if (organismoYaCoopera){
//            throw new ReglaDeNegocioException("bad.OrganismoYaCoopera", List.of(organismoDeInvestigacion.getNombre()));
//        }

    }
}
