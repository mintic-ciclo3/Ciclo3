package org.empresa.service;

import org.empresa.entity.Empresa;
import org.empresa.entity.Transaccion;
import org.empresa.repository.EmpleadoRepository;
import org.empresa.repository.EmpresaRepository;
import org.empresa.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransaccionService {

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Transaccion> findAllTransacciones() {
        List<Transaccion> transacciones = new ArrayList<Transaccion>();
        transaccionRepository.findAll().forEach(transaccion -> transacciones.add(transaccion));
        return transacciones;
    }

    public ResponseEntity<Transaccion> findTransaccionById(Long id) {
        Optional<Transaccion> transaccionData = transaccionRepository.findById(id);
        if (transaccionData.isPresent()) {
            return new ResponseEntity<>(transaccionData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*public ResponseEntity<Transaccion> createTransaccion(Long id, Transaccion transaccion) {
        try {
            Transaccion transacciontmp = new Transaccion();
            //movimientmp.setEmpresa(empresaRepository.findById(id).get());
            //Long tmp = movimiento.getEncargado();
            //movimientmp.setEmpleado(empleadoRepository.findById(tmp).get());
            transacciontmp.setConcepto(transaccion.getConcepto());
            transacciontmp.setMonto(transaccion.getMonto());
            return new ResponseEntity<Transaccion>(transaccionRepository.save(transacciontmp), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    public Boolean createTransaccion(Transaccion transaccion) {
        try {
            new ResponseEntity<>(transaccionRepository.save(transaccion), HttpStatus.CREATED);
            return Boolean.TRUE;
        } catch (Exception e) {
            new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            return Boolean.FALSE;
        }
    }

    public ResponseEntity<Transaccion> updateTransaccion(Long id, Transaccion transaccion) {
        try {
            Transaccion transaccionUp = transaccionRepository.findById(id).get();
            //movimientoUp.setEmpresa(movimiento.getId());
            //movimientoUp.setEncargado(movimiento.getEncargado());
            transaccionUp.setMonto(transaccion.getMonto());
            transaccionUp.setConcepto(transaccion.getConcepto());
            return new ResponseEntity<Transaccion>(transaccionRepository.save(transaccionUp), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Transaccion> deleteTransaccion(Long id) {
        Optional<Transaccion> transacciondata = transaccionRepository.findById(id);
        if (transacciondata.isPresent()) {
            transaccionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
