package edu.unicauca.SivriBackendApp.core.proyectos.infraestructura.adaptadores.salida.persistencia.entidades;

import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.CategoriaProductoEnum;
import edu.unicauca.SivriBackendApp.core.proyectos.dominio.modelos.enums.TipoProductoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "producto_proyecto")
@Getter
@Setter
public class ProductoProyectoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private CategoriaProductoEnum categoria;

    @Enumerated(EnumType.STRING)
    private TipoProductoEnum tipo;

    @Column(length = 1000, nullable = false)
    private String descripcion;

}
