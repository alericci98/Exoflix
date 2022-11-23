package com.example.exoflix.pojos;

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
@AllArgsConstructor
@NoArgsConstructor
public class Genere {

    private @Id @GeneratedValue Integer id_registi;

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Genere generi = (Genere) o;
        return id_registi != null && Objects.equals(id_registi, generi.id_registi);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
