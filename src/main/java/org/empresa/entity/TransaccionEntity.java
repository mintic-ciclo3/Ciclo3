package org.empresa.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.empresa.model.Empleado;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class TransaccionEntity {
    private double monto;
    private String concepto;
    private Empleado encargado;

}
