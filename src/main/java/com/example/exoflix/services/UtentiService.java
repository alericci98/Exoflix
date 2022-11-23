package com.example.exoflix.services;

import com.example.exoflix.pojos.Utente;
import com.example.exoflix.repos.UtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class UtentiService {

    @Autowired
    private UtentiRepository utentiRepository;


    public ResponseEntity<List<Utente>> findAll() {
        List<Utente> utente = utentiRepository.findAll();
        return ResponseEntity.ok(utente);
    }

    public ResponseEntity<Utente> findOne(Integer id){
        Utente r= utentiRepository.findById(id).orElseThrow(NullPointerException::new);
        return  ResponseEntity.ok(r);
    }

    public void saveUtenti(Utente utente){
        utentiRepository.save(utente);
    }
}
