package edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

    @Override
    public String toString() {
        return "| Proyecto |" + informacionDetalladaProyecto.getNombre() + " | Organismo | " + organismoPrincipal.getNombre();
    }
}
