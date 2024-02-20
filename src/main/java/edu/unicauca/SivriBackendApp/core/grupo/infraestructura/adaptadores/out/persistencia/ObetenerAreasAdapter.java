package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out.AreasObtenerREPO;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.Area;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.SubArea;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.mapper.SubAreaDtoMapper;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.AreaEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.GrupoEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.SubAreaEntity;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.mapper.AreaMapper;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.repository.IAreaRepository;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.repository.IGrupoRepository;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ObetenerAreasAdapter implements AreasObtenerREPO {

    private final IAreaRepository areaRepository;

    private final AreaMapper areaMapper;

    private final SubAreaDtoMapper subAreaMapper;
    //degrupo
      private final IGrupoRepository grupoRepository;

    public ObetenerAreasAdapter(IAreaRepository areaRepository, AreaMapper areaMapper, SubAreaDtoMapper subAreaMapper, IGrupoRepository grupoRepository) {
        this.areaRepository = areaRepository;
        this.areaMapper = areaMapper;
        this.subAreaMapper = subAreaMapper;
        this.grupoRepository = grupoRepository;
    }
    //de grupo
    public Optional<Area> obtenerAreaPorId(int id){
        //de grupo
       Optional<GrupoEntity> respuestaJpagrupo=grupoRepository.findById(id);
        if (respuestaJpagrupo.isPresent()){
            System.out.println("datos de un grupo: "+respuestaJpagrupo.get());
        }
        else{
            System.out.println("grupo");}

        //degrupo
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
