package it.exolab.repos;

import it.exolab.pojos.Utenti;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtentiRepository extends JpaRepository<Utenti, Integer> {
}
