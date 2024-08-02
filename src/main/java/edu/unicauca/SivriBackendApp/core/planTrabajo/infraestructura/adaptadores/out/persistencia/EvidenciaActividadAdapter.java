package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.planTrabajo.aplicación.ports.out.EvidenciaActividadREPO;
import edu.unicauca.SivriBackendApp.core.planTrabajo.dominio.modelos.EvidenciaActividad;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.entity.ActividadPlanTrabajoEntity;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.entity.EvidenciaActividadEntity;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.mapper.EvidenciaActividadMapper;
import edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.repository.IEvidenciaActividadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class EvidenciaActividadAdapter implements EvidenciaActividadREPO {
    private final IEvidenciaActividadRepository evidenciaActividadRepository;
    private final EvidenciaActividadMapper evidenciaActividadMapper;

    @Override
    public Integer existexActividadId(int idActividad) {
        Integer idEvidencia= evidenciaActividadRepository.existexActividadId(idActividad);
        return idEvidencia;
    }

    @Override
    public Optional<EvidenciaActividad> obtenerPorId(int id) {
        Optional<EvidenciaActividadEntity> respuestaJpa= evidenciaActividadRepository.findById(id);
        return respuestaJpa.map(evidenciaActividadMapper::obtenerModelo);
    }

    @Override
    public Boolean subirEvidenciaActividad(EvidenciaActividad nuevaEvidencia) {
        EvidenciaActividadEntity evidencia= evidenciaActividadRepository.save(evidenciaActividadMapper.obtenerEntity(nuevaEvidencia));
        return true;
    }
}
