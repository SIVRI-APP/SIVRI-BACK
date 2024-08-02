package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out.SubAreaObtenerREPO;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Disciplina;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.DisciplinaEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.SubAreaEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.mapper.DisciplinaMapper;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.repository.ISubAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
public class ObtenerSubAreaAdapter implements SubAreaObtenerREPO {

    private final ISubAreaRepository subAreaRepository;

    private final DisciplinaMapper disciplinaMapper;

    public ObtenerSubAreaAdapter(ISubAreaRepository subAreaRepository, DisciplinaMapper disciplinaMapper) {
        this.subAreaRepository = subAreaRepository;
        this.disciplinaMapper = disciplinaMapper;
    }

    @Override
    public List<Disciplina> obtenerDisciplinaPorIdSubArea(int idSubArea) {
        Optional<SubAreaEntity> respuestaJpa=subAreaRepository.findById(idSubArea);
        List<Disciplina> listaDisciplinas=new LinkedList<>();

        if (respuestaJpa.isPresent()){
            SubAreaEntity objSubAreaObtenida=respuestaJpa.get();
            List<DisciplinaEntity> disciplinas=objSubAreaObtenida.getDisciplinas();
            listaDisciplinas=disciplinaMapper.obtenerModelo(disciplinas);
        }
        return listaDisciplinas;
    }
}
