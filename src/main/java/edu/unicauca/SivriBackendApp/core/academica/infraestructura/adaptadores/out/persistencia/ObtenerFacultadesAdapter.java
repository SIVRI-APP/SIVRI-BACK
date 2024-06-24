package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia;

import edu.unicauca.SivriBackendApp.common.exception.ReglaDeNegocioException;
import edu.unicauca.SivriBackendApp.core.academica.aplicacion.ports.out.FacultadObtenerREPO;
import edu.unicauca.SivriBackendApp.core.academica.dominio.modelos.Facultad;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.entity.FacultadEntity;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.mapper.FacultadMapper;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.repository.FacultadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
@AllArgsConstructor
public class ObtenerFacultadesAdapter implements FacultadObtenerREPO {

    private final FacultadRepository facultadRepository;

    private final FacultadMapper facultadMapper;


    @Override
    public Boolean existePorId(int id) {
        return facultadRepository.existsById(id);
    }

    @Override
    public Optional<Facultad> obtenerPorId(int id) {
        Optional<FacultadEntity> respuestaJpa = facultadRepository.findById(id);
        if (respuestaJpa.isEmpty()) {
            throw new ReglaDeNegocioException("bad.no.se.encontro.facultad", List.of(String.valueOf(id)));
        }
        return Optional.of(facultadMapper.obtenerModelo(respuestaJpa.get()));
    }

    @Override
    public List<Facultad> obtenerFacultades() {
        return this.facultadRepository.findAll().stream().map(
                facultadMapper::obtenerModelo).collect(Collectors.toList());

    }
}
