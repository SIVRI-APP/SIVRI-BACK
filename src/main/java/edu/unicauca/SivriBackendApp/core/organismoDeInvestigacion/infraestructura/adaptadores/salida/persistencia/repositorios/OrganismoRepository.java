package edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.infraestructura.adaptadores.salida.persistencia.repositorios;

import edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.dominio.modelos.proyecciones.ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion;
import edu.unicauca.SivriBackendApp.core.organismoDeInvestigacion.dominio.modelos.proyecciones.ListarOrganismosParaAsociarProyectoProyeccion;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.out.persistencia.entity.OrganismoDeInvestigacionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganismoRepository extends JpaRepository<OrganismoDeInvestigacionEntity, Integer>{

    @Query("SELECT semillero " +
            "FROM SemilleroEntity semillero " +
            "LEFT JOIN FETCH semillero.integrantes integrantes " +
            "LEFT JOIN FETCH integrantes.rolSemillero rol " +
            "LEFT JOIN FETCH integrantes.usuario usuario " +
            "WHERE semillero.id = :semilleroId and usuario.tipoUsuario = 'DOCENTE'"
    )
    Optional<ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion> listarConFiltroIntegrantesSemillero(@Param("semilleroId") long semilleroId);

    @Query("SELECT grupo " +
            "FROM GrupoEntity grupo " +
            "LEFT JOIN FETCH grupo.integrantes integrantes " +
            "LEFT JOIN FETCH integrantes.rolGrupo rol " +
            "LEFT JOIN FETCH integrantes.usuario usuario " +
            "WHERE grupo.id = :grupoId and usuario.tipoUsuario = 'DOCENTE'"
    )
    Optional<ObtenerIntegrantesOrganismoParaAsociarDirProyectoProyeccion> listarConFiltroIntegrantesGrupo(@Param("grupoId") long grupoId);

    @Query(value = "select " +
            " org.id, " +
            " org.nombre " +
            "from " +
            " organismo_de_investigacion org " +
            "left join semillero sem on sem.semilleroId = org.id " +
            "left join integrante_semillero ints on ints.semilleroId = sem.semilleroId " +
            "left join usuario usu on usu.id = ints.usuarioId " +
            "where " +
            " (:id is null or LOWER(org.id) like LOWER(CONCAT('%', :id, '%')))   " +
            "    and (:nombre is null or LOWER(org.nombre) like LOWER(CONCAT('%', :nombre, '%'))) " +
            "    and (:usuarioAutenticadoId is null or LOWER(usu.id) like LOWER(CONCAT('%', :usuarioAutenticadoId, '%'))) " +
            "    and sem.estado = 'ACTIVO' " +
            "    or sem.estado = 'ACTIVO_PENDIENTE_ACTUALIZACION'"
            , nativeQuery = true)
    Page<ListarOrganismosParaAsociarProyectoProyeccion> listarConFiltroSemillero(
            @Param("id") Integer id,
            @Param("nombre") String nombre,
            @Param("usuarioAutenticadoId") Long usuarioAutenticadoId,
            @PageableDefault(sort = "id") Pageable pageable
    );

    @Query(value = "select " +
            " org.id, " +
            " org.nombre " +
            "from " +
            " organismo_de_investigacion org " +
            "left join grupo g on g.grupoId = org.id " +
            "left join integrante_grupo intg on intg.grupoId = g.grupoId " +
            "left join usuario usu on usu.id = intg.usuarioId " +
            "where " +
            " (:id is null or LOWER(org.id) like LOWER(CONCAT('%', :id, '%')))   " +
            "    and (:nombre is null or LOWER(org.nombre) like LOWER(CONCAT('%', :nombre, '%'))) " +
            "    and (:usuarioAutenticadoId is null or LOWER(usu.id) like LOWER(CONCAT('%', :usuarioAutenticadoId, '%'))) " +
            "    and g.estado = 'ACTIVO'"
            , nativeQuery = true)
    Page<ListarOrganismosParaAsociarProyectoProyeccion> listarConFiltroGrupo(
            @Param("id") Integer id,
            @Param("nombre") String nombre,
            @Param("usuarioAutenticadoId") Long usuarioAutenticadoId,
            @PageableDefault(sort = "id") Pageable pageable
    );

    @Query(value = "select " +
            " count(org.id) " +
            "from " +
            " organismo_de_investigacion org " +
            "left join semillero sem on sem.semilleroId = org.id " +
            "where " +
            " org.id = sem.semilleroId " +
            " and sem.semilleroId = :id"
            , nativeQuery = true
    )
    Integer isSemillero(@Param("id") Integer id);

    @Query(value = "select " +
            " count(org.id) " +
            "from " +
            " organismo_de_investigacion org " +
            "left join grupo g on g.grupoId = org.id " +
            "where " +
            " org.id = g.grupoId  " +
            " and g.grupoId = :id"
            , nativeQuery = true
    )
    Integer isGrupo (@Param("id") Integer id);
}