package org.empresa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column @NotBlank(message = "Name is mandatory")
    private String nombreEmpleado;
    @Column @NotBlank(message = "Enterprise is mandatory")
    private String empresa; //Cambiar a tipo Empresa
    @Column @NotBlank(message = "email is mandatory")
    private String correo;
    @Column @NotBlank(message = "job title is mandatory")
    private String cargo;

}
