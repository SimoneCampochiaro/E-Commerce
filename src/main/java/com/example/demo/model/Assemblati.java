package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "assemblati")

public class Assemblati {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_assemblato")
    private Integer idAssemblato;

    @Column(name = "nome_assemblato")
    private String nomeAssemblato;

    @Column(name = "descrizione")
    private String descrizione;

    @OneToMany(mappedBy = "assemblati")
    private List<ComponentiAssemblato> componentiAssemblato;
}
