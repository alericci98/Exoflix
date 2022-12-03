package com.example.exoflix.pojos;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "abbonamenti")
public class Abbonamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_abbonamenti;

    @Column(name = "tipologia", nullable = false, unique = true, length = 45)
    private String tipologia;

    @OneToMany(mappedBy="abbonamento", targetEntity = Film.class)
    private List<Film> films;

    @OneToMany(mappedBy="abbonamento", targetEntity = Utente.class)
    private List<Utente> utenti;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Abbonamento that = (Abbonamento) o;
        return id_abbonamenti != null && Objects.equals(id_abbonamenti, that.id_abbonamenti);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
