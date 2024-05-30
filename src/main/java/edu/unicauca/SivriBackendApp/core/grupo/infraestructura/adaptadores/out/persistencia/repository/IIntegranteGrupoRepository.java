package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.IntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.proyecciones.ListarIntegrantesConFiltro;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.proyecciones.ListarIntegrantesxGrupoId;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.IntegranteGrupoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IIntegranteGrupoRepository extends JpaRepository<IntegranteGrupoEntity,Integer> {
    //TODO para la consulta de los mentores falta LA CONDICION QUE EL USUARIO SEA PROFE
    @Query(value = "SELECT u.id,concat(u.nombres,' ', u.apellidos) AS nombres " +
            "FROM integrante_grupo ig " +
            "INNER JOIN usuario u ON u.id=ig.usuarioId " +
            "WHERE ig.grupoId=(:grupoId);",nativeQuery = true)
    List<ListarIntegrantesxGrupoId> obtenerIntegrantesMentoresxGrupoId(Integer grupoId);
    //@Query(value = "",nativeQuery = true)
    //Page<List<ListarIntegrantesConFiltro>> listarIntegrantesConFiltro();
    public List<IntegranteGrupoEntity> findByGrupoId(int idGrupo);
}
