package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "prodotti_nel_carrello")
@Data
public class ProdottiNelCarrello {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prodotto_nel_carrello")
    private Integer idProdottoNelCarrello;


    @JoinColumn(name = "id_carrello")
    @ManyToOne(cascade ={CascadeType.ALL})
    @JsonIgnore
    @JsonIgnoreProperties("prodotti_nel_carrello")
    private Carrello carrello;

    @JoinColumn(name = "id_prodotto1")
    @ManyToOne(cascade ={CascadeType.ALL})
    @JsonIgnore
    @JsonIgnoreProperties("prodotti_nel_carrello")
    private Prodotti prodotti;
}
