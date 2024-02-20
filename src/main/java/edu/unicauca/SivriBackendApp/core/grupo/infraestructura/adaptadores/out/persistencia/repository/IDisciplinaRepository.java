package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.DisciplinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDisciplinaRepository extends JpaRepository<DisciplinaEntity,Integer> {
}
