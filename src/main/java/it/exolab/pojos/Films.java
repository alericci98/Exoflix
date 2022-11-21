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
public class Films {

    private @Id @GeneratedValue Integer id_film;

    @Column(name = "titolo",length = 45, nullable = false)
    private String titolo;

    @Column(name = "durata",length = 45)
    private String durata;

    @Column(name = "valutazione", nullable = false)
    private int valutazione;

    @Column(name = "trama", length = 500)
    private String trama;

    @OneToOne
    @JoinColumn(name = "regista_id_registi")
    private Registi regista;

    @OneToOne
    @JoinColumn(name = "genere_id_registi")
    private Generi genere;


    @OneToOne
    @JoinColumn(name = "abbonamento_id_abbonamenti")
    private Abbonamenti abbonamento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Films films = (Films) o;
        return id_film != null && Objects.equals(id_film, films.id_film);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
