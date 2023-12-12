package edu.unicauca.SivriBackendApp.core.usuario.dominio.modelos;

import edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.out.persistencia.entity.UsuarioEntity;
import lombok.Data;

@Data
public class Funcionario {

    private Long id;

    private UsuarioEntity usuario;
}
