package com.example.exoflix.controllers;

import com.example.exoflix.pojos.Utente;
import com.example.exoflix.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generi")
@CrossOrigin("*")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;



    @GetMapping(value = "/trovaTutti", produces = "application/json")
    public ResponseEntity<List<Utente>> trovaTutti(){

        try {
            List<Utente> u= utenteService.findAll();
            return ResponseEntity.ok(u);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/trovaUnUtente/{id}", produces =  "application/json")
    public ResponseEntity<Utente> trovaUno(@PathVariable Integer id){

        try{
            Utente u= utenteService.findOne(id);
            return ResponseEntity.ok(u);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/cancellaUno/{id}", produces =  "application/json")
    public ResponseEntity<String> cancellaUno(@PathVariable Integer id){

        try {
            utenteService.deleteUtenti(id);
            return ResponseEntity.ok("Eliminazione effettuata con successo");
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/add", produces =  "application/json")
    public ResponseEntity<Utente> salvaUno(@RequestBody Utente utente){

        try {
            utenteService.saveUtenti(utente);
            return ResponseEntity.ok(utente);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
