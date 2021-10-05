package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;


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
    private Integer quantita;

    @Column(name = "disponibilita")
    private Boolean disponibilita;

    @Column(name="prezzo_di_acquisto")
    private Double prezzoDiAcquisto;

    @Column(name = "prezzo_di_vendita")
    private Double prezzoDiVendita;

    @JoinColumn(name = "id_anagrafica_fornitore")
    @ManyToOne
    @JsonIgnoreProperties("anagrafica_fornitori")
    private Fornitori fornitori;

    @JoinColumn(name = "id_assemblato")
    @ManyToOne
    @JsonIgnoreProperties("assemblati")
    private Assemblati assemblati;

}
