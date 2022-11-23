package com.example.exoflix.repos;

import com.example.exoflix.pojos.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtentiRepository extends JpaRepository<Utente, Integer> {
}
