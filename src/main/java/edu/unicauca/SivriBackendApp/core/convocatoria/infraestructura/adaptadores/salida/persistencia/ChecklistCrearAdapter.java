package edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.convocatoria.aplicacion.puertos.salida.ChecklistCrearREPO;
import edu.unicauca.SivriBackendApp.core.convocatoria.dominio.modelos.Checklist;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.mapper.ChecklistInfraMapper;
import edu.unicauca.SivriBackendApp.core.convocatoria.infraestructura.adaptadores.salida.persistencia.repositorio.ChecklistRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ChecklistCrearAdapter implements ChecklistCrearREPO {

    private final ChecklistRepository checklistRepository;
    private final ChecklistInfraMapper checklistInfraMapper;

    @Override
    public void crearChecklist(Checklist model) {
        checklistRepository.save(checklistInfraMapper.toEntity(model));
    }
}
