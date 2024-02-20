package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.repository;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.proyecciones.ListarIntegrantesConFiltro;
import edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.out.persistencia.entity.IntegranteGrupoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IIntegranteGrupoRepository extends JpaRepository<IntegranteGrupoEntity,Integer> {

    //@Query(value = "",nativeQuery = true)
    //Page<List<ListarIntegrantesConFiltro>> listarIntegrantesConFiltro();
}
