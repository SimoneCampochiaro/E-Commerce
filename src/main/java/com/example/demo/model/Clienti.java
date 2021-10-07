package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "anagrafica_clienti")
@Data
public class Clienti {
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id_anagrafica_clienti")
    private Integer idCliente;

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

    @Column(name = "codice_fiscale")
    private String codiceFiscale;

    @Column(name = "email")
    private String email;

    @Column(name = "username_cliente")
    private String usernameCliente;

    @Column(name = "password_cliente")
    private String passwordCliente;


    @OneToMany(mappedBy = "clienti")
    @JsonIgnore
    private List<Ordini> ordini;




}
