package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarProgramas;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.SemilleroProgramaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;

import java.util.List;

public interface ISemilleroProgramaRepository extends JpaRepository<SemilleroProgramaEntity,Long> {
    public List<SemilleroProgramaEntity> findBySemilleroId(int semilleroId);
    @Query(value = "SELECT sp.id,p.nombre " +
            "FROM semillero_programa sp " +
            "INNER JOIN programa p ON sp.idPrograma=p.id " +
            "WHERE sp.semilleroId=(:semilleroId);",nativeQuery = true)
    Page<ListarProgramas> obtenerProgramasxSemilleroId(
            @Param("semilleroId") Integer semilleroId,
            @PageableDefault(size = 10,page = 0,sort = "id") Pageable pageable);

}
