package com.example.exoflix.controllers;


import com.example.exoflix.pojos.Registi;
import com.example.exoflix.services.RegistiService;
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
public class RegistiController {

    @Autowired
    private RegistiService registiService;

    @GetMapping(value = "/findAll", produces = "application/json")
    public ResponseEntity<List<Registi>> trovaTuttiRegisti(){
          log.info("Regista findAll Rest");
        try {
            List<Registi> registi=registiService.allRegisti();
            return ResponseEntity.ok(registi);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/findOne/{id}", produces = "application/json")
    public ResponseEntity<Registi> trovaUnRegista(@PathVariable Integer id){
 log.info("Regista findOne Rest");
        try {
            Registi r= new Registi();
            r=registiService.oneRegisti(id);
            return  ResponseEntity.ok(r);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
