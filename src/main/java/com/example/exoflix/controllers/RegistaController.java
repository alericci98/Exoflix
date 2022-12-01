package com.example.exoflix.controllers;


import com.example.exoflix.pojos.Regista;
import com.example.exoflix.services.RegistaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/registi")
@Slf4j
public class RegistaController {

    @Autowired
    private RegistaService registaService;



    @GetMapping(value = "/findAll", produces = "application/json")
    public ResponseEntity<List<Regista>> trovaTuttiRegisti(){
          log.info("Regista.java findAll Rest");
        try {
            List<Regista> regista = registaService.allRegisti();
            return ResponseEntity.ok(regista);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/findOne/{id}", produces = "application/json")
    public ResponseEntity<Regista> trovaUnRegista(@PathVariable Integer id){
 log.info("Regista.java findOne Rest");
        try {
            Regista r= new Regista();
            r= registaService.oneRegisti(id);
            return  ResponseEntity.ok(r);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
