package edu.unicauca.SivriBackendApp.core.grupo.domain.model;

import edu.unicauca.SivriBackendApp.core.academica.domain.model.Facultad;
import lombok.*;

@Data
public class Grupo  extends OrganismoDeInvestigacion{
    private GrupoEstado estado;
    private Integer grupoId;
    private String direccion;
    private String telefono;
    private String email;
    private String sitioWeb;
    private String escalafonColciencias;
    private String direccionGrupLac;
    private String codigoColciencias;
    private String centroInvestigaciones;
    private String realizaciones;
    private String perspectivas;
    private Facultad idFacultad;

}
