package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "assemblati")
@Data

public class Assemblati {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_assemblato")
    private Integer idAssemblato;

    @Column(name = "nome_assemblato")
    private String nomeAssemblato;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "prezzo_di_vendita")
    private Double prezzoDiVendita;

    @OneToMany(mappedBy = "assemblati")
    @JsonIgnore
    private List<ProdottiAssemblato> prodottiAssemblato;


    @OneToMany(mappedBy = "assemblati")
    @JsonIgnore
    private List<Prodotti> prodotti;

}
