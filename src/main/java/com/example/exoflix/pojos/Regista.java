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
@Table(name = "registi")
public class Regista {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id_registi")
     private Integer id_registi;

    @Column(name = "cognome", nullable = false, length = 45)
    private String cognome;

    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    @Column(name = "numero_premi")
    private int numero_premi;

    @Column(name = "candidature_oscar")
    private int candidature_oscar;

    @OneToMany(mappedBy="regista", targetEntity = Film.class)
    private List<Film> films;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Regista regista = (Regista) o;
        return id_registi != null && Objects.equals(id_registi, regista.id_registi);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
