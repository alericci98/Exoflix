package it.exolab.pojos;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Utenti {

    private @Id @GeneratedValue Integer id_utenti;

    @Column(name = "nome", length = 45, nullable = false)
    private String nome;

    @Column(name = "cognome",nullable = false,length = 45)
    private String cognome;

    @Column(name = "email", nullable = false, unique = true, length = 45)
    private String email;

    @Column(name = "telefono", unique = true, length = 45)
    private String telefono;

    @Column(name = "username", nullable = false, unique = true, length = 45)
    private String username;

    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @OneToOne
    @JoinColumn(name = "abbonamento_id_abbonamenti")
    private Abbonamenti abbonamento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Utenti utenti = (Utenti) o;
        return id_utenti != null && Objects.equals(id_utenti, utenti.id_utenti);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
