package edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProyectoDetalladoDTO {

    private ProyectoOrganismoProyeccion organismoPrincipal;
    private ProyectoInformacionDetalladaProyeccion informacionDetalladaProyecto;
    private ProyectoConvocatoriaProyeccion convocatoriaProyecto;
    private ProyectoEvidenciasDocumentosProyeccion evidenciasDocumentosProyecto;
    private ProyectoIntegrantesProyeccion integrantesProyecto;
    private ProyectoCompromisosProyeccion compromisosProyecto;

}
