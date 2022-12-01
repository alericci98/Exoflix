package com.example.exoflix.repos;

import com.example.exoflix.pojos.Regista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistaRepository extends JpaRepository<Regista, Integer> {
}
