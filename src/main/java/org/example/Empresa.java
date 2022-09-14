package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor


public class Empresa {

    private String nombreEmpresa;
    private String NIT;
    private String direccion;
    private String telefono;

    // Constructores, setters y getters sin usar lombok

    /*public Empresa(String nombreEmpresa, String NIT, String direccion, String telefono){
        this.nombreEmpresa = nombreEmpresa;
        this.NIT = NIT;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Empresa(){}

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }*/
}

