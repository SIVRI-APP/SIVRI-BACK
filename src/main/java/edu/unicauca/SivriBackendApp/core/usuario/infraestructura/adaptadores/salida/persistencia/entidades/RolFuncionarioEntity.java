package edu.unicauca.SivriBackendApp.core.usuario.infraestructura.adaptadores.salida.persistencia.entidades;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Representa la entidad de persistencia para los roles de los funcionarios en el sistema.
 */
@Entity
@Table(name = "rol_funcionario")
@Data
public class RolFuncionarioEntity {

    /**
     * Identificador único del rol del funcionario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del rol del funcionario. Es un campo obligatorio y tiene una longitud máxima de 45 caracteres.
     */
    @Column(nullable = false, length = 100)
    private String nombre;

}
