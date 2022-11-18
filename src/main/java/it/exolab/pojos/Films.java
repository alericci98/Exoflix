package it.exolab.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Films {

    private @Id @GeneratedValue int id_film;
    private String titolo;
    private String durata;
    private int valutazione;
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
}
