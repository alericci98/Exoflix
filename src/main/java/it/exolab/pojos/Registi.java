package it.exolab.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Registi {

    private @Id @GeneratedValue int id_registi;
    private String cognome;
    private String nome;
    private int numero_premi;
    private int candidature_oscar;

}
