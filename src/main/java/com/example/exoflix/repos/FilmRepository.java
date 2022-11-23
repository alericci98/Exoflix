package com.example.exoflix.repos;

import com.example.exoflix.pojos.Films;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Films,Integer> {
}
