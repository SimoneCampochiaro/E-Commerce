package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ordini")
@Data
public class Ordini {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ordine")
    private Integer idOrdine;

    @Column(name = "id_modalita_consegna")
    private Integer idModalitaConsegna;

    @Column(name = "importo")
    private double importo;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_consegna")
    private Date dataConsegna;

    @Temporal(TemporalType.TIME)
    @Column(name = "ora_consegna")
    private Date oraConsegna;


    @JoinColumn(name = "id_carrello")
    @ManyToOne
    @JsonIgnoreProperties("ordini")
    private Carrello carrello;

    @JoinColumn(name = "id_anagrafica_cliente")
    @ManyToOne
    @JsonIgnoreProperties("ordini")
    private Clienti clienti;




}
