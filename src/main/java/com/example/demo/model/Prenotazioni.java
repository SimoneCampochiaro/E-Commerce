package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Entity
@Table(name = "prenotazioni")
@Data
public class Prenotazioni {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_prenotazione")
    private Integer idPrenotazione;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_ritiro") //aggiungere ora ritiro
    private Calendar dataRitiro;

    @JoinColumn(name = "id_anagrafica_clienti")
    @ManyToOne
    @JsonIgnoreProperties("anagrafica_clienti")
    private Clienti clienti;

    @JoinColumn(name = "id_carrello")
    @ManyToOne
    @JsonIgnoreProperties("carrello")
    private Carrello carello;
}
