package edu.unicauca.SivriBackendApp.core.planTrabajo.infraestructura.adaptadores.out.persistencia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "compromiso_semillero")
@Data
public class CompromisoSemilleroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "compromiso_semillero_seq")
    @SequenceGenerator(name = "compromiso_semillero_seq", sequenceName = "compromiso_semillero_sequence", initialValue = 4, allocationSize = 1)
    private Integer id;
    @Column(length = 200)
    private String nombre;

    //relacion 1a* con entidad actividadPlanTrabajo
    //@OneToMany(mappedBy = "compromiso", fetch = FetchType.LAZY)
    //private List<ActividadPlanTrabajoEntity> actividades;
    //private UsuarioEntity responsableUsuario;
}
