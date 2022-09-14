package org.empresa;

import org.empresa.model.Empleado;
import org.empresa.model.Empresa;
import org.empresa.model.Transaccion;

public class Main {
    public static void main(String[] args) {

        Empresa empresa1 = new Empresa("Coltelas S.A.S",
                "103.678.763-4",
                "Calle 76 # 24-15",
                "6012445896");

        Empresa empresa2 = new Empresa("Paragon E.U.",
                "896.235.125-5",
                "Av Bolivar # 56-89",
                "6025692387");

        System.out.println("EmpresaEntity 1");
        System.out.println(empresa1.getNombreEmpresa());
        System.out.println("NIT " + empresa1.getNIT());
        System.out.println("Direccion " + empresa1.getDireccion());
        System.out.println("Telefono " + empresa1.getTelefono());

        empresa1.setNombreEmpresa("Coltelar S.A.S.");
        empresa1.setNIT("1036787436");
        empresa1.setDireccion("Calle 76 Sur # 24-15");
        empresa1.setTelefono("6022445896");

        System.out.println("\n");
        System.out.println("EmpresaEntity 1");
        System.out.println(empresa1.getNombreEmpresa());
        System.out.println("NIT " + empresa1.getNIT());
        System.out.println("Direccion " + empresa1.getDireccion());
        System.out.println("Telefono " + empresa1.getTelefono());

        System.out.println("\n");
        System.out.println("EmpresaEntity 2");
        System.out.println(empresa2.getNombreEmpresa());
        System.out.println("NIT " + empresa2.getNIT());
        System.out.println("Direccion " + empresa2.getDireccion());
        System.out.println("Telefono " + empresa2.getTelefono());

        Empleado empleado1 = new Empleado("Juan Perez",
                empresa1, "Administrador", "juan.perez@coltelar.co" );

        Empleado empleado2 = new Empleado("Maria Calle",
                empresa1, "Contador", "maria.calle@coltelar.co" );

        empleado1.setNombreEmpleado("Juan Carlos Perez");
        empleado1.setEmpresa(empresa2);
        empleado1.setCorreo("juanperez@paragon.com");
        empleado1.setCargo("Ingeniero de Proyectos");

        System.out.println("\n");
        System.out.println("EmpleadoEntity");
        System.out.println(empleado1.getNombreEmpleado());
        System.out.println(empleado1.getEmpresa().getNombreEmpresa());
        System.out.println(empleado1.getCargo());
        System.out.println(empleado1.getCorreo());

        Transaccion movimiento1 = new Transaccion(5000000,
                "Caja menor", empleado1);

        movimiento1.setConcepto("Compra materiales");
        movimiento1.setMonto(-4236985.76);
        movimiento1.setEncargado(empleado2);

        System.out.println("\n");
        System.out.println("Movimiento");
        System.out.println("$ " + movimiento1.getMonto());
        System.out.println("Concepto " + movimiento1.getConcepto());
        System.out.println("Encargado " + movimiento1.getEncargado().getNombreEmpleado());
        System.out.println("EmpresaEntity " + movimiento1.getEncargado().getEmpresa().getNombreEmpresa());
    }
}