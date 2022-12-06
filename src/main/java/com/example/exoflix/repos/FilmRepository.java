package com.example.exoflix.repos;

import com.example.exoflix.pojos.Abbonamento;
import com.example.exoflix.pojos.Film;
import com.example.exoflix.pojos.Regista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film,Integer> {

    @Query("select f from Film f where f.abbonamento = Abbonamento.tipologia order by  f.titolo")
    List<Film> FindByPremiumFilms(Abbonamento abbonamento);

    @Query("select f from Film f where f.regista=?1")
    List<Film> FindByRegista(Regista regista);


   @Query("select f from Film f where f.titolo like ?1% ")
   List <Film> FindByTitoloLike(String titolo);
}
