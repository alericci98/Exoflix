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

public class Abbonamenti {

    private @Id @GeneratedValue Integer id_abbonamenti;

    @Column(name = "tipologia", nullable = false, unique = true, length = 45)
    private String tipologia;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Abbonamenti that = (Abbonamenti) o;
        return id_abbonamenti != null && Objects.equals(id_abbonamenti, that.id_abbonamenti);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
