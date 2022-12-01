package com.example.exoflix.pojos;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "films")
public class Film {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id_film;

    @Column(name = "titolo",length = 45, nullable = false)
    private String titolo;

    @Column(name = "durata",length = 45)
    private String durata;

    @Column(name = "valutazione", nullable = false)
    private int valutazione;

    @Column(name = "trama", length = 500)
    private String trama;

    @ManyToOne
    @JoinColumn(name = "regista_id_registi")
    private Regista regista;

    @OneToOne
    @JoinColumn(name = "genere_id_registi")
    private Genere genere;

    @OneToOne
    @JoinColumn(name = "abbonamento_id_abbonamenti")
    private Abbonamento abbonamento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Film film = (Film) o;
        return id_film != null && Objects.equals(id_film, film.id_film);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
