package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.proyecciones.ListarDisciplinasPorGrupoId;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.GrupoDisciplinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IGrupoDisciplinaRepository extends JpaRepository<GrupoDisciplinaEntity, Long> {
    public List<GrupoDisciplinaEntity> findByGrupoId(int grupoId);
    @Query(value = "select gd.id,gd.grupoId,d.id as idDisciplina,d.disciplina " +
            "from grupo_disciplina gd " +
            "inner join disciplina d on d.id=gd.disciplinaId " +
            "where gd.grupoId=(:grupoId);",nativeQuery = true)
    List<ListarDisciplinasPorGrupoId> obtenerDisciplinasxGrupoId(int grupoId);
}
