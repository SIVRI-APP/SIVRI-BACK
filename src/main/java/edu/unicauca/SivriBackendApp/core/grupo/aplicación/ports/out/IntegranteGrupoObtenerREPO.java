package edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.out;


import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.EstadoIntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.IntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.RolGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.proyecciones.ListarIntegrantesConFiltro;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.proyecciones.ListarIntegrantesxGrupoId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IntegranteGrupoObtenerREPO {

    Optional<IntegranteGrupo> obtenerIntegranteGrupoPorId(int id);
    List<ListarIntegrantesxGrupoId> obtenerIntegrantesMentoresxGrupoId(Integer grupoId);
    List<IntegranteGrupo> obtenerIntegrantesGrupo();
    List<IntegranteGrupo> obtenerIntegrantesGrupoPorIdGrupo(int idGrupo);
    Page<List<ListarIntegrantesConFiltro>> listarIntegrantesConFiltro(Pageable pageable, String numeroDocumento, LocalDate fechaIngresoo, LocalDate fechaRetiro, Integer idGrupo, String nombreGrupo, String rolGrupo, EstadoIntegranteGrupo estado);
}
