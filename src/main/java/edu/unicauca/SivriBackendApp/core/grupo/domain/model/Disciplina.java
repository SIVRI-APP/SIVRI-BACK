package edu.unicauca.SivriBackendApp.core.grupo.domain.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Disciplina {
    private Integer id;
    private String disciplina;
    private SubArea subArea;

    @Override
    public String toString() {
        return "Disciplina{" +
                "subArea=" + subArea +
                '}';
    }
}
