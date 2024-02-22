package edu.unicauca.SivriBackendApp.core.semillero.dominio.modelos;

import edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos.Usuario;
import lombok.Data;

import java.time.LocalDate;

@Data
public class IntegranteSemillero {
    private Integer id;
    private EstadoIntegranteSemillero estado;
    private LocalDate fechaIngreso;
    private LocalDate fechaRetiro;
    private Usuario usuario;
    private RolSemillero rolSemillero;
    private Semillero semillero;

}
