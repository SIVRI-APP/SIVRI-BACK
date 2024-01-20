package edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos;

import edu.unicauca.SivriBackendApp.core.academica.dominio.modelos.Facultad;
import edu.unicauca.SivriBackendApp.core.usuario.dominio.model.TipoDocumento;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Grupo  extends OrganismoDeInvestigacion {
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
    private Facultad facultad;
    private TipoDocumento tipoDocumento;
    private String numeroDocumento;

}
