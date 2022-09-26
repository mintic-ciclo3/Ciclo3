package org.empresa.controller;

import org.empresa.entity.Transaccion;
import org.empresa.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/transactions")
//@RequestMapping("/enterprises/{id}/transactions")
public class TransaccionController {
    @Autowired
    TransaccionService transaccionService;

    //Request GET
    //Listar todas las transacciones
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Transaccion>> getAllTransacciones() {
        return new ResponseEntity<>(transaccionService.findAllTransacciones(), HttpStatus.OK);
    }

    /*//Request GET{id}
    //Listar transacciones por id
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transaccion> findTransaccionById(@PathVariable("id") Long id) {
        return transaccionService.findTransaccionById(id);
    }*/

    //Request POST
    //Crear transaccion
    /*@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transaccion> createTransaccion(@PathVariable("id") Long id, @RequestBody Transaccion movimiento) {
        return transaccionService.createTransaccion(id, movimiento);
    }*/

    @PostMapping()
    public RedirectView createTransaccion(@ModelAttribute Transaccion transaccion, Model model) {
        model.addAttribute(transaccion);
        if (transaccionService.createTransaccion(transaccion).equals(Boolean.TRUE)){
            return new RedirectView("/transactions");
        } else {
            return new RedirectView("/error");
        }
    }

    //Request PATCH
    //Actualizar datos de la transaccion
    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transaccion> /*ResponseEntity<Transaccion>*/ updateTransaccion(@PathVariable("id") Long id, @RequestBody() Transaccion movimiento) {
        return transaccionService.updateTransaccion(id, movimiento);
    }

    // Borrar transaccion
    @DeleteMapping()
    public ResponseEntity<Transaccion> deleteTransaccion(@PathVariable("id") Long id) {
        return transaccionService.deleteTransaccion(id);
    }
}
