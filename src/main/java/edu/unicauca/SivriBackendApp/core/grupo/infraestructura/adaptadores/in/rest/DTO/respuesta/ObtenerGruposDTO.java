package edu.unicauca.SivriBackendApp.core.grupo.infraestructura.adaptadores.in.rest.DTO.respuesta;

import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.in.rest.DTO.respuesta.DepartamentoDTO;
import edu.unicauca.SivriBackendApp.core.academica.infraestructura.adaptadores.in.rest.DTO.respuesta.FacultadDTO;
import edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos.GrupoEstado;
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
    private DepartamentoDTO departamento;
    private FacultadDTO facultad;

}
