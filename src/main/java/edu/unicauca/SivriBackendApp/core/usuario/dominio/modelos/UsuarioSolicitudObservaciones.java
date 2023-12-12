package edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioSolicitudObservaciones {

    private Long id;

    private UsuarioSolicitud solicitudUsuario;

    private Funcionario funcionario;

    private String observación;

    private LocalDate fechaObservación;

    private Boolean resuelta;
}
