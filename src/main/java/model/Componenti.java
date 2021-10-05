package model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "componenti")
@Data
public class Componenti {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_componente")
    private Integer idComponente;

    @Column(name = "componente")
    private String componente;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "codice_componente")
    private String codiceComponente;

    @Column(name = "quantita")
    private int quantita;

    @Column(name = "disponibilita")
    private boolean disponibilita;

    @Column(name="prezzo_di_acquisto")
    private double prezzoDiAcquisto;

    @Column(name = "prezzo_di_vendita")
    private double prezzoDiVendita;

    @JoinColumn(name = "id_anagrafica_fornitore")
    @ManyToOne
    @JsonIgnoreProperties("componenti")
    private Fornitori fornitori;

    @JoinColumn(name = "id_assemblato")
    @OneToMany
    @JsonIgnoreProperties("componenti")
    private Assemblati assemblati;

}
