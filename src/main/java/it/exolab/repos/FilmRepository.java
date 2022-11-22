package it.exolab.repos;

import it.exolab.pojos.Films;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Films,Integer> {
}
