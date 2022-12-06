package com.example.exoflix.controllers;


import com.example.exoflix.pojos.Abbonamento;
import com.example.exoflix.pojos.Film;
import com.example.exoflix.pojos.Regista;
import com.example.exoflix.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private FilmService filmService;



    @GetMapping(value = "/findAll", produces = "application/json")
    public ResponseEntity<List<Film>> trovaTuttoFilm() {
        List<Film> films = new ArrayList<>();

        try {
            films = filmService.allFilms();

            return ResponseEntity.ok(films);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/findOne/{id}", produces = "application/json")
    public ResponseEntity<Film> trovaUnFilm(@PathVariable Integer id) {
        Film film = new Film();
        try {
            film = filmService.oneFilm(id);
            return ResponseEntity.ok(film);
        } catch (Exception e) {
            return new ResponseEntity<Film>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/findLikeTitolo/{titolo}", produces = "application/json")
    public ResponseEntity<List<Film>> trovaFilmPerTitolo(String titolo){
        try {

            List<Film> lista= filmService.filmByTitoloLike(titolo);
            return ResponseEntity.ok(lista);
        }
        catch (Exception e){
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/findByRegista/{regista}", produces = "application/json")
    public ResponseEntity<List<Film>> trovaFilmPerRegista(Regista regista){

        try {
            List<Film> lista= filmService.filmByRegista(regista);
            return ResponseEntity.ok(lista);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/findByAbbonamento/{abbonamento}", produces = "application/json")
    public ResponseEntity<List<Film>> trovaFilmPerAbbonamento(Abbonamento abbonamento){

        try {

            List<Film> lista= filmService.filmByAbbonamento(abbonamento);
            return ResponseEntity.ok(lista);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping(value = "/add", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Film> aggiungiUnFilm(@RequestBody Film film) {
        try {
            filmService.saveFilm(film);
            return ResponseEntity.ok(film);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<Film>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> cancellaUnFilm(@PathVariable Integer id) {
        try {
            filmService.deleteFilm(id);
            return ResponseEntity.ok("Eliminato con successo");
        } catch (Exception e) {
            return new ResponseEntity<>("Eliminazione non effettuata", HttpStatus.BAD_REQUEST);
        }
    }
}
