package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia;

import edu.unicauca.SivriBackendApp.core.proyectos.aplicacion.puertos.salida.IntegranteCrearREPO;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.IntegranteProyecto;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.mapper.IntegranteInfraMapper;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.repositorios.IntegranteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class IntegranteCrearAdapter implements IntegranteCrearREPO {

    private final IntegranteRepository integranteRepository;
    private final IntegranteInfraMapper integranteInfraMapper;

    @Override
    public void crear(IntegranteProyecto nuevoRegistro) {
        integranteRepository.save(integranteInfraMapper.fromModelToEntity(nuevoRegistro));
    }
}
