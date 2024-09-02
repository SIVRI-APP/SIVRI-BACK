package edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ProyectoInformacionDetalladaDTO {

    private ProyectoInformacionDetalladaProyeccion informacionDetallada;
    private Set<EvidenciasDocumentosConvocatoriaProyeccion> evidenciasDocumentosConvocatoria;

    public ProyectoInformacionDetalladaDTO() {
    }
}
