package edu.unicauca.SivriBackendApp.core.semillero.infraestructura.adaptadores.in.rest.DTO.respuesta;

import edu.unicauca.SivriBackendApp.core.academica.dominio.modelos.Programa;
import edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos.Semillero;
import lombok.Data;

@Data
public class SemilleroProgramaDTO {
    private long id;
    private Semillero semillero;
    private Programa programa;

}
