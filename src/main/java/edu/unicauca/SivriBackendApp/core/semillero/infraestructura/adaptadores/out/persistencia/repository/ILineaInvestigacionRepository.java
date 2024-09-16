package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarLineasInvestigacion;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.LineaInvestigacionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ILineaInvestigacionRepository extends JpaRepository<LineaInvestigacionEntity,Integer> {
    public List<LineaInvestigacionEntity> findBySemilleroId(int semilleroId);

     @Query(value = "select * from linea_investigacion li " +
            "where li.semilleroId=(:semilleroId);",nativeQuery = true)
    public Page<List<ListarLineasInvestigacion>> obtenerLineaxSemilleroId(@Param("semilleroId") int semilleroId,
                                                                          @PageableDefault(size = 10,page = 0,sort = "id") Pageable pageable);
}
