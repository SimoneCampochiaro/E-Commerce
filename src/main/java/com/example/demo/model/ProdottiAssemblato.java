package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "prodotti_assemblato")
@Data

public class ProdottiAssemblato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_componenti_assemblato")
    private Integer idComponentiAssemblato;


    @JoinColumn(name = "id_componente")
    @ManyToOne
    @JsonIgnoreProperties("prodotti")
    private Prodotti prodotti;


}
