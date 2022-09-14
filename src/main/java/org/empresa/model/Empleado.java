package org.empresa.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Empleado {
    private String nombreEmpleado;
    private Empresa empresa;
    private String correo;
    private String cargo;

}
