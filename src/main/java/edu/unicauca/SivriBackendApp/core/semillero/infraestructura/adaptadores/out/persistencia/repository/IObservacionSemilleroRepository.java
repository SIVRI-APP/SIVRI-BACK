package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarObservacionesPorIdSemillero;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.ObservacionSemilleroEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObservacionSemilleroRepository extends JpaRepository<ObservacionSemilleroEntity, Integer> {
    @Query(value = "SELECT os.id,os.observacion, CONCAT_WS(' ', u.nombre, u.apellido) AS usuario, os.fecha " +
            "FROM observacion_semillero os " +
            "       INNER JOIN funcionario f ON f.id = os.funcionarioId " +
            "       INNER JOIN usuario u ON u.id = f.usuarioId " +
            "    WHERE " +
            "       os.semilleroId = (:semilleroId);",nativeQuery = true)
    Page<List<ListarObservacionesPorIdSemillero>> listarObservacionesPorIdSemillero(
        @Param("semilleroId") int semilleroId,
        @PageableDefault(size = 10,page = 0,sort = "id") Pageable pageable
    );

}
