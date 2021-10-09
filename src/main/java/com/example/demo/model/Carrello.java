package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "carrello")
@Data
public class Carrello {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrello")
    private Integer idCarrello;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_carrello")
    private Calendar dataCarrello;

    @OneToMany(mappedBy = "carrello")
    @JsonIgnore
    private List<Ordini> ordini;

    @OneToMany(mappedBy = "carrello")
    @JsonIgnore
    private List<ProdottiNelCarrello> prodottiNelCarrello;
}
