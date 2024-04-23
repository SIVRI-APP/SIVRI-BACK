package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.academica.aplicación.puertos.salida.FacultadObtenerREPO;
import edu.unicauca.SivriBackendApp.core.academica.dominio.modelo.Facultad;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.salida.persistencia.entidad.FacultadEntity;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.salida.persistencia.mapper.FacultadInfraMapper;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.salida.persistencia.repositorio.FacultadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class FacultadObtenerAdapter implements FacultadObtenerREPO {
    private final FacultadRepository facultadRepository;
    private final FacultadInfraMapper facultadInfraMapper;

    @Override
    public Optional<Facultad> obtenerPorId(int id) {
        Optional<FacultadEntity> facultad =  facultadRepository.findById(id);

        if (facultad.isEmpty()){
            return Optional.empty();
        }

        return Optional.of(facultadInfraMapper.toModel(facultad.get()));
    }
}
