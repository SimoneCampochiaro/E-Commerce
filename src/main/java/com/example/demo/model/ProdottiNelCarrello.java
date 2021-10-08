package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "prodotti_nel_carrello")
@Data
public class ProdottiNelCarrello {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prodotto_nel_carrello")
    private Integer idProdottoNelCarrello;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_prodotto_carrello")
    private Calendar dataProdottoCarrello;

    @Column(name = "prezzo_di_vendita")
    private double prezzoVendita;

    @Column(name = "sconto")
    private double sconto;

    @Column(name = "codice_coupon")
    private String codiceCoupon;


    @JoinColumn(name = "id_anagrafica_clienti")
    @ManyToOne
    @JsonIgnoreProperties("anagrafica_clienti")
    private Clienti clienti;

    @JoinColumn(name = "id_carrello")
    @ManyToOne
    @JsonIgnoreProperties("carrello")
    private Carrello carrello;

    @JoinColumn(name = "id_prodotto")
    @ManyToOne
    @JsonIgnore
    private Prodotti prodotti;
}