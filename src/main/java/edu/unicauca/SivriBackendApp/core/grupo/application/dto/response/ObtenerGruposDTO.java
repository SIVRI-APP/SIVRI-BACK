package edu.unicauca.SivriBackendApp.core.grupo.application.dto.response;


import edu.unicauca.SivriBackendApp.core.academica.dominio.modelo.Facultad;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.GrupoEstado;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ObtenerGruposDTO {
    private Integer grupoId;
    private String nombre;
    private GrupoEstado estado;
    private LocalDate fechaCreacion;
    private String direccion;
    private String telefono;
    private String email;
    private String sitioWeb;
    private String escalafonColciencias;
    private String direccionGrupLac;
    private String codigoColciencias;
    private String centroInvestigaciones;
    private String objetivo;
    private String mision;
    private String vision;
    private String realizaciones;
    private String perspectivas;
    private Facultad facultad;

}
