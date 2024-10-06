package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.repositorios;

import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.IntegranteProyectoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  IntegranteRepository extends JpaRepository<IntegranteProyectoEntity, Long> {

    List<IntegranteProyectoEntity> findAllByUsuarioIdAndProyectoIdAndRolProyectoId(Long usuarioId, Long proyectoId, Integer rolProyectoId);

    List<IntegranteProyectoEntity> findAllByProyectoIdAndRolProyectoId(Long proyectoId, Integer rolProyectoId);

}
