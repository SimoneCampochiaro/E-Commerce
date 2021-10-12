package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "ordini")
@Data
public class Ordini {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ordine")
    private Integer idOrdine;


    @Column(name = "importo")
    private Double importo;


    @Column(name = "data_consegna")
    private Date dataConsegna;


    @Column(name = "ora_consegna")
    private Date oraConsegna;


    @JoinColumn(name = "id_carrello1")
    @ManyToOne
    @JsonIgnoreProperties("ordini")
    private Carrello carrello;

    @JoinColumn(name = "id_anagrafica_cliente")
    @ManyToOne
    @JsonIgnoreProperties("ordini")
    private Clienti clienti;




}
