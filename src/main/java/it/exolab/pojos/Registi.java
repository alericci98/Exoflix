package it.exolab.pojos;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Registi {

    private @Id @GeneratedValue Integer id_registi;

    @Column(name = "cognome", nullable = false, length = 45)
    private String cognome;

    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    @Column(name = "numero_premi")
    private int numero_premi;

    @Column(name = "candidature_oscar")
    private int candidature_oscar;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Registi registi = (Registi) o;
        return id_registi != null && Objects.equals(id_registi, registi.id_registi);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
