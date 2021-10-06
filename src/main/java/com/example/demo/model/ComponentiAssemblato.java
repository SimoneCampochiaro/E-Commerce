package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "componenti_assemblato")
@Data

public class ComponentiAssemblato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_componenti_assemblato")
    private Integer idComponentiAssemblato;



    @OneToOne(mappedBy = "componenti_assemblato")
    private Assemblati assemblati;


    @JoinColumn(name = "id_componente")
    @ManyToOne
    @JsonIgnoreProperties("componenti")
    private Componenti componenti;


}
