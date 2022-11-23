package com.example.exoflix.services;

import com.example.exoflix.pojos.Films;
import com.example.exoflix.repos.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;


    public ResponseEntity<List<Films>> allFilms(){

        List<Films> r= filmRepository.findAll();
        return ResponseEntity.ok(r);

    }

    public Films oneFilm( Integer id){


        return filmRepository.findById(id).orElseThrow(NullPointerException::new);

    }

    public void saveFilm(Films film){

        filmRepository.save(film);

    }

    public void deleteFilm(Integer id){

        filmRepository.deleteById(id);
    }


}
