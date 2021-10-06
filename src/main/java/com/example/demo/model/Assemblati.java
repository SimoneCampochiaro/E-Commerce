package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_assemblato", referencedColumnName = "id_componenti_assemblato")
    private ComponentiAssemblato componentiAssemblato;

    @JoinColumn(name = "id_componenti")
    @ManyToOne
    @JsonIgnoreProperties("assemblati")
    private Componenti componenti;

}
