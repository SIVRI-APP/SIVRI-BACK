package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.repositorios;

import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.CooperacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CooperacionRepository extends JpaRepository<CooperacionEntity, Long> {

    List<CooperacionEntity> findAllByProyectoId(long proyectoId);
}
