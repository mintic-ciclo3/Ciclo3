package org.empresa.service;

import org.empresa.entity.Transaccion;
import org.empresa.repository.EmpleadoRepository;
import org.empresa.repository.EmpresaRepository;
import org.empresa.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransaccionService {

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;



    public ResponseEntity<Transaccion> findTransaccionById(Long id) {
        Optional<Transaccion> movimientosData = transaccionRepository.findById(id);
        if (movimientosData.isPresent()) {
            return new ResponseEntity<>(movimientosData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Transaccion> createTransaccion(Long id, Transaccion movimiento) {
        try {
            Transaccion movimientmp =new Transaccion();
            //movimientmp.setEmpresa(empresaRepository.findById(id).get());
            //Long tmp = movimiento.getEncargado();
            //movimientmp.setEmpleado(empleadoRepository.findById(tmp).get());
            movimientmp.setConcepto(movimiento.getConcepto());
            movimientmp.setMonto(movimiento.getMonto());
            return new ResponseEntity<Transaccion>(transaccionRepository.save(movimientmp), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Transaccion> updateMovimiento(Long id, Transaccion movimiento) {
        try {
            Transaccion movimientoUp = transaccionRepository.findById(id).get();
            //movimientoUp.setEmpresa(movimiento.getId());
            //movimientoUp.setEncargado(movimiento.getEncargado());
            movimientoUp.setMonto(movimiento.getMonto());
            movimientoUp.setConcepto(movimiento.getConcepto());
            return new ResponseEntity<Transaccion>(transaccionRepository.save(movimientoUp), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Transaccion> deleteMovimiento(Long id) {
        Optional<Transaccion> movimientodata = transaccionRepository.findById(id);
        if (movimientodata.isPresent()) {
            transaccionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
