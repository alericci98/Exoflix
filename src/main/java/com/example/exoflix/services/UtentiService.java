package com.example.exoflix.services;

import com.example.exoflix.pojos.Utenti;
import com.example.exoflix.repos.UtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class UtentiService {

    @Autowired
    private UtentiRepository utentiRepository;


    public ResponseEntity<List<Utenti>> findAll() {
        List<Utenti> utenti = utentiRepository.findAll();
        return ResponseEntity.ok(utenti);
    }

    public ResponseEntity<Utenti> findOne(Integer id){
        Utenti r= utentiRepository.findById(id).orElseThrow(NullPointerException::new);
        return  ResponseEntity.ok(r);
    }

    public void saveUtenti(Utenti utenti){
        utentiRepository.save(utenti);
    }
}
