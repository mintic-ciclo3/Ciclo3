package org.empresa.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.empresa.model.Empresa;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class EmpleadoEntity {
    private String nombreEmpleado;
    private Empresa empresa;
    private String correo;
    private String cargo;

}
