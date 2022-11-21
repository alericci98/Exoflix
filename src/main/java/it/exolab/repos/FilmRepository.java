package it.exolab.repos;

import it.exolab.pojos.Films;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Films,Integer> {
}
