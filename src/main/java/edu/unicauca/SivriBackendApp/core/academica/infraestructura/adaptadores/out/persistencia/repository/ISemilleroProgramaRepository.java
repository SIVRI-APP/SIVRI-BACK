package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.entity.SemilleroProgramaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISemilleroProgramaRepository extends JpaRepository<SemilleroProgramaEntity,Long> {
    public List<SemilleroProgramaEntity> findBySemilleroId(int semilleroId);

}
