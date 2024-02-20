package edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.proyecciones;

import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.EstadoIntegranteGrupo;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.RolGrupo;

import java.time.LocalDate;

public interface ListarIntegrantesConFiltro {
    String getNumeroDocumento(); //cedula
    String getNombreCompleto();
    LocalDate getFechaIngreso();
    LocalDate getFechaRetiro();
    Integer getIdGrupo();
    String getNombreGrupo();
    RolGrupo getRolGrupo();
    EstadoIntegranteGrupo getEstado();

}
