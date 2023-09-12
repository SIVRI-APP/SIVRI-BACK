package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.grupo.application.mapper.SubAreaDtoMapper;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.Area;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.SubArea;
import edu.unicauca.SivriBackendApp.core.grupo.domain.port.out.ObtenerAreasREPO;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.mapper.AreaMapper;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.AreaEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.SubAreaEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaRepository.IAreaRepository;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaRepository.ISubAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ObetenerAreasAdapter implements ObtenerAreasREPO {
    @Autowired
    IAreaRepository areaRepository;

    //@Autowired
    //ISubAreaRepository subAreaRepository;
    @Autowired
    AreaMapper areaMapper;

    @Autowired
    SubAreaDtoMapper subAreaMapper;

    public Optional<Area> obtenerAreaPorId(int id){
        Optional<AreaEntity> respuestaJpa=areaRepository.findById(id);
        if (respuestaJpa.isPresent()){
            return Optional.of(areaMapper.obtenerModelo(respuestaJpa.get()));

        }
        return Optional.empty();
    }

    @Override
    public List<SubArea> obtenerSubAreaPorIdArea(int idArea) {

        Optional<AreaEntity> respuestaJpa=areaRepository.findById(idArea);
        List<SubArea> listaSubAreas=new LinkedList<>();
        if (respuestaJpa.isPresent()){
            AreaEntity objAreaObtenida=respuestaJpa.get();
            List<SubAreaEntity> subAreas=objAreaObtenida.getSubareas();
            listaSubAreas= subAreaMapper.dtoObtenerSubAreas(subAreas);
        }
        return listaSubAreas;
    }

    @Override
    public List<Area> obtenerAreas() {
        return this.areaRepository.findAll().stream().map(areaEntity -> {
            Area area=areaMapper.obtenerModelo(areaEntity);
            return area;
        }).collect(Collectors.toList());
    }
}
