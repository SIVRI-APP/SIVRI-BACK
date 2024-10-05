package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.entity.FacultadEntity;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.entity.ProgramaEntity;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarProgramas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProgramaRepository extends JpaRepository<ProgramaEntity, Integer> {
    //oracle ok
    @Query(value = "SELECT pr.id,pr.nombre FROM programa pr " +
            "            WHERE pr.departamento_Id=(SELECT d.id FROM semillero s " +
            "            INNER JOIN grupo g on s.grupo_Id=g.grupo_Id " +
            "            INNER JOIN departamento d on d.id=g.departamento_Id " +
            "            WHERE s.semillero_Id=(:semilleroId))", nativeQuery = true)
    List<ListarProgramas> listarProgramaxDepartamento(
            @Param("semilleroId") Integer semilleroId
    );
}
