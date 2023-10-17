package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity.FacultadEntity;
import edu.unicauca.SivriBackendApp.core.grupo.domain.model.GrupoEstado;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity.OrganismoDeInvestigacionEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity.SemilleroEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "grupo")
//relacion de herencia
@PrimaryKeyJoinColumn(name = "grupoId")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GrupoEntity extends OrganismoDeInvestigacionEntity {

    @Column(nullable = false,length = 10)
    @Enumerated(EnumType.STRING)
    private GrupoEstado estado;
    @Column(length = 95)
    private String direccion;
    @Column(length = 45)
    private String telefono;
    @Column(length = 50)
    @Email
    private String email;
    @Column(length = 100)
    private String sitioWeb;
    @Column(length = 10)
    private String escalafonColciencias;
    @Column(length = 120)
    private String direccionGrupLac;
    @Column(length = 45)
    private String codigoColciencias;
    @Column(length = 100)
    private String centroInvestigaciones;
    @Column(length = 1545)
    private String realizaciones;
    @Column(length = 1545)
    private String perspectivas;

    //relacion *a1 con entidad facultad
    @ManyToOne
    @JoinColumn(name = "facultadId")
    private FacultadEntity facultad;

    // relacion *a* con entidad Disciplina
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "grupo_disciplina",
            joinColumns = @JoinColumn(name="disciplinaId"),
            inverseJoinColumns = @JoinColumn(name="grupoId"))
    private List<DisciplinaEntity> disciplinas;

    // relacion 1a* con entidad integranteGrupo
    @OneToMany(mappedBy = "grupo", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<IntegranteGrupoEntity> integrantesGrupo;

    // relacion 1a* con entidad observacionGrupo
    @OneToMany(mappedBy = "grupo", fetch = FetchType.LAZY)
    private List<ObservacionGrupoEntity> observacionesGrupo;

    // relacion 1a* con entidad semillero
    @OneToMany(mappedBy = "grupo",fetch = FetchType.LAZY)
    @JsonBackReference
    private List<SemilleroEntity> semilleros;

}
