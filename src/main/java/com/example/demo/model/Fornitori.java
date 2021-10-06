package com.example.demo.model;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "anagrafica_fornitori")
@Data
public class Fornitori {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_anagrafica_fornitori")
    private Integer IdAnagraficaFornitori;

    @Column(name = "nominativo")
    private String nominativo;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "localita")
    private String localita;

    @Column(name = "cap")
    private String cap;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "partita_iva")
    private String partita_iva;

    @Column(name = "email")
    private String email;

    @Column(name = "sito_web")
    private String sito_web;

    @OneToMany(mappedBy = "fornitori")
    @JsonIgnore
    List<Prodotti> prodotti;
}
