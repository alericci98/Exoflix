package com.example.exoflix.services;

import com.example.exoflix.pojos.Utente;
import com.example.exoflix.repos.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utentiRepository;


    public List<Utente> findAll() {

        return utentiRepository.findAll();
    }

    public Utente findOne(Integer id){

        return utentiRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public void saveUtenti(Utente utente){

        utentiRepository.save(utente);
    }

    public void deleteUtenti(Integer id){

        utentiRepository.deleteById(id);
    }
}
