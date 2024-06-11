package edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnfoqueDiferencialListado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enfoqueDiferencialId")
    @JsonManagedReference
    private EnfoqueDiferencial enfoqueDiferencial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proyectoId")
    @JsonBackReference
    private Proyecto proyecto;
}
