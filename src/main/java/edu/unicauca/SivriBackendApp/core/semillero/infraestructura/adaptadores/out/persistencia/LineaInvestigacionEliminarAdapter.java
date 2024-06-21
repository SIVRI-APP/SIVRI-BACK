package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.semillero.aplicación.ports.out.LineaInvestigacionEliminarREPO;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.LineaInvestigacion;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.mapper.LineaInvestigacionMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository.ILineaInvestigacionRepository;
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
