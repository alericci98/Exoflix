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
public class Generi {

    private @Id @GeneratedValue int id_registi;
    private String nome;
    private String cognome;
    private int numero_premi;
    private int candidature_oscar;

}
