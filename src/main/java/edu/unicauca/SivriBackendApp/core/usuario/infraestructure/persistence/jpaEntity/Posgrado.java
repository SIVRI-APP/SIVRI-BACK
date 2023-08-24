package edu.unicauca.SivriBackendApp.core.usuario.infraestructure.persistence.jpaEntity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "posgrado")
@Data
public class Posgrado extends TipoUsuario{

    @Column(name = "programaIdPrograma")
    private Integer programaIdPrograma;

}
