package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia;


import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.EvidenciaProyectoDocumentoConvocatoriaEntity;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.repositorios.EvidenciaProyectoDocumentoConvocatoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class EvidenciaProyectoDocumentoConvocatoriaAdapter {

    private final EvidenciaProyectoDocumentoConvocatoriaRepository evidenciaProyectoDocumentoConvocatoriaRepository;

    public EvidenciaProyectoDocumentoConvocatoriaEntity guardar(EvidenciaProyectoDocumentoConvocatoriaEntity evidencia) {
        return evidenciaProyectoDocumentoConvocatoriaRepository.save(evidencia);
    }

}
