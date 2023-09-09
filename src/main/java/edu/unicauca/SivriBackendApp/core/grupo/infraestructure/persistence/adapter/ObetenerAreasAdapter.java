package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Area;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.out.ObtenerAreasREPO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.mapper.AreaMapper;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.AreaEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaRepository.IAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ObetenerAreasAdapter implements ObtenerAreasREPO {
    @Autowired
    IAreaRepository areaRepository;

    @Autowired
    AreaMapper areaMapper;

    public Optional<Area> obtenerAreaPorId(int id){
        Optional<AreaEntity> respuestaJpa=areaRepository.findById(id);
        if (respuestaJpa.isPresent()){
            return Optional.of(areaMapper.obtenerModelo(respuestaJpa.get()));

        }
        return Optional.empty();
    }
    @Override
    public List<Area> obtenerAreas() {
        return this.areaRepository.findAll().stream().map(areaEntity -> {
            Area area=areaMapper.obtenerModelo(areaEntity);
            return area;
        }).collect(Collectors.toList());
    }
}
