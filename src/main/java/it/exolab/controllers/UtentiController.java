package it.exolab.controllers;

import it.exolab.pojos.Utenti;
import it.exolab.repos.UtentiRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/generi")
@CrossOrigin("*")
public class UtentiController {

    @Autowired
    private UtentiRepository repo;

    @GetMapping("/findaAll")
    public ResponseEntity<List<Utenti>> findAll() {
        List<Utenti> utenti = repo.findAll();
        return ResponseEntity.ok(utenti);
    }

}
