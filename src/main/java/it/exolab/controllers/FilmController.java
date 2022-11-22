package it.exolab.controllers;

import it.exolab.pojos.Films;
import it.exolab.repos.FilmRepository;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@RequestMapping("/films")
public class FilmController {

    private final FilmRepository repo;

    @GetMapping(value = "/findAll",consumes = "application/json")
    public List<Films> allFilms(){

        return repo.findAll();

    }

    @GetMapping("//{id}")
    public Films oneFilm(@PathVariable Integer id){

        return repo.findById(id).orElseThrow(NullPointerException::new);

    }

    @PostMapping("/films")
   public Films addFilm(@RequestBody Films film){

        return repo.save(film);

    }

    @DeleteMapping("/films/{id}")
    public void deleteFilm(@PathVariable Integer id){

        repo.deleteById(id);
    }

    @PutMapping("/films/{id}")
    public Films updateFilm(@RequestBody Films film, @PathVariable Integer id){

        return repo.findById(id).map(f ->{
            f.setDurata(film.getDurata());
            f.setAbbonamento(film.getAbbonamento());
            f.setGenere(film.getGenere());
            f.setRegista(film.getRegista());
            f.setValutazione(film.getValutazione());
            f.setTitolo(film.getTitolo());
            f.setTrama(film.getTrama());
            return repo.save(f);
        }).orElseGet(() ->{
            film.setId_film(id);
            return repo.save(film);
        });

    }


}
