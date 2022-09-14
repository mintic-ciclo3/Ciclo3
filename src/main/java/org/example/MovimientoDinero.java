package org.example;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class MovimientoDinero {
    private double monto;
    private String concepto;
    private Empleado encargado;

    // Constructores, setters y getters sin usar lombok

    /*public MovimientoDinero(double monto, String concepto, Empleado encargado){
        this.monto = monto;
        this.concepto = concepto;
        this.encargado = encargado;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Empleado getEncargado() {
        return encargado;
    }

    public void setEncargado(Empleado encargado) {
        this.encargado = encargado;
    }*/

}
