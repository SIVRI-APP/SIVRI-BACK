package edu.unicauca.SivriBackendApp.core.grupo.infraestructure.persistence.jpaEntity;

import edu.unicauca.SivriBackendApp.core.academica.infraestructure.persistence.jpaEntity.FacultadEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity.OrganismoDeInvestigacionEntity;
import edu.unicauca.SivriBackendApp.core.semillero.infraestructure.persistence.jpaEntity.SemilleroEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "grupo")
//relacion de herencia
@PrimaryKeyJoinColumn(name = "grupoId")
@Getter
@Setter
@AllArgsConstructor
public class GrupoEntity extends OrganismoDeInvestigacionEntity {
    @Column(length = 95)
    private String direccion;
    @Column(length = 45)
    private String telefono;
    @Column(length = 50,nullable = false)
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
    private FacultadEntity idFacultad;

    // relacion *a* con entidad Disciplina
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "grupo_disciplina",
            joinColumns = @JoinColumn(name="disciplinaId"),
            inverseJoinColumns = @JoinColumn(name="grupoId"))
    private List<DisciplinaEntity> disciplinas;

    // relacion 1a* con entidad integranteGrupo
    @OneToMany(mappedBy = "grupos", fetch = FetchType.LAZY)
    private List<IntegranteGrupoEntity> integrantesGrupo;

    // relacion 1a* con entidad observacionGrupo
    @OneToMany(mappedBy = "grupo", fetch = FetchType.LAZY)
    private List<ObservacionGrupoEntity> observacionId;

    // relacion 1a* con entidad semillero
    @OneToMany(mappedBy = "idGrupo",fetch = FetchType.LAZY)
    private List<SemilleroEntity> semilleros;

    public GrupoEntity(){
    }
    public GrupoEntity(Integer id, String nombre,LocalDate fechaCreacion, String estado, String objetivo,
                       String mision, String vision,  String direccion, String telefono, @Email String email, String sitioWeb,
                       String escalafonColciencias, String direccionGrupLac, String codigoColciencias,
                       String centroInvestigaciones, String realizaciones, String perspectivas, FacultadEntity idFacultad
                       ){
        super(id,nombre,fechaCreacion,estado,objetivo,mision,vision);
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.sitioWeb = sitioWeb;
        this.escalafonColciencias = escalafonColciencias;
        this.direccionGrupLac = direccionGrupLac;
        this.codigoColciencias = codigoColciencias;
        this.centroInvestigaciones = centroInvestigaciones;
        this.realizaciones = realizaciones;
        this.perspectivas = perspectivas;
        this.idFacultad = idFacultad;


    }

}
