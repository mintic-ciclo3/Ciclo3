package org.empresa.controller;

import org.empresa.entity.Empresa;
import org.empresa.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import java.util.List;

@RestController
@RequestMapping("/enterprises")
public class EmpresaController {
    @Autowired
    EmpresaService empresaService;

    //Request GET
    //Listar todas las empresas
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Empresa>> getAllEmpresas() {
        return new ResponseEntity<>(empresaService.findAllEmpresas(), HttpStatus.OK);
    }

    //Request GET{id}
    //Listar empresas por id
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empresa> findEmpresaById(@PathVariable("id") Long id) {
        return empresaService.findEmpresaById(id);
    }

    //Request POST
    //Crear empresa
    /*@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empresa> createEmpresa(@RequestBody Empresa empresa) {
        return empresaService.createEmpresa(empresa);
    }*/
    @PostMapping()
    public RedirectView createEmpresa(@ModelAttribute Empresa empresa, Model model) {
        model.addAttribute(empresa);
        if (empresaService.createEmpresa(empresa).equals(Boolean.TRUE)){
            return new RedirectView("/enterprises");
        } else {
            return new RedirectView("/error");
        }
    }

    //Request PATCH
    //Actualizar datos de la empresa
    @PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empresa> updateEmpresa(@PathVariable("id") Long id, @RequestBody() Empresa empresa) {
        return empresaService.updateEmpresa(id, empresa);
    }

    // Borrar empresa
    @DeleteMapping("/{id}")
    public ResponseEntity<Empresa> deleteEmpresa(@PathVariable("id") Long id) {
        return empresaService.deleteEmpresa(id);
    }

}
