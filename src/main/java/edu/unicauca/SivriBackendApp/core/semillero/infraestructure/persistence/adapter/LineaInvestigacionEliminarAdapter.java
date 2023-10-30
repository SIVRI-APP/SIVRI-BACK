package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.semillero.domain.model.LineaInvestigacion;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.out.LineaInvestigacionEliminarREPO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.mapper.LineaInvestigacionMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaRepository.ILineaInvestigacionRepository;
import org.springframework.stereotype.Component;

@Component
public class LineaInvestigacionEliminarAdapter implements LineaInvestigacionEliminarREPO {
    private final ILineaInvestigacionRepository lineaInvestigacionRepository;
    private final LineaInvestigacionMapper lineaInvestigacionMapper;

    public LineaInvestigacionEliminarAdapter(ILineaInvestigacionRepository lineaInvestigacionRepository, LineaInvestigacionMapper lineaInvestigacionMapper) {
        this.lineaInvestigacionRepository = lineaInvestigacionRepository;
        this.lineaInvestigacionMapper = lineaInvestigacionMapper;
    }

    @Override
    public Boolean eliminadoFisico(LineaInvestigacion lineaEliminar) {
        lineaInvestigacionRepository.delete(lineaInvestigacionMapper.obtenerEntity(lineaEliminar));
        return true;
    }

    @Override
    public Boolean eliminadoFisicoLinea(int id) {
        lineaInvestigacionRepository.deleteById(id);
        return true;
    }
}
