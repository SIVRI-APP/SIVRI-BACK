package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.proyecciones.ListarGruposConFiltro;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.proyecciones.ListarGruposPorIdDirector;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.GrupoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGrupoRepository extends JpaRepository<GrupoEntity,Integer> {
    public Boolean existsByNombre(String nombre);
    @Query(value = "SELECT ig.grupoId,oi.nombre,ig.usuarioId " +
            "FROM integrante_grupo ig " +
            "   INNER JOIN grupo g ON ig.grupoId=g.grupoId " +
            "   INNER JOIN organismo_de_investigacion oi ON oi.id=g.grupoId " +
            "WHERE " +
            "   ig.rolGrupoId=1 AND ig.usuarioId=(:idDirector);",nativeQuery = true)
    Page<List<ListarGruposPorIdDirector>> listarGruposPorIdDirectorPaginado(
            @Param("idDirector") int idDirector,
            @PageableDefault(size = 10,page = 0,sort = "id") Pageable pageable
    );

    @Query(value = "SELECT ig.grupoId,oi.nombre,ig.usuarioId " +
            "FROM integrante_grupo ig " +
            "   INNER JOIN grupo g ON ig.grupoId=g.grupoId " +
            "   INNER JOIN organismo_de_investigacion oi ON oi.id=g.grupoId " +
            "WHERE " +
            "   ig.rolGrupoId=1 AND ig.usuarioId=(:idDirector);",nativeQuery = true)
    List<ListarGruposPorIdDirector> listarGruposPorIdDirector(
            @Param("idDirector") Long idDirector
    );

    @Query(value = "SELECT dg.*, du.director " +
            "FROM " +
            "    (SELECT CONCAT_WS(' ', u.nombres, u.apellidos) AS director, ig.grupoId " +
            "    FROM usuario u " +
            "    INNER JOIN integrante_grupo ig ON ig.usuarioId = u.id) as du " +
            "INNER JOIN " +
            "    (SELECT g.grupoId, oi.nombre as grupo, g.estado, f.nombre as facultad " +
            "    FROM grupo g " +
            "    INNER JOIN organismo_de_investigacion oi ON oi.id = g.grupoId " +
            "    INNER JOIN facultad f ON f.idFacultad = g.facultadId) AS dg " +
            "ON dg.grupoId = du.grupoId " +
            "WHERE " +
            "    (LOWER(dg.grupo) LIKE %:grupo% OR LOWER(dg.grupo) = COALESCE(LOWER(:grupo), LOWER(dg.grupo)) OR :grupo IS NULL) " +
            "    AND (LOWER(dg.estado) = COALESCE(LOWER(:estado), LOWER(dg.estado)) OR :estado IS NULL) " +
            "    AND (LOWER(dg.facultad) LIKE %:facultad% OR LOWER(dg.facultad) = COALESCE(LOWER(:facultad), LOWER(dg.facultad)) OR :facultad IS NULL) " +
            "    AND (LOWER(du.director) LIKE %:director% OR LOWER(du.director) = COALESCE(LOWER(:director), LOWER(du.director)) OR :director IS NULL);",nativeQuery = true)
    Page<List<ListarGruposConFiltro>> obtenerGruposConFiltro(
            @Param("grupo") String grupo,
            @Param("estado") String estado,
            @Param("facultad") String facultad,
            @Param("director") String director,
            @PageableDefault(size = 10,page = 0,sort = "id")Pageable pageable
    );
}
