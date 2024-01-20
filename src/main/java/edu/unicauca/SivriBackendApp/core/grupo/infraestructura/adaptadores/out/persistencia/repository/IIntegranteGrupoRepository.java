package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.IntegranteGrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIntegranteGrupoRepository extends JpaRepository<IntegranteGrupoEntity,Integer> {
}
