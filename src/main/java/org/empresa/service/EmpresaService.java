package org.empresa.service;

import org.empresa.entity.Empresa;
import org.empresa.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public ResponseEntity<List<Empresa>> findAllEmpresas() {
        try {
            List<Empresa> empresas = new ArrayList<Empresa>();
            empresaRepository.findAll().forEach(empresa -> empresas.add(empresa));
            return new ResponseEntity<>(empresas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Empresa> findEmpresaById(Long id) {
        Optional<Empresa> empresaData = empresaRepository.findById(id);
        if (empresaData.isPresent()) {
            return new ResponseEntity<>(empresaData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Empresa> createEmpresa(Empresa empresa) {
        try {
            return new ResponseEntity<>(empresaRepository.save(empresa), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Empresa> updateEmpresa(Long id, Empresa empresa) {
        try {
            Empresa empresaUp = empresaRepository.findById(id).get();
            empresaUp.setNombreEmpresa(empresa.getNombreEmpresa());
            empresaUp.setNit(empresa.getNit());
            empresaUp.setDireccion(empresa.getDireccion());
            empresaUp.setTelefono(empresa.getTelefono());
            return new ResponseEntity<Empresa>(empresaRepository.save(empresaUp), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Empresa> deleteEmpresa(Long id) {
        Optional<Empresa> empresadata = empresaRepository.findById(id);
        if (empresadata.isPresent()) {
            empresaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
