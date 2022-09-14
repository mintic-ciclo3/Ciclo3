package org.example;


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


    // Constructores, setters y getters sin usar lombok

   /* public Empleado(String nombreEmpleado, Empresa empresa, String cargo, String correo) {
        this.nombreEmpleado = nombreEmpleado;
        this.empresa = empresa;
        this.cargo = cargo;
        this.correo = correo;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }*/
}
