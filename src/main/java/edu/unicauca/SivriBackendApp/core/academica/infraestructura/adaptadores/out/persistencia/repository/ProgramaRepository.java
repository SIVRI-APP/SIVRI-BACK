package edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.entity.FacultadEntity;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.out.persistencia.entity.ProgramaEntity;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.proyecciones.ListarProgramas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProgramaRepository extends JpaRepository<ProgramaEntity, Integer> {
    @Query(value = "SELECT pr.id,pr.nombre FROM programa pr\n" +
            "WHERE pr.departamentoId=(SELECT d.id FROM semillero s\n" +
            "INNER JOIN grupo g on s.grupoId=g.grupoId\n" +
            "INNER JOIN departamento d on d.id=g.departamentoId\n" +
            "WHERE s.semilleroId=(:semilleroId)\n" +
            ");\n", nativeQuery = true)
    List<ListarProgramas> listarProgramaxDepartamento(
            @Param("semilleroId") Integer semilleroId
    );
}
