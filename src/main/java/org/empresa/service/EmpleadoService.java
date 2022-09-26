package org.empresa.service;

import org.empresa.entity.Empleado;
import org.empresa.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    /*Inyeccion de dependencias a nivel de constructor para el manejo de pruebas
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }*/

    public List<Empleado> findAllEmpleados() {
        List<Empleado> empleados = new ArrayList<Empleado>();
        empleadoRepository.findAll().forEach(empleado -> empleados.add(empleado));
        return empleados;
    }

    public ResponseEntity<Empleado> findEmpleadoById(Long id) {
        Optional<Empleado> empleadoData = empleadoRepository.findById(id);
        if (empleadoData.isPresent()) {
            return new ResponseEntity<>(empleadoData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Empleado> createEmpleado(Empleado empleado) {
        try {
            return new ResponseEntity<>(empleadoRepository.save(empleado), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Empleado> updateEmpleado(Long id, Empleado empleado) {
        try {
            Empleado empleadoUp = empleadoRepository.findById(id).get();
            empleadoUp.setNombreEmpleado(empleado.getNombreEmpleado());
            empleadoUp.setEmpresa(empleado.getEmpresa());
            empleadoUp.setCargo(empleado.getCargo());
            empleadoUp.setCorreo(empleado.getCorreo());
            return new ResponseEntity<Empleado>(empleadoRepository.save(empleadoUp), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Empleado> deleteEmpleado(Long id) {
        Optional<Empleado> empleadodata = empleadoRepository.findById(id);
        if (empleadodata.isPresent()) {
            empleadoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
