package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.grupo.application.mapper.DisciplinaDtoMapper;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Disciplina;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.out.SubAreaObtenerREPO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.mapper.DisciplinaMapper;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.DisciplinaEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.SubAreaEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaRepository.ISubAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
public class ObtenerSubAreaAdapter implements SubAreaObtenerREPO {
    @Autowired
    ISubAreaRepository subAreaRepository;
    @Autowired
    DisciplinaMapper disciplinaMapper;
    @Override
    public List<Disciplina> obtenerDisciplinaPorIdSubArea(int idSubArea) {
        System.out.println("entro metodo");
        Optional<SubAreaEntity> respuestaJpa=subAreaRepository.findById(idSubArea);
        List<Disciplina> listaDisciplinas=new LinkedList<>();

        if (respuestaJpa.isPresent()){
            SubAreaEntity objSubAreaObtenida=respuestaJpa.get();
            List<DisciplinaEntity> disciplinas=objSubAreaObtenida.getDisciplinas();
            System.out.println("datos111 "+disciplinas);
            listaDisciplinas=disciplinaMapper.obtenerModelo(disciplinas);
            System.out.println("despues del mapeo "+listaDisciplinas);

        }
        return listaDisciplinas;
    }
}
