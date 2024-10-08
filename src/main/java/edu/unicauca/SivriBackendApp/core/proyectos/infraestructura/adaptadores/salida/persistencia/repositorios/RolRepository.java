package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.repositorios;

import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.RolProyectoEnum;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.proyecciones.RolProyectoListarProyeccion;
import edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades.RolProyectoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RolRepository extends JpaRepository<RolProyectoEntity, Long> {

    Optional<RolProyectoEntity> findByNombre(RolProyectoEnum nombre);

    @Query("SELECT DISTINCT rol " +
            "FROM RolProyectoEntity rol "
    )
    List<RolProyectoListarProyeccion> retornarRoles();

    List<RolProyectoEntity> findAll();

    @Query(value = "SELECT COUNT(p.ID)  " +
            "FROM PROYECTO p " +
            "INNER JOIN INTEGRANTE_PROYECTO ip ON ip.PROYECTO_ID = p.ID " +
            "INNER JOIN ROL_PROYECTO rp ON ip.ROL_ID = rp.ID " +
            "WHERE rp.NOMBRE = 'DIRECTOR' AND p.ID = :proyectoId"
    , nativeQuery = true)
    int tieneDirector(long proyectoId);

}
