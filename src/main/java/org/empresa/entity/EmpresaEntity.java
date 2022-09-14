package org.empresa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor


public class EmpresaEntity {

    private String nombreEmpresa;
    private String NIT;
    private String direccion;
    private String telefono;

}

