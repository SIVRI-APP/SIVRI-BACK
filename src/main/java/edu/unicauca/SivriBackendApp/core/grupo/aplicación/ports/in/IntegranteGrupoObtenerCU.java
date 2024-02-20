package edu.unicauca.SivriBackendApp.core.grupo.aplicación.ports.in;

import edu.unicauca.SivriBackendApp.common.respuestaGenerica.Respuesta;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.EstadoIntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.IntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.proyecciones.ListarIntegrantesConFiltro;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface IntegranteGrupoObtenerCU {

    Respuesta<IntegranteGrupo> obtenerIntegrantePorId(int id);

    Respuesta<List<IntegranteGrupo>> obtenerIntegrantesGrupo();

    Respuesta<Page<List<ListarIntegrantesConFiltro>>> listarIntegrantesConFiltro(int pageNo, int pageSize, String numeroDocumento, LocalDate fechaIngresoo, LocalDate fechaRetiro, Integer idGrupo, String nombreGrupo, String rolGrupo, EstadoIntegranteGrupo estado);
}
