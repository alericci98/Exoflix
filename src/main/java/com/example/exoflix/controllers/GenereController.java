package com.example.exoflix.controllers;

import com.example.exoflix.pojos.Genere;
import com.example.exoflix.services.GenereService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/generi")
@Slf4j
public class GenereController {

    @Autowired
    private GenereService genereService;



    @GetMapping(value = "/trovaTutto", produces = "application/json")
    public ResponseEntity<List<Genere>> trovaGeneri(){

        try {
            List<Genere> lista= genereService.trovaTuttiGeneri();
            return ResponseEntity.ok(lista);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/trovaUno/{id}", produces = "application/json")
    public ResponseEntity<Genere> trovaUnGenere(@PathVariable Integer id){

        try {
            Genere gen= genereService.trovaUnGenere(id);
            return ResponseEntity.ok(gen);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
