package edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.academica.domain.model.Facultad;
import edu.unicauca.SivriBackendApp.core.academica.domain.port.out.FacultadObtenerREPO;
import edu.unicauca.SivriBackendApp.core.academica.infraestructure.mapper.FacultadMapper;
import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity.FacultadEntity;
import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaRepository.IFacultadRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class ObtenerFacultadesAdapter implements FacultadObtenerREPO {

    private final IFacultadRepository facultadRepository;

    private final FacultadMapper facultadMapper;


    public ObtenerFacultadesAdapter(IFacultadRepository facultadRepository, FacultadMapper facultadMapper) {
        this.facultadRepository = facultadRepository;
        this.facultadMapper = facultadMapper;
    }

    @Override
    public Boolean existePorId(int id) {
        return facultadRepository.existsById(id);
    }

    @Override
    public Optional<Facultad> obtenerPorId(int id) {
        Optional<FacultadEntity> respuestaJpa= facultadRepository.findById(id);
        if (respuestaJpa.isPresent()) {
            return Optional.of(facultadMapper.obtenerModelo(respuestaJpa.get()));
        }
        return Optional.empty();
    }

    @Override
    public List<Facultad> obtenerFacultades() {
        return this.facultadRepository.findAll().stream().map(
                facultadEntity -> {
                    Facultad facultad=facultadMapper.obtenerModelo(facultadEntity);
                    return facultad;
                }).collect(Collectors.toList());

    }
}
