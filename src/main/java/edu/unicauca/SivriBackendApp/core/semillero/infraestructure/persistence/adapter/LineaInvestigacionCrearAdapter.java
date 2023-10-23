package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.semillero.domain.model.LineaInvestigacion;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.out.LineaInvestigacionCrearREPO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.mapper.LineaInvestigacionMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaRepository.ILineaInvestigacionRepository;
import org.springframework.stereotype.Component;

@Component
public class LineaInvestigacionCrearAdapter implements LineaInvestigacionCrearREPO {
    private final ILineaInvestigacionRepository lineaInvestigacionRepository;
    private final LineaInvestigacionMapper lineaInvestigacionMapper;

    public LineaInvestigacionCrearAdapter(ILineaInvestigacionRepository lineaInvestigacionRepository, LineaInvestigacionMapper lineaInvestigacionMapper) {
        this.lineaInvestigacionRepository = lineaInvestigacionRepository;
        this.lineaInvestigacionMapper = lineaInvestigacionMapper;
    }

    @Override
    public Boolean crear(LineaInvestigacion nuevaLinea) {

        lineaInvestigacionRepository.save(lineaInvestigacionMapper.obtenerEntity(nuevaLinea));
        return true;
    }
}
