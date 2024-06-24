package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.semillero.aplicacion.ports.out.LineaInvestigacionActualizarREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.LineaInvestigacion;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper.LineaInvestigacionMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository.ILineaInvestigacionRepository;
import org.springframework.stereotype.Component;

@Component
public class LineaInvestigacionActualizarAdapter implements LineaInvestigacionActualizarREPO {
    private final ILineaInvestigacionRepository lineaInvestigacionRepository;
    private final LineaInvestigacionMapper lineaInvestigacionMapper;

    public LineaInvestigacionActualizarAdapter(ILineaInvestigacionRepository lineaInvestigacionRepository, LineaInvestigacionMapper lineaInvestigacionMapper) {
        this.lineaInvestigacionRepository = lineaInvestigacionRepository;
        this.lineaInvestigacionMapper = lineaInvestigacionMapper;
    }

    @Override
    public Boolean actualizarLinea(LineaInvestigacion nuevaLinea) {
        lineaInvestigacionRepository.save(lineaInvestigacionMapper.obtenerEntity(nuevaLinea));
        return true;
    }
}
