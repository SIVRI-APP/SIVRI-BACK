package edu.unicauca.SivriBackendApp.core.grupo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganismoDeInvestigacion {
    private Integer id;
    private String nombre;
    private LocalDate fechaCreacion;

    private String objetivo;
    private String mision;
    private String vision;
}
