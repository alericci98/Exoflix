package com.example.exoflix.controllers;

import com.example.exoflix.pojos.Abbonamento;
import com.example.exoflix.services.AbbonamentoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/abbonamento")
@Slf4j
public class AbbonamentoController {

    @Autowired
    private AbbonamentoService abbonamentoService;

    @GetMapping(value = "/trovaTutto", produces = "application/json")
    public ResponseEntity<List<Abbonamento>> trovaTutto(){
        try {

            List<Abbonamento> lista= abbonamentoService.findAll();
            return ResponseEntity.ok(lista);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/trovaUno/{id}", produces = "application/json")
    public ResponseEntity<Abbonamento> trovaUno(@PathVariable Integer id){

        try {
            Abbonamento abbonamento= abbonamentoService.findOne(id);
            return  ResponseEntity.ok(abbonamento);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
