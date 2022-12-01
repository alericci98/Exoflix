package com.example.exoflix.services;

import com.example.exoflix.pojos.Genere;
import com.example.exoflix.repos.GenereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenereService {

    @Autowired
    private GenereRepository genereRepository;


    public Genere trovaUnGenere(Integer id){
        return genereRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public List<Genere> trovaTuttiGeneri(){

        return  genereRepository.findAll();
    }
}
