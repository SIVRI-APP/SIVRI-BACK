package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaRepository;

import edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity.GrupoDisciplinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGrupoDisciplinaRepository extends JpaRepository<GrupoDisciplinaEntity, Long> {
    public List<GrupoDisciplinaEntity> findByGrupoId(int grupoId);
}
