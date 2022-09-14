package org.empresa.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Transaccion {
    private double monto;
    private String concepto;
    private Empleado encargado;

}
