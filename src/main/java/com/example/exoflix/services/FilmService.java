package com.example.exoflix.services;

import com.example.exoflix.pojos.Abbonamento;
import com.example.exoflix.pojos.Film;
import com.example.exoflix.pojos.Regista;
import com.example.exoflix.repos.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;


    public List<Film> allFilms(){

        return filmRepository.findAll();

    }

    public Film oneFilm(Integer id){


        return filmRepository.findById(id).orElseThrow(NullPointerException::new);

    }

    public List<Film> filmByTitoloLike(String titolo){
        return filmRepository.FindByTitoloLike(titolo);
    }

    public List<Film> filmByRegista(Regista regista){
        return filmRepository.FindByRegista(regista);
    }

    public List<Film> filmByAbbonamento(Abbonamento abbonamento){
        return filmRepository.FindByPremiumFilms(abbonamento);
    }
    public void saveFilm(Film film){

        filmRepository.save(film);

    }

    public void deleteFilm(Integer id){

        filmRepository.deleteById(id);
    }


}
