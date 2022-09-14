package org.empresa.controller;

import org.empresa.entity.Empleado;
import org.empresa.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    //Request GET
    //Listar todos los empleados
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Empleado>> getAllEmpleado() {
        return empleadoService.findAllEmpleado();
    }

    //Request GET{id}
    //Listar empleados por id
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empleado> findEmpleadoById(@PathVariable("id") Long id) {
        return empleadoService.findEmpleadoById(id);
    }

    //Request POST
    //Crear empleado
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empleado> createEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.createEmpleado(empleado);
    }

    //Request PATCH
    //Actualizar datos del empleado
    @PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable("id") Long id, @RequestBody() Empleado empleado) {
        return empleadoService.updateEmpleado(id, empleado);
    }

    // Borrar empleado
    @DeleteMapping("/{id}")
    public ResponseEntity<Empleado> deleteEmpleado(@PathVariable("id") Long id) {
        return empleadoService.deleteEmpleado(id);
    }
}
