package edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.adapter;

import edu.unicauca.SivriBackendApp.core.semillero.domain.model.IntegranteSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.model.Semillero;
import edu.unicauca.SivriBackendApp.core.semillero.domain.port.out.SemilleroCrearREPO;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.mapper.IntegranteSemilleroMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.mapper.SemilleroMapper;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity.IntegranteSemilleroEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity.SemilleroEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaRepository.IIntegranteSemilleroRepository;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaRepository.ISemilleroRepository;
import org.springframework.stereotype.Component;

@Component
public class SemilleroCrearAdapter implements SemilleroCrearREPO {
    private final ISemilleroRepository semilleroRepository;
    private final IIntegranteSemilleroRepository integranteSemilleroRepository;
    private final SemilleroMapper semilleroMapper;
    private final IntegranteSemilleroMapper integranteSemilleroMapper;

    public SemilleroCrearAdapter(ISemilleroRepository semilleroRepository, IIntegranteSemilleroRepository integranteSemilleroRepository, SemilleroMapper semilleroMapper, IntegranteSemilleroMapper integranteSemilleroMapper) {
        this.semilleroRepository = semilleroRepository;
        this.integranteSemilleroRepository = integranteSemilleroRepository;
        this.semilleroMapper = semilleroMapper;
        this.integranteSemilleroMapper = integranteSemilleroMapper;
    }

    @Override
    public Boolean crear(Semillero nuevoSemillero, IntegranteSemillero integranteSemillero) {
        System.out.println("datos que recibe el adapter "+nuevoSemillero);

        System.out.println("datos integrante: "+integranteSemillero);
        SemilleroEntity objSemilleroEntity=semilleroMapper.obtenerEntity(nuevoSemillero);

        SemilleroEntity semillero=semilleroRepository.save(objSemilleroEntity);
        System.out.println("DATOS GUARDADOS EN LA BD: "+semillero);
        System.out.println("ID DEL semillero: "+semillero.getId());
        System.out.println("id del integrante "+integranteSemillero.getId());
        integranteSemillero.setSemilleroId(semillero.getId());
        IntegranteSemilleroEntity integrante= integranteSemilleroRepository.save(integranteSemilleroMapper.obtenerEntity(integranteSemillero));
        System.out.println("id integrante "+integrante.getIdIntegranteSemillero());
        return semillero.getId() != null && integrante.getIdIntegranteSemillero() != null;

    }


}
