package edu.unicauca.SivriBackendApp.core.grupo.dominio.modelos;

import lombok.Data;

@Data
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
