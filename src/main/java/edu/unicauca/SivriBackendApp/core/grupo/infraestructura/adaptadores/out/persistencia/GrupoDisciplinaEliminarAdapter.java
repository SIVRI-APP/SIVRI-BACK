package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out.GrupoDisciplinaEliminarREPO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.repository.IGrupoDisciplinaRepository;
import org.springframework.stereotype.Component;

@Component
public class GrupoDisciplinaEliminarAdapter implements GrupoDisciplinaEliminarREPO {
    private final IGrupoDisciplinaRepository grupoDisciplinaRepository;
    public GrupoDisciplinaEliminarAdapter(IGrupoDisciplinaRepository grupoDisciplinaRepository) {
        this.grupoDisciplinaRepository = grupoDisciplinaRepository;
    }

    @Override
    public Boolean eliminacionGrupoDisciplinaFisico(long id) {
        grupoDisciplinaRepository.deleteById(id);
        return true;
    }
}
