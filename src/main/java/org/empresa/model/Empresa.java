package org.empresa.model;

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

}

