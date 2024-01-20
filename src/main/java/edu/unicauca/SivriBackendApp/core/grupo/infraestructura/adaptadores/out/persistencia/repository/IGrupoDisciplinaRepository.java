package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.GrupoDisciplinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGrupoDisciplinaRepository extends JpaRepository<GrupoDisciplinaEntity, Long> {
    public List<GrupoDisciplinaEntity> findByGrupoId(int grupoId);
}
