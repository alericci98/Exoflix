package it.exolab.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utenti {

    private @Id @GeneratedValue int id_utenti;
    private String nome;
    private String cognome;
    private String email;
    private String telefono;
    private String username;
    private String password;

    @OneToOne
    @JoinColumn(name = "abbonamento_id_abbonamenti")
    private Abbonamenti abbonamento;
}
