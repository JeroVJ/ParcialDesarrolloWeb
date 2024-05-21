package com.example.crud.controller;


import com.example.crud.entity.Celular;
import com.example.crud.service.CelularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@Validated
public class CelularController {
    @Autowired
    private CelularService service;

    @PostMapping("/addCelular")
    public ResponseEntity<Celular> addCelular(@Valid @RequestBody Celular celular) {
        Celular savedCelular = service.saveCelular(celular);
        return new ResponseEntity<>(savedCelular, HttpStatus.CREATED);
    }

    @PostMapping("/addCelulares")
    public ResponseEntity<List<Celular>> addCelulares(@Valid @RequestBody List<Celular> celulares) {
        List<Celular> savedCelulares = service.saveCelulares(celulares);
        return new ResponseEntity<>(savedCelulares, HttpStatus.CREATED);
    }

    @GetMapping("/celulares")
    public ResponseEntity<List<Celular>> findAllCelulares() {
        List<Celular> celulares = service.getCelulares();
        return new ResponseEntity<>(celulares, HttpStatus.OK);
    }

    @GetMapping("/celular/{id}")
    public ResponseEntity<Celular> findCelularById(@PathVariable int id) {
        Celular celular = service.getCelularById(id);
        return celular != null ? new ResponseEntity<>(celular, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/celularM/{marca}")
    public ResponseEntity<Celular> findCelularByMarca(@PathVariable String marca) {
        Celular celular = service.getCelularByMarca(marca);
        return celular != null ? new ResponseEntity<>(celular, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/celularUpdate")
    public ResponseEntity<Celular> updateCelular(@Valid @RequestBody Celular celular) {
        Celular updatedCelular = service.updateCelular(celular);
        return new ResponseEntity<>(updatedCelular, HttpStatus.OK);
    }

    @DeleteMapping("/celularDelete/{id}")
    public ResponseEntity<String> deleteCelular(@PathVariable int id) {
        String response = service.deleteCelular(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
